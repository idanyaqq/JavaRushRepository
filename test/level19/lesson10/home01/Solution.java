package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        String str = "";
        while(reader.ready())
        {
            str += reader.readLine().toString()+" ";
        }
        String[] buffer = str.split(" ");
        Map<String,Double> result = new TreeMap<String, Double>();
        for(int i = 0;i < buffer.length;)
        {
            String name = buffer[i];
            double value = 0;
            result.put(name,value);

            for(int j = 0;j<buffer.length;)
            {
                if(name.equals(buffer[j]))
                {
                    value += Double.parseDouble(buffer[j+1]);
                    result.put(name,value);

                }
                j+=2;
            }
            i+=2;
        }

        for(Map.Entry<String,Double> map :result.entrySet())
        {
            String key = map.getKey();
            double value = map.getValue();
            System.out.println(key+ " "+value);
        }
        reader.close();


    }
}
