package misctweaks.mod.fhbgds.lib;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.blocks.BlockFlintBlock;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMiscTweaks extends CreativeTabs {

	public static final CreativeTabs tabMiscTweaks = new CreativeTabMiscTweaks("MiscTweaks");
	
	public CreativeTabMiscTweaks(String label) {
		super(label);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
		return new ItemStack(Loader.flintBlock);
	}
	
	@Override
	public String getTranslatedTabLabel(){
		return "MiscTweaks";
	}
	
}
