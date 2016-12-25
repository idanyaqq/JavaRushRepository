package com.javarush.test.level09.lesson11.home09;

import java.util.*;

/* Десять котов
Создать класс кот – Cat, с полем «имя» (String).
Создать словарь Map(<String, Cat>) и добавить туда 10 котов в виде «Имя»-«Кот».
Получить из Map множество(Set) всех имен и вывести его на экран.
*/

public class Solution
{
    public static void main(String[] args)
    {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap()
    {
        Map<String, Cat> map = new HashMap<String,Cat>();
        map.put("A",new Cat("A"));
        map.put("B",new Cat("B"));
        map.put("C",new Cat("C"));
        map.put("D",new Cat("D"));
        map.put("F",new Cat("F"));
        map.put("G",new Cat("G"));
        map.put("H",new Cat("H"));
        map.put("I",new Cat("I"));
        map.put("J",new Cat("J"));
        map.put("K",new Cat("K"));
        return map;
    }
    public static Set<Cat> convertMapToSet(Map<String, Cat> map)
    {
        Set<Cat> kets = new HashSet<Cat>();
        Iterator<Map.Entry<String,Cat>> iterator = map.entrySet().iterator();
        while(iterator.hasNext())
        {
            Cat s = iterator.next().getValue();
            kets.add(s);
        }
        return kets;
    }
    public static void printCatSet(Set<Cat> set)
    {
        for (Cat cat:set)
        {
            System.out.println(cat);
        }
    }
    public static class Cat
    {
        private String name;
        public Cat(String name)
        {
            this.name = name;
        }
        public String toString()
        {
            return "Cat "+this.name;
        }
    }


}
