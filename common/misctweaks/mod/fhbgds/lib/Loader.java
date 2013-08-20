package misctweaks.mod.fhbgds.lib;

import misctweaks.mod.fhbgds.blocks.BlockAsh;
import misctweaks.mod.fhbgds.blocks.BlockAshHard;
import misctweaks.mod.fhbgds.blocks.BlockDirtyWater;
import misctweaks.mod.fhbgds.blocks.BlockFlintBlock;
import misctweaks.mod.fhbgds.blocks.BlockFlintIngotBlock;
import misctweaks.mod.fhbgds.blocks.BlockFurnaceBench;
import misctweaks.mod.fhbgds.blocks.BlockFurnaceBenchOn;
import misctweaks.mod.fhbgds.blocks.BlockGlowingGlassConnected;
import misctweaks.mod.fhbgds.blocks.BlockGlowingGlassPane;
import misctweaks.mod.fhbgds.blocks.BlockMetalSheet;
import misctweaks.mod.fhbgds.blocks.BlockMetalStack;
import misctweaks.mod.fhbgds.blocks.BlockQuartzFence;
import misctweaks.mod.fhbgds.blocks.BlockSmoothQuartz;
import misctweaks.mod.fhbgds.blocks.BlockSmoothStairs;
import misctweaks.mod.fhbgds.blocks.MyFurnace;
import misctweaks.mod.fhbgds.entities.TileEntityFurnaceBench;
import misctweaks.mod.fhbgds.entities.TileEntityMyFurnace;
import misctweaks.mod.fhbgds.items.ItemAsh;
import misctweaks.mod.fhbgds.items.ItemFlintArmor;
import misctweaks.mod.fhbgds.items.ItemFlintIngot;
import misctweaks.mod.fhbgds.items.ItemFlintPick;
import misctweaks.mod.fhbgds.items.ItemMagicCore;
import misctweaks.mod.fhbgds.items.ItemMetalSheet;
import misctweaks.mod.fhbgds.items.ItemStoneStick;
import misctweaks.mod.fhbgds.items.ItemWand;
import misctweaks.mod.fhbgds.items.ItemWandCreative;
import misctweaks.mod.fhbgds.util.MyFurnaceRecipes;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Loader {
	
	public static final CreativeTabs tab = new CreativeTabMiscTweaks("MiscTweaks");
	public static final EnumToolMaterial FLINT = EnumHelper.addToolMaterial("FLINT", 3, 1800, 10.0F, 6.0F, 15);
	public static final EnumArmorMaterial FLINT_ARMOR = EnumHelper.addArmorMaterial("FLINT", 50, new int[] {4, 9, 7, 4}, 15);
	
	public static void initObjects(){
		
		dirtyWater  = new FluidDirtyWater();
		
		ash = new ItemAsh(5006).setUnlocalizedName("ash")
				.setCreativeTab(tab);
		
		flintBlock = new BlockFlintBlock(512, Material.rock)
			.setUnlocalizedName("flintBlock").setHardness(1.0F)
			.setCreativeTab(tab)
			.setStepSound(Block.soundStoneFootstep);
		
		flintIngot = new ItemFlintIngot(5000)
			.setUnlocalizedName("flintIngot")
			.setCreativeTab(tab);
		
		flintPick = new ItemFlintPick(5001, FLINT)
			.setUnlocalizedName("flintPick")
			.setCreativeTab(tab);
		
		stoneStick = new ItemStoneStick(5002)
			.setUnlocalizedName("cobbleStick")
			.setCreativeTab(tab);
		
		wand = new ItemWand(5003, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("wand")
			.setCreativeTab(tab);
		
		creativeWand = new ItemWandCreative(5004, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("creativeWand")
			.setCreativeTab(tab);
		
		glowingGlassPane = new BlockGlowingGlassPane(514, null, null, Material.glass, false)
			.setUnlocalizedName("glowingGlassPane").setHardness(0.3F)
			.setStepSound(Block.soundGlassFootstep).setLightValue(1.0F)
			.setCreativeTab(tab);
	
		glowingGlassConnected = new BlockGlowingGlassConnected(513, Material.glass).setUnlocalizedName("glowingGlass")
			.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
			.setLightValue(1.5F).setCreativeTab(tab);
	
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
		
		furnaceBench = new BlockFurnaceBench(518).setUnlocalizedName("furnaceBench")
				.setHardness(1.5F).setResistance(2.0F);//.setCreativeTab(tab);
		
		furnaceBenchOn = new BlockFurnaceBenchOn(519).setUnlocalizedName("furnaceBenchOn")
				.setHardness(1.5F).setResistance(2.0F);
		
		blockAsh = new BlockAsh(254, Material.sand).setUnlocalizedName("blockAsh")
				.setCreativeTab(tab)
				.setHardness(0.5F).setStepSound(Block.soundSandFootstep);
		
		blockAshHard = new BlockAshHard(255, Material.rock).setUnlocalizedName("blockAshHard")
				.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(tab)
				.setResistance(1.0F);
		
		quartzFence = new BlockQuartzFence(520).setUnlocalizedName("quartzFence")
				.setCreativeTab(tab);
		
		smoothStairs = new BlockSmoothStairs(521, Material.rock).setUnlocalizedName("smoothStairs")
				.setCreativeTab(tab).setHardness(1.0F).setResistance(1.0F);
		
		blockDirtyWater = new BlockDirtyWater(522).setUnlocalizedName("blockDirtyWater")
				;//.setCreativeTab(tab);
				
		myFurnaceIdle = new MyFurnace(523, false).setUnlocalizedName("myFurnace")
				.setCreativeTab(tab).setHardness(4.0F).setResistance(4.0F);
		
		myFurnaceActive = new MyFurnace(524, true).setUnlocalizedName("myFurnaceActive")
				.setHardness(4.0F).setResistance(4.0F);
		
		flintIngotBlock = new BlockFlintIngotBlock(525, Material.rock).setUnlocalizedName("flintIngotBlock")
				.setCreativeTab(tab).setHardness(4.5F).setResistance(4.5F);
		
		helmet = (ItemFlintArmor) new ItemFlintArmor(5090, 0, FLINT_ARMOR).setUnlocalizedName("flintHelmet")
				.setCreativeTab(tab);
		
		plate = (ItemFlintArmor) new ItemFlintArmor(5091, 1, FLINT_ARMOR).setUnlocalizedName("flintPlate")
				.setCreativeTab(tab);
		
		leggings = (ItemFlintArmor) new ItemFlintArmor(5092, 2, FLINT_ARMOR).setUnlocalizedName("flintLeggings")
				.setCreativeTab(tab);
		
		boots = (ItemFlintArmor) new ItemFlintArmor(5093, 3, FLINT_ARMOR).setUnlocalizedName("flintBoots")
				.setCreativeTab(tab);
	}
	
	public static void registerBlocksAndFluids(){
		GameRegistry.registerBlock(flintBlock, Reference.MOD_ID + flintBlock.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlassPane, Reference.MOD_ID + glowingGlassPane.getUnlocalizedName());
		GameRegistry.registerBlock(glowingGlassConnected, Reference.MOD_ID + glowingGlassConnected.getUnlocalizedName());
		GameRegistry.registerBlock(metalSheet, Reference.MOD_ID + metalSheet.getUnlocalizedName());
		GameRegistry.registerBlock(metalStack, Reference.MOD_ID + metalStack.getUnlocalizedName());
		GameRegistry.registerBlock(smoothQuartz, Reference.MOD_ID + smoothQuartz.getUnlocalizedName());
		GameRegistry.registerBlock(furnaceBench, Reference.MOD_ID + furnaceBench.getUnlocalizedName());
		GameRegistry.registerBlock(blockAsh, Reference.MOD_ID + blockAsh.getUnlocalizedName());
		GameRegistry.registerBlock(blockAshHard, Reference.MOD_ID + blockAshHard.getUnlocalizedName());
		GameRegistry.registerBlock(quartzFence, Reference.MOD_ID + quartzFence.getUnlocalizedName());
		GameRegistry.registerBlock(smoothStairs, Reference.MOD_ID + smoothStairs.getUnlocalizedName());
		GameRegistry.registerBlock(blockDirtyWater, Reference.MOD_ID + blockDirtyWater.getUnlocalizedName());
		GameRegistry.registerBlock(myFurnaceIdle, Reference.MOD_ID + myFurnaceIdle.getUnlocalizedName());
		GameRegistry.registerBlock(myFurnaceActive, Reference.MOD_ID + myFurnaceActive.getUnlocalizedName());
		GameRegistry.registerBlock(flintIngotBlock, Reference.MOD_ID + flintIngotBlock.getUnlocalizedName());
		GameRegistry.registerTileEntity(TileEntityFurnaceBench.class, "FurnaceBench");
		GameRegistry.registerTileEntity(TileEntityMyFurnace.class, "MyFurnace");
		MinecraftForge.setBlockHarvestLevel(flintIngotBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(flintBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(glowingGlassPane, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowingGlassConnected, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalSheet, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalStack, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(smoothQuartz, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(blockAshHard, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(quartzFence, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(smoothStairs, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(myFurnaceIdle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(myFurnaceActive, "pickaxe", 1);
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
			LanguageRegistry.instance().addStringLocalization("tile.flintIngotBlock.name", "en_US", "Block of Flint Ingots");
			LanguageRegistry.instance().addStringLocalization("item.flintHelmet.name", "en_US", "Flint Helmet");
			LanguageRegistry.instance().addStringLocalization("item.flintPlate.name", "en_US", "Flint Chestplate");
			LanguageRegistry.instance().addStringLocalization("item.flintLeggings.name", "en_US", "Flint Leggings");
			LanguageRegistry.instance().addStringLocalization("item.flintBoots.name", "en_US", "Flint Boots");
		}else if(par1String == "Entities"){
		}
	}
	
	public static void registerCrafting(){
		GameRegistry.addRecipe(new ItemStack(flintBlock), new Object[] {"###", "###", "###", '#', Item.flint});
		GameRegistry.addRecipe(new ItemStack(glowingGlassConnected, 8), new Object[] {"###", "#G#", "###", '#', Item.glowstone,
			'G', Block.glass});
		GameRegistry.addRecipe(new ItemStack(glowingGlassPane, 16), new Object[] {"###", "###", '#', glowingGlassConnected});
		GameRegistry.addRecipe(new ItemStack(Item.flint, 9), new Object[] {"#", '#', flintBlock});
		GameRegistry.addRecipe(new ItemStack(stoneStick), new Object[] {"#", "#", '#', Block.stone});
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
		GameRegistry.addRecipe(new ItemStack(smoothStairs), new Object[] {"#  ", "## ", "###", '#', Block.stone});
		GameRegistry.addRecipe(new ItemStack(myFurnaceIdle), new Object[] {"###", "#0#", "###", '#', Block.cobblestone,
			'0', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(flintIngotBlock), new Object[] {"###", "###", "###", '#', flintIngot});
		GameRegistry.addRecipe(new ItemStack(helmet), new Object[] {"0#0", "# #", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(plate), new Object[] {"# #", "#0#", "0#0", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(leggings), new Object[] {"0#0", "# #", "# #", '#', flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(boots), new Object[] {"# #", "0 0", '#', flintIngot, '0', Item.diamond});
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(flintBlock.blockID, new ItemStack(Loader.flintIngot), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(flintBlock.blockID, new ItemStack(flintIngot, 2), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(flintIngotBlock.blockID, new ItemStack(flintIngot, 9), 0.5F);
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
	public static Block furnaceBench;
	public static Block furnaceBenchOn;
	public static Block glowingGlassConnected;
	public static Block blockAsh;
	public static Block blockAshHard;
	public static Block quartzFence;
	public static Block smoothStairs;
	public static Fluid dirtyWater;
	public static Block blockDirtyWater;
	public static Block myFurnaceIdle;
	public static Block myFurnaceActive;
	public static Block flintIngotBlock;
	public static ItemFlintArmor helmet;
	public static ItemFlintArmor plate;
	public static ItemFlintArmor leggings;
	public static ItemFlintArmor boots;
}
