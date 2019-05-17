//DESCRIPTION: 
//A class to maintain a list of stockItem using linkedHashMap

package com.ablaze;

import java.util.LinkedHashMap;
import java.util.Map;

public class StockList
{
    //************ VARIABLES ************
    private final Map<String, StockItem> stockList;
    private final String name;

    //*********** CONSTRUCTORS **********
    StockList(String name)
    {
        this.name = name;
        stockList = new LinkedHashMap<>();
    }

    //************* METHODS *************
    //addStock(StockItem item, int quantity)
    //check new stock is not null
    //update quantity if already exists in the list
    //else add the stock to the list
    //return item quantity in the stock
    public boolean addStock(StockItem item, int quantity)
    {
        if(item==null)
            return false;

        StockItem itemInStock = stockList.getOrDefault(item.getName(), item);
        //add to the list if not found
        if(itemInStock == item)
            stockList.put(item.getName(), item);

        return itemInStock.adjustStock(quantity);
    }


    //sellStock(String item, int quantity
    public boolean sellStock(String item, int quantity)
    {
        StockItem itemInStock = stockList.getOrDefault(item, null);
        if(itemInStock == null)
            return false;
        return itemInStock.adjustStock(-quantity);
    }

    //para - String item
    //return - StockItem
    public StockItem getStockItem(String item)
    {
        return stockList.getOrDefault(item, null);
    }

    //toString method
    @Override
    public String toString()
    {
        String result = "\n"+"*** StockList ***\n";
        for(Map.Entry<String, StockItem> item : stockList.entrySet())
        {
            result += item.getValue().toString()+"\n";
        }
        if(stockList.size() == 0)
            result += "No items in the stockList\n";

        return result;
    }

    //~~~~~~ GETTERS AND SETTERS ~~~~~~~~
    public String getName()
    {
        return name;
    }
}
