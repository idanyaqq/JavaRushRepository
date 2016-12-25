package com.javarush.test.level05.lesson12.bonus02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Нужно добавить в программу новую функциональность
Задача: Программа вводит два числа с клавиатуры и выводит минимальное из них на экран.
Новая задача: Программа вводит пять чисел с клавиатуры и выводит минимальное из них на экран.
*/

public class Solution
{

    public static void main(String[] args) throws Exception
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int d = Integer.parseInt(reader.readLine());
        int e = Integer.parseInt(reader.readLine());
        int x;
        int minimum1 = min1(a, b);
        int minimum2 = min2(c, d);
        if (minimum1 < minimum2)
        x = minimum1;
        else
        x = minimum2;
        if (x < e )
            x = x;
        else
        x = e;



        System.out.println("Minimum = " + x);
    }


    public static int min1(int a, int b)
    {
        return a < b ? a : b;
    }
    public static int min2(int c, int d)
    {
        return c < d ? c : d;
    }


}
