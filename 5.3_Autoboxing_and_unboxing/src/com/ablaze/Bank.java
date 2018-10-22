//DESCRIPTION: Bank as a base class that main interacts with

package com.ablaze;

import java.util.ArrayList;

public class Bank
{
    //************ VARIABLES ************
    private ArrayList<Branch> branches;
    private String bank_name;

    //*********** CONSTRUCTORS *********
    public Bank(String bank_name)
    {
        branches = new ArrayList<Branch>();
        this.bank_name = bank_name;
    }

    //************* METHODS *************
    public boolean add_branch(String branch_name)
    {
        for(Branch branch : branches)
        {
            if(branch.get_branch_name().equals(branch_name))
                return false;
        }
        Branch new_branch = new Branch(branch_name);
        branches.add(new_branch);
        return true;
    }

    public boolean add_customer(String name, double t, String branch_name)
    {
        for(Branch branch : branches)
        {
            if(branch.get_branch_name().equals(branch_name))
            {
                if(branch.add_customer(name,t))
                    return true;
            }
        }
        return false;
    }

    public boolean add_transaction(String customer_name, double new_t, String branch_name)
    {
        for(Branch branch : branches)
        {
            if(branch.get_branch_name().equals(branch_name))
            {
                if(branch.add_transaction(customer_name,new_t))
                    return true;
            }
        }
        return false;
    }

    public void print_customers(String branch_name,boolean t)
    {
        for(Branch branch : branches)
        {
            if(branch.get_branch_name().equals(branch_name))
            {
                System.out.println("// BRANCH - "+branch_name);
                System.out.println(" --- CUSTOMERS ---");
                for(Customer customer : branch.get_customers())
                {
                    System.out.print(customer.get_name());
                    if(t)
                        System.out.println(" -> "+customer.get_transactions());
                    else
                        System.out.println("");
                }
                System.out.println("------------------");
                return;
            }
        }
        System.out.println("ERROR: No such branch found!");
    }

    public boolean has_branch(String branch_name)
    {
        for(Branch branch : branches)
        {
            if(branch.get_branch_name().equals(branch_name))
                return true;
        }
        return false;
    }

    public boolean has_customer(String customer_name)
    {
        for(Branch branch : branches)
        {
            for(Customer customer : branch.get_customers())
            {
                if(customer.get_name().equals(customer_name))
                    return true;
            }
        }
        return false;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_bank_name()
    {
        return bank_name;
    }
    public ArrayList<Branch> get_branches()
    {
        return branches;
    }
    public void set_bank_name(String bank_name)
    {
        this.bank_name = bank_name;
    }
}
