package misctweaks.mod.fhbgds.client.render;

import misctweaks.mod.fhbgds.entity.EntityMagic;
import misctweaks.mod.fhbgds.lib.Loader;
import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.Icon;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderMagic extends Render{
	
	private float field_77002_a;
	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":textures/items/magicCore.png");
	private Icon textureIcon;

    public RenderMagic(float par1){
        super();
        }

    public void doRenderMagic(EntityMagic par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        GL11.glPushMatrix();
        this.bindEntityTexture(par1Entity);
        GL11.glTranslatef((float)par2, (float)par4, (float)par6);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float f2 = this.field_77002_a;
        GL11.glScalef(f2 / 1.0F, f2 / 1.0F, f2 / 1.0F);
        Icon icon = Loader.magicCore.getIconFromDamage(0);
        Tessellator tessellator = Tessellator.instance;
        float f3 = icon.getMinU();
        float f4 = icon.getMaxU();
        float f5 = icon.getMinV();
        float f6 = icon.getMaxV();
        float f7 = 1.0F;
        float f8 = 0.5F;
        float f9 = 0.25F;
        GL11.glRotatef(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.setNormal(0.0F, 1.0F, 0.0F);
        tessellator.addVertexWithUV((double)(0.0F - f8), (double)(0.0F - f9), 0.0D, (double)f3, (double)f6);
        tessellator.addVertexWithUV((double)(f7 - f8), (double)(0.0F - f9), 0.0D, (double)f4, (double)f6);
        tessellator.addVertexWithUV((double)(f7 - f8), (double)(1.0F - f9), 0.0D, (double)f4, (double)f5);
        tessellator.addVertexWithUV((double)(0.0F - f8), (double)(1.0F - f9), 0.0D, (double)f3, (double)f5);
        tessellator.draw();
        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    protected ResourceLocation func_110790_a(EntityMagic par1EntityMagic)
    {
        return texture ;
    }

    @Override
    public void updateIcons(IconRegister r){
    	this.textureIcon = r.registerIcon(Reference.MOD_ID + ":" + Loader.magicCore.getUnlocalizedName().substring(5));
    }
    
    @Override
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110790_a((EntityMagic)par1Entity);
    }

    @Override
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9)
    {
        this.doRenderMagic((EntityMagic)par1Entity, par2, par4, par6, par8, par9);
    }
}
