package com.javarush.test.level26.lesson02.task01;

import java.util.ArrayList;
import java.util.Arrays;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        Integer[] result;
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> abs = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        int mediana;
        int index=0;
        if(list.size()%2!=0)
        {
            result = new Integer[array.length-1];
            mediana = list.get(list.size()/2);
            list.remove(list.size()/2);
            for(Integer value : list)
            {
                abs.add(Math.abs(mediana-value));
            }

            for(int i = 0 ; i < list.size();i++)
            {
               int min = Integer.MAX_VALUE;
               for(int j = 0 ; j < abs.size();j++)
               {
                   if(abs.get(j)<min && abs.get(j)>0)
                   {
                       min = abs.get(j);
                       index =j;
                   }
               }
                indexes.add(index);
                abs.remove(index);
                abs.add(index,-1);

            }
            for(int i = 0 ; i < indexes.size();i++)
            {
                result[i] = list.get(indexes.get(i));
            }
        }
        return array;
    }

    public static void main(String[] args)
    {
        Integer[] array = {7,22,14,11,18,2,10};
        sort(array);
        for(Integer value : array)
        {
            System.out.print(value + " ");
        }
    }
}
