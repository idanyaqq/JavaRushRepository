package com.javarush.test.level05.lesson12.home05;

/* Вводить с клавиатуры числа и считать их сумму
Вводить с клавиатуры числа и считать их сумму, пока пользователь не введёт слово «сумма». Вывести на экран полученную сумму.
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int summ = 0;
        BufferedReader a = new BufferedReader( new InputStreamReader(System.in)); //   String b = "null";
        while (true)
        {

            String b = a.readLine();
            if (b.equals("сумма"))
            {
                break;
            }
            else
            {
                int c = Integer.parseInt(b);
                summ = summ+c;
            }
            //напишите тут ваш код
        }
        System.out.println(summ);
    }
}


    
