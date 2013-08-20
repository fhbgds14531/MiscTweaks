package misctweaks.mod.fhbgds.blocks;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.BlockFlowing;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockDirtyWater extends BlockFluidClassic {

	public static Icon flowingIcon;
	public static Icon stillIcon;
	
	public BlockDirtyWater(int id) {
		super(id, Loader.dirtyWater, Material.water);
		Loader.dirtyWater.setBlockID(id);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":water_flow");
		this.stillIcon = r.registerIcon(Reference.MOD_ID + ":water_still");
		this.flowingIcon = r.registerIcon(Reference.MOD_ID + ":water_flow");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int data){
		return this.blockIcon;
	}
	
}
