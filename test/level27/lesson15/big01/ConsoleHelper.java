package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Danya on 16/01/2017.
 */
public class ConsoleHelper
{
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    public static String readString() throws IOException
    {
        return reader.readLine();
    }
    public static List<Dish> getAllDishesForOrder() throws IOException
    {
        ArrayList<Dish> result = new ArrayList<>();
        writeMessage("Select dishes: "+ Dish.allDishesToString());
        do
        {
            String select = readString();
            if(select.equalsIgnoreCase("exit"))
            {
                break;
            }
            try
            {
                result.add(Dish.valueOf(select));
            }
            catch(IllegalArgumentException e)
            {
                ConsoleHelper.writeMessage(String.format("%s is not detected",select));
            }
        }
        while(true);

        return  result;
    }

}
