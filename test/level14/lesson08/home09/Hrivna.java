package com.javarush.test.level14.lesson08.home09;

/**
 * Created by Danya on 08/10/2016.
 */
public  class Hrivna extends Money
{
    public Hrivna(double amount)
    {
       super(amount);
    }
    public double getAmount(){
        return super.getAmount();
    }
    public  String getCurrencyName(){return "HRN";}

}
