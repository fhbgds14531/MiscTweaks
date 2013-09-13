package misctweaks.mod.fhbgds.client;

import misctweaks.mod.fhbgds.client.render.FurnaceyRenderer;
import misctweaks.mod.fhbgds.client.render.RenderMagic;
import misctweaks.mod.fhbgds.common.ProxyCommon;
import misctweaks.mod.fhbgds.entity.EntityMagic;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ProxyClient extends ProxyCommon{
	public static int blockRenderID = RenderingRegistry.getNextAvailableRenderId();
	
	@Override
	public void addRenderer(){
		RenderingRegistry.registerEntityRenderingHandler(EntityMagic.class, new RenderMagic(0));
//		RenderingRegistry.registerBlockHandler(new FurnaceyRenderer());
	}

	@Override
	public void addSounds(){
	MinecraftForge.EVENT_BUS.register(new SoundEvent());
	}
}
