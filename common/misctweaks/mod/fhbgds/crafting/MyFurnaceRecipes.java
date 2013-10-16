package misctweaks.mod.fhbgds.crafting;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class MyFurnaceRecipes
{
    private static final MyFurnaceRecipes smeltingBase = new MyFurnaceRecipes();

    private Map smeltingList = new HashMap();
    private Map experienceList = new HashMap();
    private HashMap<List<Integer>, ItemStack> metaSmeltingList = new HashMap<List<Integer>, ItemStack>();
    private HashMap<List<Integer>, Float> metaExperience = new HashMap<List<Integer>, Float>();
    private Random random = new Random();
    

    public static final MyFurnaceRecipes smelting()
    {
        return smeltingBase;
    }

    private MyFurnaceRecipes()
    {
        this.addSmelting(Block.oreIron.blockID, new ItemStack(Item.ingotIron, 1), 0.5F);
        this.addSmelting(Block.oreGold.blockID, new ItemStack(Item.ingotGold, 1), 1.0F);
        this.addSmelting(Block.sand.blockID, new ItemStack(Block.glass, 1), 0.1F);
        this.addSmelting(Block.cobblestone.blockID, new ItemStack(Block.stone, 1), 0.1F);
        this.addSmelting(Item.clay.itemID, new ItemStack(Item.brick, 1), 0.3F);
        this.addSmelting(Block.blockClay.blockID, new ItemStack(Block.hardenedClay, 1), 0.35F);
        this.addSmelting(Block.netherrack.blockID, new ItemStack(Item.netherrackBrick, 1), 0.1F);
        this.addSmelting(Item.plateGold.itemID, new ItemStack(Item.ingotGold, 4), 1);
        this.addSmelting(Item.helmetGold.itemID, new ItemStack(Item.ingotGold, 2), 1);
        this.addSmelting(Item.legsGold.itemID, new ItemStack(Item.ingotGold, 3), 1);
        this.addSmelting(Item.bootsGold.itemID, new ItemStack(Item.ingotGold, 2), 1);
        this.addSmelting(Item.plateIron.itemID, new ItemStack(Item.ingotIron, 4), 1);
        this.addSmelting(Item.helmetIron.itemID, new ItemStack(Item.ingotIron, 2), 1);
        this.addSmelting(Item.legsIron.itemID, new ItemStack(Item.ingotIron, 3), 1);
        this.addSmelting(Item.bootsIron.itemID, new ItemStack(Item.ingotIron, 2), 1);
    }

    public void addSmelting(int par1, ItemStack par2ItemStack, float par3)
    {
        this.smeltingList.put(Integer.valueOf(par1), par2ItemStack);
        this.experienceList.put(Integer.valueOf(par2ItemStack.itemID), Float.valueOf(par3));
    }

    public void addSmelting(int itemID, int metadata, ItemStack itemstack, float experience)
    {
        metaSmeltingList.put(Arrays.asList(itemID, metadata), itemstack);
        metaExperience.put(Arrays.asList(itemstack.itemID, itemstack.getItemDamage()), experience);
    }

    public ItemStack getSmeltingResult(ItemStack item) 
    {
        if (item == null)
        {
            return null;
        }
        ItemStack ret = (ItemStack)metaSmeltingList.get(Arrays.asList(item.itemID, item.getItemDamage()));
        if (ret != null) 
        {
            return ret;
        }
        return (ItemStack)smeltingList.get(Integer.valueOf(item.itemID));
    }

    public float getExperience(ItemStack item)
    {
        if (item == null || item.getItem() == null)
        {
            return 0;
        }
        float ret = item.getItem().getSmeltingExperience(item);
        if (ret < 0 && metaExperience.containsKey(Arrays.asList(item.itemID, item.getItemDamage())))
        {
            ret = metaExperience.get(Arrays.asList(item.itemID, item.getItemDamage()));
        }
        if (ret < 0 && experienceList.containsKey(item.itemID))
        {
            ret = ((Float)experienceList.get(item.itemID)).floatValue();
        }
        return (ret < 0 ? 0 : ret);
    }

    public Map<List<Integer>, ItemStack> getMetaSmeltingList()
    {
        return metaSmeltingList;
    }
}
