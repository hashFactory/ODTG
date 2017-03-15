package GraphicsEngine;

import Main.MainApplet;
import Objects.Chunk;

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

    public BufferedImage draw(BufferedImage image, Chunk[] chunks)
    {
        // TODO: Figure out what chunks to be drawn
        Graphics2D g2 = (Graphics2D)image.getGraphics();
        g2.drawImage(engine.render.textureCreator.getTexture(0), 200, 400, null);
        g2.drawImage(engine.render.textureCreator.getTexture(1), 300, 400, null);
        g2.drawImage(engine.render.textureCreator.getTexture(2), 400, 400, null);
        g2.drawImage(engine.render.textureCreator.getTexture(3), 500, 400, null);

        return image;
    }
}
