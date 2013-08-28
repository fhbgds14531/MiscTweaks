package misctweaks.mod.fhbgds.capes;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Capes {

	private String capeLoc = "https://raw.github.com/fhbgds14531/MiscTweaks/master/capeStuff/myCape.png";
	private URL url;
	public Capes(){
		makeCapes();
	}

	public void makeCapes(){
		try {
			url = new URL(capeLoc);
			URLConnection connection = url.openConnection();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
