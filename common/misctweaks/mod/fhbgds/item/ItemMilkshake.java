package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMilkshake extends ItemFood {
	private boolean alwaysEdible;

	public ItemMilkshake(int id, int refill, float saturation, boolean isWolfsFavouriteMeat) {
		super(id, refill, isWolfsFavouriteMeat);
		this.alwaysEdible = true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.itemIcon = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player){

		player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 600, 0));
		player.addPotionEffect(new PotionEffect(Potion.field_76434_w.id, 600, 0));
		player.addPotionEffect(new PotionEffect(Potion.regeneration.id, 4, 0));
		
		if (!player.capabilities.isCreativeMode)
        {
            --stack.stackSize;
        }

        if (!world.isRemote)
        {
            player.curePotionEffects(stack);
        }

        return stack.stackSize <= 0 ? new ItemStack(Item.glassBottle) : stack;
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
    {
        return 32;
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {
        return EnumAction.drink;
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.canEat(this.alwaysEdible))
        {
            par3EntityPlayer.setItemInUse(par1ItemStack, this.getMaxItemUseDuration(par1ItemStack));
        }

        return par1ItemStack;
    }
}
