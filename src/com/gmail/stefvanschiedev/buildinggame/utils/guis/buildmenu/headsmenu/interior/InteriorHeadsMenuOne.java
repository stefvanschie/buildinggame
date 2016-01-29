package com.gmail.stefvanschiedev.buildinggame.utils.guis.buildmenu.headsmenu.interior;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.NBTItem;
import com.gmail.stefvanschiedev.buildinggame.utils.nbt.item.skull.SkullItem;

public class InteriorHeadsMenuOne {

	public void show(Player player) {
		Inventory inventory = Bukkit.createInventory(null, 54, ChatColor.GREEN + "Interior");
		
		ItemStack pottedRosePlant = SkullItem.getSkull("http://textures.minecraft.net/texture/9dba38e9fc67f72c458fdac8ecd7cabaed3eb83737143a0128350a1ab381e3e");
		ItemMeta pottedRosePlantMeta = pottedRosePlant.getItemMeta();
		pottedRosePlantMeta.setDisplayName(ChatColor.GOLD + "Potted Rose Plant");
		pottedRosePlant.setItemMeta(pottedRosePlantMeta);
		
		ItemStack pottedSalviaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/ed80c26f904b57e631e39ebc446ec1af2dce3432eb8431fbd19087adb4abcb");
		ItemMeta pottedSalviaPlantMeta = pottedSalviaPlant.getItemMeta();
		pottedSalviaPlantMeta.setDisplayName(ChatColor.GOLD + "Potted Salvia Plant");
		pottedSalviaPlant.setItemMeta(pottedSalviaPlantMeta);
		
		ItemStack toiletpaper = SkullItem.getSkull("http://textures.minecraft.net/texture/7380c7e621a1f4da543e4c7ab1494ee184b87bb132418512c9eee858f9de1db");
		ItemMeta toiletpaperMeta = toiletpaper.getItemMeta();
		toiletpaperMeta.setDisplayName(ChatColor.GOLD + "Toiletpaper");
		toiletpaper.setItemMeta(toiletpaperMeta);
		
		ItemStack toiletroll = SkullItem.getSkull("http://textures.minecraft.net/texture/ded3d34da8ae8b482f266ae175cd22cce3b0cfe2ca2a16416c1c84cb1e8e3b78");
		ItemMeta toiletrollMeta = toiletroll.getItemMeta();
		toiletrollMeta.setDisplayName(ChatColor.GOLD + "Toiletroll");
		toiletroll.setItemMeta(toiletrollMeta);
		
		ItemStack winRARBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/8d1b28f886ca3c8fc4301b785bf38c619ea66b68352a882bf8080e63034e0");
		ItemMeta winRARBooksMeta = winRARBooks.getItemMeta();
		winRARBooksMeta.setDisplayName(ChatColor.GOLD + "WinRAR Books");
		winRARBooks.setItemMeta(winRARBooksMeta);
		
		ItemStack bookcase = SkullItem.getSkull("http://textures.minecraft.net/texture/32a18d36c746e4843850a3b65c51150ab3f75d13b7f8cc55c7686febd17b6a");
		ItemMeta bookcaseMeta = bookcase.getItemMeta();
		bookcaseMeta.setDisplayName(ChatColor.GOLD + "Bookcase");
		bookcase.setItemMeta(bookcaseMeta);
		
		ItemStack bookshelf = SkullItem.getSkull("http://textures.minecraft.net/texture/93184d6ad4a0e15b3a71dadf45f6c7ce9ec96172bc9ff25fd3af787a379bd1");
		ItemMeta bookshelfMeta = bookshelf.getItemMeta();
		bookshelfMeta.setDisplayName(ChatColor.GOLD + "Bookshelf");
		bookshelf.setItemMeta(bookshelfMeta);
		
		ItemStack pileOfBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/21c63d9b9fd8742eaeb04c692172cb9da43781698a575cdabe1c04df12c3f");
		ItemMeta pileOfBooksMeta = pileOfBooks.getItemMeta();
		pileOfBooksMeta.setDisplayName(ChatColor.GOLD + "Pile of Books");
		pileOfBooks.setItemMeta(pileOfBooksMeta);
		
		ItemStack chest = SkullItem.getSkull("http://textures.minecraft.net/texture/6f68d509b5d1669b971dd1d4df2e47e19bcb1b33bf1a7ff1dda29bfc6f9ebf");
		ItemMeta chestMeta = chest.getItemMeta();
		chestMeta.setDisplayName(ChatColor.GOLD + "Chest");
		chest.setItemMeta(chestMeta);
		
		ItemStack enderchest = SkullItem.getSkull("http://textures.minecraft.net/texture/a6cc486c2be1cb9dfcb2e53dd9a3e9a883bfadb27cb956f1896d602b4067");
		ItemMeta enderchestMeta = enderchest.getItemMeta();
		enderchestMeta.setDisplayName(ChatColor.GOLD + "Enderchest");
		enderchest.setItemMeta(enderchestMeta);
		
		ItemStack ironChest = SkullItem.getSkull("http://textures.minecraft.net/texture/e8e5544af7f5489cc27491ca68fa92384b8ea5cf20b5c8198adb7bfd12bc2bc2");
		ItemMeta ironChestMeta = ironChest.getItemMeta();
		ironChestMeta.setDisplayName(ChatColor.GOLD + "Iron Chest");
		ironChest.setItemMeta(ironChestMeta);
		
		ItemStack medicineChest = SkullItem.getSkull("http://textures.minecraft.net/texture/f7c7df52b5e50badb61fed7212d979e63fe94f1bde02b2968c6b156a770126c");
		ItemMeta medicineChestMeta = medicineChest.getItemMeta();
		medicineChestMeta.setDisplayName(ChatColor.GOLD + "Medicine Chest");
		medicineChest.setItemMeta(medicineChestMeta);
		
		ItemStack cabinet = SkullItem.getSkull("http://textures.minecraft.net/texture/f73c56ac528f3b9dd13789623b52f60233262e59e13cfebcf6586ca55449fcb");
		ItemMeta cabinetMeta = cabinet.getItemMeta();
		cabinetMeta.setDisplayName(ChatColor.GOLD + "Cabinet");
		cabinet.setItemMeta(cabinetMeta);
		
		ItemStack present = SkullItem.getSkull("http://textures.minecraft.net/texture/f0afa4fffd10863e76c698da2c9c9e799bcf9ab9aa37d8312881734225d3ca");
		ItemMeta presentMeta = present.getItemMeta();
		presentMeta.setDisplayName(ChatColor.GOLD + "Present");
		present.setItemMeta(presentMeta);
		
		ItemStack present2 = SkullItem.getSkull("http://textures.minecraft.net/texture/13cfbf2bdfd48514bfbace9518c7664112df2c173e8c7ad92b3e65621a9ed6e0");
		ItemMeta present2Meta = present2.getItemMeta();
		present2Meta.setDisplayName(ChatColor.GOLD + "Present");
		present2.setItemMeta(present2Meta);
		
		ItemStack present3 = SkullItem.getSkull("http://textures.minecraft.net/texture/c6e69b1c7e69bcd49ed974f5ac36ea275efabb8c649cb2b1fe9d6ea6166ec3");
		ItemMeta present3Meta = present3.getItemMeta();
		present3Meta.setDisplayName(ChatColor.GOLD + "Present");
		present3.setItemMeta(present3Meta);
		
		ItemStack globe = SkullItem.getSkull("http://textures.minecraft.net/texture/b1dd4fe4a429abd665dfdb3e21321d6efa6a6b5e7b956db9c5d59c9efab25");
		ItemMeta globeMeta = globe.getItemMeta();
		globeMeta.setDisplayName(ChatColor.GOLD + "Globe");
		globe.setItemMeta(globeMeta);
		
		ItemStack plant = SkullItem.getSkull("http://textures.minecraft.net/texture/bf9c71af3f7e819ec3c4496f291567aefb98f5584517da266ba0a6eccaa9a6e3");
		ItemMeta plantMeta = plant.getItemMeta();
		plantMeta.setDisplayName(ChatColor.GOLD + "Plant");
		plant.setItemMeta(plantMeta);
		
		ItemStack craftingTable = SkullItem.getSkull("http://textures.minecraft.net/texture/ce7d8c242d2e4f8028f930be76f35014b21b5255208b1c04181b2574131b75a");
		ItemMeta craftingTableMeta = craftingTable.getItemMeta();
		craftingTableMeta.setDisplayName(ChatColor.GOLD + "Crafting Table");
		craftingTable.setItemMeta(craftingTableMeta);
		
		ItemStack pottedDaffodilPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/23fffc8955b0e8302898f7f015d849f0a01dbbb0427417506fb89ead54d45f6");
		ItemMeta pottedDaffodilPlantMeta = pottedDaffodilPlant.getItemMeta();
		pottedDaffodilPlantMeta.setDisplayName(ChatColor.GOLD + "Potted Daffodil Plant");
		pottedDaffodilPlant.setItemMeta(pottedDaffodilPlantMeta);
		
		ItemStack pottedCamelliaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/9dc4c12bf2619cbfc8f22dc62c022ce15126cea3e212c28d9f96ea310ac4c42");
		ItemMeta pottedCamelliaPlantMeta = pottedCamelliaPlant.getItemMeta();
		pottedCamelliaPlantMeta.setDisplayName(ChatColor.GOLD + "Potted Camellia Plant");
		pottedCamelliaPlant.setItemMeta(pottedCamelliaPlantMeta);
		
		ItemStack candle = SkullItem.getSkull("http://textures.minecraft.net/texture/781226656d825291b1d7e456b74ecdce28672169641e6c35b1e23b9b40274e");
		ItemMeta candleMeta = candle.getItemMeta();
		candleMeta.setDisplayName(ChatColor.GOLD + "Candle");
		candle.setItemMeta(candleMeta);
		
		ItemStack unlitCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/7acc61666adf1e4cd7cf57af3e1e17ba17310b2fcd8e3ed27cf88b7d0d88518");
		ItemMeta unlitCandleMeta = unlitCandle.getItemMeta();
		unlitCandleMeta.setDisplayName(ChatColor.GOLD + "Unlit Candle");
		unlitCandle.setItemMeta(unlitCandleMeta);
		
		ItemStack oldBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/e344d83e7c6ece90d34c685a9a3384f8e8d0151633fc2eeae4d4b636862d33");
		ItemMeta oldBooksMeta = oldBooks.getItemMeta();
		oldBooksMeta.setDisplayName(ChatColor.GOLD + "Old Books");
		oldBooks.setItemMeta(oldBooksMeta);
		
		ItemStack pottedAzeleaPlant = SkullItem.getSkull("http://textures.minecraft.net/texture/c35257b799d3946927f2b325d366eb5104a5c35219ee4e4d35721bf28a210");
		ItemMeta pottedAzeleaPlantMeta = pottedAzeleaPlant.getItemMeta();
		pottedAzeleaPlantMeta.setDisplayName(ChatColor.GOLD + "Potted Azelea Plant");
		pottedAzeleaPlant.setItemMeta(pottedAzeleaPlantMeta);
		
		ItemStack whiteVase = SkullItem.getSkull("http://textures.minecraft.net/texture/ed7ad1b1db2b323f013b775a8f9481f1cd292bf9a58dd2905e3e1929d13bac");
		ItemMeta whiteVaseMeta = whiteVase.getItemMeta();
		whiteVaseMeta.setDisplayName(ChatColor.GOLD + "White Vase");
		whiteVase.setItemMeta(whiteVaseMeta);
		
		ItemStack brownVase = SkullItem.getSkull("http://textures.minecraft.net/texture/ca76674c6cec6f31bfefe0483ddaeaad2386f02c3587f055eab91e44ca7b4");
		ItemMeta brownVaseMeta = brownVase.getItemMeta();
		brownVaseMeta.setDisplayName(ChatColor.GOLD + "Brown Vase");
		brownVase.setItemMeta(brownVaseMeta);
		
		ItemStack pinkVase = SkullItem.getSkull("http://textures.minecraft.net/texture/3c6c1d85485ea567a536d2bb33dad8fd6dc31f1f74467e7c17d8d75a3d57");
		ItemMeta pinkVaseMeta = pinkVase.getItemMeta();
		pinkVaseMeta.setDisplayName(ChatColor.GOLD + "Pink Vase");
		pinkVase.setItemMeta(pinkVaseMeta);
		
		ItemStack blueVase = SkullItem.getSkull("http://textures.minecraft.net/texture/e5847b5d159a2d0a1d73a2c8bf8d9eaf134f4a6854176ace7d8194ff782f21f");
		ItemMeta blueVaseMeta = blueVase.getItemMeta();
		blueVaseMeta.setDisplayName(ChatColor.GOLD + "Blue Vase");
		blueVase.setItemMeta(blueVaseMeta);
		
		ItemStack furnace = SkullItem.getSkull("http://textures.minecraft.net/texture/dfd9b2f42d5f1c2a77b511fe41a4c6b5c192fb10b2ceadde05bd1af52a151");
		ItemMeta furnaceMeta = furnace.getItemMeta();
		furnaceMeta.setDisplayName(ChatColor.GOLD + "Furnace");
		furnace.setItemMeta(furnaceMeta);
		
		ItemStack cauldron = SkullItem.getSkull("http://textures.minecraft.net/texture/422768db6573651626552bb26442609a7279c7843cb69b8e603d2c1db645d0");
		ItemMeta cauldronMeta = cauldron.getItemMeta();
		cauldronMeta.setDisplayName(ChatColor.GOLD + "Cauldron");
		cauldron.setItemMeta(cauldronMeta);
		
		ItemStack aquarium = SkullItem.getSkull("http://textures.minecraft.net/texture/c2847cd5717e5f5a64e1ba9cb481dc9e22c78ca23f8516d553f55412fa113e0");
		ItemMeta aquariumMeta = aquarium.getItemMeta();
		aquariumMeta.setDisplayName(ChatColor.GOLD + "Aquarium");
		aquarium.setItemMeta(aquariumMeta);
		
		ItemStack woodenCrate = SkullItem.getSkull("http://textures.minecraft.net/texture/af22b6a3a0f24bdeeab2a6acd9b1f52bb9594d5f6b1e2c05dddb219410c8");
		ItemMeta woodenCrateMeta = woodenCrate.getItemMeta();
		woodenCrateMeta.setDisplayName(ChatColor.GOLD + "Wooden Crate");
		woodenCrate.setItemMeta(woodenCrateMeta);
		
		ItemStack christmasPresent = SkullItem.getSkull("http://textures.minecraft.net/texture/f5612dc7b86d71afc1197301c15fd979e9f39e7b1f41d8f1ebdf8115576e2e");
		ItemMeta christmasPresentMeta = christmasPresent.getItemMeta();
		christmasPresentMeta.setDisplayName(ChatColor.GOLD + "Christmas Present");
		christmasPresent.setItemMeta(christmasPresentMeta);
		
		ItemStack books = SkullItem.getSkull("http://textures.minecraft.net/texture/4411fc3f2de5b1eb9b87e9979091993c3490502eba7265bed93d8b1edf2cfa37");
		ItemMeta booksMeta = books.getItemMeta();
		booksMeta.setDisplayName(ChatColor.GOLD + "Books");
		books.setItemMeta(booksMeta);
		
		ItemStack chineseMingVase = SkullItem.getSkull("http://textures.minecraft.net/texture/45ca5e85c4aea608bd3443cabdf1c2bdde3b431ad3aa38fffe04a32eb7e525");
		ItemMeta chineseMingVaseMeta = chineseMingVase.getItemMeta();
		chineseMingVaseMeta.setDisplayName(ChatColor.GOLD + "Chinese Ming Vase");
		chineseMingVase.setItemMeta(chineseMingVaseMeta);
		
		ItemStack japaneseLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/785aeed252c927b2acecb1cd7fab450977e57d9296614e964d4ece4d7b89dd0");
		ItemMeta japaneseLanternMeta = japaneseLantern.getItemMeta();
		japaneseLanternMeta.setDisplayName(ChatColor.GOLD + "Japanese Lantern");
		japaneseLantern.setItemMeta(japaneseLanternMeta);
		
		ItemStack chineseLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/70808284ba50ec088dcf6d9e5549e91f82585f1c28299c40593cc8aaf2db50");
		ItemMeta chineseLanternMeta = chineseLantern.getItemMeta();
		chineseLanternMeta.setDisplayName(ChatColor.GOLD + "Chinese Lantern");
		chineseLantern.setItemMeta(chineseLanternMeta);
		
		ItemStack globe2 = SkullItem.getSkull("http://textures.minecraft.net/texture/4d48e75ff55cb57533c7b904be887a374925f93832f7ae16b7923987e970");
		ItemMeta globe2Meta = globe2.getItemMeta();
		globe2Meta.setDisplayName(ChatColor.GOLD + "Globe");
		globe2.setItemMeta(globe2Meta);
		
		ItemStack paperLantern = SkullItem.getSkull("http://textures.minecraft.net/texture/26283e7a88d32719304a37ede0c6a8c5dc9d9cf9b00a179cf904e8ce821312");
		ItemMeta paperLanternMeta = paperLantern.getItemMeta();
		paperLanternMeta.setDisplayName(ChatColor.GOLD + "Paper Lantern");
		paperLantern.setItemMeta(paperLanternMeta);
		
		ItemStack redCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/9fddddb8eee11bc312d1acfd621a446b56868aaf66a5071ca9425582b18cdd6");
		ItemMeta redCandleMeta = redCandle.getItemMeta();
		redCandleMeta.setDisplayName(ChatColor.GOLD + "Red Candle");
		redCandle.setItemMeta(redCandleMeta);
		
		ItemStack unlitRedCandle = SkullItem.getSkull("http://textures.minecraft.net/texture/ceaa55f43e5e3ad49b1140df2486626cf9f11dfaf76f1b278b5d93bf4edf124");
		ItemMeta unlitRedCandleMeta = unlitRedCandle.getItemMeta();
		unlitRedCandleMeta.setDisplayName(ChatColor.GOLD + "Unlit Red Candle");
		unlitRedCandle.setItemMeta(unlitRedCandleMeta);
		
		ItemStack stackOfBooks = SkullItem.getSkull("http://textures.minecraft.net/texture/82ae19107086dd314daf31d86618e51948a6e3e20d96dca17d21b25d42d2b24");
		ItemMeta stackOfBooksMeta = stackOfBooks.getItemMeta();
		stackOfBooksMeta.setDisplayName(ChatColor.GOLD + "Stack of Books");
		stackOfBooks.setItemMeta(stackOfBooksMeta);
		
		ItemStack stackOfBooks2 = SkullItem.getSkull("http://textures.minecraft.net/texture/f493936544ca291b9fc7928663ae2763e1835756aa1b3952f965d525c3937b5d");
		ItemMeta stackOfBooks2Meta = stackOfBooks2.getItemMeta();
		stackOfBooks2Meta.setDisplayName(ChatColor.GOLD + "Stack of Books");
		stackOfBooks2.setItemMeta(stackOfBooks2Meta);
		
		ItemStack fishTank = SkullItem.getSkull("http://textures.minecraft.net/texture/4ce8fda1303b5b3239b96efba395f62717cc8785be32e1d889afe6b97bb1c1a");
		ItemMeta fishTankMeta = fishTank.getItemMeta();
		fishTankMeta.setDisplayName(ChatColor.GOLD + "Fish Tank");
		fishTank.setItemMeta(fishTankMeta);
		
		//close
		ItemStack close = new ItemStack(Material.BOOK);
		ItemMeta closeMeta = close.getItemMeta();
		closeMeta.setDisplayName(ChatColor.GREEN + "Close Menu");
		close.setItemMeta(closeMeta);
				
		//next page		
		ItemStack next = new ItemStack(Material.SUGAR_CANE);
		ItemMeta nextMeta = next.getItemMeta();
		nextMeta.setDisplayName(ChatColor.GREEN + "Next Page");
		next.setItemMeta(nextMeta);
		NBTItem nextNbt = new NBTItem(next);
		nextNbt.setInteger("page", 2);
		next = nextNbt.getItem();
		
		inventory.setItem(0, pottedRosePlant);
		inventory.setItem(1, pottedSalviaPlant);
		inventory.setItem(2, toiletpaper);
		inventory.setItem(3, toiletroll);
		inventory.setItem(4, winRARBooks);
		inventory.setItem(5, bookcase);
		inventory.setItem(6, bookshelf);
		inventory.setItem(7, pileOfBooks);
		inventory.setItem(8, chest);
		inventory.setItem(9, enderchest);
		inventory.setItem(10, ironChest);
		inventory.setItem(11, medicineChest);
		inventory.setItem(12, cabinet);
		inventory.setItem(13, present);
		inventory.setItem(14, present2);
		inventory.setItem(15, present3);
		inventory.setItem(16, globe);
		inventory.setItem(17, plant);
		inventory.setItem(18, craftingTable);
		inventory.setItem(19, pottedDaffodilPlant);
		inventory.setItem(20, pottedCamelliaPlant);
		inventory.setItem(21, candle);
		inventory.setItem(22, unlitCandle);
		inventory.setItem(23, oldBooks);
		inventory.setItem(24, pottedAzeleaPlant);
		inventory.setItem(25, whiteVase);
		inventory.setItem(26, brownVase);
		inventory.setItem(27, pinkVase);
		inventory.setItem(28, blueVase);
		inventory.setItem(29, furnace);
		inventory.setItem(30, cauldron);
		inventory.setItem(31, aquarium);
		inventory.setItem(32, woodenCrate);
		inventory.setItem(33, christmasPresent);
		inventory.setItem(34, books);
		inventory.setItem(35, chineseMingVase);
		inventory.setItem(36, japaneseLantern);
		inventory.setItem(37, chineseLantern);
		inventory.setItem(38, globe2);
		inventory.setItem(39, paperLantern);
		inventory.setItem(40, redCandle);
		inventory.setItem(41, unlitRedCandle);
		inventory.setItem(42, stackOfBooks);
		inventory.setItem(43, stackOfBooks2);
		inventory.setItem(44, fishTank);
		
		inventory.setItem(49, close);
		inventory.setItem(51, next);
		
		player.openInventory(inventory);
	}
}