package com.javarush.test.level19.lesson03.task04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {
    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner scaner;
        public PersonScannerAdapter(Scanner scaner)
        {
            this.scaner = scaner;
        }

        @Override
        public Person read() throws IOException
        {

            String[] parsStr = scaner.nextLine().split(" ");
            int month = Integer.parseInt(parsStr[4]);
            int day = Integer.parseInt(parsStr[3]);
            int year = Integer.parseInt(parsStr[5]);
            Calendar calendar = new GregorianCalendar(year,--month,day);
            Person person = new Person(parsStr[1],parsStr[2],parsStr[0],calendar.getTime());
            return person;

        }

        @Override
        public void close() throws IOException
        {
            this.scaner.close();
        }
    }
}
