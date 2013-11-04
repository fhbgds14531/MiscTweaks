package misctweaks.mod.fhbgds;

import misctweaks.mod.fhbgds.client.ProxyClient;
import misctweaks.mod.fhbgds.common.ProxyCommon;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.ObjectRegistry;
import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.lib.NameRegistry;
import misctweaks.mod.fhbgds.util.GuiHandler;
import misctweaks.mod.fhbgds.world.biome.BiomeDesolatePlains;
import net.minecraft.entity.Entity;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(serverSideRequired = false, clientSideRequired = true)

public class MiscTweaks {
	public static GuiHandler gui = new GuiHandler();
	
	@SidedProxy(modId = Reference.MOD_ID, serverSide = "misctweaks.mod.fhbgds.common.ProxyCommon",
			clientSide = "misctweaks.mod.fhbgds.client.ProxyClient")
		public static ProxyCommon proxy;
	
		public static ProxyClient proxyC;

	@Instance(Reference.MOD_ID)
	public static MiscTweaks instance;

//--------------------------- Pre-Initializes the mod ---------------------------\\
@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		System.out.println("[" + Reference.MOD_ID + "] Preparing to break everything.");
		Loader.initObjects();
		Loader.registerOres();
		proxy.addSounds();
}

//--------------------------- Initializes the mod ---------------------------\\
@EventHandler
	public void Init(FMLInitializationEvent event){
		ObjectRegistry.gameRegistryStuff();
		NameRegistry.registerNames("Blocks/Items");
		NameRegistry.registerNames("Entities");
		ObjectRegistry.registerCrafting();
		ObjectRegistry.registerSmelting();
		proxy.addRenderer();
		NetworkRegistry.instance().registerGuiHandler(this, gui);
		MinecraftForge.EVENT_BUS.register(new misctweaks.mod.fhbgds.util.EventHandler());
}

//--------------------------- Post-Initializes the mod ---------------------------\\
@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		if(cpw.mods.fml.common.Loader.isModLoaded("Herobrine")){
			System.out.println("[MiscTweaks] RUN! HEROBRINE IS HERE!");
		}
		System.out.println("[" + Reference.MOD_ID + "] Everything has been successfully broken!");
	}
}