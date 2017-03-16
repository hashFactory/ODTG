package Objects;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Created by tristan on 3/15/2017.
 */
public class Map
{
    public ArrayList<Chunk> chunks = new ArrayList<>();
    public long seed = 0;

    public Map(Long _seed)
    {
        seed = _seed;
    }
}
