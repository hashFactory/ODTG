package Objects;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by tristan on 3/14/2017.
 */
public class ChunkMethods
{
    public ChunkMethods()
    {

    }

    public static ArrayList<Byte> toArrayList(Chunk chunk)
    {
        ArrayList<Byte> value = new ArrayList<>();
        ByteBuffer cache = ByteBuffer.allocate(780);
        cache.put((byte)0x40);
        cache.putInt(chunk.x);
        cache.putInt(chunk.y);
        cache.put((byte)chunk.dimension);
        for (short[] i: chunk.block_id)
            for (short j: i)
                cache.putShort(j);
        for (byte[] i: chunk.floor_id)
            for (byte j: i)
                cache.put(j);
        for (int i = 0; i < 780; i++)
        {
            value.add(cache.get(i));
        }

        return value;
    }

    /*
     * Assuming the x & y values are the relative coordinates of the top left pixel, this should return all the chunks
     * that could possibly be shown in a 1000*600 grid. Once we come up with how we want to scale things we can confirm
     * that these are the right values.
     */
    public static ArrayList<Chunk> getVisibleChunks(Chunk[][] chunk, int x, int y)
    {
        ArrayList<Chunk> active = new ArrayList<>();
        int cameraChunkX = x/16;
        int cameraChunkY = y/16;

        for(int i=0;i<4;i++)       //    1000/16^2 is a bit under 4.
        {
            for(int j=0;j<3;j++)   //    700/16^2 is a bit under 3.
            {
                active.add(chunk[cameraChunkX+i][cameraChunkY+j]);
            }
        }

        return active;
    }
}
