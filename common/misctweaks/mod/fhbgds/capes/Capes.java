package misctweaks.mod.fhbgds.capes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ImageBufferDownload;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class Capes {

	private String capeLoc = "https://raw.github.com/fhbgds14531/MiscTweaks/master/capeStuff/capes.txt";
	private URL url;
	private Map capesList = new HashMap<String, String>();
	
	public Capes(){
		makeCapeDatabase();
	}

	public void makeCapeDatabase(){
		try {
			url = new URL(capeLoc);
			URLConnection connection = url.openConnection();
			connection.setConnectTimeout(1000);
			connection.setReadTimeout(1000);
			InputStream input = connection.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			
			String line;
			int lineNumber = 1;
			
			while((line = reader.readLine()) != null){
				if(line.contains(":")){
					String username = line.substring(0, line.indexOf(":"));
					String capeURL = line.substring(line.indexOf(":") + 1);
					capesList.put(username, capeURL);
					System.out.println("[misctweaks] " + username + ": " + capeURL);
//					Minecraft.getMinecraft().renderEngine.obtainImageData(capeURL, new ImageBufferDownload());
				}else{
					System.err.println("[misctweaks] Error creating CAPE database on line " + lineNumber);
				}
			}
			reader.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@ForgeSubscribe
	public void onPreRenderSpecials(RenderPlayerEvent.Specials.Pre event){
		String capeURL = (String) capesList.get(event.entityPlayer.username);
		System.out.println(capeURL);
		if(capeURL != null){
			NewAbstractClientPlayer.addCloakURL(capeURL);
			event.renderCape = true;
		}
	}
}
