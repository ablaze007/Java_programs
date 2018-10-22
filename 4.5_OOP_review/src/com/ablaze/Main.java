//OBJECTIVE: To make an application for a fictitious company Bill's burger
//          that will help them to sell burgers

package com.ablaze;

import java.util.Scanner; //importing scanner class

public class Main
{
    //Creating scanner as static object so that all the static
    //methods within main class can access it
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        //To display main menu to the user
        while(true)
        {
            System.out.println("******* MENU ********");
            System.out.println("1. Basic Hamburger ");
            System.out.println("2. Healthy burger ");
            System.out.println("3. Deluxe Hamburger ");
            System.out.println("4. Exit");
            if(!scanner.hasNextInt())
            {
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                    make_hamburger();
                    break;
                case 2:
                    make_healthy_burger();
                    break;
                case 3:
                    make_deluxe_burger();
                    break;
                default:
                    break;
            }
            if(choice==4)
                break;
        }
        System.out.println("Exiting...");
    }

    //a method for user to get hamburger
    private static void make_hamburger()
    {
        Hamburger h1 = new Hamburger();
        while(true)
        {
            //to display hamburger sub menu
            System.out.println("****Sub Menu****");
            System.out.println("1.Choose bread type");
            System.out.println("2.Choose meat type");
            System.out.println("3.Choose additional");
            System.out.println("4.Checkout");
            System.out.println("5.Go to Main Menu");
            if(!scanner.hasNextInt())
            {
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                {
                    int bread_type = get_bread_type();
                    h1.set_bread_roll_type(bread_type);
                }
                break;

                case 2:
                {
                    int meat_type = get_meat_type();
                    h1.set_meat_type(meat_type);
                }
                break;

                case 3:
                {
                    int additional_count = get_additional(4);
                    h1.add_additional(additional_count);
                }break;

                case 4:
                {
                    burger_checkout(h1);
                }

                case 5:
                    return;

                default:
                    break;
            }
        }
    }

    private static void make_healthy_burger()
    {
        Healthy_burger hb = new Healthy_burger();

        while(true)
        {
            //to display hamburger sub menu
            System.out.println("****Sub Menu****");
            System.out.println("1.Choose meat type");
            System.out.println("2.Choose additional");
            System.out.println("3.Checkout");
            System.out.println("4.Go to Main Menu");
            if(!scanner.hasNextInt())
            {
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                {
                    int meat_type = get_meat_type();
                    hb.set_meat_type(meat_type);
                }
                break;

                case 2:
                {
                    int additional_count = get_additional(6);
                    hb.add_additional(additional_count);
                }break;

                case 3:
                {
                    burger_checkout(hb);
                }

                case 4:
                    return;

                default:
                    break;
            }
        }
    }

    private static void make_deluxe_burger()
    {
        Deluxe_hamburger hb = new Deluxe_hamburger();

        while(true)
        {
            //to display hamburger sub menu
            System.out.println("****Sub Menu****");
            System.out.println("1.Choose bread type");
            System.out.println("2.Choose meat type");
            System.out.println("3.Checkout");
            System.out.println("4.Go to Main Menu");
            if(!scanner.hasNextInt())
            {
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                {
                    int bread_type = get_bread_type();
                    hb.set_bread_roll_type(bread_type);
                }break;

                case 2:
                {
                    int meat_type = get_meat_type();
                    hb.set_meat_type(meat_type);
                }break;

                case 3:
                {
                    burger_checkout(hb);
                }

                case 4:
                    return;

                default:
                    break;
            }
        }
    }

    //***** HELPER METHODS *************
    private static void burger_checkout(Hamburger h1)
    {
        System.out.println("******************************");
        System.out.println("~~~~~~~~ Your Burger ~~~~~~~~~");
        System.out.println("Bread type - "+h1.get_bread_roll_type());
        System.out.println("Meat type - "+h1.get_meat_type());
        if(h1.getClass().getSimpleName().equals("Deluxe_hamburger"))
            System.out.println("Added CHIPS and Drink as additional");
        else
            System.out.println("Additional count - "+h1.get_additional_count());
        System.out.println("******************************");
        System.out.println("Total price: " + h1.get_price());
        System.out.println("1. Pay");
        System.out.println("2. Cancel");
        int temp = scanner.nextInt();
        scanner.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~");
        if(temp == 1)
            System.out.println("Enjoy your burger...");
        else
            System.out.println("Order cancelled...");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    private static int get_bread_type()
    {
        System.out.println("1. Regular");
        System.out.println("2. Italian herbs");
        System.out.println("3. Brown rye");
        int bread_type = scanner.nextInt();
        scanner.nextLine();
        if (bread_type < 1 || bread_type > 3)
            return get_bread_type();
        return bread_type;
    }

    private static int get_meat_type()
    {
        System.out.println("1. Grilled Chicken");
        System.out.println("2. Roasted Beef");
        System.out.println("3. Ham");
        int meat_type = scanner.nextInt();
        scanner.nextLine();
        if (meat_type < 1 || meat_type > 3)
            return get_meat_type();
        return meat_type;
    }

    private static int get_additional(int limit)
    {
        System.out.println("1. Lettuce");
        System.out.println("2. Onions");
        System.out.println("3. Cheese");
        System.out.println("4. Siracha");
        System.out.println("5. Go back");
        int count = 0;
        int choice;
        do
        {
            choice = scanner.nextInt();
            scanner.nextLine();
            if(choice<1 || choice >limit+1)
            {
                System.out.println("Invalid choice! Try again...");
                continue;
            }
            if(choice==5)
                break;
            System.out.println("Added!");
            count++;
        }while(count<limit+1);
        return count;
    }
}
