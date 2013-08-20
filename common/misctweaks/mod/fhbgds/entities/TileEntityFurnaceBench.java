package misctweaks.mod.fhbgds.entities;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.blocks.BlockFurnaceBench;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ForgeDummyContainer;

public class TileEntityFurnaceBench extends TileEntity implements ISidedInventory{

	public int fuelLevel;
	
	@Override
	public int getSizeInventory() {
		return 1;
	}
	
	@Override
	public void writeToNBT(NBTTagCompound par1){
	   super.writeToNBT(par1);
	   par1.setInteger("fuelLevel", fuelLevel);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1){
	   super.readFromNBT(par1);
	   this.fuelLevel = par1.getInteger("fuelLevel");
	}

	@Override
	public Packet getDescriptionPacket() {
        NBTTagCompound nbtTag = new NBTTagCompound();
        this.writeToNBT(nbtTag);
        return new Packet132TileEntityData(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
        }

        public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
        readFromNBT(packet.customParam1);
        }
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack itemstack) {
		
	}

	@Override
	public String getInvName() {
		return "Furnace Bench";
	}

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer entityplayer) {
		return true;
	}

	@Override
	public void openChest() {
		
	}

	@Override
	public void closeChest() {
		
	}
	
	public int getInventoryStackLimit(){
		return Integer.MAX_VALUE;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack) {
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return side == 0? new int[] {(Integer) null}: new int[] {(Integer) null};
	}

	@Override
	public boolean canInsertItem(int slot, ItemStack itemstack, int side) {
		return side == 0 && itemstack.itemID == Item.coal.itemID ? true : false;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int item) {
		return false;
	}

}
