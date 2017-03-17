package GraphicsCreator;

import Main.MainApplet;
import Misc.GlobalProperties;
import Misc.Output;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Created by tristan on 3/14/2017.
 */
public class TextureCreator implements Runnable
{
    Image [] textures;

    public TextureCreator() {
        // TODO: Implement global property for texture width and height
        try
        {
            File image_file = new File(GlobalProperties.global.getProperty("path") + File.separator + "resources" + File.separator + GlobalProperties.global.getProperty("block_texture_name"));
            URL imageurl;
            BufferedImage image;
            if (image_file.exists())
            {
                Output.warnln("JAR is being run in production environment");
                image = ImageIO.read(image_file);
            }
            else
            {
                Output.warnln("JAR is being run in testing environment");
                imageurl = getClass().getResource("/resources/" + GlobalProperties.global.getProperty("block_texture_name"));
                image = ImageIO.read(imageurl);
            }

            int rows = image.getHeight() / Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width"));
            int columns = image.getWidth()/ Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height"));

            int tile_width = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_width"));
            int tile_height = Integer.valueOf(GlobalProperties.global.getProperty("block_texture_height"));

            textures = new Image[rows*columns];

            for (int i=0;i<rows;i++)
            {
                for (int j=0;j<columns;j++)
                {
                    textures[(i*columns)+j] = image.getSubimage(j*tile_width, i*tile_height, tile_width, tile_height).getScaledInstance(tile_width * Integer.valueOf(GlobalProperties.global.getProperty("x_multiplier")), tile_height * Integer.valueOf(GlobalProperties.global.getProperty("y_multiplier")), Image.SCALE_REPLICATE);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    public void run()
    {

    }

    public Image getTexture(int id)
    {
        return textures[id];
    }
}
