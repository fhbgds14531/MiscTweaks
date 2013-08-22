package misctweaks.mod.fhbgds.inventory;

import misctweaks.mod.fhbgds.util.AlloyForgeRecipes;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.AchievementList;
import net.minecraft.util.MathHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class SlotAlloyForge extends Slot
{
	public SlotAlloyForge(EntityPlayer entityplayer, IInventory iinventory, int i, int j, int k)
	{
	         super(iinventory, i, j, k);
	}

	@Override
	public boolean isItemValid(ItemStack itemstack)
	{
	         return false;
	}

	@Override
	public void onPickupFromSlot(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
	{
	         this.onCrafting(par2ItemStack);
	         super.onPickupFromSlot(par1EntityPlayer, par2ItemStack);
	}
}
