package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintAxe extends ItemAxe{

	public ItemFlintAxe(int id, EnumToolMaterial material) {
		super(id, material);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		stack.addEnchantment(Enchantment.efficiency, 6);
		stack.addEnchantment(Enchantment.unbreaking, 4);
		stack.addEnchantment(Enchantment.silkTouch, 1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
}
