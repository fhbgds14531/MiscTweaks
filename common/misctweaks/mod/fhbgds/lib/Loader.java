package misctweaks.mod.fhbgds.lib;

import misctweaks.mod.fhbgds.blocks.BlockAsh;
import misctweaks.mod.fhbgds.blocks.BlockAshHard;
import misctweaks.mod.fhbgds.blocks.BlockFlintBlock;
import misctweaks.mod.fhbgds.blocks.BlockFurnaceBench;
import misctweaks.mod.fhbgds.blocks.BlockFurnaceBenchOn;
import misctweaks.mod.fhbgds.blocks.BlockGlowingGlassConnected;
import misctweaks.mod.fhbgds.blocks.BlockGlowingGlassPane;
import misctweaks.mod.fhbgds.blocks.BlockMetalSheet;
import misctweaks.mod.fhbgds.blocks.BlockMetalStack;
import misctweaks.mod.fhbgds.blocks.BlockQuartzFence;
import misctweaks.mod.fhbgds.blocks.BlockSmoothQuartz;
import misctweaks.mod.fhbgds.items.ItemAsh;
import misctweaks.mod.fhbgds.items.ItemFlintIngot;
import misctweaks.mod.fhbgds.items.ItemFlintPick;
import misctweaks.mod.fhbgds.items.ItemMagicCore;
import misctweaks.mod.fhbgds.items.ItemMetalSheet;
import misctweaks.mod.fhbgds.items.ItemStoneStick;
import misctweaks.mod.fhbgds.items.ItemWand;
import misctweaks.mod.fhbgds.items.ItemWandCreative;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class Loader {

	public static Item ash;
	public static Block flintBlock;
	public static Item magicCore;
	public static Item flintIngot;
	public static Item flintPick;
	public static Item stoneStick;
	public static Item wand;
	public static Item creativeWand;
	public static Block glowingGlassPane;
	public static Item spawnEgg;
	public static Item itemMetalSheet;
	public static Block metalSheet;
	public static Block metalStack;
	public static Block smoothQuartz;
	public static Entity specialCreeper;
	public static Block furnaceBench;
	public static Block furnaceBenchOn;
	public static Block glowingGlassConnected;
	public static Block blockAsh;
	public static Block blockAshHard;
	public static Block quartzFence;
	
	public static void initObjects(){
		ash = new ItemAsh(5006).setUnlocalizedName("ash")
				.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		flintBlock = new BlockFlintBlock(512, Material.rock)
			.setUnlocalizedName("flintBlock").setHardness(1.0F)
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks)
			.setStepSound(Block.soundStoneFootstep);
		
		flintIngot = new ItemFlintIngot(5000)
			.setUnlocalizedName("flintIngot")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		flintPick = new ItemFlintPick(5001, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("flintPick")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		stoneStick = new ItemStoneStick(5002)
			.setUnlocalizedName("cobbleStick")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		wand = new ItemWand(5003, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("wand")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		creativeWand = new ItemWandCreative(5004, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("creativeWand")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		glowingGlassPane = new BlockGlowingGlassPane(514, null, null, Material.glass, false)
			.setUnlocalizedName("glowingGlassPane").setHardness(0.3F)
			.setStepSound(Block.soundGlassFootstep).setLightValue(1.0F)
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
	
		glowingGlassConnected = new BlockGlowingGlassConnected(513, Material.glass).setUnlocalizedName("glowingGlass")
			.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
			.setLightValue(1.5F).setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
	
		metalSheet = new BlockMetalSheet(515, Material.iron).setUnlocalizedName("metalSheet");
	
		magicCore = new ItemMagicCore(5008).setUnlocalizedName("magicCore")
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		itemMetalSheet = new ItemMetalSheet(5009).setUnlocalizedName("itemMetalSheet")
				.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		metalStack = new BlockMetalStack(516, Material.iron).setUnlocalizedName("metalStack")
				.setHardness(0.8F).setResistance(0.6F).setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		smoothQuartz = new BlockSmoothQuartz(517, Material.rock)
			.setUnlocalizedName("smoothQuartz").setHardness(1.0F)
			.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks)
			.setStepSound(Block.soundStoneFootstep);
		
		furnaceBench = new BlockFurnaceBench(518).setUnlocalizedName("furnaceBench")
				.setHardness(1.5F).setResistance(2.0F);//.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
		
		furnaceBenchOn = new BlockFurnaceBenchOn(519).setUnlocalizedName("furnaceBenchOn")
				.setHardness(1.5F).setResistance(2.0F);
		
		blockAsh = new BlockAsh(254, Material.sand).setUnlocalizedName("blockAsh")
				.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks)
				.setHardness(0.5F).setStepSound(Block.soundSandFootstep);
		
		blockAshHard = new BlockAshHard(255, Material.rock).setUnlocalizedName("blockAshHard")
				.setHardness(1.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks)
				.setResistance(1.0F);
		
		quartzFence = new BlockQuartzFence(520).setUnlocalizedName("quartzFence")
				.setCreativeTab(CreativeTabMiscTweaks.tabMiscTweaks);
	}
	
	public static void registerBlocks(){
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
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(flintBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowingGlassPane, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(glowingGlassConnected, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalSheet, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(metalStack, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(smoothQuartz, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(blockAshHard, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(quartzFence, "pickaxe", 1);
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
			LanguageRegistry.instance().addStringLocalization("item.spawnEgg.name", "en_US", "Spawn");
			LanguageRegistry.instance().addStringLocalization("item.ash.name", "en_US", "Ash");
			LanguageRegistry.instance().addStringLocalization("item.magicCore.name", "en_US", "Magic Orb");
			LanguageRegistry.instance().addStringLocalization("tile.metalStack.name", "en_US", "Smoothed Block of Iron");
			LanguageRegistry.instance().addStringLocalization("tile.smoothQuartz.name", "en_US", "Smooth Quartz Block");
			LanguageRegistry.instance().addStringLocalization("tile.blockAsh.name", "en_US", "Block of Ash");
			LanguageRegistry.instance().addStringLocalization("tile.blockAshHard.name", "en_US", "Compressed Ash Block");
			LanguageRegistry.instance().addStringLocalization("tile.quartzFence.name", "en_US", "Quartz Fance");
		}else if(par1String == "Entities"){
			LanguageRegistry.instance().addStringLocalization("entity.SpecialCreeper.name", "en_US", "UltraCreeper");
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
		GameRegistry.addRecipe(new ItemStack(smoothQuartz, 4), new Object[] {"_", "#", '_', itemMetalSheet, '#', Block.blockNetherQuartz});
		GameRegistry.addRecipe(new ItemStack(blockAsh), new Object[] {"##", "##", '#', ash});
		GameRegistry.addRecipe(new ItemStack(blockAshHard), new Object[] {"##", "##", '#', blockAsh});
		GameRegistry.addRecipe(new ItemStack(quartzFence), new Object[] {"# #", "###", "# #", '#', Item.netherQuartz});

	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(Loader.flintBlock.blockID, new ItemStack(Loader.flintIngot), 1.0F);
	}
}
