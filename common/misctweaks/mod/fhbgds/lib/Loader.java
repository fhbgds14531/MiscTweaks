package misctweaks.mod.fhbgds.lib;

import java.util.ArrayList;

import misctweaks.mod.fhbgds.block.BioInit;
import misctweaks.mod.fhbgds.block.BlockAsh;
import misctweaks.mod.fhbgds.block.BlockAshHard;
import misctweaks.mod.fhbgds.block.BlockCeilingPanel;
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
import misctweaks.mod.fhbgds.block.MyFurnace;
import misctweaks.mod.fhbgds.block.WoodGenerator;
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
import misctweaks.mod.fhbgds.util.CreativeTabMiscTweaks;
import net.minecraft.block.Block;
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
import net.minecraftforge.oredict.OreDictionary;

public class Loader {
	
	public static final CreativeTabs blocks = new CreativeTabMiscTweaks("MiscTweaks Blocks/Items");
	public static final CreativeTabs tools = new CreativeTabMiscTweaks("MiscTweaks Tools/Combat");
	public static final CreativeTabs asthetics = new CreativeTabMiscTweaks("MiscTweaks Asthetics");
	public static final EnumToolMaterial FLINT = EnumHelper.addToolMaterial("FLINT", 4, 2000, 15.0F, 7.0F, 15);
	public static final EnumArmorMaterial FLINT_ARMOR = EnumHelper.addArmorMaterial("FLINT", 50, new int[] {4, 9, 7, 4}, 15);
	public static final EnumToolMaterial OBSIDIAN = EnumHelper.addToolMaterial("OBSIDIAN", 4, 1000, 15, 7, 15);
	
