package Main;

import Characters.Protagonist;
import GraphicsEngine.Render;
import Misc.PopulateSettings;

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
        render = new Render();
        protagonist = new Protagonist();
    }
}
