package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args)throws IOException{
    /*    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream File4Read = new FileInputStream(reader.readLine());
        FileOutputStream File4Write = new FileOutputStream(reader.readLine());

        List<Integer> newMass = new ArrayList<Integer>();
        while(File4Read.available()>0)
        {
            int data = File4Read.read();
            newMass.add(data);
        }
        for(int i = 0;i<newMass.size();i++)
        {
            File4Write.write(newMass.get(newMass.size()-1-i));
        }

        reader.close();
        File4Read.close();
        File4Write.close();
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream in = new FileInputStream(new File(reader.readLine()));
        FileOutputStream out = new FileOutputStream(reader.readLine());
        byte[] buffer = new byte[in.available()];

        for(int i = in.read(buffer); i > 0; i--)
            out.write(buffer[i-1]);
        in.close();
        out.close();

    }
}
