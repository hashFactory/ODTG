package Objects;

import Characters.Protagonist;
import Main.MainApplet;
import Misc.GlobalProperties;

import java.util.ArrayList;

/**
 * Created by tristan on 3/15/2017.
 */
public class MapMethods
{
    public static String[] getCloseChunks(Protagonist pro)
    {
        // TODO: Fill out later
        ArrayList<String> chunks = new ArrayList<>();

        int pro_x = pro.x_chunk;
        int pro_y = pro.y_chunk;
        int pro_dim = pro.dimension;

        double x_mul = Double.valueOf(GlobalProperties.global.getProperty("x_multiplier"));
        double y_mul = Double.valueOf(GlobalProperties.global.getProperty("y_multiplier"));

        int window_width = Integer.valueOf(GlobalProperties.global.getProperty("width"));
        int window_height = Integer.valueOf(GlobalProperties.global.getProperty("height"));

        int center_x = window_width / 2;
        int center_y = window_height / 2;

        int tile_x = (int)(x_mul * 16 * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width")));
        int tile_y = (int)(y_mul * 16 * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height")));

        int radius_x = (center_x / tile_x) + 1;
        int radius_y = (center_y / tile_y) + 1;

        for (int i = -radius_x; i < radius_x; i++)
            for (int j = -radius_y; j < radius_y; j++)
                chunks.add(Integer.toString(i + pro_x) + "," + Integer.toString(j + pro_y) + "," + pro_dim);

        // Return statement
        String[] final_chunks = new String[chunks.size()];
        for (int i = 0; i < final_chunks.length; i++)
            final_chunks[i] = chunks.get(i);
        return final_chunks;
    }
}
