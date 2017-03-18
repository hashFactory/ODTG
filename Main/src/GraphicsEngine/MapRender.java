package GraphicsEngine;

import Main.MainApplet;
import Misc.GlobalProperties;
import Objects.MapMethods;
import ProceduralGeneration.ChunkCreator;

import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.MainApplet.engine;

/**
 * Created by User on 3/14/2017.
 */
public class MapRender
{
    public MapRender()
    {

    }

    public BufferedImage draw(BufferedImage image)
    {
        String[] chunks = MapMethods.getCloseChunks(MainApplet.engine.protagonist);

        Graphics2D g2 = (Graphics2D)image.getGraphics();
        g2.clearRect(0, 0, image.getWidth(), image.getHeight());

        for (int i = 0; i < chunks.length; i++)
        {
            String[] chunk = chunks[i].split(",");
            int chunk_x = Integer.valueOf(chunk[0]);
            int chunk_y = Integer.valueOf(chunk[1]);
            int dimension = Integer.valueOf(chunk[2]);

            double x_multiplier = Double.valueOf(GlobalProperties.global.getProperty("x_multiplier"));
            double y_multiplier = Double.valueOf(GlobalProperties.global.getProperty("y_multiplier"));

            MainApplet.engine.map.chunks.computeIfAbsent(chunks[i], k -> ChunkCreator.createChunk(chunk_x, chunk_y, dimension, MainApplet.engine.map.seed));

            for (int x = 0; x < 16; x++)
            {
                for (int y = 0; y < 16; y++)
                {
                    double image_x = (MainApplet.engine.protagonist.x_chunk - MainApplet.engine.map.chunks.get(chunks[i]).x) * (16 * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width")) * x_multiplier) - (MainApplet.engine.protagonist.x * x_multiplier) + ((Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width")) * x_multiplier) * x) + Integer.valueOf(GlobalProperties.global.getProperty("width")) / 2;
                    double image_y = (MainApplet.engine.protagonist.y_chunk - MainApplet.engine.map.chunks.get(chunks[i]).y) * (16 * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height")) * y_multiplier) - (MainApplet.engine.protagonist.y * y_multiplier) + ((Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height")) * y_multiplier) * y) + Integer.valueOf(GlobalProperties.global.getProperty("height")) / 2;

                    g2.drawImage(engine.render.textureCreator.getTexture(MainApplet.engine.map.chunks.get(chunks[i]).block_id[x][y]), (int)image_x, (int)image_y, null);
                }
            }
        }

        return image;
    }
}
