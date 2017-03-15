package Misc;

import java.util.Enumeration;
import java.util.ResourceBundle;

/**
 * Created by tristan on 3/14/2017.
 */
public class PopulateSettings
{
    public static void populate()
    {
        ResourceBundle rb = ResourceBundle.getBundle("Misc.global");
        Enumeration rb_keys = rb.getKeys();
        while (rb_keys.hasMoreElements())
        {
            String key = (String)rb_keys.nextElement();
            GlobalProperties.global.put(key, rb.getObject(key));
        }
    }
}
