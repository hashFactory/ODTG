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
        ByteBuffer cache = ByteBuffer.allocate(779);
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
        for (int i = 0; i < 779; i++)
        {
            value.add(cache.get(i));
        }

        return value;
    }
}
