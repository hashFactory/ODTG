package GraphicsCreator;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * Created by tristan on 3/14/2017.
 */
public class TextureCreator implements Runnable
{
    Image [] textures;

    public TextureCreator() {
        /*
        try
        {
            URL imageurl = getClass().getResource("/resources/textures.png");
            BufferedImage image = ImageIO.read(imageurl);

            int rows = image.getHeight()/16;
            int columns = image.getWidth()/16;
            textures = new Image[rows*columns];

            for (int i=0;i<rows;i++)
            {
                for (int j=0;j<columns;j++)
                {
                    textures[(i*columns)+j] = image.getSubimage(j*16, i*16, 16, 16);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        */
    }

    public void run()
    {

    }

    public Image getTexture(int id)
    {
        return textures[id];
    }
}
