package misctweaks.mod.fhbgds.items;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemMetalSheet extends Item {

	public ItemMetalSheet(int id) {
		super(id);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister iconRegister){
		this.itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":m" + this.getUnlocalizedName().substring(10));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List subtext, boolean b){
		subtext.add("The incredibly smooth");
		subtext.add("surface of this thin");
		subtext.add("sheet might allow you");
		subtext.add("to move faster.");
	}
	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int par4, int par5,
			int par6, int par7, float par8, float par9, float par10){
		
		if (par7 == 0){ --par5; }

        if (par7 == 1){ ++par5; }

        if (par7 == 2){ --par6; }

        if (par7 == 3){ ++par6; }

        if (par7 == 4){ --par4; }

        if (par7 == 5){ ++par4; }

        if (!world.isAirBlock(par4, par5, par6)){
            return false;
        }
		
		if (!player.canPlayerEdit(par4, par5, par6, par7, item)){ return false; } else {
        	if (Loader.metalSheet.canPlaceBlockAt(world, par4, par5, par6)){
            	if(!player.capabilities.isCreativeMode){ --item.stackSize; }
            	world.setBlock(par4, par5, par6, Loader.metalSheet.blockID);
        	}
        	world.playSoundAtEntity(player, "dig.stone", 1, 1);
        	return true;
        }
	}
}