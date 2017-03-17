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
        try
        {
            File image_file = new File(GlobalProperties.global.getProperty("path") + File.separator + "resources" + File.separator + "textures.png");
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
                imageurl = getClass().getResource("/resources/textures.png");
                image = ImageIO.read(imageurl);
            }

            int rows = image.getHeight()/16;
            int columns = image.getWidth()/16;
            textures = new Image[rows*columns];

            for (int i=0;i<rows;i++)
            {
                for (int j=0;j<columns;j++)
                {
                    textures[(i*columns)+j] = image.getSubimage(j*16, i*16, 16, 16).getScaledInstance(16 * Integer.valueOf(GlobalProperties.global.getProperty("x_multiplier")), 16 * Integer.valueOf(GlobalProperties.global.getProperty("y_multiplier")), Image.SCALE_REPLICATE);
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
