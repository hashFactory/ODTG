package Main;

import java.io.File;
import java.nio.ByteBuffer;

/**
 * Created by tristan on 3/14/2017.
 */
public class MapSaver
{
    public MapSaver(String fn)
    {
        String filename = fn + ".odt";
        File file = new File(filename);

        ByteBuffer save_file = ByteBuffer.allocate(100);
    }
}
