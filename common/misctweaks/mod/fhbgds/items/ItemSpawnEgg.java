package misctweaks.mod.fhbgds.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.entities.EntitySpecialCreeper;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Facing;
import net.minecraft.util.Icon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public class ItemSpawnEgg extends Item {

	int[] firstColor = {0x00D277};
	int[] secondColor = {0x000046};
	String[] mobNames = {"SpecialCreeper"};
	
	public ItemSpawnEgg(int id) {
		super(id);
		this.setHasSubtypes(true);
	}

	@Override
	public void registerIcons(IconRegister iconRegister){
		
	}
	
	@Override
	public boolean requiresMultipleRenderPasses(){
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIconFromDamageForRenderPass(int par1, int par2){
		return Item.monsterPlacer.getIconFromDamageForRenderPass(par1, par2);
	}
	
	@Override
	public String getItemDisplayName(ItemStack par1ItemStack){
		String item = ("" + StatCollector.translateToLocal(this.getUnlocalizedName() + ".name"));
		String mob = mobNames[par1ItemStack.getItemDamage()];
		String completeName = null;
		
		if(mob != null){
			completeName = item + " " + StatCollector.translateToLocal("entity." + mob + ".name");
		}
		
		return completeName;
	}
	
	@Override
	public void getSubItems(int id, CreativeTabs creativeTab, List l){
		for(int i = 0; i < mobNames.length; i++){
			l.add(new ItemStack(id, 1, i));
		}
	}
	
	public int getColorFromItemStack(ItemStack par1ItemStack, int pass){
		int d = par1ItemStack.getItemDamage();
		return pass == 0 ? firstColor[d] : secondColor[d];
	}
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int posX, int posY, int posZ, int par7, float par8, float par9, float par10){
		if(!world.isRemote){
			spawnMob(par1ItemStack, world, posX, posY, posZ, par7);
			if(!player.capabilities.isCreativeMode){
				--par1ItemStack.stackSize;
			}
		}
		return true;
	}
	
	public static EntityLiving spawnMob(ItemStack par1ItemStack, World world, int posX, int posY, int posZ, int par7){
		int uID = world.getBlockId((int) posX, (int) posY, (int) posZ);
		posX += Facing.offsetsXForSide[par7];
        posY += Facing.offsetsYForSide[par7];
        posZ += Facing.offsetsZForSide[par7];
        double d1 = 0.0D;
        
        if(par7 == 1 && Block.blocksList[uID] != null && Block.blocksList[uID].getRenderType() == 11){
        	d1 = 0.5D;
        }
        
        int d = par1ItemStack.getItemDamage();
        EntityLiving entity = null;
        switch(d){
        case 0:
        	entity = new EntitySpecialCreeper(world);
        	spawnEntity(posX, posY, posZ, entity, world);
        	break;
        }
        return entity;
    }
	
	public static void spawnEntity(double x, double y, double z, EntityLiving entity, World world){
		if(!world.isRemote){
			entity.setPosition(x, y, z);
			entity.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
            entity.rotationYawHead = entity.rotationYaw;
            entity.renderYawOffset = entity.rotationYaw;
			entity.func_110161_a((EntityLivingData)null);
			world.spawnEntityInWorld(entity);
		}
	}
}