public class Duration
{
    private static final String INVALID_VALUE_MSG = "Invalid Value";

    public static void main(String[] args)
    {
        System.out.println(getDurationString(1600));
        System.out.println(getDurationString(61,0));
        System.out.println(getDurationString(61,90));
        System.out.println(getDurationString(2));
        System.out.println(getDurationString(2.0));
    }

    public static String getDurationString(int min, int sec)
    {
        if(min<0 || sec<0 || sec>59 )
            return INVALID_VALUE_MSG;
        int hour = min/60;
        min = min%60;
        return hour+"h "+min+"m "+sec+"s";
    }

    public static String getDurationString(int sec)
    {
        if(sec<0)
            return INVALID_VALUE_MSG;
        int min = sec/60;
        sec = sec%60;
        return getDurationString(min,sec);
    }

    public static String getDurationString(double sec)
    {
        return "...................";
    }
}
