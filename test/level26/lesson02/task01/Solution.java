package com.javarush.test.level26.lesson02.task01;

/* Почитать в инете про медиану выборки
Реализовать логику метода sort, который должен сортировать данные в массиве по удаленности от его медианы
Вернуть отсортированный массив от минимального расстояния до максимального
Если удаленность одинаковая у нескольких чисел, то выводить их в порядке возрастания
*/
public class Solution {
    public static Integer[] sort(Integer[] array) {
        if(array.length %2 ==0)
        {
            int mediana = (array[array.length/2]+array[array.length/2+1])/2;
        }
        return array;
    }
}
