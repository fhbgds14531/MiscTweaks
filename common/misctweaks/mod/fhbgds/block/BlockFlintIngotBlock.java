package misctweaks.mod.fhbgds.block;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFlintIngotBlock extends Block {

	public BlockFlintIngotBlock(int id, Material material) {
		super(id, material);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean isBeaconBase(World worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ){
		return true;
	}
	
	@Override
	public boolean canEntityDestroy(World world, int x, int y, int z, Entity entity){
		return false;
	}
}
