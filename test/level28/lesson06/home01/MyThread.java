package com.javarush.test.level28.lesson06.home01;

/**
 * Created by Danya on 20/01/2017.
 */
public class MyThread extends Thread
{
    public MyThread()
    {
    }

    public MyThread(Runnable target)
    {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
    }

    public MyThread(String name)
    {
        super(name);
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
    }
}
