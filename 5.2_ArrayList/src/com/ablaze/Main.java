//OBJECTIVE: To use ArrayList and its operations
/*  We have class Mobile_phone that stores contact,
    which is another class, info in an array list.
    We will manipulate the list using an object of
    mobile_phone class
 */

package com.ablaze;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);
    private static Mobile_phone my_phone = new Mobile_phone();

    public static void main(String[] args)
    {
        int choice = 1;
        display_menu();

        do
        {
            System.out.println();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice)
            {
                case 1:
                {
                    display_menu();
                }
                break;

                case 2:
                {
                    String name = get_name();
                    int number = get_number();
                    scanner.nextLine();
                    if (my_phone.add_contact(name, number))
                        System.out.println("Added!");
                    else
                        System.out.println("Failed! Duplicate contact found...");
                }
                break;

                case 3:
                {
                    String name = get_name();
                    if (my_phone.remove(name))
                        System.out.println("Removed!");
                    else
                        System.out.println("Failed! Contact does not exist...");
                }
                break;

                case 4:
                {
                    System.out.println("Existing contact...");
                    String name = get_name();
                    if (!my_phone.check_contact(name))
                    {
                        System.out.println("Contact does not exist...");
                        break;
                    }
                    System.out.println("New info...");
                    String new_name = get_name();
                    int new_number = get_number();
                    if (my_phone.modify(name, new_name, new_number))
                        System.out.println("Modified");
                    else
                        System.out.println("Failed! Contact does not exist...");
                }
                break;

                case 5:
                {
                    String name = get_name();
                    int number = my_phone.get_contact_number(name);
                    if (number != -1)
                        System.out.println(name + " - " + number);
                    else
                        System.out.println("Contact name does not match...");

                }
                break;

                case 6:
                {
                    System.out.println("~~~~~~~~~~~~~~~~~~~~");
                    my_phone.print_contact_details();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~");
                }
                break;

                default:
                    break;
            }
        } while (choice != 7);

        System.out.println("Exiting...");

    }

    //displays menu and return user choice as an int
    private static void display_menu()
    {
        System.out.println("********MENU********");
        System.out.println("1. Main menu");
        System.out.println("2. Add a contact");
        System.out.println("3. Remove a contact");
        System.out.println("4. Modify a contact");
        System.out.println("5. Search a contact");
        System.out.println("6. Print all contacts");
        System.out.println("7. Exit");
    }

    private static String get_name()
    {
        System.out.println("Enter name: ");
        return scanner.nextLine();
    }

    private static int get_number()
    {
        System.out.println("Enter number: ");
        return scanner.nextInt();
    }
}
