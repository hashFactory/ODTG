package Main;

import Misc.GlobalProperties;
import Misc.Output;
import Misc.PopulateSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MainApplet extends JApplet implements Runnable, KeyListener
{
    public static void main(String[] args)
    {
        MainApplet applet = new MainApplet();
        applet.setPreferredSize(new Dimension(1000, 700));
        applet.init();

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.getContentPane().add(applet);
        mainFrame.pack();
        mainFrame.setVisible(true);

        applet.start();
    }

    public Engine engine = new Engine();
    TickHandler tick;
    int frameCount = 0;

    public void init() {
        setSize(1000, 700);
        setBackground(Color.BLACK);

        // Initialize statics
        PopulateSettings.populate();

        tick = new TickHandler();
        Thread ticking = new Thread(tick);
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paint(Graphics g)
    {
        Output.debugln("Frame number: " + (frameCount++));
        BufferedImage image = (BufferedImage)engine.render.newFrame();
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.pink);
        g2.drawString(Integer.toString(frameCount++), 300, 300);

        //TODO: Replace later
        g2.drawImage(engine.render.textureCreator.getTexture(0), 200, 400, this);
        g2.drawImage(engine.render.textureCreator.getTexture(1), 300, 400, this);
        g2.drawImage(engine.render.textureCreator.getTexture(2), 400, 400, this);
        g2.drawImage(engine.render.textureCreator.getTexture(3), 500, 400, this);


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
