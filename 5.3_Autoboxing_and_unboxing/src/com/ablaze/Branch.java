//DESCRIPTION: 

package com.ablaze;

import java.util.ArrayList;

public class Branch
{
    //************ VARIABLES ************
    private ArrayList<Customer> customers;
    private String branch_name;
    private String branch_location;

    //*********** CONSTRUCTORS **********
    public Branch(String name)
    {
        this(name,"Unknown");
    }
    public Branch(String name, String branch_location)
    {
        customers = new ArrayList<Customer>();
        this.branch_name = name;
        this.branch_location = branch_location;
    }

    //************* METHODS *************
    public boolean add_customer(String name, double transaction)
    {
        for (Customer customer : customers)
        {
            if (customer.get_name().equals(name))
                return false;
        }
        Customer new_customer = new Customer(name,transaction);
        customers.add(new_customer);
        return true;
    }

    public boolean add_transaction(String name, double transaction)
    {
        for(Customer customer : customers)
        {
            if(customer.get_name().equals(name))
            {
                customer.add_transaction(transaction);
                return true;
            }
        }
        return false;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public ArrayList<Customer> get_customers()
    {
        return customers;
    }
    public String get_branch_name()
    {
        return branch_name;
    }
    public String get_branch_location()
    {
        return branch_location;
    }

    public void set_branch_name(String branch_name)
    {
        this.branch_name = branch_name;
    }
    public void set_branch_location(String branch_location)
    {
        this.branch_location = branch_location;
    }
}
