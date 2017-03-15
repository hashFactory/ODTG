package Main;

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
            PrintWriter pw = new PrintWriter(new FileOutputStream(fn + ".odtp"));
            pw.print(map_data);
            pw.close();
        }
        catch (FileNotFoundException ex)
        {
            Output.errorln("Could not save player data!");
            ex.printStackTrace();
        }
    }
}
