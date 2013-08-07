package misctweaks.mod.fhbgds.entities;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import misctweaks.mod.fhbgds.items.ItemAsh;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAICreeperSwell;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntitySpecialCreeper extends EntityCreeper{
	
	protected int fuseTime = 20;
	protected int timeSinceIgnited;
	protected int lastActiveTime;
	public float explosionRadius = 5F;
	
	public EntitySpecialCreeper(World world) {
		super(world);
		final EntityCreeper creeper = new EntityCreeper(world);
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0F, false));
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICreeperSwell(creeper));
        this.tasks.addTask(3, new EntityAIAvoidEntity(this, EntityOcelot.class, 6.0F, 1.0D, 1.2D));
        this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
        this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(6, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.dataWatcher.updateObject(17, Byte.valueOf((byte)1));
	}
	
	@Override
	protected void fall(float distance){
		if(distance >= 4){
			boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
			if(this.getPowered()){
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10F, false);
			}else{
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.explosionRadius, false);
			}
			this.setDead();
		}else{
			super.fall(distance);
		}
	}
	
	public boolean getPowered() {
		return this.dataWatcher.getWatchableObjectByte(17) == 1;
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt){
		super.writeEntityToNBT(nbt);
		nbt.setShort("Fuse", (short)this.fuseTime);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt){
		super.readEntityFromNBT(nbt);
		if(nbt.hasKey("Fuse")){
			this.fuseTime = nbt.getShort("Fuse");
		}
	}
	
	@Override
	public void onUpdate(){
		if(this.isEntityAlive()){
			this.lastActiveTime = this.timeSinceIgnited;
			int i = this.getCreeperState();
				
			if(i > 0 && this.timeSinceIgnited == 0){
				this.playSound("random.fuse", 1.0F, 0.5F);
			}
			
			this.timeSinceIgnited += i;
			
			if(this.timeSinceIgnited < 0){
				this.timeSinceIgnited = 0;
			}
			
			int diff = worldObj.difficultySetting;
			int fuseBoost = 4 * (3 - diff);
			int powered = this.getPowered()? 12 : 0;
			
			if(this.timeSinceIgnited >= this.fuseTime + diff + powered){
				this.timeSinceIgnited = this.fuseTime;
				
				if(!this.worldObj.isRemote){
					boolean flag = this.worldObj.getGameRules().getGameRuleBooleanValue("mobGriefing");
					
					if(powered > 0){
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 10F, flag);
					}else{
						this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 5F, flag);
					}
				this.setDead();
				}
			}
		}
		super.onUpdate();
	}
	
	
	public int getCreeperState() {
		return this.dataWatcher.getWatchableObjectByte(16);
	}

	public float getCreeperFlashIntensity(float par1){
		return ((float) this.lastActiveTime + (float) (this.timeSinceIgnited - this.lastActiveTime) * par1) / (float) this.fuseTime - 2;
		
	}
	
	@Override
	public int getDropItemId(){
    	return Loader.ash.itemID;
    }
	
	@Override
	public String getEntityName(){
		return "UltraCreeper";
	}
}