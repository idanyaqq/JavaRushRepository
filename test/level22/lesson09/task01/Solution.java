package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        ArrayList<String> OurList = new ArrayList<String>();
        while(fileRead.ready())
        {
            OurList.addAll(Arrays.asList(fileRead.readLine().split(" ")));
        }
        for(int i = 0 ; i < OurList.size();i++)
        {
            for(int j = 0; j < OurList.size();)
            {
                StringBuilder  firstWord = new StringBuilder(OurList.get(i));
                String s = firstWord.reverse().toString();
                if(OurList.get(j).equals(s)&& i != j)
                {
                    Pair pair = new Pair();
                    pair.first = OurList.get(i);
                    pair.second = OurList.get(j);
                    OurList.remove(j);
                    OurList.remove(i);

                    result.add(pair);
                    j=0;
                }
                else j++;

            }
        }
        reader.close();
        fileRead.close();
        for(Pair pair : result)
        {
            System.out.println(pair.first+" " +pair.second);
        }
    }

    public static class Pair {
        String first;
        String second;

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
