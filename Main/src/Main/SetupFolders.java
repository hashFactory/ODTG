package Main;

import Misc.GlobalProperties;
import Misc.Output;

import java.io.File;

/**
 * Created by charpentiert on 3/15/17.
 */
public class SetupFolders
{
    public static void setup()
    {
        String filename = GlobalProperties.global.getProperty("path");

        File directory = new File(filename + File.separator + "saves" + File.separator);
        if (!directory.exists()) {
            boolean result = directory.mkdir();
            if (result)
                Output.warnln("Had to create ." + File.separator + "saves folder");
            else
                Output.errorln("Could not create ." + File.separator + "saves folder");
        }
        else
            Output.infoln("." + File.separator + "saves folder already exists");

        directory = new File(filename + File.separator + "resources" + File.separator);
        if (!directory.exists()) {
            directory.mkdir();
            boolean result = directory.mkdir();
            if (result)
                Output.warnln("Had to create ." + File.separator + "resources folder");
            else
                Output.errorln("Could not create ." + File.separator + "resources folder");
        }
        else
            Output.infoln("." + File.separator + "resources folder already exists");
    }
}
