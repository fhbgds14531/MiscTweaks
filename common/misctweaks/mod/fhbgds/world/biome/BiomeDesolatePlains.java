package misctweaks.mod.fhbgds.world.biome;

import java.util.Random;

import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.world.gen.structure.StructureWastelandRuins;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.gen.structure.ComponentScatteredFeatureJunglePyramid;
import net.minecraft.world.gen.structure.StructureBoundingBox;

public class BiomeDesolatePlains extends BiomeGenBase {

	public BiomeDesolatePlains(int par1) {
		super(par1);
		this.setMinMaxHeight(0.1f, 0.2f);
		this.setTemperatureRainfall(0.05f, 0.8f);
		this.setEnableSnow();
		this.setColor(522674);
		this.setBiomeName("Desolate Plains");
		this.topBlock = (byte) Loader.blockAsh.blockID;
		this.fillerBlock = (byte) Loader.blockAshHard.blockID;
		this.spawnableMonsterList.clear();
        this.spawnableMonsterList.add(new SpawnListEntry(EntityZombie.class, 10, 4, 4));
		this.spawnableCreatureList.clear();
		this.spawnableCaveCreatureList.clear();
		this.spawnableWaterCreatureList.clear();
		this.theBiomeDecorator.generateLakes = false;
		this.theBiomeDecorator.clayPerChunk = -999;
		this.theBiomeDecorator.treesPerChunk = -999;
        this.theBiomeDecorator.deadBushPerChunk = 4;
        this.theBiomeDecorator.reedsPerChunk = -999;
        this.theBiomeDecorator.cactiPerChunk = -999;
    }

	@Override
	public void decorate(World world, Random random, int chunkX, int chunkZ){
		if (random.nextInt(250) == 0){
			StructureWastelandRuins ruins = new StructureWastelandRuins(0);
			ComponentScatteredFeatureJunglePyramid pyramid = new ComponentScatteredFeatureJunglePyramid(random, chunkX, chunkZ);
		    StructureBoundingBox box = pyramid.getBoundingBox();
			ruins.addComponentParts(world, random, box);
		}
	}
}