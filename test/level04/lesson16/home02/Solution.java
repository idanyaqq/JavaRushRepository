package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        BufferedReader a = new BufferedReader(new InputStreamReader(System.in));

        int b = Integer.parseInt(a.readLine());
        int c = Integer.parseInt(a.readLine());
        int x = Integer.parseInt(a.readLine());
       if (b > c && c > x)
       {System.out.print(c);}
        else
           if (b > x && x > c)
           {System.out.print(x);}
        if (c > b && b > x)
        {System.out.print(b);}

    }
}
