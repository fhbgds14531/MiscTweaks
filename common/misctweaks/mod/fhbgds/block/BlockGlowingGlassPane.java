package misctweaks.mod.fhbgds.block;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockGlowingGlassPane extends BlockPane{

	@SideOnly(Side.CLIENT)
	private Icon sideTexture;
	private Icon[] icons = new Icon[16];

	public BlockGlowingGlassPane(int id, String s1, String s2, Material par4Material, boolean dropSelf) {
		super(id, null, null, par4Material, dropSelf);
		this.blockParticleGravity = -1.0F;
	}
	
	public int getLightOpacity(World world, int x, int y, int z){
		return 0;
	}
	
	public boolean shouldConnect(IBlockAccess blockAccess, int x, int y, int z, int id){
        return id == this.blockID;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Icon getBlockTexture(IBlockAccess blocks, int x, int y, int z, int side){
        Icon icon = getConnectedTexture(blocks, x, y, z, side, icons);
    	return icon;
    }

    /**
     * @author fuj1n
     * @author edited by fhbgds14531
     * @param blockAccess
     * @param x
     * @param y
     * @param z
     * @param side
     * @param icons
     * @return The icon to use for the block based on surrounding blocks
     */
    public Icon getConnectedTexture(IBlockAccess blockAccess, int x, int y, int z, int side, Icon[] icons){
        boolean isOpenUp = false;
        boolean isOpenDown = false;
        boolean isOpenLeft = false;
        boolean isOpenRight = false;
        boolean isOpenUpLeft = false;
        boolean isOpenUpRight = false;
        boolean isOpenDownLeft = false;
        boolean isOpenDownRight = false;

        switch (side){
        case 0:
            if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z))){
                isOpenDown = true;
            }

            if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z)))
            {
                isOpenUp = true;
            }

            if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1)))
            {
                isOpenLeft = true;
            }

            if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1)))
            {
                isOpenRight = true;
            }

            if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
            {
                return icons[15];
            }
            else if (isOpenUp && isOpenDown && isOpenLeft)
            {
                return icons[12];
            }
            else if (isOpenUp && isOpenDown && isOpenRight)
            {
                return icons[11];
            }
            else if (isOpenUp && isOpenLeft && isOpenRight)
            {
                return icons[13];
            }
            else if (isOpenDown && isOpenLeft && isOpenRight)
            {
                return icons[14];
            }
            else if (isOpenDown && isOpenUp)
            {
                return icons[6];
            }
            else if (isOpenLeft && isOpenRight)
            {
                return icons[5];
            }
            else if (isOpenDown && isOpenLeft)
            {
                return icons[8];
            }
            else if (isOpenDown && isOpenRight)
            {
                return icons[10];
            }
            else if (isOpenUp && isOpenLeft)
            {
                return icons[7];
            }
            else if (isOpenUp && isOpenRight)
            {
                return icons[9];
            }
            else if (isOpenDown)
            {
                return icons[3];
            }
            else if (isOpenUp)
            {
                return icons[4];
            }
            else if (isOpenLeft)
            {
                return icons[2];
            }
            else if (isOpenRight)
            {
                return icons[1];
            }
        	break;
    case 1:
        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z)))
        {
            isOpenDown = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z)))
        {
            isOpenUp = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1)))
        {
            isOpenLeft = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1)))
        {
            isOpenRight = true;
        }

        if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[15];
        }
        else if (isOpenUp && isOpenDown && isOpenLeft)
        {
            return icons[12];
        }
        else if (isOpenUp && isOpenDown && isOpenRight)
        {
            return icons[11];
        }
        else if (isOpenUp && isOpenLeft && isOpenRight)
        {
            return icons[13];
        }
        else if (isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[14];
        }
        else if (isOpenDown && isOpenUp)
        {
            return icons[6];
        }
        else if (isOpenLeft && isOpenRight)
        {
            return icons[5];
        }
        else if (isOpenDown && isOpenLeft)
        {
            return icons[8];
        }
        else if (isOpenDown && isOpenRight)
        {
            return icons[10];
        }
        else if (isOpenUp && isOpenLeft)
        {
            return icons[7];
        }
        else if (isOpenUp && isOpenRight)
        {
            return icons[9];
        }
        else if (isOpenDown)
        {
            return icons[3];
        }
        else if (isOpenUp)
        {
            return icons[4];
        }
        else if (isOpenLeft)
        {
            return icons[2];
        }
        else if (isOpenRight)
        {
            return icons[1];
        }
        break;
    case 2:
        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z)))
        {
            isOpenDown = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z)))
        {
            isOpenUp = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z)))
        {
            isOpenLeft = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z)))
        {
            isOpenRight = true;
        }

        if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
        {
        	return icons[15];
        }
        else if (isOpenUp && isOpenDown && isOpenLeft)
        {
            return icons[13];
        }
        else if (isOpenUp && isOpenDown && isOpenRight)
        {
            return icons[14];
        }
        else if (isOpenUp && isOpenLeft && isOpenRight)
        {
            return icons[12];
        }
        else if (isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[11];
        }
        else if (isOpenDown && isOpenUp)
        {
            return icons[5];
        }
        else if (isOpenLeft && isOpenRight)
        {
            return icons[6];
        }
        else if (isOpenDown && isOpenLeft)
        {
            return icons[9];
        }
        else if (isOpenDown && isOpenRight)
        {
            return icons[10];
        }
        else if (isOpenUp && isOpenLeft)
        {
            return icons[7];
        }
        else if (isOpenUp && isOpenRight)
        {
            return icons[8];
        }
        else if (isOpenDown)
        {
            return icons[1];
        }
        else if (isOpenUp)
        {
            return icons[2];
        }
        else if (isOpenLeft)
        {
            return icons[4];
        }
        else if (isOpenRight)
        {
            return icons[3];
        }
        break;
    case 3:
        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z)))
        {
            isOpenDown = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z)))
        {
            isOpenUp = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x - 1, y, z)))
        {
            isOpenLeft = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x + 1, y, z)))
        {
            isOpenRight = true;
        }

        if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[15];
        }
        else if (isOpenUp && isOpenDown && isOpenLeft)
        {
            return icons[14];
        }
        else if (isOpenUp && isOpenDown && isOpenRight)
        {
            return icons[13];
        }
        else if (isOpenUp && isOpenLeft && isOpenRight)
        {
            return icons[12];
        }
        else if (isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[11];
        }
        else if (isOpenDown && isOpenUp)
        {
            return icons[5];
        }
        else if (isOpenLeft && isOpenRight)
        {
            return icons[6];
        }
        else if (isOpenDown && isOpenLeft)
        {
            return icons[10];
        }
        else if (isOpenDown && isOpenRight)
        {
            return icons[9];
        }
        else if (isOpenUp && isOpenLeft)
        {
            return icons[8];
        }
        else if (isOpenUp && isOpenRight)
        {
            return icons[7];
        }
        else if (isOpenDown)
        {
            return icons[1];
        }
        else if (isOpenUp)
        {
            return icons[2];
        }
        else if (isOpenLeft)
        {
            return icons[3];
        }
        else if (isOpenRight)
        {
            return icons[4];
        }
        break;
    case 4:
        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z)))
        {
            isOpenDown = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z)))
        {
            isOpenUp = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1)))
        {
            isOpenLeft = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1)))
        {
            isOpenRight = true;
        }

        if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[15];
        }
        else if (isOpenUp && isOpenDown && isOpenLeft)
        {
            return icons[14];
        }
        else if (isOpenUp && isOpenDown && isOpenRight)
        {
            return icons[13];
        }
        else if (isOpenUp && isOpenLeft && isOpenRight)
        {
            return icons[12];
        }
        else if (isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[11];
        }
        else if (isOpenDown && isOpenUp)
        {
            return icons[5];
        }
        else if (isOpenLeft && isOpenRight)
        {
            return icons[6];
        }
        else if (isOpenDown && isOpenLeft)
        {
            return icons[10];
        }
        else if (isOpenDown && isOpenRight)
        {
            return icons[9];
        }
        else if (isOpenUp && isOpenLeft)
        {
            return icons[8];
        }
        else if (isOpenUp && isOpenRight)
        {
            return icons[7];
        }
        else if (isOpenDown)
        {
            return icons[1];
        }
        else if (isOpenUp)
        {
            return icons[2];
        }
        else if (isOpenLeft)
        {
            return icons[3];
        }
        else if (isOpenRight)
        {
            return icons[4];
        }
        break;
    case 5:
        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y - 1, z))){
            isOpenDown = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y + 1, z))){
            isOpenUp = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z - 1))){
            isOpenLeft = true;
        }

        if (shouldConnect(blockAccess, x, y, z, blockAccess.getBlockId(x, y, z + 1))){
            isOpenRight = true;
        }

        if (isOpenUp && isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[15];
        }
        else if (isOpenUp && isOpenDown && isOpenLeft)
        {
            return icons[13];
        }
        else if (isOpenUp && isOpenDown && isOpenRight)
        {
            return icons[14];
        }
        else if (isOpenUp && isOpenLeft && isOpenRight)
        {
            return icons[12];
        }
        else if (isOpenDown && isOpenLeft && isOpenRight)
        {
            return icons[11];
        }
        else if (isOpenDown && isOpenUp)
        {
            return icons[5];
        }
        else if (isOpenLeft && isOpenRight)
        {
            return icons[6];
        }
        else if (isOpenDown && isOpenLeft)
        {
            return icons[9];
        }
        else if (isOpenDown && isOpenRight)
        {
            return icons[10];
        }
        else if (isOpenUp && isOpenLeft)
        {
            return icons[7];
        }
        else if (isOpenUp && isOpenRight)
        {
            return icons[8];
        }
        else if (isOpenDown)
        {
            return icons[1];
        }
        else if (isOpenUp)
        {
            return icons[2];
        }
        else if (isOpenLeft)
        {
            return icons[4];
        }
        else if (isOpenRight)
        {
            return icons[3];
        }
        break;
    }
    return icons[0];
}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister r){
		this.blockIcon = r.registerIcon(Reference.MOD_ID + ":glass/glass");
    	icons[0] = r.registerIcon(Reference.MOD_ID + ":glass/glass");
        icons[1] = r.registerIcon(Reference.MOD_ID + ":glass/glass_1_d");
        icons[2] = r.registerIcon(Reference.MOD_ID + ":glass/glass_1_u");
        icons[3] = r.registerIcon(Reference.MOD_ID + ":glass/glass_1_l");
        icons[4] = r.registerIcon(Reference.MOD_ID + ":glass/glass_1_r");
        icons[5] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_h");
        icons[6] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_v");
        icons[7] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_ur");
        icons[8] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_ul");
        icons[9] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_dr");
        icons[10] = r.registerIcon(Reference.MOD_ID + ":glass/glass_2_dl");
        icons[11] = r.registerIcon(Reference.MOD_ID + ":glass/glass_3_r");
        icons[12] = r.registerIcon(Reference.MOD_ID + ":glass/glass_3_l");
        icons[13] = r.registerIcon(Reference.MOD_ID + ":glass/glass_3_u");
        icons[14] = r.registerIcon(Reference.MOD_ID + ":glass/glass_3_d");
        icons[15] = r.registerIcon(Reference.MOD_ID + ":glass/glass_4");
		this.sideTexture = r.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName().subSequence(5, 17) + "Top");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Icon getSideTextureIndex(){
		return this.sideTexture;
	}
}