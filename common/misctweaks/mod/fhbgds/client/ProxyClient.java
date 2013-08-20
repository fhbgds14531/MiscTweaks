package misctweaks.mod.fhbgds.client;

import misctweaks.mod.fhbgds.client.gui.FurnaceBenchGUI;
import misctweaks.mod.fhbgds.common.ProxyCommon;
import misctweaks.mod.fhbgds.entities.EntityMagic;
import misctweaks.mod.fhbgds.render.RenderMagic;
import misctweaks.mod.fhbgds.util.ContainerFurnaceBench;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProxyClient extends ProxyCommon{

	private int furnaceBenchGUIID = 0;

	@Override
	public void addRenderer(){
		RenderingRegistry.registerEntityRenderingHandler(EntityMagic.class, new RenderMagic(0));
	}

	@Override
	public void addSounds(){
	MinecraftForge.EVENT_BUS.register(new SoundEvent());
	}
	
	@Override
    public Object getClientGuiElement (int guiID, EntityPlayer player, World world, int x, int y, int z){
		if(guiID == furnaceBenchGUIID){
			return new FurnaceBenchGUI(new ContainerFurnaceBench());
		}
		return null;
	}
}
