package misctweaks.mod.fhbgds.util;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.block.BlockFlintBlock;
import misctweaks.mod.fhbgds.lib.Loader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CreativeTabMiscTweaks extends CreativeTabs {
	private String myLabel;
	
	public CreativeTabMiscTweaks(String label) {
		super(label);
		this.myLabel = label;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getIconItemStack(){
		//return new ItemStack(Loader.flintIngot);
		return this.myLabel == "MiscTweaks Blocks/Items"? new ItemStack(Loader.flintIngot) : new ItemStack(Loader.flintPick);
	}
	
	@Override
	public String getTranslatedTabLabel(){
		return myLabel;
	}
	
}
