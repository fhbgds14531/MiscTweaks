package misctweaks.mod.fhbgds.block;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.BlockStationary;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDirtyWaterStationary extends BlockStationary {

	public BlockDirtyWaterStationary(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":water_still");
	}
	
}
