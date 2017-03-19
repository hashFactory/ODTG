package Objects;

import java.awt.*;

/**
 * Created by tristan on 3/18/2017.
 */
public class Floor
{
    public static double flammability;
    public static double speed;
    public static double durability;
    public static double build_time;

    public static Image texture;

    public Floor(double _fla, double _spe, double _dur, double _bui, Image _tex)
    {
        flammability = _fla;
        speed = _spe;
        durability = _dur;
        build_time = _bui;
        texture = _tex;
    }
}
