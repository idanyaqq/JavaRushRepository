package com.javarush.test.level27.lesson15.big01.ad;

/**
 * Created by Danya on 19/01/2017.
 */
public class Advertisement
{
    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration)
    {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        amountPerOneDisplaying = initialAmount/hits;
    }

    public int getDuration()
    {
        return duration;
    }

    public String getName()
    {
        return name;
    }

    public long getAmountPerOneDisplaying()
    {
        return amountPerOneDisplaying;
    }
}
