//OBJECTIVE: to practice inheritance, method overloading
//           to create classes: Vehicle, Race_car, Ferrari
//           Ferrari is inherited from Race_car which is inherited from Vehicle

package com.ablaze;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        //declaring new instance of Ferrari
	    Ferrari f1 = new Ferrari("f1r1");
	    //setting up scanner
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            //to display a menu
            System.out.println("1. Move");
            System.out.println("2. Shift gear");
            System.out.println("3. Refuel");
            System.out.println("4. Get stats");
            System.out.println("5. Get car info");
            System.out.println("6. Exit");

            //handler for the case when user enters non integer
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
                    System.out.println("Enter a distance: ");
                    if(!scanner.hasNextDouble())
                    {
                        System.out.println("Invalid distance!");
                        scanner.nextLine();
                        continue;
                    }
                    double distance = scanner.nextDouble();
                    if(f1.move(distance))
                        System.out.println("Successful");
                    else
                        System.out.println("Failed. Please REFUEL!!");
                }break;

                case 2:
                {
                    System.out.println("Enter gear number: ");
                    if(!scanner.hasNextInt())
                    {
                        System.out.println("Invalid gear number!");
                        continue;
                    }
                    int gear = scanner.nextInt();
                    if(f1.set_gear(gear))
                        System.out.println("Successful!");
                    else
                    {
                        System.out.println("Gear number not in range!");
                        System.out.println("Try gear between 1 and " + f1.get_top_gear());
                    }
                }break;

                case 3:
                {
                    f1.refuel();
                    System.out.println("Successful!");
                }break;

                case 4:
                {
                    System.out.println("Distance: "+f1.get_distance_covered());
                    System.out.println("Fuel level: "+f1.get_fuel_level());
                    System.out.println("Current gear: "+f1.get_gear());
                    System.out.println("Top gear: "+f1.get_top_gear());
                }break;

                case 5:
                {
                    System.out.println("Vehicle: "+f1.get_vehicle_type());
                    System.out.println("Company: "+f1.get_model());
                    System.out.println("License: "+f1.get_license());
                }break;

                default: break;
            }

            if(choice == 6)
                break;
        }
        System.out.println("Exiting...");
    }
}
