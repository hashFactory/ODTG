package Objects;

/**
 * Created by tristan on 3/14/2017.
 */
public class Chunk
{
    public int dimension = 1;
    public int x = 0, y = 0;
    public long seed = 0;
    public short[][] block_id = new short[16][16];
    public byte[][] floor_id = new byte[16][16];

    public Chunk(int _x, int _y, int _dimension, long _seed)
    {
        dimension = _dimension;
        x = _x;
        y = _y;
        seed = _seed;
    }
}
