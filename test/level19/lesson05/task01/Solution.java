package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        FileWriter writerFile = new FileWriter(new File(reader.readLine()));
        List<Integer> buff = new ArrayList<Integer>();
        while(fileRead.ready())
        {
            buff.add(fileRead.read());
        }
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0 ; i < buff.size();i++)
        {
           if (i%2!=0&& i!=0)
           {
               result.add(buff.get(i));
           }
        }
        for(Integer a : result)
        {
            writerFile.write(a);
        }
        reader.close();
        fileRead.close();
        writerFile.close();
    }
}
