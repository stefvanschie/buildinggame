package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.plot.Plot;
import org.bukkit.Material;
import org.bukkit.block.Biome;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The gui to change the biome of your plot
 *
 * @since 5.2.0
 */
class BiomeMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
    private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

    /**
     * Constructs a new biome menu for the specified plot
     *
     * @param plot the plot this menu belongs to
     */
    BiomeMenu(Plot plot) {
        super(null, 18, MessageManager.translate(MESSAGES.getString("gui.biome.title")),
                1);

        //ice plains
        ItemStack icePlains = new ItemStack(Material.ICE);
        ItemMeta icePlainsMeta = icePlains.getItemMeta();
        icePlainsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.ice-plains.name")));
        icePlainsMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.ice-plains.lores")));
        icePlains.setItemMeta(icePlainsMeta);

        addItem(icePlains, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.ICE_FLATS));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //taiga
        ItemStack taiga = new ItemStack(Material.LOG, 1, (short) 1);
        ItemMeta taigaMeta = taiga.getItemMeta();
        taigaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.taiga.name")));
        taigaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.taiga.lores")));
        taiga.setItemMeta(taigaMeta);

        addItem(taiga, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.TAIGA));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //extreme hills
        ItemStack extremeHills = new ItemStack(Material.STONE);
        ItemMeta extremeHillsMeta = extremeHills.getItemMeta();
        extremeHillsMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.biome.extreme-hills.name")));
        extremeHillsMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.biome.extreme-hills.lores")));
        extremeHills.setItemMeta(extremeHillsMeta);

        addItem(extremeHills, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.EXTREME_HILLS));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //plains
        ItemStack plains = new ItemStack(Material.GRASS);
        ItemMeta plainsMeta = plains.getItemMeta();
        plainsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.plains.name")));
        plainsMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.plains.lores")));
        plains.setItemMeta(plainsMeta);

        addItem(plains, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.PLAINS));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //forest
        ItemStack forest = new ItemStack(Material.LOG);
        ItemMeta forestMeta = forest.getItemMeta();
        forestMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.forest.name")));
        forestMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.forest.lores")));
        forest.setItemMeta(forestMeta);

        addItem(forest, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.FOREST));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //roofed forest
        ItemStack roofedForest = new ItemStack(Material.LOG_2, 1, (short) 1);
        ItemMeta roofedForestMeta = roofedForest.getItemMeta();
        roofedForestMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.biome.roofed-forest.name")));
        roofedForestMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.biome.roofed-forest.lores")));
        roofedForest.setItemMeta(roofedForestMeta);

        addItem(roofedForest, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.ROOFED_FOREST));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //swampland
        ItemStack swampland = new ItemStack(Material.WATER_LILY);
        ItemMeta swamplandMeta = swampland.getItemMeta();
        swamplandMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.swampland.name")));
        swamplandMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.swampland.lores")));
        swampland.setItemMeta(swamplandMeta);

        addItem(swampland, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.SWAMPLAND));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //jungle
        ItemStack jungle = new ItemStack(Material.VINE);
        ItemMeta jungleMeta = jungle.getItemMeta();
        jungleMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.jungle.name")));
        jungleMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.jungle.lores")));
        jungle.setItemMeta(jungleMeta);

        addItem(jungle, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.JUNGLE));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //mushroom island
        ItemStack mushroomIsland = new ItemStack(Material.MYCEL);
        ItemMeta mushroomIslandMeta = mushroomIsland.getItemMeta();
        mushroomIslandMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.biome.mushroom-island.name")));
        mushroomIslandMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.biome.mushroom-island.lores")));
        mushroomIsland.setItemMeta(mushroomIslandMeta);

        addItem(mushroomIsland, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.MUSHROOM_ISLAND));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //the end
        ItemStack theEnd = new ItemStack(Material.ENDER_STONE);
        ItemMeta theEndMeta = theEnd.getItemMeta();
        theEndMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.the-end.name")));
        theEndMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.the-end.lores")));
        theEnd.setItemMeta(theEndMeta);

        addItem(theEnd, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.SKY));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //mesa
        ItemStack desert = new ItemStack(Material.SAND);
        ItemMeta desertMeta = desert.getItemMeta();
        desertMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.mesa.name")));
        desertMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.mesa.lores")));
        desert.setItemMeta(desertMeta);

        addItem(desert, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.DESERT));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //savanna
        ItemStack savanna = new ItemStack(Material.LOG_2);
        ItemMeta savannaMeta = savanna.getItemMeta();
        savannaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.savanna.name")));
        savannaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.savanna.lores")));
        savanna.setItemMeta(savannaMeta);

        addItem(savanna, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.SAVANNA));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //mesa
        ItemStack mesa = new ItemStack(Material.HARD_CLAY);
        ItemMeta mesaMeta = mesa.getItemMeta();
        mesaMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.mesa.name")));
        mesaMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.mesa.lores")));
        mesa.setItemMeta(mesaMeta);

        addItem(mesa, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.MESA));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //the nether
        ItemStack theNether = new ItemStack(Material.NETHERRACK);
        ItemMeta theNetherMeta = theNether.getItemMeta();
        theNetherMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.the-nether.name")));
        theNetherMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.the-nether.lores")));
        theNether.setItemMeta(theNetherMeta);

        addItem(theNether, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.HELL));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //ocean
        ItemStack ocean = new ItemStack(Material.WATER_BUCKET);
        ItemMeta oceanMeta = ocean.getItemMeta();
        oceanMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.ocean.name")));
        oceanMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.ocean.lores")));
        ocean.setItemMeta(oceanMeta);

        addItem(ocean, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.OCEAN));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });

        //the void
        ItemStack theVoid = new ItemStack(Material.BARRIER);
        ItemMeta theVoidMeta = theVoid.getItemMeta();
        theVoidMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.biome.the-void.name")));
        theVoidMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.biome.the-void.lores")));
        theVoid.setItemMeta(theVoidMeta);

        addItem(theVoid, event -> {
            plot.getBoundary().getAllBlocks().forEach(block -> block.setBiome(Biome.VOID));

            //just send it to all players directly, so we don't have to do weird trickery
            plot.getBoundary().getChunks().forEach(chunk -> plot.getArena().getUsedPlots().forEach(p ->
                    p.getAllGamePlayers().forEach(gamePlayer -> gamePlayer.refreshChunk(chunk))));

            event.setCancelled(true);
        });
    }
}