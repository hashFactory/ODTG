package Objects;

import java.util.HashMap;

/**
 * Created by tristan on 3/15/2017.
 */
public class Map
{
    public HashMap<String, Chunk> chunks = new HashMap<>();
    public long seed = 0;

    public Map(Long _seed)
    {
        seed = _seed;
    }
}
