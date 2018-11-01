//OBJECTIVE: To demonstrate different types of inner classes

package com.ablaze;

public class Main
{
    //An anonymous class
    public interface IContractor
    {
        String get_name();
    }

    //*************** MAIN **************************
    public static void main(String[] args)
    {
        //Defining an outer class object
	    House my_house = new House("ablaze","blue",3);

	    //-------------------------------------------------------------------
	    //Defining an INNER CLASS object
        House.Room room = my_house.new Room("Bedroom");
        //Accessing fields in inner class
        System.out.println("Room 1 - "+room.get_type());

        //Accessing private Inner Class
        my_house.add_door();
        System.out.println("Doors - "+my_house.get_doors_count());
        //-------------------------------------------------------------------

        //Defining an Method local class
        //this class scope is limited within main method
        IContractor my_contractor = new IContractor()
        {
            private String name = "Ablaze";
            @Override
            public String get_name()
            {
                return this.name;
            }
        };
        //Accessing method local class object
        System.out.println("Contractor name - "+my_contractor.get_name());
        //-------------------------------------------------------------------

        //ANONYMOUS CLASS
        //this class is instantiated for only for this print method class
        //thus anonymous (without a name)
        print(new IContractor()
        {
            private String name = "Nepal";
            @Override
            public String get_name()
            {
                return this.name;
            }
        });

    }

    private static void print(IContractor x)
    {
        System.out.println("Contractor - "+x.get_name());
    }
}
