package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileRead = new FileReader(reader.readLine());
        String buff="";
        while(fileRead.ready())
        {
           char a = (char)fileRead.read();
            buff += String.valueOf(a).toLowerCase();
        }
        buff = buff.replaceAll("\\p{Punct}|\n|\r"," ");
        String[] res = buff.split(" ");
        int count = 0;
        for(String s : res){
                s.trim();
            if(s.equals("world"))
            {
                count++;
            }
        }
        System.out.println(count);
        reader.close();
        fileRead.close();
    }
}
