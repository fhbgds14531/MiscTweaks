package misctweaks.mod.fhbgds.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSoulSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Icon;
import net.minecraft.world.World;

public class BlockMetalStack extends Block {

	public BlockMetalStack(int par1, Material par2Material) {
		super(par1, par2Material);
		this.setStepSound(soundMetalFootstep);
		this.slipperiness = 0.9F;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int par1, int par2){
        switch(par1){
        case 0: case 1:
        	return Loader.metalSheet.getBlockTextureFromSide(par1);
        case 2: case 3: case 4: case 5:
        	return Block.blockIron.getBlockTextureFromSide(par1);
        }
        return null;
    }
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z){
		float f = 0.15F;
        return AxisAlignedBB.getAABBPool().getAABB((double)x, (double)y, (double)z, (double)(x + 1),
        		(double)((float)(y + 1) - f), (double)(z + 1));
	}
	
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity){
		entity.motionX *= 1.1D;
		entity.motionZ *= 1.1D;
	}
}
