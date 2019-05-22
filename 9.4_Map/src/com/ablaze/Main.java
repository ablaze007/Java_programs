//DESCRIPTION: To practice Map
//Design a Mart where you can shop items
//Items are stored as StockItem
//StockList is the list of StockItems available
//Basket is used to collect the items that you'd like to buy
//A simple menu is used to navigate

package com.ablaze;

import java.util.Scanner;

public class Main
{
    //create a stockList
    private static StockList list = new StockList("StockList");
    private static Basket basket = new Basket("Basket");
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        //create some stock items and add them to the stockList
        Init();

        System.out.println("\nWELCOME TO THE MART");
        System.out.println("\nPress 1 to start shopping");
        System.out.println("Press 2 to exit");
        System.out.println("\n>> ");

        //entering the mart
        if(scanner.nextInt() == 1)
        {
            //loop until user exits with 6
            while (true)
            {
                //display the menu
                int myChoice = Menu();
                switch (myChoice)
                {
                    case 1:
                    {
                        System.out.println(list.toString());
                        break;
                    }

                    case 2:
                    {
                        System.out.println("ADDING AN ITEM");
                        System.out.println("Enter the name of item:");
                        String name = scanner.next();
                        if(list.getStockItem(name) == null)
                        {
                            System.out.println("Item not found!");
                            break;
                        }
                        else
                            System.out.println(list.getStockItem(name).toString());
                        System.out.println("Enter the quantity:");
                        int q = scanner.nextInt();
                        printMessage(basket.addToBasket(list, name, q));
                    }
                    break;

                    case 3:
                    {
                        System.out.println("REMOVING AN ITEM");
                        System.out.println("Enter the name of item:");
                        String name = scanner.next();
                        if(list.getStockItem(name) == null)
                        {
                            System.out.println("Item not found!");
                            break;
                        }
                        else
                            System.out.println(name + " - " + basket.getCount(list.getStockItem(name)));
                        System.out.println("Enter the quantity:");
                        int q = scanner.nextInt();
                        printMessage(basket.removeFromBasket(list, name, q));
                    }
                    break;

                    case 4:
                    {
                        System.out.println(basket.toString());
                    }
                    break;

                    case 5:
                    {
                        System.out.println(basket.toString());
                        System.out.println("1: Pay");
                        System.out.println("2: Go back");
                        int choice = scanner.nextInt();
                        if (choice == 1)
                        {
                            System.out.println("Total - $" + basket.checkout(list));
                            myChoice = 6;
                        }
                    }

                    default:
                        break;
                }

                if (myChoice == 6)
                {
                    System.out.println("\nThank you for shopping...\n");
                    break;
                }
                else if(myChoice<5)
                    ShortMenu();
            }
        }
		//TODO close scanner
		//scanner.close();
    }

    //TO print success messages
    private static void printMessage(boolean success)
    {
        if(success)
            System.out.println("Successful");
        else
            System.out.println("Failed");
    }

    //TO display a short menu that lets user stay and go back
    private static void ShortMenu()
    {
        System.out.println("*** Press 1 to go back ***");
        if(scanner.nextInt() != 1)
            ShortMenu();
    }

    //To display a menu to the user
    private static int Menu()
    {
        System.out.println("\n**** MENU ****");
        System.out.println("1. Explore the mart");
        System.out.println("2. Add item to your basket");
        System.out.println("3. Remove item from your basket");
        System.out.println("4. View your basket");
        System.out.println("5. Checkout your basket");
        System.out.println("6. Exit");
        System.out.println("\n>> ");

        int choice = scanner.nextInt();

        if(choice>0 && choice <=6)
            return choice;
        System.out.println("Invalid input!");
        return Menu();
    }

    //TO initialize the stockList with some stockItems
    private static void Init()
    {
        list.addStock(new StockItem("Pen",0.75),10);
        list.addStock(new StockItem("Pencil", 0.1), 100);
        list.addStock(new StockItem("Calculator",15), 15);
        list.addStock(new StockItem("Eraser", 0.08), 150);
        list.addStock(new StockItem("Markers", 0.25), 250);
        list.addStock(new StockItem("Copy", 0.20), 50);
        list.addStock(new StockItem("Folders",0.5), 50);
    }
}
