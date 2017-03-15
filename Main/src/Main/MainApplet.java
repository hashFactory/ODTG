package Main;

import InputEngine.InputEngine;
import Misc.GlobalProperties;
import Misc.Output;
import Misc.PopulateSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;

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
    public static String path = new File(MainApplet.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getPath();
    public InputEngine inputEngine = new InputEngine(getRootPane());

    public void init()
    {
        setSize(1000, 700);
        setBackground(Color.BLACK);

        // Initialize statics
        PopulateSettings.populate();

        SetupFolders.setup(path);

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
        Output.debugln("Frame number: " + (frameCount++));
        BufferedImage image = (BufferedImage)engine.render.newFrame();
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.pink);
        g2.drawString(Integer.toString(frameCount++), 300, 300);

        g.drawImage(image, 0, 0, this);
        tick.timeSinceLastFrame = 0;
    }

    @Override
    public void run()
    {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);

        while (true)
        {
            try {
                Thread.sleep(Long.parseLong(GlobalProperties.global.getProperty("sleep_time")));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }


}
