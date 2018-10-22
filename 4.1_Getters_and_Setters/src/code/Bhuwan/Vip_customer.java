
//OBJECTIVE: To demonstrate use of multiple constructors
//           To generate code using Intellij's feature
package code.Bhuwan;

public class Vip_customer
{
    //VARIABLES
    private String name;
    private int credit_limit;
    private String email;

    //CONSTRUCTORS
    public Vip_customer(String name, int credit_limit, String email)
    {
        this.name = name;
        this.credit_limit = credit_limit;
        this.email = email;
    }
    public Vip_customer()
    {
        this("xyz",1000,"xyz@gmail.com");
    }
    public Vip_customer(String name, int credit_limit)
    {
        this("xyz",1000,"\0");
    }

    //GETTERS methods

    public String getName()
    {
        return name;
    }
    public int getCredit_limit()
    {
        return credit_limit;
    }
    public String getEmail()
    {
        return email;
    }
}
