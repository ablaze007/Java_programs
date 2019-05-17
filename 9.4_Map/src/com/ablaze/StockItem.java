//DESCRIPTION: 
//A comparable StockItem class
//Variables - name, price, quantityInStock
//Methods - getters, setters, adjustStock, equals, hashCode, compareTo, toString

package com.ablaze;

public class StockItem implements Comparable<StockItem>
{
    //************ VARIABLES ************
    private final String name;
    private double price;
    private int quantityInStock;
    private int reserved = 0;

    //*********** CONSTRUCTORS **********
    StockItem(String name, double price, int quantityInStock)
    {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
    }
    StockItem(String name, double price)
    {
        this(name,price,0);
    }

    //************* METHODS *************
    @Override
    public int compareTo(StockItem obj)
    {
        if(this == obj)
            return 0;
        if(obj!=null)
        {
            return this.name.compareTo(obj.getName());
        }

        throw new NullPointerException();
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj)
            return true;
        if(obj == null || obj.getClass() != this.getClass())
            return false;
        return ((StockItem)obj).getName().equals(this.name);
    }

    @Override
    public int hashCode()
    {
        return this.name.hashCode()+7;
    }

    @Override
    public String toString()
    {
        return this.name+"\n\t$"+this.price+"\t- "+ this.getAvailableQuantity() +" units";
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String getName()
    {
        return name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        if(price >= 0)
            this.price = price;
    }

    public int getQuantityInStock()
    {
        return quantityInStock;
    }

    public boolean adjustStock(int quantityStock)
    {
        int result = this.getAvailableQuantity() + quantityStock;
        if(result >= 0)
        {
            this.quantityInStock += quantityStock;
            return true;
        }
        return false;
    }

    public int getAvailableQuantity()
    {
        return this.quantityInStock - this.reserved;
    }

    public boolean reserveStock(int quantity)
    {
        if(quantity <= this.getAvailableQuantity())
        {
            reserved = quantity;
            return true;
        }
        return false;
    }

    public void unreserveStock(int quantity)
    {
        if(quantity>0 && quantity <= reserved)
        {
            reserved -= quantity;
        }
    }
}
