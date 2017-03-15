package Characters;

import java.nio.ByteBuffer;
import java.util.ArrayList;

/**
 * Created by tristan on 3/14/2017.
 */
public class ProtagonistMethods
{
    public static ArrayList<Byte> toArrayList(Protagonist p)
    {
        ByteBuffer cache = ByteBuffer.allocate(512);
        cache.put((byte)0x41);
        String modified_user = String.format("%1$" + 24 + "s", p.username);
        char[] user = modified_user.toCharArray();
        for (char character: user)
            cache.putChar(character);
        cache.put((byte)p.dimension);
        cache.putInt(p.x_chunk);
        cache.putInt(p.y_chunk);
        cache.putFloat(p.x);
        cache.putFloat(p.y);
        for (short i: p.special_items)
            cache.putShort(i);
        cache.put((byte)9);
        cache.put((byte)10);
        for (short[] i: p.inventory)
            for (short j: i)
                cache.putShort(j);

        ArrayList<Byte> value = new ArrayList<>(512);
        for (int i = 0; i < 512; i++)
            value.add(cache.get(i));

        return value;
    }
}
