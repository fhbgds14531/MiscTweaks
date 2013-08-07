package misctweaks.mod.fhbgds.blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockFurnaceBenchOn extends BlockContainer {
	private static boolean keepBlockInventory;

	public BlockFurnaceBenchOn(int par1){
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
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9)
    {
        if (par1World.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityFurnace tileEntityFurnaceBench = (TileEntityFurnace)par1World.getBlockTileEntity(par2, par3, par4);

            if (tileEntityFurnaceBench != null)
            {
                par5EntityPlayer.displayGUIFurnace(tileEntityFurnaceBench);
            }

            return true;
        }
    }
	
	public static void updateFurnaceBlockState(boolean par0, World world, int x, int y, int z){
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
		return null;
	}

}