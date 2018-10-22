//to print out the sum of 10 numbers

import java.util.Scanner;

public class User_input
{
    public static void main(String[] main)
    {
        int sum = 0;
        Scanner scanner = new Scanner(System.in);
        for(int i=0; i<10; i++)
        {
            System.out.printf("Enter number #%d: ",i+1);
            boolean int_value = scanner.hasNextInt();
            if(int_value)
            {
                int num = scanner.nextInt();
                sum += num;
            }
            else{
                System.out.println("Sorry, please enter an integer value.");
                i--;
            }
            scanner.nextLine();

        }

        System.out.printf("\nThe sum is %d\n",sum);
        scanner.close();
    }
}
