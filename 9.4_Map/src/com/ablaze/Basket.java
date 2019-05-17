//DESCRIPTION: 
//A class that allows to shop stock items using a basket (TreeMap)

package com.ablaze;
import java.util.Map;
import java.util.TreeMap;

public class Basket
{
    //************ VARIABLES ************
    //name, map<StockItem, Integer>
    private final String name;
    private final Map<StockItem, Integer> basket;

    //*********** CONSTRUCTORS **********
    Basket(String name)
    {
        this.name = name;
        basket = new TreeMap<>();
    }

    //************* METHODS *************
    //addToBasket(StockItem item, int quantity)
    //return current quantity in the basket
    public boolean addToBasket(StockList stockList, String item, int quantity)
    {
        StockItem itemInStock = stockList.getStockItem(item);
        if(itemInStock!=null && quantity>0)
        {
            if(itemInStock.reserveStock(quantity))
            {
                int oldQuantity = basket.getOrDefault(itemInStock, 0);
                basket.put(itemInStock, quantity+oldQuantity);
                return true;
            }
        }
        return false;
    }

    //a method to remove item from basket
    public boolean removeFromBasket(StockList stockList, String item, int quantity)
    {
        StockItem itemInStock = stockList.getStockItem(item);
        if(itemInStock!=null && basket.containsKey(itemInStock) && quantity>0)
        {
            if(quantity <= basket.get(itemInStock))
            {
                itemInStock.unreserveStock(quantity);
                int remQuantity = basket.get(itemInStock) - quantity;
                if(remQuantity == 0)
                    basket.remove(itemInStock);
                else
                    basket.put(itemInStock, remQuantity);
                return true;
            }
        }
        return false;
    }

    //a method to checkout basket
    //return total price
    public double checkout(StockList list)
    {
        double totalPrice = 0;
        for(Map.Entry<StockItem, Integer> item : basket.entrySet())
        {
            item.getKey().unreserveStock(item.getValue());
            item.getKey().adjustStock(- item.getValue());
            totalPrice += item.getKey().getPrice() * item.getValue();
        }
        basket.clear();
        return totalPrice;
    }

    public int getCount(StockItem item)
    {
        return basket.get(item);
    }

    //override toString method
    @Override
    public String toString()
    {
        String result = "\n"+this.name+"\n";
        double totalPrice = 0;
        //alternative way to iterate over a map
        for(StockItem key : basket.keySet())
        {
            result += key.getName()+" - "+basket.get(key)+" units\n";
            totalPrice += key.getPrice() * basket.get(key);
        }
        result += "Total Price: "+totalPrice+"\n";
        return  result;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~

}
