package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu;

import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.managers.files.SettingsManager;
import com.gmail.stefvanschiedev.buildinggame.managers.messages.MessageManager;
import com.gmail.stefvanschiedev.buildinggame.utils.guis.Gui;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class InteriorHeadsMenu extends Gui {

	private static YamlConfiguration messages = SettingsManager.getInstance().getMessages();
	
	public InteriorHeadsMenu() {
		super(null, 54, MessageManager.translate(messages.getString("gui.heads.interior.title")), 2);
		
		//page one
		ItemStack pottedRosePlant = SkullItem.getSkull("http://textures.minecraft.net/texture/9dba38e9fc67f72c458fdac8ecd7cabaed3eb83737143a0128350a1ab381e3e");
		ItemMeta pottedRosePlantMeta = pottedRosePlant.getItemMeta();
		pottedRosePlantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.potted-rose-plant.name")));
		pottedRosePlantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.potted-rose-plant.lores")));
		pottedRosePlant.setItemMeta(pottedRosePlantMeta);
		
		addItem(pottedRosePlant, new Action());
		
		ItemStack pottedSalviaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/ed80c26f904b57e631e39ebc446ec1af2dce3432eb8431fbd19087adb4abcb");
		ItemMeta pottedSalviaPlantMeta = pottedSalviaPlant.getItemMeta();
		pottedSalviaPlantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.potted-salvia-plant.name")));
		pottedSalviaPlantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.potted-salvia-plant.lores")));
		pottedSalviaPlant.setItemMeta(pottedSalviaPlantMeta);
		
		addItem(pottedSalviaPlant, new Action());
		
		ItemStack toiletpaper = SkullItem.getSkull("http://textures.minecraft.net/texture/7380c7e621a1f4da543e4c7ab1494ee184b87bb132418512c9eee858f9de1db");
		ItemMeta toiletpaperMeta = toiletpaper.getItemMeta();
		toiletpaperMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.toiletpaper.name")));
		toiletpaperMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.toiletpaper.lores")));
		toiletpaper.setItemMeta(toiletpaperMeta);
		
		addItem(toiletpaper, new Action());
		
		ItemStack toiletroll = SkullItem.getSkull("http://textures.minecraft.net/texture/ded3d34da8ae8b482f266ae175cd22cce3b0cfe2ca2a16416c1c84cb1e8e3b78");
		ItemMeta toiletrollMeta = toiletroll.getItemMeta();
		toiletrollMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.toiletroll.name")));
		toiletrollMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.toiletroll.lores")));
		toiletroll.setItemMeta(toiletrollMeta);
		
		addItem(toiletroll, new Action());
		
		ItemStack winRARBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/8d1b28f886ca3c8fc4301b785bf38c619ea66b68352a882bf8080e63034e0");
		ItemMeta winRARBooksMeta = winRARBooks.getItemMeta();
		winRARBooksMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.winrar-books.name")));
		winRARBooksMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.winrar-books.lores")));
		winRARBooks.setItemMeta(winRARBooksMeta);
		
		addItem(winRARBooks, new Action());
		
		ItemStack bookcase = SkullItem.getSkull("http://textures.minecraft.net/texture/32a18d36c746e4843850a3b65c51150ab3f75d13b7f8cc55c7686febd17b6a");
		ItemMeta bookcaseMeta = bookcase.getItemMeta();
		bookcaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.bookcase.name")));
		bookcaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.bookcase.lores")));
		bookcase.setItemMeta(bookcaseMeta);
		
		addItem(bookcase, new Action());
		
		ItemStack bookshelf = SkullItem.getSkull("http://textures.minecraft.net/texture/93184d6ad4a0e15b3a71dadf45f6c7ce9ec96172bc9ff25fd3af787a379bd1");
		ItemMeta bookshelfMeta = bookshelf.getItemMeta();
		bookshelfMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.bookshelf.name")));
		bookshelfMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.bookshelf.lores")));
		bookshelf.setItemMeta(bookshelfMeta);
		
		addItem(bookshelf, new Action());
		
		ItemStack pileOfBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/21c63d9b9fd8742eaeb04c692172cb9da43781698a575cdabe1c04df12c3f");
		ItemMeta pileOfBooksMeta = pileOfBooks.getItemMeta();
		pileOfBooksMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.pile-of-books.name")));
		pileOfBooksMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.pile-of-books.lores")));
		pileOfBooks.setItemMeta(pileOfBooksMeta);
		
		addItem(pileOfBooks, new Action());
		
		ItemStack chest = SkullItem.getSkull("http://textures.minecraft.net/texture/6f68d509b5d1669b971dd1d4df2e47e19bcb1b33bf1a7ff1dda29bfc6f9ebf");
		ItemMeta chestMeta = chest.getItemMeta();
		chestMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.chest.name")));
		chestMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.chest.lores")));
		chest.setItemMeta(chestMeta);
		
		addItem(chest, new Action());
		
		ItemStack enderchest = SkullItem.getSkull("http://textures.minecraft.net/texture/a6cc486c2be1cb9dfcb2e53dd9a3e9a883bfadb27cb956f1896d602b4067");
		ItemMeta enderchestMeta = enderchest.getItemMeta();
		enderchestMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.enderchest.name")));
		enderchestMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.enderchest.lores")));
		enderchest.setItemMeta(enderchestMeta);
		
		addItem(enderchest, new Action());
		
		ItemStack ironChest = SkullItem.getSkull("http://textures.minecraft.net/texture/e8e5544af7f5489cc27491ca68fa92384b8ea5cf20b5c8198adb7bfd12bc2bc2");
		ItemMeta ironChestMeta = ironChest.getItemMeta();
		ironChestMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.iron-chest.name")));
		ironChestMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.iron-chest.lores")));
		ironChest.setItemMeta(ironChestMeta);
		
		addItem(ironChest, new Action());
		
		ItemStack medicineChest = SkullItem.getSkull("http://textures.minecraft.net/texture/f7c7df52b5e50badb61fed7212d979e63fe94f1bde02b2968c6b156a770126c");
		ItemMeta medicineChestMeta = medicineChest.getItemMeta();
		medicineChestMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.medicine-chest.name")));
		medicineChestMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.medicine-chest.lores")));
		medicineChest.setItemMeta(medicineChestMeta);
		
		addItem(medicineChest, new Action());
		
		ItemStack cabinet = SkullItem.getSkull("http://textures.minecraft.net/texture/f73c56ac528f3b9dd13789623b52f60233262e59e13cfebcf6586ca55449fcb");
		ItemMeta cabinetMeta = cabinet.getItemMeta();
		cabinetMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.cabinet.name")));
		cabinetMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.cabinet.lores")));
		cabinet.setItemMeta(cabinetMeta);
		
		addItem(cabinet, new Action());
		
		ItemStack present = SkullItem.getSkull("http://textures.minecraft.net/texture/f0afa4fffd10863e76c698da2c9c9e799bcf9ab9aa37d8312881734225d3ca");
		ItemMeta presentMeta = present.getItemMeta();
		presentMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.present.name")));
		presentMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.present.lores")));
		present.setItemMeta(presentMeta);
		
		addItem(present, new Action());
		
		ItemStack present2 = SkullItem.getSkull("http://textures.minecraft.net/texture/13cfbf2bdfd48514bfbace9518c7664112df2c173e8c7ad92b3e65621a9ed6e0");
		ItemMeta present2Meta = present2.getItemMeta();
		present2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.present-2.name")));
		present2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.present-2.lores")));
		present2.setItemMeta(present2Meta);
		
		addItem(present2, new Action());
		
		ItemStack present3 = SkullItem.getSkull("http://textures.minecraft.net/texture/c6e69b1c7e69bcd49ed974f5ac36ea275efabb8c649cb2b1fe9d6ea6166ec3");
		ItemMeta present3Meta = present3.getItemMeta();
		present3Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.present-3.name")));
		present3Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.present-3.lores")));
		present3.setItemMeta(present3Meta);
		
		addItem(present3, new Action());
		
		ItemStack globe = SkullItem.getSkull("http://textures.minecraft.net/texture/b1dd4fe4a429abd665dfdb3e21321d6efa6a6b5e7b956db9c5d59c9efab25");
		ItemMeta globeMeta = globe.getItemMeta();
		globeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.globe.name")));
		globeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.globe.lores")));
		globe.setItemMeta(globeMeta);
		
		addItem(globe, new Action());
		
		ItemStack plant = SkullItem.getSkull("http://textures.minecraft.net/texture/bf9c71af3f7e819ec3c4496f291567aefb98f5584517da266ba0a6eccaa9a6e3");
		ItemMeta plantMeta = plant.getItemMeta();
		plantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.plant.name")));
		plantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.plant.lores")));
		plant.setItemMeta(plantMeta);
		
		addItem(plant, new Action());
		
		ItemStack craftingTable = SkullItem.getSkull("http://textures.minecraft.net/texture/ce7d8c242d2e4f8028f930be76f35014b21b5255208b1c04181b2574131b75a");
		ItemMeta craftingTableMeta = craftingTable.getItemMeta();
		craftingTableMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.crafting-table.name")));
		craftingTableMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.crafting-table.lores")));
		craftingTable.setItemMeta(craftingTableMeta);
		
		addItem(craftingTable, new Action());
		
		ItemStack pottedDaffodilPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/23fffc8955b0e8302898f7f015d849f0a01dbbb0427417506fb89ead54d45f6");
		ItemMeta pottedDaffodilPlantMeta = pottedDaffodilPlant.getItemMeta();
		pottedDaffodilPlantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.potted-daffodil-plant.name")));
		pottedDaffodilPlantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.potted-daffodil-plant.lores")));
		pottedDaffodilPlant.setItemMeta(pottedDaffodilPlantMeta);
		
		addItem(pottedDaffodilPlant, new Action());
		
		ItemStack pottedCamelliaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/9dc4c12bf2619cbfc8f22dc62c022ce15126cea3e212c28d9f96ea310ac4c42");
		ItemMeta pottedCamelliaPlantMeta = pottedCamelliaPlant.getItemMeta();
		pottedCamelliaPlantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.potted-camellia-plant.name")));
		pottedCamelliaPlantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.potted-camellia-plant.lores")));
		pottedCamelliaPlant.setItemMeta(pottedCamelliaPlantMeta);
		
		addItem(pottedCamelliaPlant, new Action());
		
		ItemStack candle = SkullItem.getSkull("http://textures.minecraft.net/texture/781226656d825291b1d7e456b74ecdce28672169641e6c35b1e23b9b40274e");
		ItemMeta candleMeta = candle.getItemMeta();
		candleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.candle.name")));
		candleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.candle.lores")));
		candle.setItemMeta(candleMeta);
		
		addItem(candle, new Action());
		
		ItemStack unlitCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/7acc61666adf1e4cd7cf57af3e1e17ba17310b2fcd8e3ed27cf88b7d0d88518");
		ItemMeta unlitCandleMeta = unlitCandle.getItemMeta();
		unlitCandleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.unlit-candle.name")));
		unlitCandleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.unlit-candle.lores")));
		unlitCandle.setItemMeta(unlitCandleMeta);
		
		addItem(unlitCandle, new Action());
		
		ItemStack oldBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/e344d83e7c6ece90d34c685a9a3384f8e8d0151633fc2eeae4d4b636862d33");
		ItemMeta oldBooksMeta = oldBooks.getItemMeta();
		oldBooksMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.old-books.name")));
		oldBooksMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.old-books.lores")));
		oldBooks.setItemMeta(oldBooksMeta);
		
		addItem(oldBooks, new Action());
		
		ItemStack pottedAzeleaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/c35257b799d3946927f2b325d366eb5104a5c35219ee4e4d35721bf28a210");
		ItemMeta pottedAzeleaPlantMeta = pottedAzeleaPlant.getItemMeta();
		pottedAzeleaPlantMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.potted-azelea-plant.name")));
		pottedAzeleaPlantMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.potted-azelea-plant.lores")));
		pottedAzeleaPlant.setItemMeta(pottedAzeleaPlantMeta);
		
		addItem(pottedAzeleaPlant, new Action());
		
		ItemStack whiteVase = SkullItem.getSkull("http://textures.minecraft.net/texture/ed7ad1b1db2b323f013b775a8f9481f1cd292bf9a58dd2905e3e1929d13bac");
		ItemMeta whiteVaseMeta = whiteVase.getItemMeta();
		whiteVaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.white-vase.name")));
		whiteVaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.white-vase.lores")));
		whiteVase.setItemMeta(whiteVaseMeta);
		
		addItem(whiteVase, new Action());
		
		ItemStack brownVase = SkullItem.getSkull("http://textures.minecraft.net/texture/ca76674c6cec6f31bfefe0483ddaeaad2386f02c3587f055eab91e44ca7b4");
		ItemMeta brownVaseMeta = brownVase.getItemMeta();
		brownVaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.brown-vase.name")));
		brownVaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.brown-vase.lores")));
		brownVase.setItemMeta(brownVaseMeta);
		
		addItem(brownVase, new Action());
		
		ItemStack pinkVase = SkullItem.getSkull("http://textures.minecraft.net/texture/3c6c1d85485ea567a536d2bb33dad8fd6dc31f1f74467e7c17d8d75a3d57");
		ItemMeta pinkVaseMeta = pinkVase.getItemMeta();
		pinkVaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.pink-vase.name")));
		pinkVaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.pink-vase.lores")));
		pinkVase.setItemMeta(pinkVaseMeta);
		
		addItem(pinkVase, new Action());
		
		ItemStack blueVase = SkullItem.getSkull("http://textures.minecraft.net/texture/e5847b5d159a2d0a1d73a2c8bf8d9eaf134f4a6854176ace7d8194ff782f21f");
		ItemMeta blueVaseMeta = blueVase.getItemMeta();
		blueVaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.blue-vase.name")));
		blueVaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.blue-vase.lores")));
		blueVase.setItemMeta(blueVaseMeta);
		
		addItem(blueVase, new Action());
		
		ItemStack furnace = SkullItem.getSkull("http://textures.minecraft.net/texture/dfd9b2f42d5f1c2a77b511fe41a4c6b5c192fb10b2ceadde05bd1af52a151");
		ItemMeta furnaceMeta = furnace.getItemMeta();
		furnaceMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.furnace.name")));
		furnaceMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.furnace.lores")));
		furnace.setItemMeta(furnaceMeta);
		
		addItem(furnace, new Action());
		
		ItemStack cauldron = SkullItem.getSkull("http://textures.minecraft.net/texture/422768db6573651626552bb26442609a7279c7843cb69b8e603d2c1db645d0");
		ItemMeta cauldronMeta = cauldron.getItemMeta();
		cauldronMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.cauldron.name")));
		cauldronMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.cauldron.lores")));
		cauldron.setItemMeta(cauldronMeta);
		
		addItem(cauldron, new Action());
		
		ItemStack aquarium = SkullItem.getSkull("http://textures.minecraft.net/texture/c2847cd5717e5f5a64e1ba9cb481dc9e22c78ca23f8516d553f55412fa113e0");
		ItemMeta aquariumMeta = aquarium.getItemMeta();
		aquariumMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.aquarium.name")));
		aquariumMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.aquarium.lores")));
		aquarium.setItemMeta(aquariumMeta);
		
		addItem(aquarium, new Action());
		
		ItemStack woodenCrate = SkullItem.getSkull("http://textures.minecraft.net/texture/af22b6a3a0f24bdeeab2a6acd9b1f52bb9594d5f6b1e2c05dddb219410c8");
		ItemMeta woodenCrateMeta = woodenCrate.getItemMeta();
		woodenCrateMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.wooden-crate.name")));
		woodenCrateMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.wooden-crate.lores")));
		woodenCrate.setItemMeta(woodenCrateMeta);
		
		addItem(woodenCrate, new Action());
		
		ItemStack christmasPresent = SkullItem.getSkull("http://textures.minecraft.net/texture/f5612dc7b86d71afc1197301c15fd979e9f39e7b1f41d8f1ebdf8115576e2e");
		ItemMeta christmasPresentMeta = christmasPresent.getItemMeta();
		christmasPresentMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.christmas-present.name")));
		christmasPresentMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.christmas-present.lores")));
		christmasPresent.setItemMeta(christmasPresentMeta);
		
		addItem(christmasPresent, new Action());
		
		ItemStack books = SkullItem.getSkull("http://textures.minecraft.net/texture/4411fc3f2de5b1eb9b87e9979091993c3490502eba7265bed93d8b1edf2cfa37");
		ItemMeta booksMeta = books.getItemMeta();
		booksMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.books.name")));
		booksMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.books.lores")));
		books.setItemMeta(booksMeta);
		
		addItem(books, new Action());
		
		ItemStack chineseMingVase = SkullItem.getSkull("http://textures.minecraft.net/texture/45ca5e85c4aea608bd3443cabdf1c2bdde3b431ad3aa38fffe04a32eb7e525");
		ItemMeta chineseMingVaseMeta = chineseMingVase.getItemMeta();
		chineseMingVaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.chinese-ming-vase.name")));
		chineseMingVaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.chinese-ming-vase.lores")));
		chineseMingVase.setItemMeta(chineseMingVaseMeta);
		
		addItem(chineseMingVase, new Action());
		
		ItemStack japaneseLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/785aeed252c927b2acecb1cd7fab450977e57d9296614e964d4ece4d7b89dd0");
		ItemMeta japaneseLanternMeta = japaneseLantern.getItemMeta();
		japaneseLanternMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.japanese-lantern.name")));
		japaneseLanternMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.japanese-lantern.lores")));
		japaneseLantern.setItemMeta(japaneseLanternMeta);
		
		addItem(japaneseLantern, new Action());
		
		ItemStack chineseLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/70808284ba50ec088dcf6d9e5549e91f82585f1c28299c40593cc8aaf2db50");
		ItemMeta chineseLanternMeta = chineseLantern.getItemMeta();
		chineseLanternMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.chinese-lantern.name")));
		chineseLanternMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.chinese-lantern.lores")));
		chineseLantern.setItemMeta(chineseLanternMeta);
		
		addItem(chineseLantern, new Action());
		
		ItemStack globe2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4d48e75ff55cb57533c7b904be887a374925f93832f7ae16b7923987e970");
		ItemMeta globe2Meta = globe2.getItemMeta();
		globe2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.globe-2.name")));
		globe2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.globe-2.lores")));
		globe2.setItemMeta(globe2Meta);
		
		addItem(globe2, new Action());
		
		ItemStack paperLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/26283e7a88d32719304a37ede0c6a8c5dc9d9cf9b00a179cf904e8ce821312");
		ItemMeta paperLanternMeta = paperLantern.getItemMeta();
		paperLanternMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.paper-lantern.name")));
		paperLanternMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.paper-lantern.lores")));
		paperLantern.setItemMeta(paperLanternMeta);
		
		addItem(paperLantern, new Action());
		
		ItemStack redCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/9fddddb8eee11bc312d1acfd621a446b56868aaf66a5071ca9425582b18cdd6");
		ItemMeta redCandleMeta = redCandle.getItemMeta();
		redCandleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.red-candle.name")));
		redCandleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.red-candle.lores")));
		redCandle.setItemMeta(redCandleMeta);
		
		addItem(redCandle, new Action());
		
		ItemStack unlitRedCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/ceaa55f43e5e3ad49b1140df2486626cf9f11dfaf76f1b278b5d93bf4edf124");
		ItemMeta unlitRedCandleMeta = unlitRedCandle.getItemMeta();
		unlitRedCandleMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.unlit-red-candle.name")));
		unlitRedCandleMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.unlit-red-candle.lores")));
		unlitRedCandle.setItemMeta(unlitRedCandleMeta);
		
		addItem(unlitRedCandle, new Action());
		
		ItemStack stackOfBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/82ae19107086dd314daf31d86618e51948a6e3e20d96dca17d21b25d42d2b24");
		ItemMeta stackOfBooksMeta = stackOfBooks.getItemMeta();
		stackOfBooksMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.stack-of-books.name")));
		stackOfBooksMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.stack-of-books.lores")));
		stackOfBooks.setItemMeta(stackOfBooksMeta);
		
		addItem(stackOfBooks, new Action());
		
		ItemStack stackOfBooks2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f493936544ca291b9fc7928663ae2763e1835756aa1b3952f965d525c3937b5d");
		ItemMeta stackOfBooks2Meta = stackOfBooks2.getItemMeta();
		stackOfBooks2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.stack-of-books-2.name")));
		stackOfBooks2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.stack-of-books-2.lores")));
		stackOfBooks2.setItemMeta(stackOfBooks2Meta);
		
		addItem(stackOfBooks2, new Action());
		
		ItemStack fishTank = SkullItem.getSkull("http://textures.minecraft.net/texture/4ce8fda1303b5b3239b96efba395f62717cc8785be32e1d889afe6b97bb1c1a");
		ItemMeta fishTankMeta = fishTank.getItemMeta();
		fishTankMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.fish-tank.name")));
		fishTankMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.fish-tank.lores")));
		fishTank.setItemMeta(fishTankMeta);
		
		addItem(fishTank, new Action());
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.close.name")));
		closeMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.close.lores")));
		close.setItemMeta(closeMeta);
		
		setItem(close, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 49);
		
		//next page		
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.next-page.name")));
		nextMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.next-page.lores")));
		next.setItemMeta(nextMeta);
		
		setItem(next, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked(), 2);
				return true;
			}
		}, 51);
		
		setStartingPoint(54);
		
		//page two
		ItemStack present4 = SkullItem.getSkull("http://textures.minecraft.net/texture/bd7a9f6ed08dd217fdf09f4652bf6b7af621e1d5f8963605349da73998a443");
		ItemMeta present4Meta = present4.getItemMeta();
		present4Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.present-4.name")));
		present4Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.present-4.lores")));
		present4.setItemMeta(present4Meta);
		
		addItem(present4, new Action());
		
		ItemStack present5 = SkullItem.getSkull("http://textures.minecraft.net/texture/64abe81e6f4961e0f6bd82f2d4135b6b5fc845739e71cfe3b8943531d921e");
		ItemMeta present5Meta = present5.getItemMeta();
		present5Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.present-5.name")));
		present5Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.present-5.lores")));
		present5.setItemMeta(present5Meta);
		
		addItem(present5, new Action());
		
		ItemStack cdCase = SkullItem.getSkull("http://textures.minecraft.net/texture/c2412548ebd6897e808c1fcbbf5bf7a625fe15fa48fbff4cf822b0c8e57a8");
		ItemMeta cdCaseMeta = cdCase.getItemMeta();
		cdCaseMeta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.cd-case.name")));
		cdCaseMeta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.cd-case.lores")));
		cdCase.setItemMeta(cdCaseMeta);
		
		addItem(cdCase, new Action());
		
		//previous page
		ItemStack previous2 = new ItemStack (Material.SUGAR_CANE);
		ItemMeta previous2Meta = previous2.getItemMeta();
		previous2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.previous-page.name")));
		previous2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.previous-page.lores")));
		previous2.setItemMeta(previous2Meta);
		
		setItem(previous2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				
				open((Player) event.getWhoClicked());
				return true;
			}
		}, 101);
		
		//close
		ItemStack close2 = new ItemStack(Material.BOOK);
		ItemMeta close2Meta = close2.getItemMeta();
		close2Meta.setDisplayName(MessageManager.translate(messages.getString("gui.heads.interior.close.name")));
		close2Meta.setLore(MessageManager.translate(messages.getStringList("gui.heads.interior.close.lores")));
		close2.setItemMeta(close2Meta);
		
		setItem(close2, new GuiAction() {
			@Override
			public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
				if (type != GuiActionType.CLICK)
					return false;
				
				InventoryClickEvent event = (InventoryClickEvent) e;
				Player player = (Player) event.getWhoClicked();
				
				player.closeInventory();
				removePlayer(player);
				return true;
			}
		}, 103);
	}
	
	public class Action extends GuiAction {
		@SuppressWarnings("deprecation")
		@Override
		public boolean actionPerformed(GuiActionType type, InventoryEvent e) {
			if (type != GuiActionType.CLICK)
				return false;
			
			InventoryClickEvent event = (InventoryClickEvent) e;
			event.setCursor(event.getCurrentItem());
			return true;
		}
	}
}