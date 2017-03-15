package Main;

import Misc.GlobalProperties;
import Misc.Output;
import Misc.PopulateSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MainApplet extends JApplet implements Runnable, KeyListener
{
    /*
    public static void main(String[] args)
    {
        MainApplet applet = new MainApplet();
        applet.setPreferredSize(new Dimension(1000, 200));
        applet.init();

        JFrame mainFrame = new JFrame();
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        mainFrame.getContentPane().add(applet);
        mainFrame.pack();
        mainFrame.setVisible(true);

        applet.start();
    }
    */

    public static Engine engine = new Engine();
    TickHandler tick;
    int frameCount = 0;

    public void init() {
        JRootPane rp = getRootPane();
        InputMap map = rp.getInputMap();
        ActionMap a_map = rp.getActionMap();

        map.put(KeyStroke.getKeyStroke("UP"), "UP");
        a_map.put("UP", saveMap);

        setSize(1000, 700);
        setBackground(Color.BLACK);
        addKeyListener(this);

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
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
    }

    private AbstractAction saveMap = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            Output.warnln(new File(MainApplet.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getPath() + "\\saves\\test.odtp");
            MapSaver.savePlayer(new File(MainApplet.class.getProtectionDomain().getCodeSource().getLocation().getPath()).getParentFile().getPath() + "\\saves\\test", engine.protagonist);
        }
    };

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void paint(Graphics g)
    {
        Output.debugln("Frame number: " + (frameCount++));
        BufferedImage image = (BufferedImage)engine.render.newFrame();
        Graphics g2 = image.getGraphics();
        g2.setColor(Color.pink);
        g2.drawString(Integer.toString(frameCount), 300, 300);
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
