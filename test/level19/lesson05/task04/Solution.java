package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileRead = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter fileWrite = new BufferedWriter(new FileWriter(reader.readLine()));
        String str = "";
        while(fileRead.ready())
        {
            str += fileRead.readLine();
        }
        str = str.replaceAll("\\.","!");
        fileWrite.write(str);
        reader.close();
        fileRead.close();
        fileWrite.close();
    }
}
