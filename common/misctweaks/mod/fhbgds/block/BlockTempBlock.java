package misctweaks.mod.fhbgds.block;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockTempBlock extends Block {

	public BlockTempBlock(int id, Material material) {
		super(id, material);
	}

	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + this.getUnlocalizedName().substring(5));
	}
	
}
