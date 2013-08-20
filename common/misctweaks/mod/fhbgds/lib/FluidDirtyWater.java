package misctweaks.mod.fhbgds.lib;

import misctweaks.mod.fhbgds.blocks.BlockDirtyWater;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class FluidDirtyWater extends Fluid {

	public FluidDirtyWater(){
		super("DirtyWater");
		setDensity(8);
		setViscosity(800);
		FluidRegistry.registerFluid(this);
	}
}