package misctweaks.mod.fhbgds.inventory;

import misctweaks.mod.fhbgds.entities.TileEntityAlloyForge;
import misctweaks.mod.fhbgds.util.AlloyForgeRecipes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerAlloyForge extends Container{
    private TileEntityAlloyForge alloyForge;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerAlloyForge(InventoryPlayer playerInventory, TileEntityAlloyForge alloyForge)
    {
        this.alloyForge = alloyForge;
        this.addSlotToContainer(new Slot(alloyForge, 0, 48, 17));
        this.addSlotToContainer(new Slot(alloyForge, 1, 56, 53));
        this.addSlotToContainer(new Slot(alloyForge, 2, 64, 17));
        this.addSlotToContainer(new SlotAlloyForge(playerInventory.player, alloyForge, 3, 116, 35));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.alloyForge.furnaceCookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.alloyForge.furnaceBurnTime);
        par1ICrafting.sendProgressBarUpdate(this, 3, this.alloyForge.currentItemBurnTime);
    }

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < this.crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)this.crafters.get(i);

            if (this.lastCookTime != this.alloyForge.furnaceCookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.alloyForge.furnaceCookTime);
            }

            if (this.lastBurnTime != this.alloyForge.furnaceBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.alloyForge.furnaceBurnTime);
            }

            if (this.lastItemBurnTime != this.alloyForge.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 3, this.alloyForge.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.alloyForge.furnaceCookTime;
        this.lastBurnTime = this.alloyForge.furnaceBurnTime;
        this.lastItemBurnTime = this.alloyForge.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0 || par1 == 2)
        {
            this.alloyForge.furnaceCookTime = par2;
        }

        if (par1 == 1)
        {
            this.alloyForge.furnaceBurnTime = par2;
        }

        if (par1 == 3)
        {
            this.alloyForge.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.alloyForge.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
    {
             ItemStack itemstack = null;
             Slot slot = (Slot)inventorySlots.get(par2);
             if (slot != null && slot.getHasStack())
             {
                     ItemStack itemstack1 = slot.getStack();
                     itemstack = itemstack1.copy();
                     if (par2 == 2)
                     {
                             if (!mergeItemStack(itemstack1, 3, 39, true))
                             {
                                     return null;
                             }
                     }
                     else if (par2 >= 3 && par2 < 30)
                     {
                             if (!mergeItemStack(itemstack1, 30, 39, false))
                             {
                                     return null;
                             }
                     }
                     else if (par2 >= 30 && par2 < 39)
                     {
                             if (!mergeItemStack(itemstack1, 3, 30, false))
                             {
                                     return null;
                             }
                     }
                     else if (!mergeItemStack(itemstack1, 3, 39, false))
                     {
                             return null;
                     }
                     if (itemstack1.stackSize == 0)
                     {
                             slot.putStack(null);
                     }
                     else
                     {
                             slot.onSlotChanged();
                     }
                     if (itemstack1.stackSize != itemstack.stackSize)
                     {
                             slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
                     }
                     else
                     {
                             return null;
                     }
             }
             return itemstack;
    }
}
