package com.javarush.test.level18.lesson10.home09;

/* Файлы и исключения
Читайте с консоли имена файлов
Если файла не существует (передано неправильное имя файла), то
перехватить исключение FileNotFoundException, вывести в консоль переданное неправильное имя файла и завершить работу программы.
Закрыть потоки. Не использовать try-with-resources
Не используйте System.exit();
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = null;
        boolean isTrue = false;
        while (!isTrue)
        {
            String s = reader.readLine();
            try
            {
                file = new FileInputStream(s);
            }
            catch (FileNotFoundException e)
            {
                System.out.println(s);
                isTrue = true;
            }
        }
        reader.close();
        file.close();
    }
}
