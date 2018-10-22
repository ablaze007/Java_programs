//DESCRIPTION: To use arrays and sort its element in
//             descending order using Insertion sort

import java.util.Scanner;
import java.util.Arrays;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        int[] numbers = get_array();
        sort_array(numbers);
        print_array(numbers);
    }

    //a method to sort an int array in descending order using Insertion sort
    private static void sort_array(int[] my_arr)
    {
        insertion_sort(my_arr,1);
    }

    // a recursive implementation of insertion sort
    private static void insertion_sort(int[] my_arr, int start)
    {
        if(start >= my_arr.length)
            return;
        int temp = my_arr[start];
        int i = start - 1;
        while(i>=0 && my_arr[i] < temp)
        {
            my_arr[i+1] = my_arr[i];
            i--;
        }
        my_arr[i+1]=temp;
        insertion_sort(my_arr,start+1);
    }

    //a method to print an integer array
//    private static void print_array(int[] my_arr)
//    {
//        for(int i=0; i<my_arr.length; i++)
//            System.out.println("int[" +i+ "] = " +my_arr[i]);
//    }
    //ALTERNATIVE print_array method
    private static void print_array(int[] my_arr)
    {
        System.out.println("Sorted array = "+Arrays.toString(my_arr));
    }

    //a method to get an integer array from user
    private static int[] get_array()
    {
        System.out.println("Enter the number of integers: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        int[] my_arr = new int[size];

        System.out.println("Enter "+size+" numbers:\r");
        for(int i=0; i<size; i++)
        {
            my_arr[i] = scanner.nextInt();
        }

        return my_arr;
    }
}
