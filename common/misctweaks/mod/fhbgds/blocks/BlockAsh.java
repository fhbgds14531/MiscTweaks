package misctweaks.mod.fhbgds.blocks;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockAsh extends BlockSand {

	public BlockAsh(int par1, Material par2Material) {
		super(par1, par2Material);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":blockAsh");
	}
	
	@Override
	public int idDropped(int par1, Random par2Random, int par3){
		return Loader.ash.itemID;
	}
	
	@Override
	public int quantityDropped(Random par1Random){
		return par1Random.nextInt(5) + 1;
	}
}