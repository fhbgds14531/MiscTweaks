package misctweaks.mod.fhbgds.world.gen.structure;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.gen.structure.StructurePieceBlockSelector;

public class RandomStones{
	protected int selectedBlock = 0;
	
	
	public void selectRandomBlock(Random random, boolean includeAir, float airFreq) {
		if(!includeAir && airFreq == 0.0F){
			if(random.nextFloat() < 0.6){
				this.selectedBlock = Block.cobblestone.blockID;
			}else{
				this.selectedBlock = Block.cobblestoneMossy.blockID;
			}
		}else if(includeAir && airFreq !=0){
			selectRandomBlockIncludesAir(random, includeAir, airFreq);
			}else if(includeAir && airFreq == 0){
				if(random.nextFloat() < 0.6){
					this.selectedBlock = Block.cobblestone.blockID;
				}else if(random.nextFloat() <= 0.5F){
					this.selectedBlock = Block.cobblestoneMossy.blockID;
				}else{
					this.selectedBlock = Block.dirt.blockID;
				}
			}
		}
	
	private void selectRandomBlockIncludesAir(Random random, boolean includeAir, float airFreq) {
		float randomNumber = random.nextFloat();
		
		if(airFreq < 0){airFreq = 0.0F;}
		if(airFreq > 1.0){airFreq = 1.0F;}
		
		if(randomNumber < 1.0 - airFreq){
			if(random.nextFloat() < 0.6){
				this.selectedBlock = Block.cobblestone.blockID;
			}else{
				this.selectedBlock = Block.cobblestoneMossy.blockID;
			}
		}else{
			this.selectedBlock = 0;
		}
	}
	
	public int getSelectedBlock(){
		return this.selectedBlock;
	}
	
}
