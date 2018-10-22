
//OBJECTIVE: To create a class and its constructor, getters, setters, methods, and variables

package code.Bhuwan;

public class Bank_account
{
    //Variables
    private int account_number;
    private double balance;
    private String customer_name;
    private int phone;

    //constructor
    public Bank_account(int num, double balance, String name, int phone)
    {
        this.account_number = num;
        this.balance = balance;
        this.customer_name = name;
        this.phone = phone;
    }

    //empty constructor
    public Bank_account()
    {
        this(1,2,"xyz",123);
    }

    //getters and setters
    public void set_account_number(int num)
    {
        this.account_number = num;
    }
    public int get_account_number()
    {
        return this.account_number;
    }

    //methods
    public boolean deposit(int a)
    {
        if(a>0)
        {
            this.balance+=a;
            return true;
        }
        return false;
    }

    public boolean withdraw(int a)
    {
        if(this.balance < a)
            return false;
        this.balance -= a;
        return true;
    }
}
