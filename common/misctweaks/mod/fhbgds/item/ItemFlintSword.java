package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintSword extends ItemSword {

	public ItemFlintSword(int par1, EnumToolMaterial par2EnumToolMaterial) {
		super(par1, par2EnumToolMaterial);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		stack.addEnchantment(Enchantment.sharpness, 7);
		stack.addEnchantment(Enchantment.looting, 3);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == Loader.flintIngot? true : (stack2.getItem() == Item.diamond? true: false);
	}
}
