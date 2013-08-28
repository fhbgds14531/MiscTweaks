package misctweaks.mod.fhbgds.inventory;

import misctweaks.mod.fhbgds.crafting.WoodGenRecipes;
import misctweaks.mod.fhbgds.tileentity.TileEntityWoodGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ContainerWoodGenerator extends Container{
    private TileEntityWoodGenerator woodGen;
    private int lastCookTime;
    private int lastBurnTime;
    private int lastItemBurnTime;

    public ContainerWoodGenerator(InventoryPlayer par1InventoryPlayer, TileEntityWoodGenerator tileEntity)
    {
        this.woodGen = tileEntity;
        this.addSlotToContainer(new Slot(tileEntity, 0, 56, 17));
        this.addSlotToContainer(new Slot(tileEntity, 1, 56, 53));
        this.addSlotToContainer(new SlotCustomSlot(par1InventoryPlayer.player, tileEntity, 2, 116, 35));
        int i;

        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                this.addSlotToContainer(new Slot(par1InventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i)
        {
            this.addSlotToContainer(new Slot(par1InventoryPlayer, i, 8 + i * 18, 142));
        }
    }

    public void addCraftingToCrafters(ICrafting par1ICrafting)
    {
        super.addCraftingToCrafters(par1ICrafting);
        par1ICrafting.sendProgressBarUpdate(this, 0, this.woodGen.cookTime);
        par1ICrafting.sendProgressBarUpdate(this, 1, this.woodGen.burnTime);
        par1ICrafting.sendProgressBarUpdate(this, 2, this.woodGen.currentItemBurnTime);
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

            if (this.lastCookTime != this.woodGen.cookTime)
            {
                icrafting.sendProgressBarUpdate(this, 0, this.woodGen.cookTime);
            }

            if (this.lastBurnTime != this.woodGen.burnTime)
            {
                icrafting.sendProgressBarUpdate(this, 1, this.woodGen.burnTime);
            }

            if (this.lastItemBurnTime != this.woodGen.currentItemBurnTime)
            {
                icrafting.sendProgressBarUpdate(this, 2, this.woodGen.currentItemBurnTime);
            }
        }

        this.lastCookTime = this.woodGen.cookTime;
        this.lastBurnTime = this.woodGen.burnTime;
        this.lastItemBurnTime = this.woodGen.currentItemBurnTime;
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int par1, int par2)
    {
        if (par1 == 0)
        {
            this.woodGen.cookTime = par2;
        }

        if (par1 == 1)
        {
            this.woodGen.burnTime = par2;
        }

        if (par1 == 2)
        {
            this.woodGen.currentItemBurnTime = par2;
        }
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return this.woodGen.isUseableByPlayer(par1EntityPlayer);
    }

    /**
     * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
     */
    public ItemStack transferStackInSlot(EntityPlayer player, int invSlot)
    {
        ItemStack itemstack = null;
        Slot slot = (Slot)this.inventorySlots.get(invSlot);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (invSlot == 2)
            {
                if (!this.mergeItemStack(itemstack1, 3, 39, true))
                {
                    return null;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (invSlot != 1 && invSlot != 0)
            {
                    if (WoodGenRecipes.gen().getGenResult(itemstack1) != null)
                    {
                            if (!this.mergeItemStack(itemstack1, 0, 1, false))
                            {
                                    return null;
                            }
                    }
                    else if (TileEntityWoodGenerator.isItemFuel(itemstack1))
                    {
                            if (!this.mergeItemStack(itemstack1, 1, 2, false))
                            {
                                    return null;
                            }
                    }
                else if (TileEntityWoodGenerator.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return null;
                    }
                }
                else if (invSlot >= 4 && invSlot < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 30, 39, false))
                    {
                        return null;
                    }
                }
                else if (invSlot >= 30 && invSlot < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return null;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 39, false))
            {
                return null;
            }

            if (itemstack1.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemstack1.stackSize == itemstack.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(player, itemstack1);
        }

        return itemstack;
    }
}
