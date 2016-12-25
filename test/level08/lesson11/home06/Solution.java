package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;

public class Solution
{
    public static void main(String[] args)

    {
        ArrayList<Human> detidetei = new ArrayList<Human>();
        ArrayList<Human> ch = new ArrayList<Human>();
        ch.add(new Human("And",true,2,detidetei));
        ch.add(new Human("And11",false,3,detidetei));
        ch.add(new Human("And112",true,4,detidetei));
        ArrayList<Human> mother = new ArrayList<Human>();
        mother.add(new Human("MAtka", false,44,ch));
        ArrayList<Human> father = new ArrayList<Human>();
        father.add(new Human("Batka",true, 55,ch));
        ArrayList<Human> predki = new ArrayList<Human>();
        predki.add(new Human("Ded1",true,99,mother));
        predki.add(new Human("Ded2",true,99,father));
        predki.add(new Human("Babka1",false,99,mother));
        predki.add(new Human("Babka2",false,99,father));
        for (int i = 0 ; i < ch.size();i++)
        {
            System.out.println(ch.get(i));
        }
        for (int i = 0 ; i < predki.size();i++)
        {
            System.out.println(predki.get(i));
        }
        for (int i = 0 ; i < father.size();i++)
        {
            System.out.println(father.get(i));
        }
        for (int i = 0 ; i < mother.size();i++)
        {
            System.out.println(mother.get(i));
        }
    }

    public static class Human
    {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children = new ArrayList<Human>();
        public Human(String name, boolean sex, int age, ArrayList children)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;

        }


        //напишите тут ваш код

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
