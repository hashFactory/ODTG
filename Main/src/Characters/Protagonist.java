package Characters;

import java.awt.*;

/**
 * Created by charpentiert on 3/14/17.
 */
public class Protagonist
{
    // TODO: Get animations for character
    Image sprite;
    int x_chunk = 0, y_chunk = 0;
    int dimension = 0;
    float x = 0, y = 0;
    String username = "";
    byte[] special_items = new byte[8];
    // 9x9 MAX INVENTORY SIZE
    short[][] inventory = new short[9][10];

    public Protagonist()
    {
    }
}
