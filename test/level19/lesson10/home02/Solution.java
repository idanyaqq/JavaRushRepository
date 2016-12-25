package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str="";
        while(reader.ready())
        {
            str+= reader.readLine()+ " ";
        }
        String[] buffer = str.split(" ");
        Map<String,Double> prom = new TreeMap<String, Double>();
        for(int i =0;i<buffer.length;)
        {
            String name = buffer[i];
            double value = 0;
            prom.put(name,value);
            for(int j = 0 ; j < buffer.length;)
            {
                if(name.equals(buffer[j]))
                {
                    value+= Double.parseDouble(buffer[j+1]);
                    prom.put(name,value);
                }
                j+=2;
            }
            i+=2;
        }
        Map<String,Double> result = new TreeMap<String, Double>();
        double max = 0;
        String lastName = null;
        for(Map.Entry<String,Double> map:prom.entrySet())
        {
            double value = map.getValue();
            lastName = map.getKey();
            if(value > max)
            {
                max = value;
                lastName = map.getKey();
            }
        }
        for(Map.Entry<String,Double>map:prom.entrySet())
        {
            if(map.getValue()>=max)
                result.put(map.getKey(),map.getValue());
        }
        for(Map.Entry<String,Double>map:result.entrySet())
        {
            String name = map.getKey();
            System.out.println(name);
        }
        reader.close();

    }
}
