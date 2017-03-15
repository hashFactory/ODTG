package Objects;

/**
 * Created by tristan on 3/14/2017.
 */
public class Chunk
{
    int dimension = 1;
    int x = 0, y = 0;
    long seed = 0;
    short[][] block_id = new short[16][16];
    byte[][] floor_id = new byte[16][16];

    public Chunk(int _x, int _y, int _dimension, long _seed)
    {
        dimension = _dimension;
        x = _x;
        y = _y;
        seed = _seed;
    }
}
