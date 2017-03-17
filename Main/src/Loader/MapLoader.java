package Loader;

import Misc.GlobalProperties;
import Misc.Output;
import Objects.Chunk;
import Objects.Map;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;

/**
 * Created by tristan on 3/14/2017.
 */
public class MapLoader
{
    public MapLoader(String fn)
    {
    }

    public static Map loadMap(Map map, String fn)
    {
        int number = 1;
        FileInputStream map_file_stream;

        int map_length = (int)new File(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odt" + Integer.toString(number)).length();

        ByteBuffer file = ByteBuffer.allocate(map_length);

        try {
            map_file_stream = new FileInputStream(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odt" + Integer.toString(number));
            map_file_stream.getChannel().read(file);
            file.rewind();
        } catch (FileNotFoundException e) {
            Output.errorln("Could not load map file!");
            e.printStackTrace();
        } catch (IOException e) {
            Output.errorln("Could not load map file into ByteBuffer");
            e.printStackTrace();
        }

        // TODO: Find better solution for larger files
        // TODO: Make player data and map data length constants that are configurable in Global.properties

        if (file.get() != (byte)0x40)
        {
            Output.errorln("Invalid map file; does not start with magic number");
            System.exit(12);
        }

        while (file.position() < map_length)
        {
            Chunk chunk = new Chunk(file.getInt(), file.getInt(), file.get(), map.seed);

            // TODO: If the map is Transposed, flip i and j
            for (int i = 0; i < 16; i++)
                for (int j = 0; j < 16; j++)
                    chunk.block_id[i][j] = file.getShort();

            for (int i = 0; i < 16; i++)
                for (int j = 0; j < 16; j++)
                    chunk.floor_id[i][j] = file.get();

            if (file.position() % 780 != 0)
            {
                Output.errorln("Incorrect buffer size for chunk");
                System.exit(13);
            }
            map.chunks.put(chunk.x + "," + chunk.y + "," + chunk.dimension, chunk);
        }

        return map;
    }
}
