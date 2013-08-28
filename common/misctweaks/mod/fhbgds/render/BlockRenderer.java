package misctweaks.mod.fhbgds.render;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.world.IBlockAccess;

public class BlockRenderer extends RenderBlocks {

	public BlockRenderer(IBlockAccess par1iBlockAccess) {
		super(par1iBlockAccess);
	}

	public BlockRenderer() {
	}

	@Override
	public void renderBlockAsItem(Block par1Block, int par2, float par3){
		super.renderBlockAsItem(par1Block, 3, par3);
	}
}
