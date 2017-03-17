package Misc;

import Characters.Protagonist;
import Characters.ProtagonistMethods;
import Misc.Output;
import Objects.Chunk;
import Objects.ChunkMethods;
import Objects.Map;
import Objects.MapMethods;

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
        ArrayList<Byte> player_data = new ArrayList<>();

        // TODO: Add saving of seed and file version
        // TODO: .odts (stats) contains stats such as seed and file version
        // TODO: Fix the savePlayer / saveMap for later
        player_data.addAll(ProtagonistMethods.toArrayList(p));

        try
        {
            FileOutputStream player = new FileOutputStream(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odtp");

            for (Byte spot: player_data) {
                try {
                    player.write(spot);
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

    public static void saveMap(String fn, Map map)
    {
        ArrayList<Byte> chunk_data = new ArrayList<>();

        for (Chunk chunk: map.chunks.values())
            chunk_data.addAll(ChunkMethods.toArrayList(chunk));

        try
        {
            FileOutputStream chunks = new FileOutputStream(GlobalProperties.global.getProperty("path") + File.separator + "saves" + File.separator + fn + ".odt1");

            for (Byte spot: chunk_data) {
                try {
                    chunks.write(spot);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        catch (FileNotFoundException ex)
        {
            Output.errorln("Could not save map data!");
            ex.printStackTrace();
        }
    }
}
