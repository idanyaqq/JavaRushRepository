package com.javarush.test.level15.lesson12.bonus01;

/**
 * Created by Danya on 18/10/2016.
 */
public class Plane implements Flyable
{
    private int pasCount;
    public Plane(int pasCount)
    {
        this.pasCount = pasCount;
    }

    @Override
    public void fly()
    {

    }
}
