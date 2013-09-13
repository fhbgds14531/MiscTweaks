package misctweaks.mod.fhbgds.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.util.MiscMethods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class ItemEpicFlintShovel extends ItemSpade {

	public ItemEpicFlintShovel(int id, EnumToolMaterial material) {
		super(id, material);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":flintShovel");
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(Enchantment.efficiency, 3);
		stack.addEnchantment(Enchantment.unbreaking, 4);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == Loader.flintIngot? true : (stack2.getItem() == Item.diamond? true: false);
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
	
	/*  
	 *  ALL credit for the contents of this method goes to mDiyo
	 *  https://github.com/mDiyo 
	 */
	@Override
    public boolean onBlockStartBreak (ItemStack stack, int x, int y, int z, EntityPlayer player){
		
		World world = player.worldObj;
        final int listBlockID = world.getBlockId(x, y, z);
        final int listMeta = world.getBlockMetadata(x, y, z);
        final Block listBlock = Block.blocksList[listBlockID];
        if (listBlock == null) return super.onBlockStartBreak(stack, x, y, z, player);
        
        MovingObjectPosition objectPosition = MiscMethods.getMovingObjectPositionFromPlayer(world, player, true);
        
        int xRange = 1;
        int yRange = 1;
        int zRange = 1;
        switch (objectPosition.sideHit)
        {
        case 0:
        case 1:
            yRange = 0;
            break;
        case 2:
        case 3:
            zRange = 0;
            break;
        case 4:
        case 5:
            xRange = 0;
            break;
        }
        
        for (int xPos = x - xRange; xPos <= x + xRange; xPos++)
        {
            for (int yPos = y - yRange; yPos <= y + yRange; yPos++)
            {
                for (int zPos = z - zRange; zPos <= z + zRange; zPos++)
                {
                    int localblockID = world.getBlockId(xPos, yPos, zPos);
                    Block block = Block.blocksList[localblockID];
                    Material blockMaterial = world.getBlockMaterial(xPos, yPos, zPos);
                    int localMeta = world.getBlockMetadata(xPos, yPos, zPos);

                    if (block != null && block != Block.bedrock && (blockMaterial == Material.ground || blockMaterial == Material.sand||
                    		blockMaterial == Material.clay || blockMaterial == Material.snow || blockMaterial == Material.craftedSnow))
                    {
                    	if (!player.capabilities.isCreativeMode)
                    	{
                        	block.removeBlockByPlayer(world, player, xPos, yPos, zPos);
                        	block.onBlockDestroyedByPlayer(world, xPos, yPos, zPos, localMeta);
                        	block.harvestBlock(world, player, xPos, yPos, zPos, localMeta);
                        	block.onBlockHarvested(world, xPos, yPos, zPos, localMeta, player);
                        	onBlockDestroyed(stack, world, localblockID, xPos, yPos, zPos, player);
                    	}
                        else
                        {
                        world.setBlockToAir(xPos, yPos, zPos);
                        }
                    }
            	}
            }
        }
        if (!world.isRemote) world.playAuxSFX(2001, x, y, z, listBlockID + (listMeta << 12));
        return true;
    }
}
