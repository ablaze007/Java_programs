import java.util.Scanner;

public class Area
{
    public static void main(String[] args)
    {
        while (true)
        {
            //taking input from user
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the radius of the circle (in cm): ");
            double radius = in.nextDouble();

            //computing area
            double area = area(radius);

            //showing output
            System.out.printf("\nThe area of the circle is %.2f cm2\n", area);

            //exit condition
            System.out.println("\nEnter 1 to calculate another area.\nEnter 2 to exit.\n");
            int ans = in.nextInt();
            if (ans != 1)
                break;
        }

    }
    private static double area(double r)
    {
        double pi = 3.14;
        return pi * r * r;
    }
}
