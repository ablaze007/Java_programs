//DESCRIPTION: A class that offers methods to find
//sum, factorial, or fibonacci of a number

package com.example.ablaze;

public class Series
{
    //************ VARIABLES ************

    //*********** CONSTRUCTORS **********

    //************* METHODS *************
    public static int sum(int n)
    {
        if(n<=0)
            return 0;
        int sum = 0;
        for(int i=1; i<=n; i++)
            sum += i;
        return sum;
    }

    public static int factorial(int n)
    {
        if(n<=1)
            return 1;
        int factorial=1;
        for(int i=1; i<=n; i++)
            factorial *= i;
        return factorial;
    }

    public static int fibonacci(int n)
    {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        return fibonacci(n-1)+fibonacci((n-2));
    }
    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~

}
