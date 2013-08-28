package misctweaks.mod.fhbgds.util;

import misctweaks.mod.fhbgds.client.gui.GuiBioInit;
import misctweaks.mod.fhbgds.client.gui.GuiMyFurnace;
import misctweaks.mod.fhbgds.client.gui.GuiWoodGen;
import misctweaks.mod.fhbgds.inventory.ContainerBioInit;
import misctweaks.mod.fhbgds.inventory.ContainerMyFurnace;
import misctweaks.mod.fhbgds.inventory.ContainerWoodGenerator;
import misctweaks.mod.fhbgds.tileentity.TileEntityBioInit;
import misctweaks.mod.fhbgds.tileentity.TileEntityMyFurnace;
import misctweaks.mod.fhbgds.tileentity.TileEntityWoodGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{

@Override
public Object getServerGuiElement(int id, EntityPlayer player, World world,
		int x, int y, int z) {

TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

switch(id)
{

case 0: return new ContainerMyFurnace(player.inventory, (TileEntityMyFurnace) tileEntity);
case 2: return new ContainerBioInit(player.inventory, (TileEntityBioInit) tileEntity);
case 3: return new ContainerWoodGenerator(player.inventory, (TileEntityWoodGenerator) tileEntity);
}
return null;
}

@Override
public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
	TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

	switch(id)
	{

	case 0: return new GuiMyFurnace(player.inventory, (TileEntityMyFurnace) tileEntity);
	case 2: return new GuiBioInit(player.inventory, (TileEntityBioInit) tileEntity);
	case 3: return new GuiWoodGen(player.inventory, (TileEntityWoodGenerator) tileEntity);
	}

	return null;
}
}