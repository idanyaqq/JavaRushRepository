package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int[] mas = new int[5];
        for (int i = 0; i < mas.length; i++)
        {
            mas[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = mas.length-1; i >=1; i--)
        {
            boolean sort = true;
            for (int j = 0; j < i; j++)
            {
                if (mas[j] > mas[j+1])
                {
                    int temp = mas[j];
                    mas[j] = mas[j+1];
                    mas[j+1] = temp;
                    sort = false;
                }
            }
            if (sort) {break;}
        }
        for (int i = 0; i < mas.length;i++)
        {
            if (i != mas.length -1)
            {
                System.out.println(mas[i]);
            }
            else System.out.println(mas[i]);
        }
    }


}
