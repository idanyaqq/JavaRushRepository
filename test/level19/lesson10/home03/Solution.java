package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();


    public static void main(String[] args)throws IOException, ParseException{
        BufferedReader reader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        String birthday = "";
        String name = "";
        while(reader.ready())
        {
            String[] buffer = reader.readLine().split(" ");
            birthday = buffer[buffer.length-3]+" "+buffer[buffer.length-2]+" "+buffer[buffer.length-1];
            if(buffer.length == 4)
                name = buffer[buffer.length-4];
            else if(buffer.length ==5)
                name = buffer[buffer.length-5]+" "+buffer[buffer.length-4];
            else if(buffer.length ==6)
                name = buffer[buffer.length-6]+" "+buffer[buffer.length-5]+" "+buffer[buffer.length-4];

            PEOPLE.add(new Person(name,simpleDateFormat.parse(birthday)));

        }
        reader.close();

    }

}
