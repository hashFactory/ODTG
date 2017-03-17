package InputEngine;

import Loader.MapLoader;
import Main.MainApplet;
import Misc.GlobalProperties;
import Misc.MapSaver;
import Misc.Output;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.File;

/**
 * Created by charpentiert on 3/14/17.
 */
public class KeyboardHandler
{
    public KeyboardHandler(JRootPane rpc)
    {
        JRootPane rp = rpc;
        InputMap map = rp.getInputMap();
        ActionMap a_map = rp.getActionMap();

        // ARROW KEYS
        map.put(KeyStroke.getKeyStroke("UP"), "UP");
        map.put(KeyStroke.getKeyStroke("DOWN"), "DOWN");
        map.put(KeyStroke.getKeyStroke("LEFT"), "LEFT");
        map.put(KeyStroke.getKeyStroke("RIGHT"), "RIGHT");

        // SPACE to `
        for (int i = 32; i < 96; i++)
            map.put(KeyStroke.getKeyStroke(Character.toString((char)i)), "pressedAction");
        for (int i = 32; i < 96; i++)
            map.put(KeyStroke.getKeyStroke("released " + Character.toString((char)i)), "releasedAction");

        a_map.put("pressedAction", pressedAction);
        a_map.put("releasedAction", releasedAction);

        // ADD ELEMENTS TO MAP
        a_map.put("UP", up);
        a_map.put("DOWN", down);
        a_map.put("RIGHT", right);
    }

    private AbstractAction pressedAction = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            int character = e.getActionCommand().toCharArray()[0];
            InputEngine.keyStroke[character] = true;
        }
    };

    private AbstractAction releasedAction = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            int character = e.getActionCommand().toCharArray()[0];
            InputEngine.keyStroke[character] = false;
        }
    };

    private AbstractAction right = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            MainApplet.engine.map = MapLoader.loadMap(MainApplet.engine.map, "test");
        }
    };

    private AbstractAction up = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            Output.warnln(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + "test.odtp");
            MapSaver.savePlayer("test", MainApplet.engine.protagonist);
        }
    };

    private AbstractAction down = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            Output.warnln(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + "test.odt1");
            MapSaver.saveMap("test", MainApplet.engine.map);
        }
    };

    private AbstractAction w = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            InputEngine.keyStroke['w'] = true;
        }
    };

    public static void interpret()
    {
        if (InputEngine.keyStroke['w'])
        {
            MainApplet.engine.protagonist.y--;
            if (MainApplet.engine.protagonist.y < 0)
            {
                MainApplet.engine.protagonist.y_chunk++;
                MainApplet.engine.protagonist.y += 256;
            }
        }

        if (InputEngine.keyStroke['s'])
        {
            MainApplet.engine.protagonist.y++;
            if (MainApplet.engine.protagonist.y > 256)
            {
                MainApplet.engine.protagonist.y_chunk--;
                MainApplet.engine.protagonist.y -= 256;
            }
        }

        if (InputEngine.keyStroke['a'])
        {
            MainApplet.engine.protagonist.x--;
            if (MainApplet.engine.protagonist.x < 0)
            {
                MainApplet.engine.protagonist.x_chunk++;
                MainApplet.engine.protagonist.x += 256;
            }
        }

        if (InputEngine.keyStroke['d'])
        {
            MainApplet.engine.protagonist.x++;
            if (MainApplet.engine.protagonist.x > 256)
            {
                MainApplet.engine.protagonist.x_chunk--;
                MainApplet.engine.protagonist.x -= 256;
            }
        }
    }
}
