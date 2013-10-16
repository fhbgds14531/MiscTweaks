package misctweaks.mod.fhbgds.lib;

import misctweaks.mod.fhbgds.crafting.MyFurnaceRecipes;
import misctweaks.mod.fhbgds.tileentity.TileEntityBioInit;
import misctweaks.mod.fhbgds.tileentity.TileEntityMyFurnace;
import misctweaks.mod.fhbgds.tileentity.TileEntityWoodGenerator;
import misctweaks.mod.fhbgds.util.PlayerTracker;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class ObjectRegistry {

	public static void gameRegistryStuff(){
		GameRegistry.registerBlock(Loader.flintBlock, Reference.MOD_ID          +  Loader.flintBlock.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.glowingGlassPane, Reference.MOD_ID    +  Loader.glowingGlassPane.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.glowingGlass, Reference.MOD_ID        +  Loader.glowingGlass.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.metalSheet, Reference.MOD_ID          +  Loader.metalSheet.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.metalStack, Reference.MOD_ID          +  Loader.metalStack.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.smoothQuartz, Reference.MOD_ID        +  Loader.smoothQuartz.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.blockAsh, Reference.MOD_ID 		    +  Loader.blockAsh.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.blockAshHard, Reference.MOD_ID        +  Loader.blockAshHard.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.quartzFence, Reference.MOD_ID         +  Loader.quartzFence.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.smoothStairs, Reference.MOD_ID        +  Loader.smoothStairs.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.myFurnaceIdle, Reference.MOD_ID       +  Loader.myFurnaceIdle.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.myFurnaceActive, Reference.MOD_ID     +  Loader.myFurnaceActive.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.flintIngotBlock, Reference.MOD_ID     +  Loader.flintIngotBlock.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.bioInitIdle, Reference.MOD_ID         +  Loader.bioInitIdle.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.bioInit, Reference.MOD_ID             +  Loader.bioInit.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.woodGeneratorActive, Reference.MOD_ID +  Loader.woodGeneratorActive.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.woodGeneratorIdle, Reference.MOD_ID   +  Loader.woodGeneratorIdle.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.fertileDirt, Reference.MOD_ID         +  Loader.fertileDirt.getUnlocalizedName());
		GameRegistry.registerBlock(Loader.ceilingPanel, Reference.MOD_ID        +  Loader.ceilingPanel.getUnlocalizedName());
		
		
		GameRegistry.registerTileEntity(TileEntityMyFurnace.class, "MyFurnace");
		GameRegistry.registerTileEntity(TileEntityBioInit.class, "BiochemicalInitializer");
		GameRegistry.registerTileEntity(TileEntityWoodGenerator.class, "WoodGenerator");
		
		
		GameRegistry.registerPlayerTracker(new PlayerTracker());
		
		
		MinecraftForge.setBlockHarvestLevel(Loader.ceilingPanel, "shears", 0);
		MinecraftForge.setBlockHarvestLevel(Loader.fertileDirt, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.flintIngotBlock, "pickaxe", 2);
		MinecraftForge.setBlockHarvestLevel(Loader.blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.flintBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.glowingGlassPane, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.glowingGlass, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.metalSheet, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.metalStack, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.smoothQuartz, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.blockAsh, "shovel", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.blockAshHard, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.quartzFence, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.smoothStairs, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.myFurnaceIdle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.myFurnaceActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.bioInit, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.bioInitIdle, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.woodGeneratorActive, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(Loader.woodGeneratorIdle, "pickaxe", 1);
	}
	
	public static void registerSmelting(){
		GameRegistry.addSmelting(Loader.flintBlock.blockID, new ItemStack(Loader.flintIngot), 1.0F);
		GameRegistry.addSmelting(Item.carrot.itemID, new ItemStack(Loader.cookedCarrot), 1.0F);
		GameRegistry.addSmelting(Item.plateGold.itemID, new ItemStack(Item.ingotGold, 4), 1);
        GameRegistry.addSmelting(Item.helmetGold.itemID, new ItemStack(Item.ingotGold, 2), 1);
        GameRegistry.addSmelting(Item.legsGold.itemID, new ItemStack(Item.ingotGold, 3), 1);
        GameRegistry.addSmelting(Item.bootsGold.itemID, new ItemStack(Item.ingotGold, 2), 1);
        GameRegistry.addSmelting(Item.plateIron.itemID, new ItemStack(Item.ingotIron, 4), 1);
        GameRegistry.addSmelting(Item.helmetIron.itemID, new ItemStack(Item.ingotIron, 2), 1);
        GameRegistry.addSmelting(Item.legsIron.itemID, new ItemStack(Item.ingotIron, 3), 1);
        GameRegistry.addSmelting(Item.bootsIron.itemID, new ItemStack(Item.ingotIron, 2), 1);
        GameRegistry.addSmelting(Item.swordIron.itemID, new ItemStack(Item.ingotIron), 0.5F);
        GameRegistry.addSmelting(Item.pickaxeIron.itemID, new ItemStack(Item.ingotIron), 0.5F);
        GameRegistry.addSmelting(Item.shovelIron.itemID, new ItemStack(Item.ingotIron), 0.5F);
        GameRegistry.addSmelting(Item.hoeIron.itemID, new ItemStack(Item.ingotIron), 0.5F);
        GameRegistry.addSmelting(Item.pickaxeGold.itemID, new ItemStack(Item.ingotGold), 0.5F);
        GameRegistry.addSmelting(Item.shovelGold.itemID, new ItemStack(Item.ingotGold), 0.5F);
        GameRegistry.addSmelting(Item.hoeGold.itemID, new ItemStack(Item.ingotGold), 0.5F);
        GameRegistry.addSmelting(Item.swordGold.itemID, new ItemStack(Item.ingotGold), 0.5F);
		MyFurnaceRecipes.smelting().addSmelting(Item.carrot.itemID, new ItemStack(Loader.cookedCarrot), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(Block.wood.blockID, new ItemStack(Item.coal, 1, 1), 0.5F);
		MyFurnaceRecipes.smelting().addSmelting(Loader.flintBlock.blockID, new ItemStack(Loader.flintIngot, 2), 1.0F);
		MyFurnaceRecipes.smelting().addSmelting(Loader.flintIngotBlock.blockID, new ItemStack(Loader.flintIngot, 9), 0.5F);
		MyFurnaceRecipes.smelting().addSmelting(Item.rottenFlesh.itemID, new ItemStack(Item.leather, 2), 1);
	}
	
	public static void registerCrafting(){
		
		//=========================================== Adding Recipes ================================================
		GameRegistry.addRecipe(new ItemStack(Loader.obsidianSword), new Object[] {"BD ", "BD ", "mbm", 'B', Block.obsidian, 'D', Item.diamond,
			'b', Loader.stoneStick, 'm', Loader.itemMetalSheet});
		GameRegistry.addRecipe(new ItemStack(Block.dragonEgg, 2), new Object[] {"INI", "BDB", "EBE", 'D', Block.dragonEgg, 'I', Block.blockIron,
			'B', Block.blockDiamond, 'G', Block.blockGold, 'E', Block.whiteStone, 'N', Item.netherStar});
		GameRegistry.addRecipe(new ItemStack(Loader.flintBlock), new Object[] {"###", "###", "###", '#', Item.flint});
		GameRegistry.addRecipe(new ItemStack(Loader.glowingGlass, 8), new Object[] {"###", "#G#", "###", '#', Item.glowstone,
			'G', Block.glass});
		GameRegistry.addRecipe(new ItemStack(Loader.glowingGlassPane, 16), new Object[] {"###", "###", '#', Loader.glowingGlass});
		GameRegistry.addRecipe(new ItemStack(Item.flint, 9), new Object[] {"#", '#', Loader.flintBlock});
		GameRegistry.addRecipe(new ItemStack(Loader.stoneStick, 2), new Object[] {"#", "#", '#', Block.stone});
		GameRegistry.addRecipe(new ItemStack(Loader.flintPick), new Object[] {"IDI", "MSM", "MSM", 'I',
			Loader.flintIngot, 'D', Item.diamond, 'S', Loader.stoneStick, 'M', Loader.itemMetalSheet});
		GameRegistry.addRecipe(new ItemStack(Loader.wand), new Object[] {"SBS", "S#S", "SBS", '#', Loader.magicCore, 
			'B', Item.blazeRod, 'S', Loader.itemMetalSheet});
		GameRegistry.addRecipe(new ItemStack(Loader.magicCore), new Object[] {"AEA", "GNG", "ABA", 'G', Block.whiteStone, 'A', Block.blockDiamond,
			'B', Item.blazePowder, 'N', Item.netherStar, 'E', Block.dragonEgg});
		GameRegistry.addRecipe(new ItemStack(Loader.itemMetalSheet, 6), new Object[] {"###", '#', Item.ingotIron});
		GameRegistry.addRecipe(new ItemStack(Loader.metalStack, 16), new Object[] {"###", "III", "III", '#', Loader.itemMetalSheet, 'I',
			Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(Loader.smoothQuartz, 4), new Object[] {"_", "#", '_', Loader.itemMetalSheet, '#', 
			Block.blockNetherQuartz});
		GameRegistry.addRecipe(new ItemStack(Loader.blockAsh), new Object[] {"##", "##", '#', Loader.ash});
		GameRegistry.addRecipe(new ItemStack(Loader.blockAshHard), new Object[] {"##", "##", '#', Loader.blockAsh});
		GameRegistry.addRecipe(new ItemStack(Loader.quartzFence), new Object[] {"###", "###", '#', Item.netherQuartz});
		GameRegistry.addRecipe(new ItemStack(Loader.smoothStairs, 6), new Object[] {"#  ", "## ", "###", '#', Block.stone});
		GameRegistry.addRecipe(new ItemStack(Loader.myFurnaceIdle), new Object[] {"###", "#0#", "###", '#', Block.cobblestone,
			'0', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(Loader.flintIngotBlock), new Object[] {"###", "###", "###", '#', Loader.flintIngot});
		GameRegistry.addRecipe(new ItemStack(Loader.helmet), new Object[] {"0#0", "# #", '#', Loader.flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Loader.plate), new Object[] {"# #", "#0#", "0#0", '#', Loader.flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Loader.leggings), new Object[] {"0#0", "# #", "# #", '#', Loader.flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Loader.boots), new Object[] {"# #", "0 0", '#', Loader.flintIngot, '0', Item.diamond});
		GameRegistry.addRecipe(new ItemStack(Loader.bioInitIdle), new Object[] {"###", "# #", "#B#", '#', Block.stone, 'B',
			Item.bucketEmpty});
		GameRegistry.addRecipe(new ItemStack(Loader.biomash), new Object[] {"#S", "SB", '#', Block.dirt, 'S', Item.seeds,
			'B', new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addRecipe(new ItemStack(Loader.woodGeneratorIdle), new Object[] {"###", "# #", "#D#", '#', Block.cobblestone, 'D', 
			Block.dirt});
		GameRegistry.addRecipe(new ItemStack(Loader.fertileSapling), new Object[] {"#B#", "B#B", "#B#", '#', Block.sapling, 'B',
			new ItemStack(Item.dyePowder, 1, 15)});
		GameRegistry.addShapelessRecipe(new ItemStack(Loader.milkshake), new Object[] {Item.bucketMilk, Item.sugar,
			Block.ice, Item.glassBottle});
		GameRegistry.addRecipe(new ItemStack(Loader.flintSword), new Object[] {"D#", " #", " S", 'D', Item.diamond, 
			'#', Loader.flintIngot, 'S', Loader.stoneStick});
		GameRegistry.addRecipe(new ItemStack(Loader.epicFlintPick), new Object[] {"#D#", " S ", " S ", '#', Loader.flintIngotBlock, 'D',
			Block.blockDiamond, 'S', Block.blockIron});
		GameRegistry.addRecipe(new ItemStack(Loader.flintAxe), new Object[] {"D# ", "#S ", " S ", 'D', Item.diamond, '#',
			Loader.flintIngot, 'S', Loader.stoneStick});
		for (int i = 0; i < 16; ++i)
        {
            GameRegistry.addRecipe(new ItemStack(Block.cloth, 1, i), new Object[] {"#", "#", "#", '#', new ItemStack(Block.carpet, 1, i)});
        }
		GameRegistry.addShapelessRecipe(new ItemStack(Item.dyePowder, 2, 15), new Object[] {Item.bone});
		
		
		Loader.removeRecipe(new ItemStack(Item.dyePowder, 3, 15));
	}
}
