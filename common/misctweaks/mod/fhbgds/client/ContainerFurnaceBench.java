package misctweaks.mod.fhbgds.client;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerFurnaceBench extends Container {

	public ContainerFurnaceBench() {
		
	}

	@Override
	public boolean canInteractWith(EntityPlayer entityplayer) {
		return true;
	}

}
