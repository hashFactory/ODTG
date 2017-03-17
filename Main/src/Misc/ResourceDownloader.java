package Misc;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by tristan on 3/15/2017.
 */
public class ResourceDownloader
{
    public ResourceDownloader()
    {

    }

    public static boolean populate()
    {
        File textures = new File(GlobalProperties.global.getProperty("path") + File.separator + "resources" + File.separator + GlobalProperties.global.getProperty("block_texture_name"));
        if (!textures.exists())
        {
            try {
                URL textures_url = new URL("https://raw.githubusercontent.com/hashFactory/ODTG/master/Main/src/Resources/" + GlobalProperties.global.getProperty("block_texture_name"));
                Files.copy(textures_url.openStream(), textures.toPath());
                Output.debugln("Successfully populated ." + File.separator + "resources" + File.separator + GlobalProperties.global.getProperty("block_texture_name"));
            } catch (MalformedURLException e)
            {
                Output.errorln("Could not form URL for " + GlobalProperties.global.getProperty("block_texture_name") + " from GitHub");
                e.printStackTrace();
                return false;
            } catch (IOException e) {
                Output.errorln("Could not open stream to " + GlobalProperties.global.getProperty("block_texture_name") + "textures.png");
                e.printStackTrace();
                return false;
            }
        }
        else
            Output.debugln("Loaded " + GlobalProperties.global.getProperty("block_texture_name") + " without downloading it!");

        return true;
    }
}
