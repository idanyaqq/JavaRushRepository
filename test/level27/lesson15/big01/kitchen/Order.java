package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import java.io.IOException;
import java.util.List;

/**
 * Created by Danya on 15/01/2017.
 */
public class Order
{
    private Tablet tablet;
    private List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public List<Dish> getDishes()
    {
        return dishes;
    }

    @Override
    public String toString()
    {
       if(dishes.isEmpty() || dishes.isEmpty())
       {return "";}
        else
       {
           return "Your order: " + dishes.toString() + " of " + tablet;
       }

    }
    public int getTotalCookingTime()
    {
        int result = 0;
        for(Dish dish :dishes)
        {
            result+= dish.getDuration();
        }
        return  result;
    }
    public boolean isEmpty()
    {
        return dishes == null || dishes.isEmpty();
    }
}
