package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        File file = new File(reader.readLine());
        FileReader newFile = new FileReader(file);

        char[] buffer = new char[(int)file.length()];
        newFile.read(buffer);
        int count =0;
        for(Character simb : buffer)
        {
            if (simb ==(44))
                count++;
        }
        System.out.println(count);
        reader.close();
        newFile.close();



    }
}
