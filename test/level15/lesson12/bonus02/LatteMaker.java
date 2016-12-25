package com.javarush.test.level15.lesson12.bonus02;

/**
 * Created by Danya on 18/10/2016.
 */
public class LatteMaker extends DrinkMaker
{
    @Override
    protected void getRightCup()
    {
        System.out.println("Берем чашку для латте");
    }

    @Override
    protected void putIngredient()
    {
        System.out.println("Делаем кофе");
    }

    @Override
    protected void pour()
    {
        System.out.println("Заливаем молоком с пенкой");
    }

    @Override
    protected void makeDrink()
    {
        super.makeDrink();
    }
}
