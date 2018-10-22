//DESCRIPTION: A customer class with name and array list of transactions

package com.ablaze;

import java.util.ArrayList;

public class Customer
{
    //************ VARIABLES ************
    private String name;
    private ArrayList<Double> transactions;

    //*********** CONSTRUCTORS **********
    public Customer(String name)
    {
        this.name = name;
        transactions = new ArrayList<Double>();
    }
    public Customer(String name, double initial_t)
    {
        this(name);
        transactions.add(initial_t);    //automatic autoboxing by JAVA
    }
    //************* METHODS *************

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String get_name()
    {
        return this.name;
    }
    public ArrayList<Double> get_transactions()
    {
        return transactions;
    }

    public void set_name(String name)
    {
        this.name = name;
    }
    public void add_transaction(double new_t)
    {
        this.transactions.add(new_t);
    }
}
