package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args)throws IOException{


        int count = 0 ;
        int countOfSpaces = 0;
        double twoElementAfterDot = 0 ;
        if(args.length>0)
        {
            FileInputStream file = new FileInputStream(new File(args[0]));

            while(file.available()>0)
            {
                count++;
                int data = file.read();
                if(data == Integer.valueOf(' '))
                {
                    countOfSpaces++;
                }

            }
            file.close();
        }


        if(count == 0){}else
        {
            twoElementAfterDot = (double)countOfSpaces / count * 100;

        }
        System.out.printf("%.2f", twoElementAfterDot);


    }
}
