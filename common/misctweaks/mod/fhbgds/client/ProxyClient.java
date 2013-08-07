package misctweaks.mod.fhbgds.client;

import misctweaks.mod.fhbgds.blocks.BlockFurnaceBench;
import misctweaks.mod.fhbgds.common.ProxyCommon;
import misctweaks.mod.fhbgds.entities.EntityMagicCreative;
import misctweaks.mod.fhbgds.entities.EntitySpecialCreeper;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.render.ModelSpecialCreeper;
import misctweaks.mod.fhbgds.render.RenderMagic;
import misctweaks.mod.fhbgds.render.RenderSpecialCreeper;
import misctweaks.mod.fhbgds.client.gui.FurnaceBenchGUI;
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
		RenderingRegistry.registerEntityRenderingHandler(EntitySpecialCreeper.class, new RenderSpecialCreeper(new ModelSpecialCreeper(), 0.5F));
		RenderingRegistry.registerEntityRenderingHandler(EntityMagicCreative.class, new RenderMagic(0));
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
