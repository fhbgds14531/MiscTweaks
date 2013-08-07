package misctweaks.mod.fhbgds.client;

import misctweaks.mod.fhbgds.lib.Reference;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class SoundEvent {

	@ForgeSubscribe
    public void onSound(SoundLoadEvent event)
    {
        try 
        {
        	event.manager.addSound("misctweaks:pew.ogg");
        }
        
        catch (Exception e)
        {
            System.err.println("Sound error");
        }

}
}