package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> allValues = new ArrayList<Integer>();
        List<Integer> allValues2 = new ArrayList<Integer>();
        Map<Integer,Integer> finalList = new HashMap<Integer, Integer>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String FileName = reader.readLine();

        FileInputStream ReadFile = new FileInputStream(FileName);
        reader.close();
        while(ReadFile.available()>0)
        {
            int data = ReadFile.read();
            allValues.add(data);
        }
        ReadFile.close();


        for(int i = 0; i< allValues.size();i++)
        {
            for (int j = 0; j < allValues.size(); j++)
            {
                if (allValues.get(i) == allValues.get(j))
                {
                    finalList.put(allValues.get(i), null);
                }
            }

        }
        for(Map.Entry<Integer,Integer> numbers : finalList.entrySet())
        {
            int key = numbers.getKey();
            allValues2.add(key);
        }
        Collections.sort(allValues2);
        for(int numbers : allValues2)
        {
            System.out.println(numbers);
        }
    }
}
