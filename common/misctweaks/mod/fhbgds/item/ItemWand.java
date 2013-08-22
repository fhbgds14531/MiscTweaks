package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.entities.EntityMagic;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWand extends ItemBow{

	public ItemWand wand;
	
	public ItemWand(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id);
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
    }
	
	public int getItemEnchantability(){
        return 0;
    }
	
	public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer){
        return par1ItemStack;
    }
	
	public EnumAction getItemUseAction(){
		return EnumAction.bow;
	}
	
	public int getMaxItemUseDuration(ItemStack par1ItemStack){
        return 72000;
    }
	
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player){
        ArrowNockEvent event = new ArrowNockEvent(player, itemStack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled()){
            return event.result;
        }
        player.setItemInUse(itemStack, this.getMaxItemUseDuration(itemStack));
        return itemStack;
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack itemStack, World world, EntityPlayer player, int par4){
		
		int j = this.getMaxItemUseDuration(itemStack) - par4;
		
		ArrowLooseEvent event = new ArrowLooseEvent(player, itemStack, j);
		
        MinecraftForge.EVENT_BUS.post(event);
        
        if (event.isCanceled()){
            return;
        }
        j = event.charge;
        
        float f = (float)j / 20.0F;

        EntityMagic projectile = new EntityMagic(world, player, 5, 1, 10);

        world.spawnEntityInWorld(projectile);
        projectile.worldObj.playSoundAtEntity(player, "misctweaks:pew", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
    }
}