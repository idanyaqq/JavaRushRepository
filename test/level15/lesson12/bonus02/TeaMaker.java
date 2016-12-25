package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Danya on 18/10/2016.
 */
public class TeaMaker extends DrinkMaker
{
    @Override
   protected void getRightCup()
    {
        System.out.println("Берем чашку для чая");
    }

    @Override
   protected void putIngredient()
    {
        System.out.println("Насыпаем чай");
    }

    @Override
   protected void pour()
    {
        System.out.println("Заливаем водой");
    }

    @Override
   protected void makeDrink()
    {
        super.makeDrink();
    }
}
