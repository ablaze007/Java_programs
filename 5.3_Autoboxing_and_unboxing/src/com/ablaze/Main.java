// Objective - To use autoboxing in context of using
//             using doubles in ArrayList
// In addition, we will also practice Composition

package com.ablaze;

import java.util.Scanner;

public class Main
{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
	    Bank bank = new Bank("Himalayan");
	    display_menu();

	    while(true)
        {
            System.out.println("Choose a command:");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice)
            {
                case 1:
                {
                    display_menu();
                }break;

                case 2:
                {
                    System.out.println("FOR NEW BRANCH...");
                    System.out.println("Enter branch name: ");
                    String name = scanner.nextLine();
                    if(bank.add_branch(name))
                        System.out.println("Added...");
                    else
                        System.out.println("Failed...");
                }break;

                case 3:
                {
                    System.out.println("FOR NEW CUSTOMER...");
                    System.out.println("Branch name: ");
                    String branch_name = scanner.nextLine();
                    if(!bank.has_branch(branch_name))
                    {
                        System.out.println("Branch "+branch_name+" does not exist!");
                        break;
                    }
                    System.out.println("Customer name: ");
                    String customer_name = scanner.nextLine();
                    System.out.println("Initial transaction: ");
                    double init_t = scanner.nextDouble();

                    if(bank.add_customer(customer_name,init_t,branch_name))
                        System.out.println("Added...");
                    else
                        System.out.println("Failed...");
                }break;

                case 4:
                {
                    System.out.println("FOR NEW CUSTOMER...");
                    System.out.println("Branch name: ");
                    String branch_name = scanner.nextLine();
                    if(!bank.has_branch(branch_name))
                    {
                        System.out.println("Branch "+branch_name+" does not exist!");
                        break;
                    }
                    System.out.println("Customer name: ");
                    String customer_name = scanner.nextLine();
                    if(!bank.has_customer(customer_name))
                    {
                        System.out.println("Customer "+customer_name+" does not exist!");
                        break;
                    }
                    System.out.println("New transaction: ");
                    double new_t = scanner.nextDouble();

                    if(bank.add_transaction(customer_name, new_t, branch_name))
                        System.out.println("Added...");
                    else
                        System.out.println("Failed....");
                }break;

                case 5:
                {
                    System.out.println("Enter a branch name: ");
                    String branch_name = scanner.nextLine();
                    if(!bank.has_branch(branch_name))
                    {
                        System.out.println("Branch "+branch_name+" does not exist!");
                        break;
                    }
                    System.out.println("Do you want to print transactions too [Y/N]:");
                    char temp = scanner.next().charAt(0);
                    if(temp=='Y')
                        bank.print_customers(branch_name,true);
                    else
                        bank.print_customers(branch_name, false);
                }break;

                case 6:
                {
                    System.out.println(" --- BRANCHES ---");
                    for(Branch branch : bank.get_branches())
                    {
                        System.out.println(branch.get_branch_name());
                    }
                    System.out.println("------------------");
                }
                default: break;
            }

            if(choice==7)
                break;
        }
    }

    private static void display_menu()
    {
        System.out.println("---- MAIN MENU ----");
        System.out.println("1. Display menu");
        System.out.println("2. Add a new branch");
        System.out.println("3. Add a new customer");
        System.out.println("4. Add a transaction");
        System.out.println("5. Display all customers in a branch");
        System.out.println("6. Display all branches");
        System.out.println("7. Exit");
    }
}
