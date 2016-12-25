package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Danya on 08/10/2016.
 */
public class USD extends Money
{
    public USD(double amount)
    {
        super(amount);
    }
    public double getAmount(){
        return super.getAmount();
    }
    public  String getCurrencyName(){return "USD";}
}
