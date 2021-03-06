package GraphicsEngine;

import Main.MainApplet;
import Misc.GlobalProperties;
import Misc.Output;
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
    int width, height;
    double scaled_x, scaled_y;
    double x_multiplier, y_multiplier;

    public MapRender()
    {
        setScale();
    }

    public void setScale()
    {
        width = Integer.valueOf(GlobalProperties.global.getProperty("width"));
        height = Integer.valueOf(GlobalProperties.global.getProperty("height"));
        x_multiplier = Double.valueOf(GlobalProperties.global.getProperty("x_multiplier"));
        y_multiplier = Double.valueOf(GlobalProperties.global.getProperty("y_multiplier"));
        scaled_x = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width")) * x_multiplier;
        scaled_y = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height")) * y_multiplier;
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

            MainApplet.engine.map.chunks.computeIfAbsent(chunks[i], k -> ChunkCreator.createChunk(chunk_x, chunk_y, dimension, MainApplet.engine.map.seed));

            double chunk_image_x = (MainApplet.engine.protagonist.x_chunk - MainApplet.engine.map.chunks.get(chunks[i]).x) * (16 * scaled_x) - (MainApplet.engine.protagonist.x * x_multiplier) + width / 2;
            double chunk_image_y = (MainApplet.engine.protagonist.y_chunk - MainApplet.engine.map.chunks.get(chunks[i]).y) * (16 * scaled_y) - (MainApplet.engine.protagonist.y * y_multiplier) + height / 2;

            for (int x = 0; x < 16; x++)
            {
                for (int y = 0; y < 16; y++) {
                    double image_x = chunk_image_x + (scaled_x * x);
                    double image_y = chunk_image_y + (scaled_y * y);

                    if (image_x + scaled_x > 0 && image_y + scaled_y > 0 && image_x < width && image_y < height)
                    {
                        g2.drawImage(engine.render.textureCreator.getTexture(MainApplet.engine.map.chunks.get(chunks[i]).block_id[x][y]), (int) image_x, (int) image_y, null);
                    }
                }
            }
        }
        return image;
    }
}
