package misctweaks.mod.fhbgds.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class AlloyForgeRecipes
{
    private static final AlloyForgeRecipes smeltingBase = new AlloyForgeRecipes();

    private HashMap<List<Integer>, ItemStack> smeltingList = new HashMap<List<Integer>, ItemStack>();
    private Map experienceList = new HashMap();
    private static HashMap<Integer, Integer> fuelList = new HashMap<Integer, Integer>();
    private Random random = new Random();
    

    public static final AlloyForgeRecipes smelting()
    {
        return smeltingBase;
    }

    private AlloyForgeRecipes()
    {
    	this.addSmelting(Item.ingotIron.itemID, Item.ingotIron.itemID, new ItemStack(Block.blockIron), 1.0F);
//    	this.addSmelting(new ItemStack(Block.oreIron, 3), new ItemStack(Item.coal), new ItemStack(Block.blockIron), 1.0F);
    }
//-----------------------------------------------------------------------------------------
    public void addSmelting(int input1, int input2, ItemStack result, float exp)
    {
        this.smeltingList.put(Arrays.asList(Integer.valueOf(input1), Integer.valueOf(input2)), result);
        this.experienceList.put(Integer.valueOf(result.itemID), Float.valueOf(exp));
    }
//-----------------------------------------------------------------------------------------
    public ItemStack getSmeltingResult(int item, int item1) 
    {
        if (item == 0)
        {
            return null;
        }
        if (item1 == 0)
        {
            return null;
        }
        return (ItemStack)smeltingList.get(Arrays.asList(item, item1));
    }

    public float getExperience(ItemStack item)
    {
//        if (item == null || item.getItem() == null)
//        {
//            return 0;
//        }
//        float ret = item.getItem().getSmeltingExperience(item);
//
//        if (ret < 0 && experienceList.containsKey(item.itemID))
//        {
//            ret = ((Float)experienceList.get(item.itemID)).floatValue();
//        }
//        return (ret < 0 ? 0 : ret);
    	return 1.0F;
    }

	public int getFuelBurnTime(int stack){
//        if (stack == 0)
//        {
//            return 0;
//        }
//        int ret = 0;
//        if (ret == 0 && fuelList.containsKey(stack))
//        {
//            ret = fuelList.get(stack);
//        }else if(stack == Item.coal.itemID){
//        	return 11;
//        }
//        return (ret == 0 ? 0 : ret);
		if (fuelList.containsKey(Integer.valueOf(stack))){
        return 1;
		}
        return 0;
    }
	
	public void addFuel(int stack, int burnTime){
		this.fuelList.put(stack, Integer.valueOf(burnTime));
	}
}
