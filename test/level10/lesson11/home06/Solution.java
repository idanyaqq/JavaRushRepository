package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        String s;
        boolean b;
        int age;
        short sh;
        long lng;
        String s1;
        public Human(String s)
        {
            this.s = s;
        }
        public Human(boolean b)
        {
            this.b = b;
        }
        public Human(int age)
        {
            this.age = age;
        }
        public Human(short sh)
        {
            this.sh = sh;
        }
        public Human(long lng)
        {
            this.lng = lng;
        }
        public Human(String s,String s1)
        {
            this.s = s;
            this.s1 = s1;
        }
        public Human(String s, boolean b)
        {
            this.s=s;
            this.b=b;
        }
        public Human(String s,int age)
        {
            this.s=s;
            this.age=age;
        }
        public Human(String s,short sh)
        {
            this.s = s;
            this.sh=sh;
        }
        public Human(String s, long lng)
        {
            this.s=s;
            this.lng=lng;
        }
    }
}
