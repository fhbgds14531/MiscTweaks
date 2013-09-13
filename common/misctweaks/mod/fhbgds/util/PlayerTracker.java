package misctweaks.mod.fhbgds.util;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatMessageComponent;
import cpw.mods.fml.common.IPlayerTracker;

public class PlayerTracker implements IPlayerTracker {
	String greeting = "Thank you for using " + Reference.MOD_NAME + ", ";
	
	public PlayerTracker() {}

	@Override
	public void onPlayerLogin(EntityPlayer player) {
		ChatMessageComponent hello = new ChatMessageComponent().addText(greeting + player.username);
		player.sendChatToPlayer(hello);
		}

	@Override
	public void onPlayerLogout(EntityPlayer player) {}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {}
}
