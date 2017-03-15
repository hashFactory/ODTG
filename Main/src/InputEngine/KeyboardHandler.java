package InputEngine;

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

        // SPACE to `
        for (int i = 32; i < 96; i++)
            map.put(KeyStroke.getKeyStroke(Character.toString((char)i)), Character.toString((char)i));

        // ADD ELEMENTS TO MAP
        a_map.put("UP", up);
    }

    private AbstractAction up = new AbstractAction()
    {
        public void actionPerformed(ActionEvent e)
        {
            Output.warnln(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + "test.odtp");
            MapSaver.savePlayer("test", MainApplet.engine.protagonist);
        }
    };
}
