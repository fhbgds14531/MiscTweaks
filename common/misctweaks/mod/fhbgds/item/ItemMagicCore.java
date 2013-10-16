package misctweaks.mod.fhbgds.item;

import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.util.MiscMethods;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFluid;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicCore extends Item {

	public ItemMagicCore(int id) {
		super(id);
		this.setMaxStackSize(1);
		this.setMaxDamage(57750);
		//this.setMaxDamage(3);
	}

	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity){
        
		if(!(entity instanceof EntityPlayer)){
			if(entity instanceof EntityLiving){
				entity.playSound("mob.endermen.portal", 1, 1);
				entity.worldObj.addWeatherEffect(new EntityLightningBolt(entity.worldObj, entity.posX, entity.posY, entity.posZ));
				entity.setDead();
				MiscMethods.spawnBlockParticles(player.worldObj, player, (int)entity.posX - 1, (int)entity.posY, (int)entity.posZ, "smoke", "magic orb entity removal");
				MiscMethods.spawnBlockParticles(player.worldObj, player, (int)entity.posX - 1, (int)entity.posY + 1, (int)entity.posZ, "smoke", "magic orb entity removal");
			}
		}
		
		return false;
    }
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player){
		
		int damage = stack.getItemDamage();
		
		MovingObjectPosition mop = MiscMethods.getMovingObjectPositionFromPlayer(world, player, true);
		
		if(mop != null){
		
		int x = mop.blockX;
		int y = mop.blockY;
		int z = mop.blockZ;
		
		int id = world.getBlockId(x, y, z);
		int data = world.getBlockMetadata(x, y, z);
		Block block = Block.blocksList[id];
		
		if(id != 7){
			
				world.setBlockToAir(x, y, z);
				
				player.playSound("mob.endermen.portal", 1, 1);
			
				MiscMethods.spawnBlockParticles(world, player, x, y, z, "smoke", "magic orb block deletion");
				
				if(!player.capabilities.isCreativeMode){
					
					if(!(block instanceof BlockLeaves) && !(block instanceof BlockFluid)){
						player.inventory.addItemStackToInventory(new ItemStack(block, 1, 0));
					}
				
					if(block instanceof BlockLog){
						player.inventory.addItemStackToInventory(new ItemStack(block, 1, data));
					}
				
					return new ItemStack(stack.itemID, 1, damage + 1);
				}
		}
	}
	return stack;
}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().substring(5));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack, int renderPass){
		return true;
	}
	
	@Override
	public Icon getIconFromDamage(int par1){
		return this.itemIcon;
	}
	
	@Override
	public boolean isDamageable(){
		return true;
	}
}