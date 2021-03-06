package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintPick extends ItemPickaxe {

	public ItemFlintPick(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id, par2EnumToolMaterial);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2)
    {
        return false;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
        if(entity instanceof EntityPlayer){
        	EntityPlayer entityPlayer = (EntityPlayer) entity;
        	String name = entityPlayer.username;
        	if(name == "fhbgds14531" || name == "fhbgds14532") return true;
        }
		return false;
    }
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(Enchantment.efficiency, 6);
		stack.addEnchantment(Enchantment.unbreaking, 4);
//		player.addExperienceLevel(30);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == Loader.flintIngot? true : (stack2.getItem() == Item.diamond? true: false);
	}
}
