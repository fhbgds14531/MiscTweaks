package misctweaks.mod.fhbgds.client.gui;

import misctweaks.mod.fhbgds.entities.TileEntityFurnaceBench;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

public class FurnaceBenchGUI extends GuiContainer{

	public FurnaceBenchGUI(Container par1Container) {
		super(par1Container);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		
	}

}
