package misctweaks.mod.fhbgds.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSmoothStairs extends BlockStairs {

	public BlockSmoothStairs(int id, Material material) {
		super(id, Block.stone, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int data){
		return Block.stone.getBlockTextureFromSide(side);
	}
}
