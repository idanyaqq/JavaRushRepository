package com.javarush.test.level14.lesson08.home05;

/**
 * Created by Danya on 07/10/2016.
 */
public class Keyboard implements  CompItem
{
    @Override
    public String getName()
    {
        return this.getClass().getSimpleName();
    }
}
