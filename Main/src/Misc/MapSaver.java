package Misc;

import Characters.Protagonist;
import Characters.ProtagonistMethods;
import Misc.Output;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by tristan on 3/14/2017.
 */
public class MapSaver
{
    public static void savePlayer(String fn, Protagonist p)
    {
        ArrayList<Byte> map_data = new ArrayList<>();

        map_data.addAll(ProtagonistMethods.toArrayList(p));

        try
        {
            FileOutputStream stream = new FileOutputStream(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odtp");

            for (Byte spot: map_data) {
                try {
                    stream.write(spot);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            Output.errorln("Could not save player data!");
            ex.printStackTrace();
        }
    }
}
