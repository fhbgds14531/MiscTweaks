package misctweaks.mod.fhbgds.crafting;

import java.util.HashMap;
import java.util.Map;

import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class WoodGenRecipes {

	private Map woodList = new HashMap();
	private Map axeList = new HashMap();
	private static WoodGenRecipes wood = new WoodGenRecipes();
	
	public WoodGenRecipes(){
		this.addGenResult(Loader.fertileSapling.itemID, new ItemStack(Block.wood));
		this.addAxe(new ItemStack(Item.axeStone), 32);
		this.addAxe(new ItemStack(Item.axeIron), 64);
	}
	
	public static WoodGenRecipes gen(){
		return wood;
	}
	
	public ItemStack getGenResult(ItemStack stack){
		ItemStack returned = (ItemStack) this.woodList.get(Integer.valueOf(stack.getItem().itemID));
		if(returned != null && returned.getItem() != null){
			return returned;
		}else{
			return null;
		}
	}
	
	private void addGenResult(int inputID, ItemStack result){
		this.woodList.put(Integer.valueOf(inputID), result);
	}
	
	private void addAxe(ItemStack axe, int logsProduced){
		this.axeList.put(axe, Integer.valueOf(logsProduced));
	}
	
	public int getAxeQuantityProduced(ItemStack axe){
//		if(axe != null && axe.getItem() != null && this.axeList.get(axe) != null){
//			int returned = (int) this.axeList.get(axe);
//				return returned;
//		}else{
			return 32;
//		}
	}
}
