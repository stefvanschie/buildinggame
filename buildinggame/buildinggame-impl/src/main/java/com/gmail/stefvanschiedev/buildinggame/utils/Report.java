package com.gmail.stefvanschiedev.buildinggame.utils;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.sk89q.worldedit.extent.clipboard.Clipboard;
import com.sk89q.worldedit.extent.clipboard.io.BuiltInClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardFormat;
import com.sk89q.worldedit.extent.clipboard.io.ClipboardReader;
import com.sk89q.worldedit.util.io.Closer;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.time.ZonedDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * A report that was made on a build
 *
 * @since 6.5.0
 */
public final class Report {

    /**
     * The player that was reported and the player that reported this player
     */
    @NotNull
    private final OfflinePlayer reportee, reporter;

    /**
     * The date and time this report was made
     */
    @NotNull
    private final ZonedDateTime reportDate;

    /**
     * The schematic file
     */
    @NotNull
    private final File schematicFile;

    /**
     * All loaded reports
     */
    @NotNull
    private static final Collection<Report> REPORTS = new HashSet<>();

    /**
     * Creates a new report
     *
     * @param reportee the player who was reported
     * @param reporter the player that reported this player
     * @param reportDate the date at which this report was made
     * @param schematicFile the file in which the build was saved
     * @since 6.5.0
     */
    public Report(@NotNull OfflinePlayer reportee, @NotNull OfflinePlayer reporter, @NotNull ZonedDateTime reportDate,
                  @NotNull File schematicFile) {
        this.reportee = reportee;
        this.reporter = reporter;
        this.reportDate = reportDate;
        this.schematicFile = schematicFile;
    }

    /**
     * Loads the schematic belonging to this report, which is found in {@link #schematicFile}, and returns the clipboard
     * onto which it was loaded. This method should be called async.
     *
     * @return the clipboard with the schematic
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public Clipboard loadSchematic() throws IOException {
        try (Closer closer = Closer.create()) {
            var fileInputStream = closer.register(new FileInputStream(schematicFile));
            var bufferedInputStream = closer.register(new BufferedInputStream(fileInputStream));
            ClipboardFormat format = BuiltInClipboardFormat.SPONGE_SCHEMATIC;
            ClipboardReader reader = closer.register(format.getReader(bufferedInputStream));

            return reader.read();
        }
    }

    /**
     * Gets the date at which the report was made, see {@link #reportDate}
     *
     * @return the date
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public ZonedDateTime getDate() {
        return reportDate;
    }

    /**
     * Gets the reportee, see {@link #reportee}
     *
     * @return the reportee
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public OfflinePlayer getReportee() {
        return reportee;
    }

    /**
     * Gets the reporter, see {@link #reporter}
     *
     * @return the reporter
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public OfflinePlayer getReporter() {
        return reporter;
    }

    /**
     * Gets the schematic file, see {@link #schematicFile}
     *
     * @return the schematic file
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    private File getSchematicFile() {
        return schematicFile;
    }

    /**
     * Saves all the currently loaded reports into the reports.yml
     *
     * @throws IOException when something goes wrong while saving
     * @since 6.5.0
     */
    public static void saveAllReports() throws IOException {
        File file = SettingsManager.getInstance().getReports();

        if (file == null) {
            return;
        }

        Map<OfflinePlayer, Collection<Report>> mappings = new HashMap<>();

        getReports().forEach(report -> {
            OfflinePlayer reportee = report.getReportee();
            Collection<Report> reports = mappings.get(reportee);

            if (reports == null) {
                reports = new HashSet<>();
            }

            reports.add(report);
            mappings.put(reportee, reports);
        });

        try (var jsonWriter = new Gson().newJsonWriter(new OutputStreamWriter(new FileOutputStream(file)))) {
            jsonWriter.beginObject();

            for (Map.Entry<OfflinePlayer, Collection<Report>> entry : mappings.entrySet()) {
                jsonWriter.name(entry.getKey().getUniqueId().toString());
                jsonWriter.beginArray();

                for (var report : entry.getValue()) {
                    jsonWriter.beginObject();
                    jsonWriter.name("by").value(report.getReporter().getUniqueId().toString());
                    jsonWriter.name("date").value(report.getDate().toString());
                    jsonWriter.name("schematic").value(report.getSchematicFile().getName());
                    jsonWriter.endObject();
                }

                jsonWriter.endArray();
            }

            jsonWriter.endObject();
        }
    }

