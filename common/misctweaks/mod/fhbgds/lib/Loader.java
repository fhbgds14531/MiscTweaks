package misctweaks.mod.fhbgds.lib;

import java.util.ArrayList;

import misctweaks.mod.fhbgds.block.BioInit;
import misctweaks.mod.fhbgds.block.BlockAsh;
import misctweaks.mod.fhbgds.block.BlockAshHard;
import misctweaks.mod.fhbgds.block.BlockFertileBlock;
import misctweaks.mod.fhbgds.block.BlockFlintBlock;
import misctweaks.mod.fhbgds.block.BlockFlintIngotBlock;
import misctweaks.mod.fhbgds.block.BlockGlowingGlass;
import misctweaks.mod.fhbgds.block.BlockGlowingGlassPane;
import misctweaks.mod.fhbgds.block.BlockMetalSheet;
import misctweaks.mod.fhbgds.block.BlockMetalStack;
import misctweaks.mod.fhbgds.block.BlockQuartzFence;
import misctweaks.mod.fhbgds.block.BlockSmoothQuartz;
import misctweaks.mod.fhbgds.block.BlockSmoothStairs;
import misctweaks.mod.fhbgds.block.BlockTempBlock;
import misctweaks.mod.fhbgds.block.MyFurnace;
import misctweaks.mod.fhbgds.block.WoodGenerator;
import misctweaks.mod.fhbgds.crafting.MyFurnaceRecipes;
import misctweaks.mod.fhbgds.item.ItemAsh;
import misctweaks.mod.fhbgds.item.ItemBiomash;
import misctweaks.mod.fhbgds.item.ItemCookedCarrot;
import misctweaks.mod.fhbgds.item.ItemFertileSapling;
import misctweaks.mod.fhbgds.item.ItemFlintArmor;
import misctweaks.mod.fhbgds.item.ItemFlintAxe;
import misctweaks.mod.fhbgds.item.ItemFlintEpicPick;
import misctweaks.mod.fhbgds.item.ItemFlintIngot;
import misctweaks.mod.fhbgds.item.ItemFlintPick;
import misctweaks.mod.fhbgds.item.ItemFlintShovel;
import misctweaks.mod.fhbgds.item.ItemFlintSword;
import misctweaks.mod.fhbgds.item.ItemMagicCore;
import misctweaks.mod.fhbgds.item.ItemMetalSheet;
import misctweaks.mod.fhbgds.item.ItemMilkshake;
import misctweaks.mod.fhbgds.item.ItemStoneStick;
import misctweaks.mod.fhbgds.item.ItemWand;
import misctweaks.mod.fhbgds.item.ItemWandCreative;
import misctweaks.mod.fhbgds.tileentity.TileEntityBioInit;
import misctweaks.mod.fhbgds.tileentity.TileEntityMyFurnace;
import misctweaks.mod.fhbgds.tileentity.TileEntityWoodGenerator;
import misctweaks.mod.fhbgds.util.CreativeTabMiscTweaks;
import misctweaks.mod.fhbgds.util.PlayerTracker;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Loader {
	
	public static final CreativeTabs tab = new CreativeTabMiscTweaks("MiscTweaks Blocks/Items");
	public static final CreativeTabs tab1 = new CreativeTabMiscTweaks("MiscTweaks Tools/Combat");
	public static final Material placeholder = new Material(MapColor.airColor).setReplaceable();
	public static final EnumToolMaterial FLINT = EnumHelper.addToolMaterial("FLINT", 4, 2000, 15.0F, 7.0F, 15);
	public static final EnumArmorMaterial FLINT_ARMOR = EnumHelper.addArmorMaterial("FLINT", 50, new int[] {4, 9, 7, 4}, 15);
	
	public static void initObjects(){
		
		ash = new ItemAsh(5006).setUnlocalizedName("ash")
				.setCreativeTab(tab);
		
		flintBlock = new BlockFlintBlock(512, Material.rock)
			.setUnlocalizedName("flintBlock").setHardness(1.0F)
			.setCreativeTab(tab)
			.setStepSound(Block.soundStoneFootstep);
		
		flintIngot = new ItemFlintIngot(5000)
			.setUnlocalizedName("flintIngot")
			.setCreativeTab(tab);
		
		flintPick = new ItemFlintPick(5098, FLINT)
			.setUnlocalizedName("flintPick")
			.setCreativeTab(tab1);
		
		stoneStick = new ItemStoneStick(5002)
			.setUnlocalizedName("cobbleStick")
			.setCreativeTab(tab);
		
		wand = new ItemWand(5003, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("wand")
			.setCreativeTab(tab1);
		
		creativeWand = new ItemWandCreative(5004, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("creativeWand")
			.setCreativeTab(tab1);
		
		glowingGlassPane = new BlockGlowingGlassPane(514, null, null, Material.glass, false)
			.setUnlocalizedName("glowingGlassPane").setHardness(0.3F)
			.setStepSound(Block.soundGlassFootstep).setLightValue(1.0F)
			.setCreativeTab(tab);
	
		glowingGlass = new BlockGlowingGlass(513, Material.glass).setUnlocalizedName("glowingGlass")
			.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
			.setLightValue(1.0F).setCreativeTab(tab);
	
		metalSheet = new BlockMetalSheet(515, Material.iron).setUnlocalizedName("metalSheet");
	
		magicCore = new ItemMagicCore(5008).setUnlocalizedName("magicCore")
			.setCreativeTab(tab);
		
		itemMetalSheet = new ItemMetalSheet(5009).setUnlocalizedName("itemMetalSheet")
				.setCreativeTab(tab);
		
		metalStack = new BlockMetalStack(516, Material.iron).setUnlocalizedName("metalStack")
				.setHardness(0.8F).setResistance(0.6F).setCreativeTab(tab);
		
		smoothQuartz = new BlockSmoothQuartz(517, Material.rock)
			.setUnlocalizedName("smoothQuartz").setHardness(1.0F)
			.setCreativeTab(tab)
			.setStepSound(Block.soundStoneFootstep);
		
		blockAsh = new BlockAsh(254, Material.sand).setUnlocalizedName("blockAsh")
				.setCreativeTab(tab)
				.setHardness(0.5F).setStepSound(Block.soundSandFootstep);
		
		blockAshHard = new BlockAshHard(255, Material.rock).setUnlocalizedName("blockAshHard")
				.setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(tab)
				.setResistance(1.0F);
		
		quartzFence = new BlockQuartzFence(520).setUnlocalizedName("quartzFence")
				.setCreativeTab(tab);
		
		smoothStairs = new BlockSmoothStairs(521, Material.rock).setUnlocalizedName("smoothStairs")
				.setCreativeTab(tab).setHardness(1.0F).setResistance(1.0F);
		
		myFurnaceIdle = new MyFurnace(523, false).setUnlocalizedName("myFurnace")
				.setHardness(4.0F).setResistance(4.0F).setCreativeTab(tab);
		
		myFurnaceActive = new MyFurnace(524, true).setUnlocalizedName("myFurnaceActive")
				.setHardness(4.0F).setResistance(4.0F);
		
		flintIngotBlock = new BlockFlintIngotBlock(525, Material.rock).setUnlocalizedName("flintIngotBlock")
				.setCreativeTab(tab).setHardness(4.5F).setResistance(4.5F);
		
		helmet = (ItemFlintArmor) new ItemFlintArmor(5090, 0, FLINT_ARMOR).setUnlocalizedName("flintHelmet")
				.setCreativeTab(tab1);
		
		plate = (ItemFlintArmor) new ItemFlintArmor(5091, 1, FLINT_ARMOR).setUnlocalizedName("flintPlate")
				.setCreativeTab(tab1);
		
		leggings = (ItemFlintArmor) new ItemFlintArmor(5092, 2, FLINT_ARMOR).setUnlocalizedName("flintLeggings")
				.setCreativeTab(tab1);
		
		boots = (ItemFlintArmor) new ItemFlintArmor(5093, 3, FLINT_ARMOR).setUnlocalizedName("flintBoots")
				.setCreativeTab(tab1);
		
		bioInitIdle = new BioInit(528, false).setUnlocalizedName("bioInitIdle").setCreativeTab(tab)
				.setHardness(4.0F).setResistance(4.0F);
		
		bioInit = new BioInit(529, true).setUnlocalizedName("bioInitActive")
				.setHardness(4.0F).setResistance(4.0F);
		
		biomash = new ItemBiomash(5094).setUnlocalizedName("biomash").setCreativeTab(tab);
		
		fertileSapling = new ItemFertileSapling(5095).setUnlocalizedName("fertileSapling").setCreativeTab(tab);
		
		woodGeneratorIdle = new WoodGenerator(530, false).setCreativeTab(tab).setUnlocalizedName("woodGen")
				.setHardness(4).setResistance(4);
		
		woodGeneratorActive = new WoodGenerator(531, true).setUnlocalizedName("woodGenOn")
				.setHardness(4).setResistance(4);
		
		milkshake = new ItemMilkshake(5096, 3, 3, false).setUnlocalizedName("milkshake").setCreativeTab(tab).setMaxStackSize(1);
		
		flintSword = new ItemFlintSword(5097, FLINT).setUnlocalizedName("flintSword").setCreativeTab(tab1)
				.setMaxStackSize(1);
		
		flintAxe = new ItemFlintAxe(5099, FLINT).setUnlocalizedName("flintAxe").setCreativeTab(tab1).setMaxStackSize(1);
		
		epicFlintPick = new ItemFlintEpicPick(5100, FLINT).setUnlocalizedName("epicFlintPick")
				.setCreativeTab(tab1).setMaxStackSize(1);
		
		cookedCarrot = new ItemCookedCarrot(5101, 10, 100, false).setUnlocalizedName("cookedCarrot").setCreativeTab(tab);
		
		fertileDirt = new BlockFertileBlock(532, Material.ground).setUnlocalizedName("fertileDirt").setCreativeTab(tab)
				.setHardness(0.6f).setStepSound(Block.soundPowderFootstep);
		
		flintShovel = new ItemFlintShovel(5102, FLINT).setUnlocalizedName("flintShovel").setCreativeTab(tab1);
		
		tempBlock = new BlockTempBlock(532, placeholder).setUnlocalizedName("tempBlock").setHardness(0).setResistance(0);
	}
	
	public static void gameRegistryStuff(){
		GameRegistry.registerBlock(flintBlock, Reference.MOD_ID + flintBlock.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlassPane, Reference.MOD_ID + glowingGlassPane.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlass, Reference.MOD_ID + glowingGlass.getUnlocalizedName());
		GameRegistry.registerBlock(metalSheet, Reference.MOD_ID + metalSheet.getUnlocalizedName());
		GameRegistry.registerBlock(metalStack, Reference.MOD_ID + metalStack.getUnlocalizedName());
		GameRegistry.registerBlock(smoothQuartz, Reference.MOD_ID + smoothQuartz.getUnlocalizedName());
		GameRegistry.registerBlock(blockAsh, Reference.MOD_ID + blockAsh.getUnlocalizedName());
		GameRegistry.registerBlock(blockAshHard, Reference.MOD_ID + blockAshHard.getUnlocalizedName());
		GameRegistry.registerBlock(quartzFence, Reference.MOD_ID + quartzFence.getUnlocalizedName());
		GameRegistry.registerBlock(smoothStairs, Reference.MOD_ID + smoothStairs.getUnlocalizedName());
		GameRegistry.registerBlock(myFurnaceIdle, Reference.MOD_ID + myFurnaceIdle.getUnlocalizedName());
		GameRegistry.registerBlock(myFurnaceActive, Reference.MOD_ID + myFurnaceActive.getUnlocalizedName());
		GameRegistry.registerBlock(flintIngotBlock, Reference.MOD_ID + flintIngotBlock.getUnlocalizedName());
		GameRegistry.registerBlock(bioInitIdle, Reference.MOD_ID + bioInitIdle.getUnlocalizedName());
		GameRegistry.registerBlock(bioInit, Reference.MOD_ID + bioInit.getUnlocalizedName());
		GameRegistry.registerBlock(woodGeneratorActive, Reference.MOD_ID + woodGeneratorActive.getUnlocalizedName());
		GameRegistry.registerBlock(woodGeneratorIdle, Reference.MOD_ID + woodGeneratorIdle.getUnlocalizedName());
		GameRegistry.registerBlock(fertileDirt, Reference.MOD_ID + fertileDirt.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityMyFurnace.class, "MyFurnace");
		GameRegistry.registerTileEntity(TileEntityBioInit.class, "BiochemicalInitializer");
		GameRegistry.registerTileEntity(TileEntityWoodGenerator.class, "WoodGenerator");
		GameRegistry.registerPlayerTracker(new PlayerTracker());
		MinecraftForge.setBlockHarvestLevel(fertileDirt, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(flintIngotBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(flintBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowingGlassPane, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowingGlass, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalSheet, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalStack, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(smoothQuartz, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(blockAshHard, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(quartzFence, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(smoothStairs, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(myFurnaceIdle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(myFurnaceActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(bioInit, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(bioInitIdle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(woodGeneratorActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(woodGeneratorIdle, "pickaxe", 1);
	}

	public static void registerNames(String par1String){
		if(par1String == "Blocks/Items"){
			LanguageRegistry.instance().addStringLocalization("tile.flintBlock.name", "en_US", "Block of Flint");
			LanguageRegistry.instance().addStringLocalization("item.flintIngot.name", "en_US", "Flint Ingot");
			LanguageRegistry.instance().addStringLocalization("item.itemMetalSheet.name", "en_US", "Sheet of Metal");
			LanguageRegistry.instance().addStringLocalization("item.flintPick.name", "en_US", "Flint Pickaxe");
			LanguageRegistry.instance().addStringLocalization("item.cobbleStick.name", "Stone Stick");
			LanguageRegistry.instance().addStringLocalization("tile.glowingGlassPane.name", "en_US", "Glowing Glass Pane");
			LanguageRegistry.instance().addStringLocalization("tile.glowingGlass.name", "en_US", "Glowing Glass");
			LanguageRegistry.instance().addStringLocalization("item.wand.name", "en_US", "Magic Wand");
			LanguageRegistry.instance().addStringLocalization("item.creativeWand.name", "en_US", "Magic Wand");
			LanguageRegistry.instance().addStringLocalization("item.ash.name", "en_US", "Ash");
			LanguageRegistry.instance().addStringLocalization("item.magicCore.name", "en_US", "Magic Orb");
			LanguageRegistry.instance().addStringLocalization("tile.metalStack.name", "en_US", "Smoothed Block of Iron");
			LanguageRegistry.instance().addStringLocalization("tile.smoothQuartz.name", "en_US", "Smooth Quartz Block");
			LanguageRegistry.instance().addStringLocalization("tile.blockAsh.name", "en_US", "Block of Ash");
			LanguageRegistry.instance().addStringLocalization("tile.blockAshHard.name", "en_US", "Compressed Ash Block");
			LanguageRegistry.instance().addStringLocalization("tile.quartzFence.name", "en_US", "Quartz Fance");
			LanguageRegistry.instance().addStringLocalization("tile.smoothStairs.name", "en_US", "Smooth Stone Stairs");
			LanguageRegistry.instance().addStringLocalization("tile.myFurnace.name", "en_US", "Implosion Furnace");
			LanguageRegistry.instance().addStringLocalization("tile.myFurnaceActive.name", "en_US", "Implosion Furnace");
			LanguageRegistry.instance().addStringLocalization("tile.flintIngotBlock.name", "en_US", "Block of Flint Ingots");
			LanguageRegistry.instance().addStringLocalization("item.flintHelmet.name", "en_US", "Flint Helmet");
			LanguageRegistry.instance().addStringLocalization("item.flintPlate.name", "en_US", "Flint Chestplate");
			LanguageRegistry.instance().addStringLocalization("item.flintLeggings.name", "en_US", "Flint Leggings");
			LanguageRegistry.instance().addStringLocalization("item.flintBoots.name", "en_US", "Flint Boots");
			LanguageRegistry.instance().addStringLocalization("tile.bioInitIdle.name", "en_US", "Biochemical Initializer");
			LanguageRegistry.instance().addStringLocalization("tile.bioInitActive.name", "en_US", "Biochemical Initializer");
			LanguageRegistry.instance().addStringLocalization("item.biomash.name", "en_US", "Biomash");
			LanguageRegistry.instance().addStringLocalization("item.fertileSapling.name", "en_US", "Fertile Sapling");
			LanguageRegistry.instance().addStringLocalization("tile.woodGen.name", "en_US", "Cellulose Synthesizer");
			LanguageRegistry.instance().addStringLocalization("tile.woodGenOn.name", "en_US", "Cellulose Synthesizer");
			LanguageRegistry.instance().addStringLocalization("item.milkshake.name", "en_US", "Milkshake");
			LanguageRegistry.instance().addStringLocalization("item.flintSword.name", "en_US", "Flint Sword");
			LanguageRegistry.instance().addStringLocalization("item.flintAxe.name", "en_US", "Flint Axe");
			LanguageRegistry.instance().addStringLocalization("item.cookedCarrot.name", "en_US", "Cooked Carrot");
			LanguageRegistry.instance().addStringLocalization("item.epicFlintPick.name", "en_US", "Epic Flint Pickaxe");
			LanguageRegistry.instance().addStringLocalization("tile.fertileDirt.name", "en_US", "Fertile Dirt");
			LanguageRegistry.instance().addStringLocalization("tile.metalSheet.name", "en_US", "Metal Sheet");
		}else if(par1String == "Entities"){
		}
	}
	
	public static void registerCrafting(){
		
		//=========================================== Adding Recipes ================================================
		GameRegistry.addRecipe(new ItemStack(flintBlock), new Object[] {"###", "###", "###", '#', Item.flint});
		GameRegistry.addRecipe(new ItemStack(glowingGlass, 8), new Object[] {"###", "#G#", "###", '#', Item.glowstone,
			'G', Block.glass});
		GameRegistry.addRecipe(new ItemStack(glowingGlassPane, 16), new Object[] {"###", "###", '#', glowingGlass});
		GameRegistry.addRecipe(new ItemStack(Item.flint, 9), new Object[] {"#", '#', flintBlock});
		GameRegistry.addRecipe(new ItemStack(stoneStick, 2), new Object[] {"#", "#", '#', Block.stone});
		GameRegistry.addRecipe(new ItemStack(flintPick), new Object[] {"IDI", "MSM", "MSM", 'I',
			flintIngot, 'D', Item.diamond, 'S', stoneStick, 'M', itemMetalSheet});
		GameRegistry.addRecipe(new ItemStack(wand), new Object[] {"SBS", "S#S", "SBS", '#', magicCore, 
			'B', Item.blazeRod, 'S', itemMetalSheet});
		GameRegistry.addRecipe(new ItemStack(magicCore), new Object[] {"GAB", "RNR", "BAG", 'G', Item.glowstone, 'A', ash,
			'B', Item.blazePowder, 'R', Item.redstone, 'N', Item.netherStar});
		GameRegistry.addRecipe(new ItemStack(itemMetalSheet, 6), new Object[] {"###", '#', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(metalStack, 16), new Object[] {"###", "III", "III", '#', itemMetalSheet, 'I',
			Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(smoothQuartz, 4), new Object[] {"_", "#", '_', itemMetalSheet, '#', 
			Block.blockNetherQuartz});
		GameRegistry.addRecipe(new ItemStack(blockAsh), new Object[] {"##", "##", '#', ash});
		GameRegistry.addRecipe(new ItemStack(blockAshHard), new Object[] {"##", "##", '#', blockAsh});
		GameRegistry.addRecipe(new ItemStack(quartzFence), new Object[] {"###", "###", '#', Item.netherQuartz});
		GameRegistry.addRecipe(new ItemStack(smoothStairs, 6), new Object[] {"#  ", "## ", "###", '#', Block.stone});
		GameRegistry.addRecipe(new ItemStack(myFurnaceIdle), new Object[] {"###", "#0#", "###", '#', Block.cobblestone,
			'0', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(flintIngotBlock), new Object[] {"###", "###", "###", '#', flintIngot});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"0#0", "# #", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(plate), new Object[] {"# #", "#0#", "0#0", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] {"0#0", "# #", "# #", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"# #", "0 0", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(bioInitIdle), new Object[] {"###", "# #", "#B#", '#', Block.stone, 'B',
			Item.bucketEmpty});
		GameRegistry.addRecipe(new ItemStack(biomash), new Object[] {"#S#", "SBS", "#S#", '#', Block.dirt, 'S', Item.seeds,
			'B', new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(woodGeneratorIdle), new Object[] {"###", "# #", "#D#", '#', Block.cobblestone, 'D', 
			Block.dirt});
		GameRegistry.addRecipe(new ItemStack(fertileSapling), new Object[] {"#B#", "B#B", "#B#", '#', Block.sapling, 'B',
			new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(milkshake), new Object[] {Item.bucketMilk, Item.sugar,
			Block.ice, Item.glassBottle});
		GameRegistry.addRecipe(new ItemStack(flintSword), new Object[] {"D#", " #", " S", 'D', Item.diamond, 
			'#', flintIngot, 'S', stoneStick});
		GameRegistry.addRecipe(new ItemStack(epicFlintPick), new Object[] {"#D#", " S ", " S ", '#', flintIngotBlock, 'D',
			Block.blockDiamond, 'S', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(flintAxe), new Object[] {"D# ", "#S ", " S ", 'D', Item.diamond, '#',
			flintIngot, 'S', stoneStick});
		for (int i = 0; i < 16; ++i)
        {
            GameRegistry.addRecipe(new ItemStack(Block.cloth, 1, i), new Object[] {"#", "#", "#", '#', new ItemStack(Block.carpet, 1, i)});
        }
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 15), new Object[] {Item.bone});
		
		
		//==================================== Removing Recipes ======================================================
		
		removeRecipe(new ItemStack(Item.dyePowder, 3, 15));
	}
	
	public static void registerOres(){
		oreDictionary("blockFlint", (flintBlock));
		oreDictionary("blockIngotFlint", (flintIngotBlock));
		oreDictionary("ingotFlint", (flintIngot));
	}
	
	public static void oreDictionary(String name, Block oreStack){
		OreDictionary.registerOre(name, new ItemStack(oreStack));
		System.out.println("[MiscTweaks] Registered '" + oreStack.getLocalizedName() + "' with the Ore Dictionary as: '" + name +"'");
	}
	
	public static void oreDictionary(String name, Item oreStack){
		OreDictionary.registerOre(name, new ItemStack(oreStack));
		System.out.println("[MiscTweaks] Registered '" + oreStack.getItemDisplayName(new ItemStack(oreStack)) + "' with the Ore Dictionary as: '" + name +"'");
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(flintBlock.blockID, new ItemStack(Loader.flintIngot), 1.0F);
		GameRegistry.addSmelting(Item.carrot.itemID, new ItemStack(cookedCarrot), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(Item.carrot.itemID, new ItemStack(cookedCarrot), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(Block.wood.blockID, new ItemStack(Item.coal, 1, 1), 0.5F);
		MyFurnaceRecipes.smelting().addSmelting(flintBlock.blockID, new ItemStack(flintIngot, 2), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(flintIngotBlock.blockID, new ItemStack(flintIngot, 9), 0.5F);
		MyFurnaceRecipes.smelting().addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather, 2), 1);
	}
	
	public static Item ash;
	public static Block flintBlock;
	public static Item magicCore;
	public static Item flintIngot;
	public static Item flintPick;
	public static Item stoneStick;
	public static Item wand;
	public static Item creativeWand;
	public static Block glowingGlassPane;
	public static Item itemMetalSheet;
	public static Block metalSheet;
	public static Block metalStack;
	public static Block smoothQuartz;
	public static Block glowingGlass;
	public static Block blockAsh;
	public static Block blockAshHard;
	public static Block quartzFence;
	public static Block smoothStairs;
	public static Block myFurnaceIdle;
	public static Block myFurnaceActive;
	public static Block flintIngotBlock;
	public static ItemFlintArmor helmet;
	public static ItemFlintArmor plate;
	public static ItemFlintArmor leggings;
	public static ItemFlintArmor boots;
	public static Item biomash;
	public static Block bioInit;
	public static Block bioInitIdle;
	public static Item fertileSapling;
	public static Block woodGeneratorIdle;
	public static Block woodGeneratorActive;
	public static Item milkshake;
	public static Item flintSword;
	public static Item flintShovel;
	public static Item flintAxe;
	public static Item epicFlintPick;
	public static Item cookedCarrot;
	public static Block fertileDirt;
	public static Block tempBlock;
	
	
	/**
	 * Removes vanilla crafting recipes.
	 * 
	 * @author pigalot
	 * @author yope_fried
	 * @param resultItem - The {@link ItemStack} result of the recipe to be removed. 
	 */
	private static void removeRecipe(ItemStack resultItem)
	{
	    ItemStack recipeResult = null;
	    ArrayList recipes = (ArrayList) CraftingManager.getInstance().getRecipeList();

	    for (int scan = 0; scan < recipes.size(); scan++)
	    {
	        IRecipe tmpRecipe = (IRecipe) recipes.get(scan);
	        if (tmpRecipe instanceof ShapedRecipes)
	        {
	            ShapedRecipes recipe = (ShapedRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        }

	        if (tmpRecipe instanceof ShapelessRecipes)
	        {
	            ShapelessRecipes recipe = (ShapelessRecipes)tmpRecipe;
	            recipeResult = recipe.getRecipeOutput();
	        }

	        if (ItemStack.areItemStacksEqual(resultItem, recipeResult))
	        {
	            System.out.println("[" + Reference.MOD_NAME + "] Removed Recipe: " + recipes.get(scan) + " -> " + recipeResult);
	            recipes.remove(scan);
	        }
	    }
	}
}
