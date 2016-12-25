package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        ArrayList<Character> arr = new ArrayList<Character>();
        int leng = s.length();
        arr.add(Character.toUpperCase(s.charAt(0)));
        for (int i = 0; i < leng-1;i++)
        {
            if (s.charAt(i)==' '&& s.charAt(i+1)!=' ')
            {
                arr.add(Character.toUpperCase(s.charAt(i+1)));
            }
            else
            {
                arr.add(s.charAt(i+1));
            }
        }

        String result = "";
        for (int i=0; i<arr.size();i++)
        {
            result += arr.get(i);
        }
        System.out.println(result);
    }


}
