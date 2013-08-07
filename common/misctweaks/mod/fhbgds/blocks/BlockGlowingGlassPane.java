package misctweaks.mod.fhbgds.blocks;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowingGlassPane extends BlockPane{

	@SideOnly(Side.CLIENT)
	private Icon sideTexture;

	public BlockGlowingGlassPane(int id, String s1, String s2, Material par4Material, boolean dropSelf) {
		super(id, null, null, par4Material, dropSelf);
		this.blockParticleGravity = -1.0F;
	}

	/**
	 * ADD CONNECTED TEXTURES
	 */
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":/glass/glass");
		this.sideTexture = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().subSequence(5, 17) + "Top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getSideTextureIndex(){
		return this.sideTexture;
	}
}