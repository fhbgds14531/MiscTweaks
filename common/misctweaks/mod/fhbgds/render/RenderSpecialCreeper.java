package misctweaks.mod.fhbgds.render;

import misctweaks.mod.fhbgds.entities.EntitySpecialCreeper;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class RenderSpecialCreeper extends RenderLiving {

	private static final ResourceLocation poweredTexture = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
	public static ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/entities/specialCreeper.png");
	private ModelBase specialCreeperModel = new ModelSpecialCreeper();
	
	public RenderSpecialCreeper(ModelBase par1Model, float par2) {
		super(par1Model, par2);
	}

	protected ResourceLocation func_110829_a(EntitySpecialCreeper entity){
        return texture;
    }

	@Override
	protected ResourceLocation func_110775_a(Entity entity) {
		return this.func_110829_a((EntitySpecialCreeper)entity);
	}
	
	protected void preRenderCallback(EntityLivingBase entity, float par2){
        this.updateCreeperScale((EntitySpecialCreeper)entity, par2);
    }

	protected void updateCreeperScale(EntitySpecialCreeper par1EntitySpecialCreeper, float par2){
        float f1 = par1EntitySpecialCreeper.getCreeperFlashIntensity(par2);
        float f2 = 1.0F + MathHelper.sin(f1 * 100.0F) * f1 * 0.01F;

        if (f1 < 0.0F){
            f1 = 0.0F;
        }

        if (f1 > 1.0F){
            f1 = 1.0F;
        }

        f1 *= f1;
        f1 *= f1;
        float f3 = (1.0F + f1 * 0.4F) * f2;
        float f4 = (1.0F + f1 * 0.1F) / f2;
        GL11.glScalef(f3, f4, f3);
    }
	
	protected int getColorMultiplier(EntityLivingBase par1EntityLivingBase, float par2, float par3){
        return this.updateCreeperColorMultiplier((EntitySpecialCreeper)par1EntityLivingBase, par2, par3);
    }
	
	protected int shouldRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3){
        return this.renderCreeperPassModel((EntitySpecialCreeper)par1EntityLivingBase, par2, par3);
    }
	
	protected int inheritRenderPass(EntityLivingBase par1EntityLivingBase, int par2, float par3){
        return this.func_77061_b((EntitySpecialCreeper)par1EntityLivingBase, par2, par3);
    }
	
	protected int func_77061_b(EntitySpecialCreeper entity, int par2, float par3){
        return -1;
    }
	
    protected int renderCreeperPassModel(EntitySpecialCreeper par1EntitySpecialCreeper, int par2, float par3){
        if (par1EntitySpecialCreeper.getPowered()){
            if (par1EntitySpecialCreeper.isInvisible()){
                GL11.glDepthMask(false);
            }else{
                GL11.glDepthMask(true);
            }

            if (par2 == 1){
                float f1 = (float)par1EntitySpecialCreeper.ticksExisted + par3;
                this.func_110776_a(poweredTexture);
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                float f2 = f1 * 0.01F;
                float f3 = f1 * 0.01F;
                GL11.glTranslatef(f2, f3, 0.0F);
                this.setRenderPassModel(this.specialCreeperModel);
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_BLEND);
                float f4 = 0.5F;
                GL11.glColor4f(f4, f4, f4, 1.0F);
                GL11.glDisable(GL11.GL_LIGHTING);
                GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
                return 1;
            }

            if (par2 == 2){
                GL11.glMatrixMode(GL11.GL_TEXTURE);
                GL11.glLoadIdentity();
                GL11.glMatrixMode(GL11.GL_MODELVIEW);
                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glDisable(GL11.GL_BLEND);
            }
        }

        return -1;
    }
    
    protected int updateCreeperColorMultiplier(EntitySpecialCreeper par1EntitySpecialCreeper, float par2, float par3){
        float f2 = par1EntitySpecialCreeper.getCreeperFlashIntensity(par3);

        if ((int)(f2 * 10.0F) % 2 == 0){
            return 0;
        }else{
            int i = (int)(f2 * 0.2F * 255.0F);

            if (i < 0){
                i = 0;
            }

            if (i > 255){
                i = 255;
            }

            short short1 = 255;
            short short2 = 255;
            short short3 = 255;
            return i << 24 | short1 << 16 | short2 << 8 | short3;
        }
    }
}
