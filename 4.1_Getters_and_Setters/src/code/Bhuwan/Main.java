
//OBJECTIVE: To get familiar with basic class structure in Java

package code.Bhuwan;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Bank_account b1 = new Bank_account(1,100, "Bhuwan", 123);
        b1.set_account_number(101);
        System.out.println("The account number is "+b1.get_account_number());

        Vip_customer v1 = new Vip_customer("sushmi",2000);

        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while(exit)
        {
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.VIP");
            System.out.println("4.Exit");
            if(!scanner.hasNextInt())
            {
                System.out.println("Enter either 1 2 or 3");
                continue;
            }
            int choice = scanner.nextInt();
            switch(choice)
            {
                case 1:
                {
                    System.out.println("Enter amount: ");
                    int amt = scanner.nextInt();
                    if(b1.deposit(amt))
                        System.out.println("Successful!");
                    else
                        System.out.println("Failed! Amount invalid");
                }break;

                case 2:
                {
                    System.out.println("Enter amount: ");
                    int amt = scanner.nextInt();
                    if(b1.withdraw(amt))
                        System.out.println("Successful!");
                    else
                        System.out.println("Failed! Insufficient balance");
                }break;

                case 3:
                {
                    System.out.println(v1.getName());
                    System.out.println(v1.getCredit_limit());
                    System.out.println(v1.getEmail());
                }break;

                case 4:
                    exit = false;
                    break;

                default:
                    break;

            }

        }
        System.out.println("Thank you...");
    }
}
