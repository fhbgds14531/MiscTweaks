package misctweaks.mod.fhbgds.util;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

public class EventHandler {
	private Random eventRand = new Random();

	@ForgeSubscribe
	public void bonemealEvent(BonemealEvent event){
		ItemStack stack = event.entityPlayer.getCurrentEquippedItem();
		if(stack.getItem() == Item.dyePowder){
			if(stack.getItemDamage() == 15){
				ItemDye item = (ItemDye) stack.getItem();
				MiscMethods.applyBonemeal(stack, event.world, event.X, event.Y, event.Z, event.entityPlayer);
				stack.stackSize++;
				MiscMethods.applyBonemeal(stack, event.world, event.X, event.Y, event.Z, event.entityPlayer);
				if(eventRand.nextFloat() < 0.2) stack.stackSize++;
			}
		}
	}
}
