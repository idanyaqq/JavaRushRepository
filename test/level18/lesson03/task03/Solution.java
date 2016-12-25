package com.javarush.test.level18.lesson03.task03;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/* Самые частые байты
Ввести с консоли имя файла
Найти байт или байты с максимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> allValues = new ArrayList<Integer>();
        List<Integer> finalValues = new ArrayList<Integer>();

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

        int[] count = new int[allValues.size()];
        for(int i = 0; i< count.length;i++)
        {
            count[i]=0;
            for(int j =0;j < count.length;j++)
            {
                if(allValues.get(i) == allValues.get(j))
                {count[i]++;}
            }
        }

        int max = Integer.MIN_VALUE;
        for(int min : count)
        {
            if(min > max) max= min;
        }

        for(int i =0;i<allValues.size();i++)
        {
            if(!finalValues.contains(allValues.get(i))&&count[i]==max)
                finalValues.add(allValues.get(i));
        }
        for(int values : finalValues)
        {
            System.out.print(values+" ");
        }



    }
}
