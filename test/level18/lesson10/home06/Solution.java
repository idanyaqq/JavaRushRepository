package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/



import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args)throws IOException{

        FileInputStream in = new FileInputStream(new File(args[0]));
        byte[] buff = new byte[in.available()];
        in.read(buff);
        Map<Byte,Integer> result = new TreeMap<Byte, Integer>();

        for(int i=0;i < buff.length;i++)
        {
            int count = 0 ;
            byte value = buff[i];
            for(int j =0 ; j < buff.length;j++)
            {
                if(value == buff[j])
                {
                    count++;
                    result.put(value,count);
                }
            }
        }
        for(Map.Entry<Byte,Integer> map : result.entrySet())
        {
            char key = (char)(int)map.getKey();
            int value = map.getValue();
            System.out.println(key+ " "+ value);
        }
        in.close();


    }
}
