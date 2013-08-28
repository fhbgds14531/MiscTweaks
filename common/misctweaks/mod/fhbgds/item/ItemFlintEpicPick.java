package misctweaks.mod.fhbgds.item;

import java.util.Random;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.util.MiscMethods;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumToolMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFlintEpicPick extends ItemPickaxe {

	public ItemFlintEpicPick(int id, EnumToolMaterial par2EnumToolMaterial) {
		super(id, par2EnumToolMaterial);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":flintPick");
	}
	
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player) {
		stack.addEnchantment(Enchantment.efficiency, 6);
		stack.addEnchantment(Enchantment.unbreaking, 4);
	}
	
	@Override
	public boolean getIsRepairable(ItemStack stack1, ItemStack stack2){
		return stack2.getItem() == Loader.flintIngot? true : (stack2.getItem() == Item.diamond? true: false);
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
        
        MovingObjectPosition objectPosition = MiscMethods.raytraceFromEntity(world, player, true, 5.0D);
        
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

                    if (block != null && block != Block.bedrock && blockMaterial == Material.rock)
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
