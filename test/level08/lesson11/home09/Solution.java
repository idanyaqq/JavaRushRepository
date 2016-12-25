package com.javarush.test.level08.lesson11.home09;

import java.util.Date;

/* Работа с датой
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года - нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
*/

public class Solution
{
    public static void main(String[] args)
    {
        System.out.println(isDateOdd("JANUARY 2 2000"));
    }

    public static boolean isDateOdd(String date)
    {
        Date date1 = new Date(date);
        long finish = date1.getTime();
        date1.setMonth(0);
        date1.setDate(1);
        long start = date1.getTime();

        long Days = finish -start;
        long msDay = 24*60*60*1000;
        int daysFromBegin = (int)(Days/msDay);
        if(daysFromBegin % 2 ==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
