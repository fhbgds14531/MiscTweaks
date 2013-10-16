package misctweaks.mod.fhbgds.lib;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

public class ObsidianSword extends ItemSword {

	public ObsidianSword(int id, EnumToolMaterial material) {
		super(id, material);
	}

	@Override
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		stack.addEnchantment(Enchantment.sharpness, 7);
	}
}
