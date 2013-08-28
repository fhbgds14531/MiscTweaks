package misctweaks.mod.fhbgds.capes;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.IImageBuffer;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraft.client.renderer.ThreadDownloadImageData;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureObject;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StringUtils;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public abstract class NewAbstractClientPlayer extends AbstractClientPlayer
{
    public static final ResourceLocation field_110314_b = new ResourceLocation("textures/entity/steve.png");
    private ThreadDownloadImageData field_110316_a;
    private ThreadDownloadImageData field_110315_c;
    private ResourceLocation field_110312_d;
    private ResourceLocation field_110313_e;
    private static String[] cloakURLs;

    public NewAbstractClientPlayer(World par1World, String par2Str)
    {
        super(par1World, par2Str);
        this.func_110302_j();
        for(int i = 0; i <= cloakURLs.length; i++){
        	cloakURLs[i] = null;
        }
        this.cloakURLs[0] = "http://skins.minecraft.net/MinecraftCloaks/";
    }

    @Override
    protected void func_110302_j()
    {
        System.out.println("Setting up custom skins");

        if (this.username != null && !this.username.isEmpty())
        {
            this.field_110312_d = getSkin(this.username);
            this.field_110313_e = getCloak(this.username);
            this.field_110316_a = downloadSkin(this.field_110312_d, this.username);
            this.field_110315_c = downloadCloak(this.field_110313_e, this.username);
        }
    }

    @Override
    public ThreadDownloadImageData func_110309_l()
    {
        return this.field_110316_a;
    }

    @Override
    public ThreadDownloadImageData func_110310_o()
    {
        return this.field_110315_c;
    }

    @Override
    public ResourceLocation func_110306_p()
    {
        return this.field_110312_d;
    }

    @Override
    public ResourceLocation func_110303_q()
    {
        return this.field_110313_e;
    }

    public static ThreadDownloadImageData downloadSkin(ResourceLocation par0ResourceLocation, String par1Str)
    {
        return func_110301_a(par0ResourceLocation, getSkinURL(par1Str), field_110314_b, new ImageBufferDownload());
    }

    public static ThreadDownloadImageData downloadCloak(ResourceLocation par0ResourceLocation, String par1Str)
    {
    	boolean cloakFound = false;
    	ThreadDownloadImageData data = func_110301_a(par0ResourceLocation, getCloakURL(par1Str, 0), (ResourceLocation)null, (IImageBuffer)null);
        for(int i = 1; i <= cloakURLs.length; i++){
        	if(data == null){
        		data = func_110301_a(par0ResourceLocation, getCloakURL(par1Str, i), (ResourceLocation)null, new ImageBufferDownload());
        	}else{
        		cloakFound = true;
        		break;
        	}
        	if(cloakFound) return data;
        }
    	
    	return data;
    }

    private static ThreadDownloadImageData func_110301_a(ResourceLocation resourceLocation, String resourceURL,
    		ResourceLocation resourceLocation1, IImageBuffer buffer)
    {
        TextureManager texturemanager = Minecraft.getMinecraft().func_110434_K();//gets renderengine
        Object object = texturemanager.func_110581_b(resourceLocation);//gets texture

        if (object == null)
        {
            object = new ThreadDownloadImageData(resourceURL, resourceLocation1, buffer);
            texturemanager.func_110579_a(resourceLocation, (TextureObject)object);
        }

        return (ThreadDownloadImageData)object;
    }

    public static String getSkinURL(String username)
    {
        return String.format("http://skins.minecraft.net/MinecraftSkins/%s.png", new Object[] {StringUtils.stripControlCodes(username)});
    }

    public static String getCloakURL(String username, int urlIndex)
    {
        return String.format(cloakURLs[urlIndex] + "%s.png", new Object[] {StringUtils.stripControlCodes(username)});
    }
    


    public static ResourceLocation getSkin(String par0Str)
    {
        return new ResourceLocation("skins/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ResourceLocation getCloak(String par0Str)
    {
        return new ResourceLocation("cloaks/" + StringUtils.stripControlCodes(par0Str));
    }

    public static ResourceLocation func_110305_h(String par0Str)
    {
        return new ResourceLocation("skull/" + StringUtils.stripControlCodes(par0Str));
    }
    
//=================================================================================================================================    
    /**
     * @param url - The URL of the cloaks folder ("http://skins.minecraft.net/MinecraftCloaks/")
     * @return The string added, for verification
     */
    public static String addCloakURL(String url)
    {
    	int currentLength = cloakURLs.length;
    	cloakURLs[currentLength + 1] = url;
    	return cloakURLs[currentLength + 1];
    }
}
