package com.javarush.test.level22.lesson09.task03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        String fullLineString = "";
        while (fileRead.ready())
        {
            fullLineString += fileRead.readLine();
        }
        reader.close();
        fileRead.close();

        StringBuilder result = getLine(fullLineString.split(" "));
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words)
    {
        ArrayList<String> ourList = new ArrayList<String>(); //рабочий лист , с которого будем удалять
        ArrayList<String> FireTime = new ArrayList<String>(); // лист для повторного использования
        ourList.addAll(Arrays.asList(words));
        FireTime.addAll(Arrays.asList(words));
        String datForRecursion = ""; //строка для сравнивания с Builder
        int k = 0;  // переменная для посчета слов вошедших в Builder
        for (String str : words)
        {
            datForRecursion += str + " ";
        }
        datForRecursion = datForRecursion.trim();
        StringBuilder builder = new StringBuilder();
        if(words==null|| words.length ==0)
            return builder;
        else if (words != null)
        {
            if (words.length == 1)
            {
                builder.append(words[0]+" ");
            }
            else
            {
                for(int i = 0;i<ourList.size();)
                {
                    /*
                    Каждый раз когда Builder не равен строке для сравнения , перемешиваем наш List
                    и берем новое нулевое значение
                     */
                    if(i==0)
                    {
                        Collections.shuffle(ourList);
                        builder.append(ourList.get(0)+" ");
                        ourList.remove(0);

                    }
                    for(int j = 0 ; j < ourList.size();)
                    {
                        /*
                        Если предпоследний символ(т.к. последний это пробел) Builder'a равен первому символу List.get(j),
                        к Builder добавляем List.get(j)
                        Добавили слово - увеличили переменную k на 1

                         */
                        if(builder.toString().substring(builder.length()-2,builder.length()-1).toLowerCase().equals(ourList.get(j).substring(0, 1).toLowerCase()))
                        {
                            builder.append(ourList.get(j)+" ");
                            ourList.remove(j);
                            j=0;
                            k++;
                        }
                        else
                            j++;
                    }
                    i++;
                    /*
                     Если k != размеру 2го List'a очишщаем рабочий List и заполняем его запасным
                     Builder делаем "пустым", обнуляем переменные i,k.
                     */
                    if(k != FireTime.size())
                    {
                        if(builder.toString().length()-1 != datForRecursion.length())
                        {
                            ourList.removeAll(ourList);
                            ourList.addAll(FireTime);
                            builder.replace(0,builder.length(),"");
                            i=0;
                            k=0;
                        }
                    }
                }
            }
        }
        builder.replace(builder.length()-1,builder.length(),"");

        return builder;
    }
}
