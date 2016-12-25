package com.javarush.test.level06.lesson11.home06;

/* KissMyShinyMetalAss
Создай класс с именем KissMyShinyMetalAss. Создай объект этого класса, выведи его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        KissMyShinyMetalAss popa = new KissMyShinyMetalAss("Lox");
        System.out.println(popa);
    }

    public static class KissMyShinyMetalAss
    {
        String name;
        KissMyShinyMetalAss(String name)
        {
            this.name = name;
        }

    }

}
