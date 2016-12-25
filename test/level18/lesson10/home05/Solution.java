package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader reader1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedWriter writelntfile = new BufferedWriter(new FileWriter(reader.readLine()));
        List<Integer> result = new ArrayList<Integer>();
        String stgr;
        String[] str;
        while((stgr = reader1.readLine())!= null)
        {
            str = stgr.split(" ");
            for(String a : str)
            {
               result.add((int)Math.round(Double.parseDouble(a)));
            }
        }
        for(int a :result)
        {
            writelntfile.write(a+" ");
        }
        reader.close();
        reader1.close();
        writelntfile.close();

    }
}
