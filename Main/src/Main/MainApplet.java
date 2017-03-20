package Main;

import InputEngine.InputEngine;
import Misc.GlobalProperties;
import Misc.Output;

import java.applet.Applet;
import java.awt.*;
import javax.swing.*;

public class MainApplet extends JApplet implements Runnable
{

    public static void main(String[] args)
    {

        MainApplet applet = new MainApplet();
        applet.setPreferredSize(new Dimension(1000, 700));
        applet.init();

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        mainFrame.getContentPane().add(applet);
        mainFrame.pack();
        mainFrame.setVisible(true);

        applet.start();
    }

    public static Engine engine = new Engine();
    TickHandler tick;
    int frameCount = 0;
    public InputEngine inputEngine = new InputEngine(getRootPane());

    public void init()
    {
        setSize(1000, 700);
        setBackground(Color.BLACK);

        // Initialize statics

        tick = new TickHandler();
        Thread ticking = new Thread(tick);
        ticking.setPriority(Thread.MIN_PRIORITY);
        ticking.start();
    }

    public void start()
    {
        Thread th = new Thread(this);
        th.start();
    }

    public void stop()
    {
        // TODO: Repopulate global.properties with cached settings
    }

    public void paint(Graphics g)
    {
        Output.infoln("Frame number: " + (frameCount++));

        inputEngine.kh.interpret();
        g.drawImage(engine.render.newFrame(), 0, 0, this);
        tick.timeSinceLastFrame = 0;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        while (true)
        {
            try {
                Thread.sleep(1000 / Long.parseLong(GlobalProperties.global.getProperty("frames_per_second")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }
}