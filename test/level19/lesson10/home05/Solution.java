package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException{

        BufferedReader fileRead = new BufferedReader(new FileReader(args[0]));
        BufferedWriter filewWrite = new BufferedWriter(new FileWriter(args[1]));
        Pattern pattern= Pattern.compile("\\d");

        while(fileRead.ready())
        {
            String[] str = fileRead.readLine().split(" ");
            for(String s:str)
            {
                Matcher matcher = pattern.matcher(s);
                if(matcher.find())
                {
                    filewWrite.write(s+" ");
                }
            }

        }
        fileRead.close();
        filewWrite.close();
    }
}
