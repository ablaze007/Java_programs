import java.util.Scanner;

public class Leap_year
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        while(true)
        {
            int year = in.nextInt();
            if(year==0)
                break;
            if(year<1 || year >9999)
                continue;
            if(isLeapyear(year))
                System.out.println(year+" is a leap year");
            else
                System.out.println(year+" is not a leap year");
        }

    }

    public static boolean isLeapyear(double y)
    {
        boolean result = false;
        if(y%400 == 0)
            result = true;
        else if(y%4 == 0 && y%100 != 0)
            result = true;
        return result;
    }
}
