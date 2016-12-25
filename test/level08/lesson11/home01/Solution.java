package com.javarush.test.level08.lesson11.home01;

import java.util.HashSet;
import java.util.Set;
import java.util.Iterator;
/* Set из котов
1. Внутри класса Solution создать public static класс кот – Cat.
2. Реализовать метод createCats, он должен создавать множество (Set) котов и добавлять в него 3 кота.
3. В методе main удалите одного кота из Set cats.
4. Реализовать метод printCats, он должен вывести на экран всех котов, которые остались во множестве. Каждый кот с новой строки.
*/

public class Solution
{
    public static void main(String[] args) {
        Set<Cat> cats = createCats();
        Iterator<Cat> abc = cats.iterator();
        abc.next();
        abc.remove();
        printCats(cats);
    }

    public static Set<Cat> createCats() {
       Set<Cat> a = new HashSet<Cat>();
        for (int i = 0; i < 3; i++){
        a.add(new Cat());//напишите тут ваш код. пункт 2
        }
        return a;
    }

    public static void printCats(Set<Cat> cats) {
        for(Cat cat1:cats)
        {
            System.out.println(cat1);
        }

    }

    public static class Cat {

    }
}
