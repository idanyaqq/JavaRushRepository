package com.javarush.test.level14.lesson08.bonus01;


import java.io.IOException;
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
        try
        {
            new ArrayStoreException();
        }
        catch(ArrayStoreException e)
        {
            exceptions.add(e);
        }
        try
        {
            float i = 1 / 0;

        } catch (Exception e)
        {
            exceptions.add(e);
        }
        try{
            new IOException();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            new ArrayIndexOutOfBoundsException();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try{
            new IndexOutOfBoundsException();
        }
        catch (IndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try{
            new StringIndexOutOfBoundsException();

        }
        catch(StringIndexOutOfBoundsException e)
        {
            exceptions.add(e);
        }
        try{
            new ClassCastException();
        }
        catch(ClassCastException e)
        {
            exceptions.add(e);
        }
        try{
            new RuntimeException();
        }
        catch(RuntimeException e)
        {
            exceptions.add(e);
        }
        try
        {
            new NullPointerException();
        }
        catch(NullPointerException e)
        {
            exceptions.add(e);
        }
        try
        {
            new IllegalThreadStateException();
        }
        catch(IllegalThreadStateException e)
        {
            exceptions.add(e);
        }

        //Add your code here

    }
}
