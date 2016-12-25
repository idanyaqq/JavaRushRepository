package com.javarush.test.level16.lesson03.task03;

import java.util.ArrayList;
import java.util.List;

/* Список и нити
В методе main добавить в статический объект list 5 нитей SpecialThread - различных объектов.
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        SpecialThread numbone = new SpecialThread();
        Thread thread1 = new Thread(numbone);
        list.add(thread1);
        SpecialThread numbtwo = new SpecialThread();
        Thread thread2 = new Thread(numbtwo);
        list.add(thread2);
        SpecialThread numbthree = new SpecialThread();
        Thread thread3 = new Thread(numbthree);
        list.add(thread3);
        SpecialThread numbfour = new SpecialThread();
        Thread thread4 = new Thread(numbfour);
        list.add(thread4);
        SpecialThread numbfive = new SpecialThread();
        Thread thread5 = new Thread(numbfive);
        list.add(thread5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's run method inside SpecialThread");
        }
    }
}
