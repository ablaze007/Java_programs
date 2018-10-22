//OBJECTIVE: to determine if the user entered number
// is a palindrome

import java.util.Scanner;

public class Number_palindrome
{
    public static void main(String[] args)
    {
        //setting up the scanner
        Scanner in = new Scanner(System.in);

        while(true)
        {
            //taking user input
            System.out.println("Enter a number (-1 to exit): ");
            int num = in.nextInt();

            //exit condition
            if(num==-1)
                break;

            //calling palindrome function
            if(Is_palindrome(num))
                System.out.println(num+" is palindrome.");
            else
                System.out.println(num+" is not a palindrome.");
        }
    }

    //a function to determine whether a given number is palindrome
    private static boolean Is_palindrome(int a)
    {
        if((a<10 && a>-10))
            return true;

        //changing negative numbers to positive for ease
        if(a<0)
            a = a*(-1);

        int initial_num = a; //backing up initial number
        int new_num = 0;     //new_num will be in reversed order
        while(a>0)
        {
            int digit = a%10;
            new_num = new_num*10 + digit;
            a = a/10;
        }

        if(new_num == initial_num)
            return true;

        return false;
    }
}
