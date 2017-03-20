package Objects;

import Misc.Output;

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
        ByteBuffer cache = ByteBuffer.allocate(778);
        cache.position(0);

        cache.put((byte)(chunk.x >> 24));
        cache.put((byte)(chunk.x >> 16));
        cache.put((byte)(chunk.x >> 8));
        cache.put((byte)(chunk.x));

        cache.put((byte)(chunk.y >> 24));
        cache.put((byte)(chunk.y >> 16));
        cache.put((byte)(chunk.y >> 8));
        cache.put((byte)(chunk.y));

        Output.infoln(Integer.toString(chunk.x));
        cache.put((byte)chunk.dimension);
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                cache.putShort(chunk.block_id[i][j]);
        for (int i = 0; i < 16; i++)
            for (int j = 0; j < 16; j++)
                cache.put(chunk.floor_id[i][j]);
        for (int i = 0; i < 778; i++)
        {
            Output.error(cache.get(i) + " ");
            value.add(cache.get(i));
        }


        Output.warnln(Integer.toString(cache.position()));
        return value;
    }
}
