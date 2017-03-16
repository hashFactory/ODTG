package Characters;

import java.awt.*;

/**
 * Created by charpentiert on 3/14/17.
 */
public class Protagonist
{
    // TODO: Get animations for character
    // TODO: This version has no
    Image sprite;
    public int x_chunk = 0, y_chunk = 0;
    public int dimension = 0;
    public float x = 0, y = 0;
    public String username = "";
    public short[] special_items = new short[8];
    // 9x9 MAX INVENTORY SIZE
    // With 1 row for hotbar
    public short[][] inventory = new short[9][10];

    public Protagonist()
    {
    }
}
