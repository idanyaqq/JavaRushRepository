package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    Properties properties1 = new Properties();

    public void fillInPropertiesMap() throws Exception {
        BufferedReader consoleread = new BufferedReader(new InputStreamReader(System.in));
        InputStream reader = new FileInputStream(consoleread.readLine());
        consoleread.close();
        load(reader);


        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        if(properties.size()>0)
        {
            properties.putAll(properties);
            properties1.store(outputStream,"");
            printWriter.close();
        }
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        properties1.load(inputStream);
        Set<String> list = properties1.stringPropertyNames();
        for(String current :list)
        properties.put(current,properties1.getProperty(current));
        reader.close();
    }
}
