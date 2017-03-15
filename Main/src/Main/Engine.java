package Main;

import Characters.Protagonist;
import GraphicsEngine.Render;
import Misc.GlobalProperties;
import Misc.Output;
import Misc.PopulateSettings;
import Misc.ResourceDownloader;

/**
 * Created by tristan on 3/14/2017.
 */
public class Engine
{
    public Render render;
    public Protagonist protagonist;

    public Engine()
    {
        PopulateSettings.populate();
        SetupFolders.setup();
        ResourceDownloader.populate();
        Output.debugln("Running at " + (1000 / Integer.parseInt(GlobalProperties.global.getProperty("frames_per_second"))) + " frames per second");
        render = new Render();
        protagonist = new Protagonist();
    }
}
