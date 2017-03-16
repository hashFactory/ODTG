package Loader;

import Characters.Protagonist;
import Misc.GlobalProperties;
import Misc.Output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by tristan on 3/15/2017.
 */
public class CharacterLoader
{
    public static Protagonist loadCharacter(Protagonist pro, String fn)
    {
        //File pro_file = new File(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odp");

        FileInputStream pro_file_stream;

        int pro_length = (int)new File(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odtp").length();

        ByteBuffer file = ByteBuffer.allocate(pro_length);

        try {
            pro_file_stream = new FileInputStream(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odtp");
            pro_file_stream.getChannel().read(file);
            file.rewind();
        } catch (FileNotFoundException e) {
            Output.errorln("Could not load player file!");
            e.printStackTrace();
        } catch (IOException e) {
            Output.errorln("Could not load player file into ByteBuffer");
            e.printStackTrace();
        }

        // TODO: Find better solution for larger files
        // TODO: Make player data and map data length constants that are configurable in Global.properties

        if (file.get() != (byte)0x41)
        {
            Output.errorln("Invalid player file; does not start with magic number");
            System.exit(12);
        }
        char[] name = new char[24];
        for (int i = 0; i < 24; i++)
        {
            name[i] = file.getChar();
        }
        pro.username = String.valueOf(name);
        pro.dimension = file.get();
        pro.x_chunk = file.getInt();
        pro.y_chunk = file.getInt();
        pro.x = file.getFloat();
        pro.y = file.getFloat();
        for (int i = 0; i < 9; i++)
        {
            pro.special_items[i] = file.getShort();
        }
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                pro.inventory[i][j] = file.getShort();
            }
        }

        return pro;
    }
}
