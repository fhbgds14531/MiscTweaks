package misctweaks.mod.fhbgds;

import misctweaks.mod.fhbgds.capes.Capes;
import misctweaks.mod.fhbgds.client.ProxyClient;
import misctweaks.mod.fhbgds.common.ProxyCommon;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.util.GuiHandler;
import misctweaks.mod.fhbgds.world.biome.BiomeDesolatePlains;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.oredict.OreDictionary;
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

	public static Entity specialCreeper;
	
	
//--------------------------- Pre-Initializes the mod ---------------------------\\
@EventHandler
	public void PreInit(FMLPreInitializationEvent event){
		System.out.println("[" + Reference.MOD_ID + "] Preparing to break everything.");
		Loader.initObjects();
		OreDictionary.registerOre("blockFlint", new ItemStack(Loader.flintBlock));
		OreDictionary.registerOre("ingotFlint", new ItemStack(Loader.flintIngot));
		proxy.addSounds();
		Capes capes = new Capes();
}

//--------------------------- Initializes the mod ---------------------------\\
@EventHandler
	public void Init(FMLInitializationEvent event){
		Loader.registerBlocksAndFluids();
		Loader.registerNames("Blocks/Items");
		Loader.registerNames("Entities");
		Loader.registerCrafting();
		Loader.registerSmelting();
		proxy.addRenderer();
		NetworkRegistry.instance().registerGuiHandler(this, gui);
}

//--------------------------- Post-Initializes the mod ---------------------------\\
@EventHandler
	public void PostInit(FMLPostInitializationEvent event){
		BiomeGenBase myBiome1 = new BiomeDesolatePlains(26);
		GameRegistry.addBiome(myBiome1);
		BiomeDictionary.registerBiomeType(myBiome1, BiomeDictionary.Type.WASTELAND);
		System.out.println("[" + Reference.MOD_ID + "] Everything has been successfully broken!");
	}
}