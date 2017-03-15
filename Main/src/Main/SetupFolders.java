package Main;

import Misc.Output;

import java.io.File;

/**
 * Created by charpentiert on 3/15/17.
 */
public class SetupFolders
{
    public static void setup(String filename)
    {
        File directory = new File(filename + File.separator + "saves" + File.separator);
        if (!directory.exists())
            directory.mkdir();
        else
            Output.warnln("Could not create save folder");

        directory = new File(filename + File.separator + "resources" + File.separator);
        if (!directory.exists())
            directory.mkdir();
        else
            Output.warnln("Could not create resources folder");
    }
}
