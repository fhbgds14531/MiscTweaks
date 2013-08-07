package misctweaks.mod.fhbgds.blocks;

import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.BlockWood;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmoothQuartz extends BlockRotatedPillar{

	public BlockSmoothQuartz(int par1, Material par2Material) {
		super(par1, par2Material);
	}

//----------------------------------------------------------Texture stuff------------------------------------------------------------	
	
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister r){}
    
    @Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2)
    {
        int k = par2 & 12;
        int l = par2 & 3;
        return k == 0 && (par1 == 1 || par1 == 0) ? this.func_111049_d(l) : (k == 4 && (par1 == 5 || par1 == 4) ?
        		this.func_111049_d(l) : (k == 8 && (par1 == 2 || par1 == 3) ? this.func_111049_d(l) : this.func_111048_c(l)));
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	protected Icon func_111048_c(int i) {
		return Block.blockNetherQuartz.getBlockTextureFromSide(i);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    protected Icon func_111049_d(int par1){
        return Loader.metalSheet.getBlockTextureFromSide(1);
    }
}
