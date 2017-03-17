package ProceduralGeneration;

import Objects.Chunk;

/**
 * Created by tristan on 3/16/2017.
 */
public class ChunkCreator
{
    public static Chunk createChunk(int x, int y, int dimension, long seed)
    {
        // TODO: This is just a sample chunk
        Chunk chunk = new Chunk(x, y, dimension, seed);

        for (int i = 0; i < 16; i++)
        {
            for (int j = 0; j < 16; j++)
            {
                chunk.floor_id[i][j] = 0;
            }
        }

        for (int i = 0; i < 256; i+=Math.random() * 8)
        {
            chunk.block_id[i / 16][i % 16] = 4;
        }

        return chunk;
    }

    /*
    public static Chunk randomChunk()
    {
        // TODO: Implement later
    }
    */
}
