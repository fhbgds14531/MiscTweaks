package misctweaks.mod.fhbgds.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.entities.TileEntityFurnaceBench;
import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFurnaceBench extends BlockContainer {

	private static boolean keepBlockInventory;
	public int internalFuelLevel;

	public BlockFurnaceBench(int par1){
		super(par1, Material.rock);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2){
        return par1 == 1 ? Block.workbench.getBlockTextureFromSide(1) : Block.furnaceIdle.getBlockTextureFromSide(1);
    }
	
//	@Override
//	public void onBlockAdded(World world, int x, int y, int z){
//		world.setBlockTileEntity(x, y, z, new TileEntityFurnaceBench());
//	}
	
	@Override
	public void breakBlock(World world, int par2, int par3, int par4, int par5, int par6){
        super.breakBlock(world, par2, par3, par4, par5, par6);
        world.removeBlockTileEntity(par2, par3, par4);
    }
	
	@Override
	public boolean onBlockActivated(World world, int par2, int par3, int par4, 
			EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityFurnaceBench tEnt = (TileEntityFurnaceBench)world.getBlockTileEntity(par2, par3, par4);

            if(tEnt != null){
            	
            	ItemStack item = player.getCurrentEquippedItem();
            	
            	if(item != null && item.itemID == Item.coal.itemID){
            		int itemStackSize = item.stackSize;
            		if(!player.capabilities.isCreativeMode){
            			item.stackSize = 0;
            		}
            		tEnt.fuelLevel += itemStackSize;
            	}else if(item == null){
            		
            	}
            	
            }

            return true;
        }
    }
	
	public static void updateFurnaceBenchState(boolean par0, World world, int x, int y, int z){
        int l = world.getBlockMetadata(x, y, z);
        TileEntity tileentity = world.getBlockTileEntity(x, y, z);
        keepBlockInventory = true;

        if (par0){
            world.setBlock(x, y, z, Loader.furnaceBenchOn.blockID);
        }else{
            world.setBlock(x, y, z, Loader.furnaceBench.blockID);
        }

        keepBlockInventory = false;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);

        if (tileentity != null)
        {
            tileentity.validate();
            world.setBlockTileEntity(x, y, z, tileentity);
        }
    }

	@Override
	public TileEntity createNewTileEntity(World world) {
		return new TileEntityFurnaceBench();
	}

}
