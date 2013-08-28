package misctweaks.mod.fhbgds.render;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;
import misctweaks.mod.fhbgds.client.ProxyClient;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class RenderMyBlocks implements ISimpleBlockRenderingHandler{
	
	@Override
	public void renderInventoryBlock(Block block, int metadata, int modelID, RenderBlocks renderer) {
		if(renderer instanceof BlockRenderer){
		}
	}

	@Override
	public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
	      //change the passed integer coordinates into double precision floats, and set the height on the y axis
	        double par3 = (double)x;
	        double par5 = (double)y + 0.25F;
	        double par7 = (double)z;
	                
	        //this is the scale of the squares, in blocks
	        float par9 = 1.0F;
	        
	        //get the tessellator instance
	        Tessellator var10 = Tessellator.instance;
	        
	        //set the texture
	        Icon var11 = block.getBlockTextureFromSide(0);

	        //here the scale is changed
	        double var22 = 0.45D * (double)par9;
	        
	        //offset the vertices from the centre of the block
	        double var24 = par3 + 0.5D - var22;
	        double var26 = par3 + 0.5D + var22;
	        double var28 = par7 + 0.5D - var22;
	        double var30 = par7 + 0.5D + var22;
	        
	        //not create the vertices
	        var10.addVertexWithUV(var24, par5 + par9, var28, 0, 0);
	        var10.addVertexWithUV(var24, par5 + 0.0D, var28, 0, 0);
	        var10.addVertexWithUV(var26, par5 + 0.0D, var30, 0, 0);
	        var10.addVertexWithUV(var26, par5 + par9, var30, 0, 0);
	        var10.addVertexWithUV(var26, par5 + par9, var30, 0, 0);
	        var10.addVertexWithUV(var26, par5 + 0.0D, var30, 0, 0);
	        var10.addVertexWithUV(var24, par5 + 0.0D, var28, 0, 0);
	        var10.addVertexWithUV(var24, par5 + par9, var28, 0, 0);
	        var10.addVertexWithUV(var24, par5 + par9, var30, 0, 0);
	        var10.addVertexWithUV(var24, par5 + 0.0D, var30, 0, 0);
	        var10.addVertexWithUV(var26, par5 + 0.0D, var28, 0, 0);
	        var10.addVertexWithUV(var26, par5 + par9, var28, 0, 0);
	        var10.addVertexWithUV(var26, par5 + par9, var28, 0, 0);
	        var10.addVertexWithUV(var26, par5 + 0.0D, var28, 0, 0);
	        var10.addVertexWithUV(var24, par5 + 0.0D, var30, 0, 0);
	        var10.addVertexWithUV(var24, par5 + par9, var30, 0, 0);
	    
		return false;
	}

	@Override
	public boolean shouldRender3DInInventory() {
		return true;
	}

	@Override
	public int getRenderId() {
		return 0;
	}
}
