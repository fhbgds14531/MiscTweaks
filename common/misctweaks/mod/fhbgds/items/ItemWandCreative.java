package misctweaks.mod.fhbgds.items;

import java.util.List;

import misctweaks.mod.fhbgds.entities.EntityMagicCreative;
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

public class ItemWandCreative extends ItemBow{

	public ItemWandCreative creativeWand;
	
	public ItemWandCreative(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id);
		this.setMaxStackSize(1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List subtext, boolean b){
		subtext.add("");
		subtext.add("Creative Spawned");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":wand");
    }
	
	@Override
	public int getItemEnchantability(){
        return -1;
    }
	
	@Override
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
        
        float f = (float)j / 10.0F;

        EntityMagicCreative projectile = new EntityMagicCreative(world, player, 300F, 3F, 200);

        world.spawnEntityInWorld(projectile);
        projectile.worldObj.playSoundAtEntity(player, "misctweaks:pew", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
    }
}