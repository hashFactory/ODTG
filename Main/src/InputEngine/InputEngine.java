package InputEngine;

import javax.swing.*;

/**
 * Created by charpentiert on 3/15/17.
 */
public class InputEngine
{
    public KeyboardHandler kh;
    public MouseHandler mh = new MouseHandler();
    public GamepadHandler gh = new GamepadHandler();

    public JRootPane jrp;

    public InputEngine(JRootPane _jrp)
    {
        jrp = _jrp;
        kh = new KeyboardHandler(jrp);
    }



}
