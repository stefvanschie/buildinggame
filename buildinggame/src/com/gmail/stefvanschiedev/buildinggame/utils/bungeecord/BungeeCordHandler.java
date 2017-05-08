package com.gmail.stefvanschiedev.buildinggame.utils.bungeecord;

import com.gmail.stefvanschiedev.buildinggame.Main;
import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import fr.rhaz.socket4mc.Bukkit;
import fr.rhaz.socket4mc.Socket4MC;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.AnimalTamer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 * Handles all bungeecord calls
 */
public class BungeeCordHandler implements Listener {

    private static final String CHANNEL = "BuildingGame";

    public final class Receiver {
        public static final String BUNGEE = "bungee";
        public static final String SUB_SERVER = "main";

        private Receiver() {}
    }

    private final Collection<IdentifiedCallable> callables = new HashSet<>();

    private void send(String message, IdentifiedCallable callable) {
        if (callable != null)
            callables.add(callable);
        Socket4MC.bukkit().getSocketClient().writeJSON(CHANNEL, message + (callable == null ? "" : ";uuid:" +
                callable.getUuid()));
    }

    public void connect(String receiver, AnimalTamer player, String server, IdentifiedCallable callable) {
        send("connect:" + player.getName() + ", " + server + ";receiver:" + receiver, callable);
    }

    public void teleport(String receiver, String playerName, String world, double x, double y, double z,
                                IdentifiedCallable callable) {
        send("teleport:" + playerName + ", " + world + ", " + x + ", " + y + ", " + z + ";receiver:" +
                receiver, callable);
    }

    public void sign(String receiver, Arena arena, String line1, String line2, String line3, String line4,
                     IdentifiedCallable callable) {
        //escape the special ':' character
        send("sign:" + arena.getName() + ", " + line1.replace(":", "\\:") + ", " + line2
                .replace(":", "\\:") + ", " + line3.replace(":", "\\:") + ", " +
                line4.replace(":", "\\:") + ";receiver:" + receiver, callable);
    }

    @EventHandler
    public void onBukkitSocketJSON(Bukkit.BukkitSocketJSONEvent e) {
        if (!e.getChannel().equals("BuildingGame"))
            return;

        //encode data
        String[] data = e.getData().split(";");

        if (data[0].startsWith("response") && data.length > 1)
            getCallable(UUID.fromString(data[1].split(":")[1])).call(data[0].split(":")[1]);
        else if (data[0].startsWith("write"))
            send(write(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("save"))
            send(save() + ';' + (data.length > 2 ? data[2] : ""), null);
        else if (data[0].startsWith("join"))
            send(join(data[0].split(":")[1]) + ';' + (data.length > 2 ? data[2] : ""), null);
    }

    private String write(String input) {
        String[] data = input.split(", ");
        YamlConfiguration file;

        switch (data[0]) {
            case "arenas.yml":
                file = SettingsManager.getInstance().getArenas();
                break;
            case "config.yml":
                file = SettingsManager.getInstance().getConfig();
                break;
            case "messages.yml":
                file = SettingsManager.getInstance().getMessages();
                break;
            case "signs.yml":
                file = SettingsManager.getInstance().getSigns();
                break;
            default:
                return "response:failed";
        }

        file.set(data[1], data[2].startsWith("(int)") ? Integer.parseInt(data[2].replace("(int)", "")
                .trim()) : data[2]);

        return "response:success";
    }

    private String save() {
        SettingsManager.getInstance().save();

        return "response:success";
    }

    private String join(String input) {
        String[] data = input.split(", ");

        Player player = org.bukkit.Bukkit.getPlayer(data[0].trim());
        Arena arena = ArenaManager.getInstance().getArena(data[1].trim());

        if (player == null || arena == null)
            return "response:failed";

        new BukkitRunnable() {
            @Override
            public void run() {
                arena.join(player);
            }
        }.runTask(Main.getInstance());

        return "response:success";
    }

    private IdentifiedCallable getCallable(UUID uuid) {
        for (IdentifiedCallable callable : callables) {
            if (callable.getUuid().equals(uuid))
                return callable;
        }

        return null;
    }

    private BungeeCordHandler() {}
    private static BungeeCordHandler INSTANCE;
    public static BungeeCordHandler getInstance() {
        if (INSTANCE == null)
            INSTANCE = new BungeeCordHandler();
        return INSTANCE;
    }
}
