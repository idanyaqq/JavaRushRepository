package com.javarush.test.level20.lesson07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* Externalizable Person
Класс Person должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку сериализации.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static void main(String[] args)throws IOException, ClassNotFoundException
    {
        Person person1 = new Person("Dodya1","Kepchuk",13);
        Person mom = new Person("Mom","Kepchuk",44);
        Person dad = new Person("Batya","Kepchuk",46);
        Person son = new Person("Sinok","Kepchuk",16);
        Person doughter = new Person("Dodya","Kepchuk",16);
        person1.setFather(dad);
        person1.setMother(mom);
        List<Person> list = new ArrayList<>();
        list.add(son);
        list.add(doughter);
        person1.setChildren(list);

        System.out.println(person1.firstName+" "+person1.lastName+" "+person1.age+" "+person1.father+" "+person1.mother+" "+person1.children);
        File file = new File("e:/java.txt");
        ObjectOutputStream obj = new ObjectOutputStream(new FileOutputStream(file));
        obj.writeObject(person1);
        obj.close();

        ObjectInputStream inObj = new ObjectInputStream(new FileInputStream(file));
        Person person = (Person) inObj.readObject();
        inObj.close();
        System.out.println(person.firstName+" "+person.lastName+" "+person.age+" "+person.father+" "+person.mother+" "+person.children);


    }
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(){}

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }


        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(this.mother);
            out.writeObject(this.father);
            out.writeObject(this.firstName);
            out.writeObject(this.lastName);
            out.writeInt(this.age);
            out.writeObject(this.children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person)in.readObject();
            father = (Person)in.readObject();
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            age = in.readInt();
            children = (List<Person>)in.readObject();
        }
    }
}
