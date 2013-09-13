package misctweaks.mod.fhbgds.util;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCocoa;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.BlockDirectional;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockStem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class MiscMethods {
	private static Random miscRand = new Random();

	public static MovingObjectPosition getMovingObjectPositionFromPlayer(World par1World, EntityPlayer par2EntityPlayer, boolean par3)
    {
        float f = 1.0F;
        float f1 = par2EntityPlayer.prevRotationPitch + (par2EntityPlayer.rotationPitch - par2EntityPlayer.prevRotationPitch) * f;
        float f2 = par2EntityPlayer.prevRotationYaw + (par2EntityPlayer.rotationYaw - par2EntityPlayer.prevRotationYaw) * f;
        double d0 = par2EntityPlayer.prevPosX + (par2EntityPlayer.posX - par2EntityPlayer.prevPosX) * (double)f;
        double d1 = par2EntityPlayer.prevPosY + (par2EntityPlayer.posY - par2EntityPlayer.prevPosY) * (double)f + 1.62D - (double)par2EntityPlayer.yOffset;
        double d2 = par2EntityPlayer.prevPosZ + (par2EntityPlayer.posZ - par2EntityPlayer.prevPosZ) * (double)f;
        Vec3 vec3 = par1World.getWorldVec3Pool().getVecFromPool(d0, d1, d2);
        float f3 = MathHelper.cos(-f2 * 0.017453292F - (float)Math.PI);
        float f4 = MathHelper.sin(-f2 * 0.017453292F - (float)Math.PI);
        float f5 = -MathHelper.cos(-f1 * 0.017453292F);
        float f6 = MathHelper.sin(-f1 * 0.017453292F);
        float f7 = f4 * f5;
        float f8 = f3 * f5;
        double d3 = 5.0D;
        if (par2EntityPlayer instanceof EntityPlayerMP)
        {
            d3 = ((EntityPlayerMP)par2EntityPlayer).theItemInWorldManager.getBlockReachDistance();
        }
        Vec3 vec31 = vec3.addVector((double)f7 * d3, (double)f6 * d3, (double)f8 * d3);
        return par1World.rayTraceBlocks_do_do(vec3, vec31, par3, !par3);
    }
	
	
	
	public static boolean applyBonemeal(ItemStack stack, World world, int x, int y, int z, EntityPlayer player)
    {
        int l = world.getBlockId(x, y, z);
    
        if (l == Block.sapling.blockID)
        {
            if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < 0.45D)
                {
                    ((BlockSapling)Block.sapling).markOrGrowMarked(world, x, y, z, world.rand);
                }

                --stack.stackSize;
            }

            return true;
        }
        else if (l != Block.mushroomBrown.blockID && l != Block.mushroomRed.blockID)
        {
            if (l != Block.melonStem.blockID && l != Block.pumpkinStem.blockID)
            {
                if (l > 0 && Block.blocksList[l] instanceof BlockCrops)
                {
                    if (world.getBlockMetadata(x, y, z) == 7)
                    {
                        return false;
                    }
                    else
                    {
                        if (!world.isRemote)
                        {
                            ((BlockCrops)Block.blocksList[l]).fertilize(world, x, y, z);
                            --stack.stackSize;
                        }

                        return true;
                    }
                }
                else
                {
                    int i1;
                    int j1;
                    int k1;

                    if (l == Block.cocoaPlant.blockID)
                    {
                        i1 = world.getBlockMetadata(x, y, z);
                        j1 = BlockDirectional.getDirection(i1);
                        k1 = BlockCocoa.func_72219_c(i1);

                        if (k1 >= 2)
                        {
                            return false;
                        }
                        else
                        {
                            if (!world.isRemote)
                            {
                                ++k1;
                                world.setBlockMetadataWithNotify(x, y, z, k1 << 2 | j1, 2);
                                --stack.stackSize;
                            }

                            return true;
                        }
                    }
                    else if (l != Block.grass.blockID)
                    {
                        return false;
                    }
                    else
                    {
                        if (!world.isRemote)
                        {
                            --stack.stackSize;
                            label102:

                            for (i1 = 0; i1 < 128; ++i1)
                            {
                                j1 = x;
                                k1 = y + 1;
                                int l1 = z;

                                for (int i2 = 0; i2 < i1 / 16; ++i2)
                                {
                                    j1 += miscRand.nextInt(3) - 1;
                                    k1 += (miscRand.nextInt(3) - 1) * miscRand.nextInt(3) / 2;
                                    l1 += miscRand.nextInt(3) - 1;

                                    if (world.getBlockId(j1, k1 - 1, l1) != Block.grass.blockID || world.isBlockNormalCube(j1, k1, l1))
                                    {
                                        continue label102;
                                    }
                                }

                                if (world.getBlockId(j1, k1, l1) == 0)
                                {
                                    if (miscRand.nextInt(10) != 0)
                                    {
                                        if (Block.tallGrass.canBlockStay(world, j1, k1, l1))
                                        {
                                            world.setBlock(j1, k1, l1, Block.tallGrass.blockID, 1, 3);
                                        }
                                    }
                                    else
                                    {
                                        ForgeHooks.plantGrass(world, j1, k1, l1);
                                    }
                                }
                            }
                        }

                        return true;
                    }
                }
            }
            else if (world.getBlockMetadata(x, y, z) == 7)
            {
                return false;
            }
            else
            {
                if (!world.isRemote)
                {
                    ((BlockStem)Block.blocksList[l]).fertilizeStem(world, x, y, z);
                    --stack.stackSize;
                }

                return true;
            }
        }
        else
        {
            if (!world.isRemote)
            {
                if ((double)world.rand.nextFloat() < 0.4D)
                {
                    ((BlockMushroom)Block.blocksList[l]).fertilizeMushroom(world, x, y, z, world.rand);
                }

                --stack.stackSize;
            }

            return true;
        }
    }
}
