package Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

public class MainApplet extends JApplet implements Runnable, KeyListener
{
    public static void main(String[] args)
    {
    }

    public Engine engine = new Engine();
    TickHandler tick;
    int frameCount = 0;

    public void init() {
        setSize(1000, 700);
        setBackground(Color.BLACK);
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
        //System.out.println("Frame number: " + (frameCount++));
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

        // TODO: change to property loading
        while (true)
        {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }

    }
}
