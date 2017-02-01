package com.javarush.test.level14.lesson08.bonus01;

import java.util.ArrayList;
import java.util.List;

/* Нашествие эксепшенов
Заполни массив exceptions 10 различными эксепшенами.
Первое исключение уже реализовано в методе initExceptions.
*/

public class Solution
{
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args)
    {
        initExceptions();

        for (Exception exception : exceptions)
        {
            System.out.println(exception);
        }
    }

    private static void initExceptions()
    {   //it's first exception
        try{float i = 1 / 0;}
        catch(Exception e){exceptions.add(e);}
        int[] a = new int[1];
        try{a[1] = 2;}
        catch (ArrayIndexOutOfBoundsException e){exceptions.add(e);}try{int b = a[2];}
        catch(IndexOutOfBoundsException e){exceptions.add(e);}
        try{String str = "1a";int val = Integer.valueOf(str);}
        catch(NumberFormatException e){exceptions.add(e);}
        //Add your code here

    }
}
