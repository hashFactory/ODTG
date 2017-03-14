package GraphicsEngine;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by User on 3/14/2017.
 */
public class ShaderRender
{
    public ShaderRender()
    {

    }

    public BufferedImage draw(BufferedImage image)
    {
        // TODO: Replace this
        Graphics2D g2 = (Graphics2D)image.getGraphics();

        g2.setColor(Color.green);
        g2.fillRect(50, 50, 100, 100);

        return image;
    }
}
