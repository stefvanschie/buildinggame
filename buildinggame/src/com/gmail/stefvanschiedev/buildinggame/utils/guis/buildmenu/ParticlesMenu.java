package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu;

import com.gmail.stefvanschiedev.buildinggame.managers.arenas.ArenaManager;
import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.arena.Arena;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.Particle;
import com.gmail.stefvanschiedev.buildinggame.utils.particle.ParticleType;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * The gui for particles
 *
 * @since 2.1.0
 */
class ParticlesMenu extends Gui {

    /**
     * YAML Configuration for the messages.yml
     */
	private static final YamlConfiguration MESSAGES = SettingsManager.getInstance().getMessages();

	/**
     * Constructs a new Particles menu
     */
	ParticlesMenu() {
		super(null, 27, MessageManager.translate(MESSAGES.getString("gui.particles.title")),
                1);
		
		//flames
		ItemStack flames = new ItemStack(Material.FLINT_AND_STEEL, 1);
		ItemMeta flamesMeta = flames.getItemMeta();
		flamesMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.flames.name")));
		flamesMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.flames.lores")));
		flames.setItemMeta(flamesMeta);
		
		setItem(flames, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.FLAMES), player);

            event.setCancelled(true);
		}, 0);
		
		//magic crit
		ItemStack magicCrit = new ItemStack(Material.DIAMOND_SWORD, 1);
		ItemMeta magicCritMeta = magicCrit.getItemMeta();
		magicCritMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.magic-crit.name")));
		magicCritMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.magic-crit.lores")));
		magicCrit.setItemMeta(magicCritMeta);
		
		setItem(magicCrit, event -> {
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
 				if (arena == null)
					return;
					
				arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.MAGIC_CRIT), player);

				event.setCancelled(true);
		}, 1);
		
		//lava drip
		ItemStack lavaDrip = new ItemStack(Material.LAVA_BUCKET, 1);
		ItemMeta lavaDripMeta = lavaDrip.getItemMeta();
		lavaDripMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.lava-drip.name")));
		lavaDripMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.lava-drip.lores")));
		lavaDrip.setItemMeta(lavaDripMeta);
		
		setItem(lavaDrip, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.LAVA_DRIP), player);

            event.setCancelled(true);
		}, 2);
		
		//water drip
		ItemStack waterDrip = new ItemStack(Material.WATER_BUCKET, 1);
		ItemMeta waterDripMeta = waterDrip.getItemMeta();
		waterDripMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.water-drip.name")));
		waterDripMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.water-drip.lores")));
		waterDrip.setItemMeta(waterDripMeta);
		
		setItem(waterDrip, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.WATER_DRIP), player);

            event.setCancelled(true);
		}, 3);
		
		//enchantment
		ItemStack enchantment = new ItemStack(Material.ENCHANTMENT_TABLE, 1);
		ItemMeta enchantmentMeta = enchantment.getItemMeta();
		enchantmentMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.enchantment.name")));
		enchantmentMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.enchantment.lores")));
		enchantment.setItemMeta(enchantmentMeta);
		
		setItem(enchantment, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.ENCHANTMENT), player);

            event.setCancelled(true);
		}, 4);
		
		//hearts
		ItemStack hearts = new ItemStack(Material.RED_ROSE, 1);
		ItemMeta heartsMeta = hearts.getItemMeta();
		heartsMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.hearts.name")));
		heartsMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.hearts.lores")));
		hearts.setItemMeta(heartsMeta);
		
		setItem(hearts, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.HEARTS), player);

            event.setCancelled(true);
		}, 5);
		
		//angry villager
		ItemStack angryVillager = new ItemStack(Material.CLAY, 1);
		ItemMeta angryVillagerMeta = angryVillager.getItemMeta();
		angryVillagerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.angry-villager.name")));
		angryVillagerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.angry-villager.lores")));
		angryVillager.setItemMeta(angryVillagerMeta);
		
		setItem(angryVillager, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.ANGRY_VILLAGER), player);

            event.setCancelled(true);
		}, 6);
		
		//happy villager
		ItemStack happyVillager = new ItemStack(Material.EMERALD, 1);
		ItemMeta happyVillagerMeta = happyVillager.getItemMeta();
		happyVillagerMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.happy-villager.name")));
		happyVillagerMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.happy-villager.lores")));
		happyVillager.setItemMeta(happyVillagerMeta);
		
		setItem(happyVillager, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.HAPPY_VILLAGER), player);

            event.setCancelled(true);
		}, 7);
		
		//redstone magic
		ItemStack redstoneMagic = new ItemStack(Material.REDSTONE, 1);
		ItemMeta redstoneMagicMeta = redstoneMagic.getItemMeta();
		redstoneMagicMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.redstone-magic.name")));
		redstoneMagicMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.redstone-magic.lores")));
		redstoneMagic.setItemMeta(redstoneMagicMeta);

		setItem(redstoneMagic, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.REDSTONE_MAGIC), player);

            event.setCancelled(true);
		}, 8);
		
		//spell
		ItemStack spell = new ItemStack(Material.POTION, 1);
		ItemMeta spellMeta = spell.getItemMeta();
		spellMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.spell.name")));
		spellMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.spell.lores")));
		spell.setItemMeta(spellMeta);
		
		setItem(spell, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.SPELL), player);

            event.setCancelled(true);
		}, 9);
		
		//snowball poof
		ItemStack snowballPoof = new ItemStack(Material.SNOW_BALL, 1);
		ItemMeta snowballPoofMeta = snowballPoof.getItemMeta();
		snowballPoofMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.snowball-poof.name")));
		snowballPoofMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.snowball-poof.lores")));
		snowballPoof.setItemMeta(snowballPoofMeta);
		
		setItem(snowballPoof, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.SNOWBALL_POOF), player);

            event.setCancelled(true);
		}, 10);
		
		//smoke
		ItemStack smoke = new ItemStack(Material.FURNACE, 1);
		ItemMeta smokeMeta = smoke.getItemMeta();
		smokeMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.smoke.name")));
		smokeMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.smoke.lores")));
		smoke.setItemMeta(smokeMeta);
		
		setItem(smoke, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.SMOKE), player);

            event.setCancelled(true);
		}, 11);
		
		//damage indicator
		ItemStack damageIndicator = new ItemStack(Material.ANVIL, 1, (short) 2);
		ItemMeta damageIndicatorMeta = damageIndicator.getItemMeta();
		damageIndicatorMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.damage-indicator.name")));
		damageIndicatorMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.damage-indicator.lores")));
		damageIndicator.setItemMeta(damageIndicatorMeta);
		
		setItem(damageIndicator, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.DAMAGE_INDICATOR),
                    player);
            event.setCancelled(true);
		}, 12);
		
		//dragon breath
		ItemStack dragonBreath = new ItemStack(Material.FIREBALL, 1);
		ItemMeta dragonBreathMeta = dragonBreath.getItemMeta();
		dragonBreathMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.dragon-breath.name")));
		dragonBreathMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.dragon-breath.lores")));
		dragonBreath.setItemMeta(dragonBreathMeta);
		
		setItem(dragonBreath, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.DRAGON_BREATH), player);

            event.setCancelled(true);
		}, 13);
		
		//end rod
		ItemStack endRod = new ItemStack(Material.END_ROD, 1);
		ItemMeta endRodMeta = endRod.getItemMeta();
		endRodMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.end-rod.name")));
		endRodMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.end-rod.lores")));
		endRod.setItemMeta(endRodMeta);
		
		setItem(endRod, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.END_ROD), player);

            event.setCancelled(true);
		}, 14);
		
		//sweep attack
		ItemStack sweepAttack = new ItemStack(Material.SHIELD, 1);
		ItemMeta sweepAttackMeta = sweepAttack.getItemMeta();
		sweepAttackMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.sweep-attack.name")));
		sweepAttackMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.sweep-attack.lores")));
		sweepAttack.setItemMeta(sweepAttackMeta);
		
		setItem(sweepAttack, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.SWEEP_ATTACK), player);

            event.setCancelled(true);
		}, 15);
		
		//falling dust
		ItemStack fallingDust = new ItemStack(Material.SAND);
		ItemMeta fallingDustMeta = fallingDust.getItemMeta();
		fallingDustMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.falling-dust.name")));
		fallingDustMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.falling-dust.lores")));
		fallingDust.setItemMeta(fallingDustMeta);
		
		setItem(fallingDust, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).addParticle(event.getCursor() != null ?
                    new Particle(player.getLocation(), ParticleType.FALLING_DUST, event.getCursor().getData()) :
                    new Particle(player.getLocation(), ParticleType.FALLING_DUST), player);

            event.setCancelled(true);
		}, 16);
		
		//totem
		ItemStack totem = new ItemStack(Material.TOTEM);
		ItemMeta totemMeta = totem.getItemMeta();
		totemMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.totem.name")));
		totemMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.totem.lores")));
		totem.setItemMeta(totemMeta);
		
		setItem(totem, event -> {
				Player player = (Player) event.getWhoClicked();
				Arena arena = ArenaManager.getInstance().getArena(player);
				
 				if (arena == null)
					return;
 				
				arena.getPlot(player).addParticle(new Particle(player.getLocation(), ParticleType.TOTEM), player);

				event.setCancelled(true);
		}, 17);
		
		//clear particles
		ItemStack clearParticles = new ItemStack(Material.BARRIER, 1);
		ItemMeta clearParticlesMeta = clearParticles.getItemMeta();
		clearParticlesMeta.setDisplayName(MessageManager.translate(MESSAGES
                .getString("gui.particles.clear-particles.name")));
		clearParticlesMeta.setLore(MessageManager.translate(MESSAGES
                .getStringList("gui.particles.clear-particles.lores")));
		clearParticles.setItemMeta(clearParticlesMeta);
		
		setItem(clearParticles, event -> {
            Player player = (Player) event.getWhoClicked();
            Arena arena = ArenaManager.getInstance().getArena(player);

            if (arena == null)
                return;

            arena.getPlot(player).getParticles().clear();

            event.setCancelled(true);
		}, 25);
		
		//back
		ItemStack back = new ItemStack(Material.BOOK, 1);
		ItemMeta backMeta = back.getItemMeta();
		backMeta.setDisplayName(MessageManager.translate(MESSAGES.getString("gui.particles.back.name")));
		backMeta.setLore(MessageManager.translate(MESSAGES.getStringList("gui.particles.back.lores")));
		back.setItemMeta(backMeta);
		
		setItem(back, event -> {
            Player player = (Player) event.getWhoClicked();

            ArenaManager.getInstance().getArena(player).getPlot(player).getBuildMenu().open(player);
            removePlayer(player);

            event.setCancelled(true);
		}, 26);
	}
}