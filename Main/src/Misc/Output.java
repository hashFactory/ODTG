package Misc;

/**
 * Created by tristan on 3/14/2017.
 */
public class Output
{
    public static void errorln(String input)
    {
        System.out.println("\u001B[31m" + input + "\u001B[0m");
    }

    public static void warnln(String input)
    {
        System.out.println("\u001B[33m" + input + "\u001B[0m");
    }

    public static void debugln(String input)
    {
        System.out.println("\u001B[34m" + input + "\u001B[0m");
    }

    public static void infoln(String input)
    {
        System.out.println(input);
    }

    public static void error(String input)
    {
        System.out.print("\u001B[31m" + input + "\u001B[0m");
    }

    public static void warn(String input)
    {
        System.out.print("\u001B[33m" + input + "\u001B[0m");
    }

    public static void debug(String input)
    {
        System.out.print("\u001B[34m" + input + "\u001B[0m");
    }

    public static void info(String input)
    {
        System.out.print(input);
    }
}
