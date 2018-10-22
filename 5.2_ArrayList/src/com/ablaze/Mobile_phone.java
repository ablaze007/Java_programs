//DESCRIPTION: A class Mobile_phone that stores and manipulates
//            an ArrayList of contact class objects

package com.ablaze;
import java.util.ArrayList;

public class Mobile_phone
{
    //************ VARIABLES ************
    private ArrayList<Contact> contact_list = new ArrayList<Contact>();

    //*********** CONSTRUCTORS **********

    //************* METHODS *************
    public boolean add_contact(String name, int number)
    {
        for(int i=0; i<contact_list.size(); i++)
        {
            if(contact_list.get(i).get_name().equals(name))
                return false;
        }
        Contact contact = new Contact(name,number);
        contact_list.add(contact);
        return true;
    }

    public boolean remove(String name)
    {
        boolean check = false;
        int index = 0;
        for(int i=0; i<contact_list.size(); i++)
        {
            if(contact_list.get(i).get_name().equals(name))
            {
                index = i;
                check = true;
            }
        }
        if(!check)
            return false;

        contact_list.remove(index);
        return true;
    }

    public boolean modify(String prev_name, String new_name, int new_number)
    {
        for(int i=0; i<contact_list.size(); i++)
        {
            if (contact_list.get(i).get_name().equals(prev_name))
            {
                Contact new_contact = new Contact(new_name, new_number);
                contact_list.set(i, new_contact);
                return true;
            }
        }
        return false;
    }

    public boolean check_contact(String name)
    {
        for(int i=0; i<contact_list.size(); i++)
        {
            if(contact_list.get(i).get_name().equals(name))
                return true;
        }
        return false;
    }

    public int get_contact_number(String name)
    {
        for(int i=0; i<contact_list.size(); i++)
        {
            if(contact_list.get(i).get_name().equals(name))
                return contact_list.get(i).get_number();
        }
        return -1;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public ArrayList<Contact> get_contact_list()
    {
        return this.contact_list;
    }
    public void print_contact_details()
    {
        for(int i=0; i<contact_list.size(); i++)
        {
            Contact contact = contact_list.get(i);
            System.out.println(i+1 +" "+contact.get_name()+" - "+contact.get_number());
        }
    }

}
