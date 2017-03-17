package GraphicsEngine;

import Misc.GlobalProperties;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by User on 3/14/2017.
 */
public class CharacterRender
{
    public CharacterRender()
    {

    }

    public BufferedImage draw(BufferedImage image)
    {
        Graphics2D g2 = (Graphics2D)image.getGraphics();

        int pro_width = Integer.valueOf(GlobalProperties.global.getProperty("x_multiplier")) * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width"));
        int pro_height = Integer.valueOf(GlobalProperties.global.getProperty("y_multiplier")) * Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height"));

        g2.setColor(Color.BLACK);
        g2.fillRect(image.getWidth() / 2 - pro_width / 2, image.getHeight() / 2 - pro_height / 2, pro_width, pro_height);
        g2.setColor(Color.pink);
        g2.drawRect(image.getWidth() / 2 - pro_width / 2, image.getHeight() / 2 - pro_height / 2, pro_width, pro_height);

        return image;
    }
}
