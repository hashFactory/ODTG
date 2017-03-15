package Main;

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
                Thread.sleep(500-timeSinceLastTick);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.out.println(timeSinceLastTick);
            timeAtLastTick = System.currentTimeMillis();
        }
    }

    public void execute(){
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
