package com.javarush.test.level19.lesson08.task04;

/* Решаем пример
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить на консоль решенный пример
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток

Возможные операции: + - *
Шаблон входных данных и вывода: a [знак] b = c
Отрицательных и дробных чисел, унарных операторов - нет.

Пример вывода:
3 + 6 = 9
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream outStream = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        System.setOut(printStream);
        testString.printSomething();
        String outstr = stream.toString();
        String[] str = outstr.split(" ");
        int firstValue = Integer.parseInt(str[0]);
        int secondValue = Integer.parseInt(str[2]);
        int value = 0;
        if(str[1].equals("+"))
            value = firstValue + secondValue;
        else if(str[1].equals("*"))
            value = firstValue * secondValue;
        else if(str[1].equals("-"))
            value = firstValue - secondValue;

        System.setOut(outStream);
        System.out.println(str[0]+" "+str[1]+" "+str[2]+" "+str[3]+" "+value);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

