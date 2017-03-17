package Main;

import Misc.GlobalProperties;
import Misc.Output;
import Objects.MapMethods;

/**
 * Created by tristan on 3/14/2017.
 */
public class TickHandler implements Runnable
{
    public final long startTime;
    public long timeSinceLastFrame = 0;
    public long timeSinceLastTick = 0;
    public long timeAtLastTick = 0;

    public TickHandler()
    {
        Output.infoln("Running at " + GlobalProperties.global.getProperty("ticks_per_second") + " ticks per second");
        startTime = System.currentTimeMillis();
    }

    public void run()
    {
        long timeAtLastTick = System.currentTimeMillis();
        while (true)
        {
            execute();
            timeSinceLastTick = System.currentTimeMillis()-timeAtLastTick;
            try{
                Thread.sleep(1000 / Integer.parseInt(GlobalProperties.global.getProperty("ticks_per_second")) - timeSinceLastTick);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            Output.infoln("Tick");
            timeAtLastTick = System.currentTimeMillis();
        }
    }

    public void execute()
    {
        String[] output = MapMethods.getCloseChunks(MainApplet.engine.protagonist);
        for (String string: output)
            Output.debug(string + "\t");
        Output.debug("\n");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
