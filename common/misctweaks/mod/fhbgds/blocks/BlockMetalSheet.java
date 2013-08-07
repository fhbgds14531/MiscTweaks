package misctweaks.mod.fhbgds.blocks;

import java.util.Random;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMetalSheet extends Block{

	public BlockMetalSheet(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setHardness(0.8F);
		this.setResistance(0.5F);
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
        byte b0 = 0;
        float f = 0.0625F;
        return AxisAlignedBB.getAABBPool().getAABB((double)x + this.minX, (double)y + this.minY, (double)z + this.minZ, (double)x + this.maxX, (double)((float)y + (float)b0 * f), (double)z + this.maxZ);
    }

    @Override
    public boolean isOpaqueCube(){
        return false;
    }

    @Override
    public boolean renderAsNormalBlock(){
        return false;
    }

    @Override
    public void setBlockBoundsForItemRender(){
        this.func_111047_d(0);
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4){
        this.func_111047_d(par1IBlockAccess.getBlockMetadata(par2, par3, par4));
    }

    protected void func_111047_d(int par1){
        byte b0 = 0;
        float f = (float)(1 * (1 + b0)) / 16.0F;
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
    }

    @Override
    public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4){
        return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
    }

    @Override
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5){
        this.checkCanStay(par1World, par2, par3, par4);
    }

    private boolean checkCanStay(World world, int par2, int par3, int par4){
        if (!this.canBlockStay(world, par2, par3, par4)){
            this.dropBlockAsItem(world, par2, par3, par4, world.getBlockMetadata(par2, par3, par4), 0);
            world.setBlockToAir(par2, par3, par4);
            return false;
        }else{ return true; }
    }

    @Override
    public boolean canBlockStay(World par1World, int par2, int par3, int par4){
        return !par1World.isAirBlock(par2, par3 - 1, par4);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5){
        return par5 == 1 ? true : super.shouldSideBeRendered(par1IBlockAccess, par2, par3, par4, par5);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister r){
    	this.blockIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }
    
    @Override
    public int idDropped(int par1, Random par2Random, int par3){
    	return Loader.itemMetalSheet.itemID;
    }
    
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		entity.motionX *= 1.05D;
		entity.motionZ *= 1.05D;
	}
}
