package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintArmor extends ItemArmor {
	
	public ItemFlintArmor(int id, int armorType, EnumArmorMaterial material) {
		super(id, material, 3, armorType);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type){
		if(itemID ==Loader.helmet.itemID || itemID == Loader.plate.itemID || itemID == Loader.boots.itemID){
			return "misctweaks:textures/models/armor/FLINT_layer_1.png";
			}
		if(itemID == Loader.leggings.itemID)
			{
			return "misctweaks:textures/models/armor/FLINT_layer_2.png";
			}
		else return null;
	}
	
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		Loader.helmet.itemIcon = r.registerIcon(Reference.MOD_ID + ":flintHelmet");
		Loader.plate.itemIcon = r.registerIcon(Reference.MOD_ID + ":flintChestplate");
		Loader.leggings.itemIcon = r.registerIcon(Reference.MOD_ID + ":flintLeggings");
		Loader.boots.itemIcon = r.registerIcon(Reference.MOD_ID + ":flintBoots");
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(Enchantment.protection, 5);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == Loader.flintIngot? true : (stack2.getItem() == Item.diamond? true: false);
	}
}