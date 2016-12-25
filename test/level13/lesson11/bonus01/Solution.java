package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<Integer> result = new ArrayList<>();
        while(fileRead.ready())
            result.add(Integer.parseInt(fileRead.readLine()));
        Collections.sort(result);
        for(int i =0 ; i < result.size();i++)
        {
            if(result.get(i)%2 == 0)
            System.out.println(result.get(i));
        }
    }
}
