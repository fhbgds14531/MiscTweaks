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
		ChatMessageComponent hello1 = new ChatMessageComponent().addText("<MiscTweaks> Sup, bro?");
		if(!player.getEntityName().substring(0, 5).contains("fhbgds")){
			player.sendChatToPlayer(hello);
		}else{
			player.sendChatToPlayer(hello1);
		}
	}

	@Override
	public void onPlayerLogout(EntityPlayer player) {}

	@Override
	public void onPlayerChangedDimension(EntityPlayer player) {}

	@Override
	public void onPlayerRespawn(EntityPlayer player) {}
}
