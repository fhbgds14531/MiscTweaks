package misctweaks.mod.fhbgds.entity;

import java.util.Random;

import misctweaks.mod.fhbgds.lib.Reference;
import misctweaks.mod.fhbgds.util.MiscMethods;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EntityMagic extends EntityThrowable{
	
	public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/items/magicCore.png");
	private float damage = 0.0F;
	private float explosionSize;
	private int range;
	private Random rand = new Random();
	private DamageSource magic;
	private EntityPlayer player;

	public EntityMagic(World world, EntityLivingBase player, float damage, float explosionSize, int range){
		super(world, player);
		this.setDamage(damage);
		this.setExplosionSize(explosionSize);
		this.setRange(range);
		this.player = (EntityPlayer) player;
		magic = DamageSource.causePlayerDamage((EntityPlayer) player);
	}

	private void setRange(int range) {
		this.range = range;
	}

	@Override
	protected void onImpact(MovingObjectPosition event){
		switch (event.typeOfHit) {
		case ENTITY:
			if (event.entityHit != null) {
				Entity entity = event.entityHit;
				if(entity instanceof EntityPlayer){
					MiscMethods.spawnBlockParticles(worldObj, null, (int)this.posX, (int)this.posY, (int)this.posZ, "smokelarge", "EntityMagic hit");
				
					this.worldObj.playSoundAtEntity(event.entityHit, "mob.irongolem.throw", 1.0f, 1.0f);
				
					
					
					event.entityHit.attackEntityFrom(magic, this.getDamage());
				}else{
					if(entity instanceof EntityLiving){
						MiscMethods.spawnBlockParticles(worldObj, null, (int)this.posX, (int)this.posY, (int)this.posZ, "smokelarge", "EntityMagic hit");
					
						int a = rand.nextInt(), b = rand.nextInt(), c = rand.nextInt();
						
						if(a > 100)  a =  50;
						if(a < -100) a = -50;
						if(b > 100)  a =  50;
						if(b < -100) a = -50;
						if(c > 100)  a =  50;
						if(c < -100) a = -50;
						
						if((EntityLiving) entity instanceof EntityMob) ((EntityLiving)entity).setRevengeTarget(this.player);
					}
				}
			}
			break;
		case TILE:
			
			MiscMethods.spawnBlockParticles(worldObj, null, (int)this.posX, (int)this.posY, (int)this.posZ, "smokelarge", "EntityMagic death");
			break;
		default:
			break;
		}
		if (FMLCommonHandler.instance().getEffectiveSide() == Side.SERVER)
		{
		}
			this.setDead();
	}
	
	@Override
	public boolean canTriggerWalking(){
		return false;
	}
	
	@Override
	public boolean canAttackWithItem(){
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public float getShadowSize(){
		return 0.0F;
	}
	
	@Override
	protected void entityInit(){
		this.renderDistanceWeight = 10.0D;
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
		this.setDead();
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (this.ticksExisted > this.getMaxLifetime()) {
			for(int i = 0; i < 10; i++){
			MiscMethods.spawnBlockParticles(worldObj, null, (int)this.posX, (int)this.posY, (int)this.posZ, "smokelarge", "EntityMagic death");
			}
			this.worldObj.playSoundAtEntity(this, "poof", 1, 1);
//			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, false);
			this.setDead();
			
		}
	}
	
	@Override
	public String getEntityName(){
		return "Magic";
	}

	private int getMaxLifetime() {
		return range;
	}
	
	public void setDamage(float f){
		this.damage = f;
	}
	
	public float getDamage(){
		return this.damage;
	}
	
	public void setExplosionSize(float f){
		this.explosionSize = f;
	}
	
	public float getExplosionSize(){
		return this.explosionSize;
	}

    /**
     * Gets how bright this entity is.
     */
    public float getBrightness(float par1)
    {
        return 1.0F;
    }

    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender(float par1)
    {
        return 15728880;
    }
}