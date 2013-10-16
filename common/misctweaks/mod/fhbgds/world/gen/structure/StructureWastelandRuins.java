package misctweaks.mod.fhbgds.world.gen.structure;

import java.util.Random;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class StructureWastelandRuins extends StructureComponent{

	public static final WeightedRandomChestContent[] ruinsChestContents = new WeightedRandomChestContent[] {
    	new WeightedRandomChestContent(Item.diamond.itemID, 0, 1, 3, 2),
    	new WeightedRandomChestContent(Item.ingotIron.itemID, 0, 1, 5, 15),
    	new WeightedRandomChestContent(Item.ingotGold.itemID, 0, 2, 7, 10),
    	new WeightedRandomChestContent(Item.emerald.itemID, 0, 1, 3, 1),
    	new WeightedRandomChestContent(Item.saddle.itemID, 0, 1, 1, 3),
    	new WeightedRandomChestContent(Loader.ash.itemID, 0, 2, 4, 12),
    	new WeightedRandomChestContent(Item.plateChain.itemID, 0, 1, 1, 1)
    	};
    
//    public static final WeightedRandomChestContent[] ruinsDispenserContents = new WeightedRandomChestContent[] {
//    	new WeightedRandomChestContent(Item.arrow.itemID, 0, 2, 7, 30),
//    	new WeightedRandomChestContent(Item.monsterPlacer.itemID, 54, 3, 8, 35)
//    	};

    private static RandomStones randomStones = new RandomStones();
    
    public StructureWastelandRuins(int i){
        super(i);
    }

    @Override
    public boolean addComponentParts(World world, Random random, StructureBoundingBox sBB){
		
    	int y = (int) (world.getTopSolidOrLiquidBlock(sBB.minX, sBB.minZ) - Math.floor((random.nextFloat() * 3.7)));
    	System.out.println("[" + Reference.MOD_ID + "] Generating ruins at: " + sBB.minX + ", " + y + ", " + sBB.minZ);
		
    	//----------Floor----------------------
    	for(int x = sBB.minX; x <= sBB.maxX; ++x){
           	for(int z = sBB.minZ; z <= sBB.maxZ; ++z){
           		int y1 = y - 1;
           		randomStones.selectRandomBlock(random, true, 0.0F);
           		int block = randomStones.getSelectedBlock();
           		world.setBlock(x, y1, z, block);
           	}
        }
    	//---------Walls - Level 1-----------------
    	for(int x = sBB.minX; x <= sBB.maxX; x++){
    		int z = sBB.minZ;
    		int y1 = y;
       		randomStones.selectRandomBlock(random, true, 0.2F);
       		int block = randomStones.getSelectedBlock();
       		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int z = sBB.minZ; z <= sBB.maxZ; z++){
    		int x = sBB.minX;
    		int y1 = y;
    		randomStones.selectRandomBlock(random, true, 0.2F);
    		int block = randomStones.getSelectedBlock();
    		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int x = sBB.minX; x <= sBB.maxX; x++){
    		int z = sBB.maxZ;
    		int y1 = y;
       		randomStones.selectRandomBlock(random, true, 0.2F);
       		int block = randomStones.getSelectedBlock();
       		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int z = sBB.minZ; z <= sBB.maxZ; z++){
    		int x = sBB.maxX;
    		int y1 = y;
    		randomStones.selectRandomBlock(random, true, 0.2F);
    		int block = randomStones.getSelectedBlock();
    		world.setBlock(x, y1, z, block);
    	}
    	
    	world.setBlock(sBB.minX + 1, y, sBB.minZ + 1, Block.chest.blockID);
    	world.setBlock(sBB.minX + 1, y, sBB.minZ + 2, Block.chest.blockID);
    	TileEntityChest chest = (TileEntityChest)world.getBlockTileEntity(sBB.minX + 1, y, sBB.minZ + 1);
    	TileEntityChest chest1 = (TileEntityChest)world.getBlockTileEntity(sBB.minX + 1, y, sBB.minZ + 2);
    	
    	if (chest != null && chest1 != null){
    		WeightedRandomChestContent.generateChestContents(random, ruinsChestContents, chest, 5);
    		WeightedRandomChestContent.generateChestContents(random, ruinsChestContents, chest1, 5);
    	}
    	
//    	if(random.nextInt(15) < 10){
//    		int x = sBB.minX + random.nextInt(7);
//    		int y1 = y;
//    		int z = sBB.minZ;
//    		world.setBlock(x, y1, z, Block.doorWood.blockID);
//    	}else{
//    		int z = sBB.minZ + random.nextInt(7);
//    		int y1 = y;
//    		int x = sBB.minX;
//    		world.setBlock(x, y1, z, Block.doorWood.blockID);
//    		world.setBlock(x, y1 + 1, z, Block.doorWood.blockID);
//    	}
    	
    	//------------Walls - Level 2-------------------
    	for(int x = sBB.minX; x <= sBB.maxX; x++){
    		int z = sBB.minZ;
    		int y1 = y + 1;
       		randomStones.selectRandomBlock(random, true, 0.5F);
       		int block = randomStones.getSelectedBlock();
       		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int z = sBB.minZ; z <= sBB.maxZ; z++){
    		int x = sBB.minX;
    		int y1 = y + 1;
    		randomStones.selectRandomBlock(random, true, 0.5F);
    		int block = randomStones.getSelectedBlock();
    		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int x = sBB.minX; x <= sBB.maxX; x++){
    		int z = sBB.maxZ;
    		int y1 = y + 1;
       		randomStones.selectRandomBlock(random, true, 0.5F);
       		int block = randomStones.getSelectedBlock();
       		world.setBlock(x, y1, z, block);
    	}
    	
    	for(int z = sBB.minZ; z <= sBB.maxZ; z++){
    		int x = sBB.maxX;
    		int y1 = y + 1;
    		randomStones.selectRandomBlock(random, true, 0.5F);
    		int block = randomStones.getSelectedBlock();
    		world.setBlock(x, y1, z, block);
    	}
        return true;
    }

	@Override
	protected void func_143012_a(NBTTagCompound nbttagcompound) {
		
	}

	@Override
	protected void func_143011_b(NBTTagCompound nbttagcompound) {
		
	}
}