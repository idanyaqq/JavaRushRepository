package com.javarush.test.level06.lesson11.home02;

import java.util.ArrayList;

/* Статические коты
1. В классе Cat добавь public статическую переменную cats (ArrayList<Cat>).
2. Пусть при каждом создании кота (нового объекта Cat) в переменную cats добавляется этот новый кот. Создать 10 объектов Cat.
3. Метод printCats должен выводить всех котов на экран. Нужно использовать переменную cats.
*/

public class Cat
{
    public Cat()
    {
        cats.add(this);
    }

    public static ArrayList<Cat> cats = new ArrayList<Cat>();
    //напишите тут ваш код

    public static void main(String[] args)
    {
        Cat[] c= new Cat[10];
        for (int i=0;i<10;i++)
            c[i]= new Cat();
        printCats();

    }

    public static void printCats()
    {
        for (Cat catField : cats)

            System.out.println(catField); //Добавь свой код для пункта 3 тут

    }
}