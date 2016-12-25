package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        String fileName2 = reader.readLine();
        RandomAccessFile file1 = new RandomAccessFile(fileName,"rw");
        RandomAccessFile file2 = new RandomAccessFile(fileName2,"r");
        long pointPosition = 0;
        byte[] buff = new byte[(int)file1.length()];
        for(int i = 0 ; i<buff.length;i++)
        {
            buff[i] = file1.readByte();
        }
        byte[] buff2 = new byte[(int)file2.length()];
        for(int i = 0;i < buff2.length;i++)
        {
           buff2[i] =  file2.readByte();
        }
        file1.seek(0);
        for(Byte b : buff2)
        {
            file1.writeByte(b);
        }

        for(Byte b : buff)
        {
            file1.writeByte(b);
        }
        reader.close();
        file1.close();
        file2.close();


    }
}
