package misctweaks.mod.fhbgds.entities;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.entity.EntityLivingBase;
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
	
	public final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/items/magicCore.png");
	private float damage = 0.0F;
	private float explosionSize;
	private int range;

	public EntityMagic(World world, EntityLivingBase player, float damage, float explosionSize, int range){
		super(world, player);
		this.setDamage(damage);
		this.setExplosionSize(explosionSize);
		this.setRange(range);
	}

	private void setRange(int range) {
		this.range = range;
	}

	@Override
	protected void onImpact(MovingObjectPosition event){
		switch (event.typeOfHit) {
		case ENTITY:
			if (event.entityHit != null) {
				for(int i = 0; i < 20; i++){
					this.worldObj.spawnParticle("splash", this.posX , this.posY, this.posZ, 0.0, -0.5, 0.0);
				}
				this.worldObj.playSoundAtEntity(event.entityHit, "mob.irongolem.throw", 1.0f, 1.0f);
				event.entityHit.attackEntityFrom(DamageSource.magic, this.getDamage());
			}
			break;
		case TILE:
			
			for(int i = 0; i < 20; i++){
				this.worldObj.spawnParticle("splash", this.posX , this.posY, this.posZ, 0.0, -0.5, 0.0);
			}
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, this.getExplosionSize(), false);
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
	
//	@Override
//	protected void entityInit(){
//		this.renderDistanceWeight = 10.0D;
//	}
	
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
			this.worldObj.spawnParticle("splash", this.posX , this.posY, this.posZ, 0.0, -0.5, 0.0);
			}
			this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 1, false);
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
	
	public String getTextureFileLoc(){
		return "assets/misctweaks/textures/items/magicCore.png";
	}
}