    /**
     * Loads all reports from the reports.json file. If the reports.json file doesn't exist, this file will be created.
     * If anything goes wrong an {@link IOException} will be thrown.
     *
     * @throws IOException if anything goes wrong while reading from/creating files
     * @since 6.5.0
     */
    public static void loadAllReports() throws IOException {
        REPORTS.clear();

        File file = SettingsManager.getInstance().getReports();

        if (!file.exists() && !file.createNewFile()) {
            Main.getInstance().getLogger().warning("Unable to create reports.json file");
            return;
        }

        var jsonReader = new Gson().newJsonReader(new InputStreamReader(new FileInputStream(file)));

        //in case the file is empty
        try {
            jsonReader.peek();
            /* Gson 2.8.0 (currently bundled) throws an EOFException instead of returning the right JsonToken. This has
            been fixed in later versions, but for now we will need to use this. */
        } catch (EOFException exception) {
            return;
        }

        jsonReader.beginObject();

        while (jsonReader.hasNext()) {
            String reporteeUUID = jsonReader.nextName();

            jsonReader.beginArray();

            while (jsonReader.hasNext()) {
                jsonReader.beginObject();

                REPORTS.add(loadReport(jsonReader, reporteeUUID));

                jsonReader.endObject();
            }

            jsonReader.endArray();
        }

        jsonReader.endObject();
    }

    /**
     * Loads a single report from the given json reader and the already found reportee UUID. It is expected that the
     * json reader has just started reading the object. An {@link IOException} is thrown whenever something goes wrong
     * while reading the file.
     *
     * @param reader the json reader to read from
     * @param reporteeUUID the uuid of the reportee
     * @return the report read
     * @throws IOException when anything goes wrong while reading
     * @since 6.5.0
     */
    private static Report loadReport(JsonReader reader, String reporteeUUID) throws IOException {
        String reporterUUID = null;
        String reportDate = null;
        String schematicFileName = null;

        while (reader.hasNext()) {
            String name = reader.nextName();

            switch (name) {
                case "by":
                    reporterUUID = reader.nextString();
                    break;
                case "date":
                    reportDate = reader.nextString();
                    break;
                case "schematic":
                    schematicFileName = reader.nextString();
                    break;
                default:
                    reader.nextNull();
                    break;
            }
        }

        if (reporterUUID == null || reportDate == null || schematicFileName == null) {
            Main.getInstance().getLogger().warning("Incorrect reports.json file detected");
            return null;
        }

        OfflinePlayer reportee = Bukkit.getOfflinePlayer(UUID.fromString(reporteeUUID));
        OfflinePlayer reporter = Bukkit.getOfflinePlayer(UUID.fromString(reporterUUID));
        File schematicFile = new File(SettingsManager.getInstance().getReportsSchematicsFolder(), schematicFileName);

        return new Report(reportee, reporter, ZonedDateTime.parse(reportDate), schematicFile);
    }

    /**
     * Gets all the reports where the {@link #reportee} is the specified player
     *
     * @param player the player who is the reportee
     * @return 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public static List<Report> getReports(OfflinePlayer player) {
        return getReports().stream()
            .filter(report -> report.getReportee().equals(player))
            .collect(Collectors.toUnmodifiableList());
    }

    /**
     * Adds the specified report to the currently registered reports. This report will also get saved when
     * {@link #saveAllReports()} is called.
     *
     * @param report the report to add
     * @since 6.5.0
     */
    public static void add(@NotNull Report report) {
        REPORTS.add(report);
    }

    /**
     * Deletes the specified reports
     *
     * @param reports the reports to delete
     * @since 6.5.0
     */
    public static void delete(@NotNull Collection<Report> reports) {
        reports.forEach(report -> {
            if (!report.getSchematicFile().delete()) {
                Main.getInstance().getLogger().warning("Unable to delete report");
            }
        });

        REPORTS.removeAll(reports);
    }

    /**
     * Deletes the specified report
     *
     * @param report the report to delete
     * @since 6.5.0
     */
    public static void delete(@NotNull Report report) {
        if (!report.getSchematicFile().delete()) {
            Main.getInstance().getLogger().warning("Unable to delete report");
        }

        REPORTS.remove(report);
    }

    /**
     * Gets all the reports. The collection returned is unmodifiable.
     *
     * @return the reports
     * @since 6.5.0
     */
    @NotNull
    @Contract(pure = true)
    public static Collection<Report> getReports() {
        return Collections.unmodifiableCollection(REPORTS);
    }
}
