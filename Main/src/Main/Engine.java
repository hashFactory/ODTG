package Main;

import Characters.Protagonist;
import GraphicsEngine.Render;

/**
 * Created by tristan on 3/14/2017.
 */
public class Engine
{
    public Render render;
    public Protagonist protagonist;

    public Engine()
    {
        render = new Render();
        protagonist = new Protagonist();
    }
}
