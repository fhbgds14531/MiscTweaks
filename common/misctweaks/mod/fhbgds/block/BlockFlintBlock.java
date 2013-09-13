package misctweaks.mod.fhbgds.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.world.World;

public class BlockFlintBlock extends Block{

	public BlockFlintBlock(int id, Material par2Material) {
		super(id, par2Material);
	}

   
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":flintBlock");
	}
	
	@Override
	public boolean isBeaconBase(World worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ){
		return true;
	}
	
	@Override
	public boolean canEntityDestroy(World world, int x, int y, int z, Entity entity){
		return entity instanceof EntityWither? true: false;
	}
}
