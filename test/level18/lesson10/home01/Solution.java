package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        List<Character> fileInside = new ArrayList<Character>();
        FileInputStream ourFile = new FileInputStream(new File(args[0]));
        for(char i = 'a'; i <= 'z';i++)
        {
            fileInside.add(i);
        }
        int c;
        int wordCount =0;
        while(ourFile.available()>0)
        {
            c = ourFile.read();
            if(fileInside.contains(Character.toLowerCase((char)c)))
                wordCount++;
        }
        System.out.println(wordCount);
        ourFile.close();
    }
}
