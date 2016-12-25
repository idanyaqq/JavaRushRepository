package com.javarush.test.level20.lesson10.home05;

import java.io.*;
import java.util.logging.Logger;

/* Сериализуйте Person
Сериализуйте класс Person стандартным способом. При необходимости поставьте полям модификатор transient.
*/
public class Solution {

    public static void main(String[] args)throws IOException,ClassNotFoundException
    {
        Person person = new Person("danya","redin","Russia",Sex.MALE);
        File file = new File("e:/java.txt");
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        out.writeObject(person);

        Person person1 = (Person)in.readObject();
        System.out.println(person1);

    }

    public static class Person  implements Serializable{
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greetingString;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;



        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greetingString = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }
         Person(){
            this.greetingString = "Hello, ";
        }
        private void writeObject(ObjectOutputStream out) throws IOException
        {
            out.writeObject(firstName);
            out.writeObject(lastName);
           // out.writeObject(fullName);
            out.writeObject(country);
            out.writeObject(sex);
           // out.writeObject(logger);

        }
        private void readObject(ObjectInputStream in)throws IOException, ClassNotFoundException
        {
            firstName = (String)in.readObject();
            lastName = (String)in.readObject();
            //fullName = (String)in.readObject();
            country = (String)in.readObject();
            sex = (Sex)in.readObject();
            //logger = (Logger)in.readObject();
        }

    }

    enum Sex {
        MALE,
        FEMALE
    }
}