	public static void initObjects(){
		
		ash = new ItemAsh(5006).setUnlocalizedName("ash")
				.setCreativeTab(blocks);
		
		flintBlock = new BlockFlintBlock(512, Material.rock)
			.setUnlocalizedName("flintBlock").setHardness(1.0F)
			.setCreativeTab(blocks)
			.setStepSound(Block.soundStoneFootstep);
		
		flintIngot = new ItemFlintIngot(5000)
			.setUnlocalizedName("flintIngot")
			.setCreativeTab(blocks);
		
		flintPick = new ItemFlintPick(5098, FLINT)
			.setUnlocalizedName("flintPick")
			.setCreativeTab(tools);
		
		stoneStick = new ItemStoneStick(5002)
			.setUnlocalizedName("cobbleStick")
			.setCreativeTab(blocks);
		
		wand = new ItemWand(5003, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("wand")
			.setCreativeTab(tools);
		
		creativeWand = new ItemWandCreative(5004, EnumToolMaterial.EMERALD)
			.setUnlocalizedName("creativeWand")
			.setCreativeTab(tools);
		
		glowingGlassPane = new BlockGlowingGlassPane(514, null, null, Material.glass, false)
			.setUnlocalizedName("glowingGlassPane").setHardness(0.3F)
			.setStepSound(Block.soundGlassFootstep).setLightValue(1.0F)
			.setCreativeTab(blocks);
	
		glowingGlass = new BlockGlowingGlass(513, Material.glass).setUnlocalizedName("glowingGlass")
			.setHardness(0.3F).setStepSound(Block.soundGlassFootstep)
			.setLightValue(1.0F).setCreativeTab(blocks);
	
		metalSheet = new BlockMetalSheet(515, Material.iron).setUnlocalizedName("metalSheet");
	
		magicCore = new ItemMagicCore(5008).setUnlocalizedName("magicCore")
			.setCreativeTab(blocks);
		
		itemMetalSheet = new ItemMetalSheet(5009).setUnlocalizedName("itemMetalSheet")
				.setCreativeTab(blocks);
		
		metalStack = new BlockMetalStack(516, Material.iron).setUnlocalizedName("metalStack")
				.setHardness(0.8F).setResistance(0.6F).setCreativeTab(blocks);
		
		smoothQuartz = new BlockSmoothQuartz(517, Material.rock)
			.setUnlocalizedName("smoothQuartz").setHardness(1.0F)
			.setCreativeTab(blocks)
			.setStepSound(Block.soundStoneFootstep);
		
		blockAsh = new BlockAsh(254, Material.sand).setUnlocalizedName("blockAsh")
				.setCreativeTab(blocks)
				.setHardness(0.5F).setStepSound(Block.soundSandFootstep);
		
		blockAshHard = new BlockAshHard(255, Material.rock).setUnlocalizedName("blockAshHard")
				.setHardness(2.0F).setStepSound(Block.soundStoneFootstep).setCreativeTab(blocks)
				.setResistance(1.0F);
		
		quartzFence = new BlockQuartzFence(520).setUnlocalizedName("quartzFence")
				.setCreativeTab(blocks);
		
		smoothStairs = new BlockSmoothStairs(521, Material.rock).setUnlocalizedName("smoothStairs")
				.setCreativeTab(blocks).setHardness(1.0F).setResistance(1.0F);
		
		myFurnaceIdle = new MyFurnace(523, false).setUnlocalizedName("myFurnace")
				.setHardness(4.0F).setResistance(4.0F).setCreativeTab(blocks);
		
		myFurnaceActive = new MyFurnace(524, true).setUnlocalizedName("myFurnaceActive")
				.setHardness(4.0F).setResistance(4.0F);
		
		flintIngotBlock = new BlockFlintIngotBlock(525, Material.rock).setUnlocalizedName("flintIngotBlock")
				.setCreativeTab(blocks).setHardness(4.5F).setResistance(4.5F);
		
		helmet = (ItemFlintArmor) new ItemFlintArmor(5090, 0, FLINT_ARMOR).setUnlocalizedName("flintHelmet")
				.setCreativeTab(tools);
		
		plate = (ItemFlintArmor) new ItemFlintArmor(5091, 1, FLINT_ARMOR).setUnlocalizedName("flintPlate")
				.setCreativeTab(tools);
		
		leggings = (ItemFlintArmor) new ItemFlintArmor(5092, 2, FLINT_ARMOR).setUnlocalizedName("flintLeggings")
				.setCreativeTab(tools);
		
		boots = (ItemFlintArmor) new ItemFlintArmor(5093, 3, FLINT_ARMOR).setUnlocalizedName("flintBoots")
				.setCreativeTab(tools);
		
		bioInitIdle = new BioInit(528, false).setUnlocalizedName("bioInitIdle").setCreativeTab(blocks)
				.setHardness(4.0F).setResistance(4.0F);
		
		bioInit = new BioInit(529, true).setUnlocalizedName("bioInitActive")
				.setHardness(4.0F).setResistance(4.0F);
		
		biomash = new ItemBiomash(5094).setUnlocalizedName("biomash").setCreativeTab(blocks);
		
		fertileSapling = new ItemFertileSapling(5095).setUnlocalizedName("fertileSapling").setCreativeTab(blocks);
		
		woodGeneratorIdle = new WoodGenerator(530, false).setCreativeTab(blocks).setUnlocalizedName("woodGen")
				.setHardness(4).setResistance(4);
		
		woodGeneratorActive = new WoodGenerator(531, true).setUnlocalizedName("woodGenOn")
				.setHardness(4).setResistance(4);
		
		milkshake = new ItemMilkshake(5096, 3, 3, false).setUnlocalizedName("milkshake").setCreativeTab(blocks).setMaxStackSize(1);
		
		flintSword = new ItemFlintSword(5097, FLINT).setUnlocalizedName("flintSword").setCreativeTab(tools)
				.setMaxStackSize(1);
		
		flintAxe = new ItemFlintAxe(5099, FLINT).setUnlocalizedName("flintAxe").setCreativeTab(tools).setMaxStackSize(1);
		
		epicFlintPick = new ItemFlintEpicPick(5100, FLINT).setUnlocalizedName("epicFlintPick")
				.setCreativeTab(tools).setMaxStackSize(1);
		
		cookedCarrot = new ItemCookedCarrot(5101, 100, 100, false).setUnlocalizedName("cookedCarrot").setCreativeTab(blocks);
		
		fertileDirt = new BlockFertileBlock(532, Material.ground).setUnlocalizedName("fertileDirt").setCreativeTab(blocks)
				.setHardness(0.6f).setStepSound(Block.soundPowderFootstep);
		
		flintShovel = new ItemFlintShovel(5102, FLINT).setUnlocalizedName("flintShovel").setCreativeTab(tools);
		
		ceilingPanel = new BlockCeilingPanel(533).setUnlocalizedName("ceilingPanel").setCreativeTab(asthetics)
				.setHardness(0.1F).setStepSound(Block.soundClothFootstep).setLightOpacity(0);
		
		obsidianSword = new ObsidianSword(5103, OBSIDIAN).setUnlocalizedName("obsidianSword").setMaxStackSize(1).setCreativeTab(tools);
		
		//TODO add mossy stairs (cobble & brick) and cracked stairs
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
	public static Block ceilingPanel;
	public static Item obsidianSword;
	
	
	/**
	 * Removes vanilla crafting recipes.
	 * 
	 * @author pigalot
	 * @author yope_fried
	 * @param resultItem - The {@link ItemStack} result of the recipe to be removed. 
	 */
	public static void removeRecipe(ItemStack resultItem)
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
