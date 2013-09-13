package misctweaks.mod.fhbgds.block;

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

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister r){}
    
	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getSideIcon(int i) {
		return Block.blockNetherQuartz.getBlockTextureFromSide(i);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	protected Icon getEndIcon(int i){
		return Loader.metalSheet.getBlockTextureFromSide(i);
	}
}
