package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.ItemFood;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCookedCarrot extends ItemFood {

	public ItemCookedCarrot(int id, int hunger, float saturation, boolean wolfsFavorite) {
		super(id, hunger, saturation, wolfsFavorite);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
