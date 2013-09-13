package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintShovel extends ItemSpade {

	public ItemFlintShovel(int id, EnumToolMaterial material) {
		super(id, material);
	}

	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player){
		stack.addEnchantment(Enchantment.efficiency, 6);
		stack.addEnchantment(Enchantment.unbreaking, 4);
	}
	
	@Override
    public boolean isBookEnchantable(ItemStack itemstack1, ItemStack itemstack2){
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
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
}
