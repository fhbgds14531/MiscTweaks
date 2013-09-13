package misctweaks.mod.fhbgds.block;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockDirt;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.IPlantable;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFertileBlock extends BlockDirt {

	public BlockFertileBlock(int par1, Material par2Material) {
		super(par1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean canSustainPlant(World world, int x, int y, int z, ForgeDirection direction, IPlantable plant){
		return true;
	}
	
	@Override
	public boolean isFertile(World world, int x, int y, int z){
		return true;
	}
}
