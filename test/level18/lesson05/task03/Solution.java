package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream FileName1 = new FileInputStream( reader.readLine());
        FileOutputStream FileName2 = new FileOutputStream( reader.readLine());
        FileOutputStream FileName3 = new FileOutputStream( reader.readLine());

        byte[] file1 = new byte[FileName1.available()/2 + FileName1.available()%2];
        byte[] file2= new byte[FileName1.available()/2];

        FileName2.write(file1,0,FileName1.read(file1));
        FileName3.write(file2,0,FileName1.read(file2));

        reader.close();
        FileName1.close();
        FileName2.close();
        FileName3.close();
    }
}
