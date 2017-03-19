package Objects;

import Characters.Protagonist;
import Main.MainApplet;
import Misc.GlobalProperties;
import Misc.Output;

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

        int radius_x = (center_x / tile_x) + 2;
        int radius_y = (center_y / tile_y) + 2;

        for (int i = -radius_x; i < radius_x; i++)
            for (int j = -radius_y; j < radius_y; j++)
                chunks.add(Integer.toString(i + pro_x) + "," + Integer.toString(j + pro_y) + "," + pro_dim);

        // Return statement
        String[] final_chunks = new String[chunks.size()];
        for (int i = 0; i < final_chunks.length; i++)
            final_chunks[i] = chunks.get(i);
        return final_chunks;
    }

    public static String[] getRenderableChunks(Protagonist pro)
    {
        ArrayList<String> chunks = new ArrayList<>();

        int pro_x = pro.x_chunk;
        int pro_y = pro.y_chunk;
        int pro_dim = pro.dimension;

        int window_width = Integer.valueOf(GlobalProperties.global.getProperty("width"));
        int window_height = Integer.valueOf(GlobalProperties.global.getProperty("height"));
        double x_mul = Double.valueOf(GlobalProperties.global.getProperty("x_multiplier"));
        double y_mul = Double.valueOf(GlobalProperties.global.getProperty("y_multiplier"));
        double scaled_x = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width")) * x_mul;
        double scaled_y = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height")) * y_mul;
        double chunkWidth = scaled_x*16;
        double chunkHeight =  scaled_y*16;
        double chunk_image_x = (MainApplet.engine.protagonist.x_chunk - pro_x * (16 * scaled_x) - (MainApplet.engine.protagonist.x * x_mul) + window_width / 2);
        double chunk_image_y = (MainApplet.engine.protagonist.y_chunk - pro_y * (16 * scaled_y) - (MainApplet.engine.protagonist.y * y_mul) + window_height / 2);

        int beginX, endX, beginY, endY;

        //TODO: This is what I think is broken - the next 4 lines.
        beginX = (int)(chunk_image_x/chunkWidth)-1;
        endX = (int)((window_width-(chunk_image_x+chunkWidth))/chunkWidth)+1;

        beginY = (int)(chunk_image_y/chunkHeight)-1;
        endY = (int)((window_height-(chunk_image_y+chunkHeight))/chunkHeight)+1;

        Output.warnln(beginX+","+endX+"-"+beginY+","+endY);

        for (int i = beginX; i <= endX; i++)
            for (int j = beginY; j <= endY; j++)
                chunks.add(Integer.toString(i + pro_x) + "," + Integer.toString(j + pro_y) + "," + pro_dim);

        // Return statement
        String[] final_chunks = new String[chunks.size()];
        for (int i = 0; i < final_chunks.length; i++)
            final_chunks[i] = chunks.get(i);
        return final_chunks;
    }
}
