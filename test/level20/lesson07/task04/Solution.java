package com.javarush.test.level20.lesson07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Serializable Solution
Сериализуйте класс Solution.
Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
Объект всегда должен содержать актуальные итоговые данные.
Метод main не участвует в тестировании.
Написать код проверки самостоятельно в методе main:
1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
2) создать экземпляр класса Solution - savedObject
3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
4) создать другой экземпляр класса Solution с другим параметром
5) загрузить из потока на чтение объект - loadedObject
6) проверить, что savedObject.string равна loadedObject.string
7) обработать исключения
*/
public class Solution implements Serializable{
    public static void main(String[] args)throws IOException,ClassNotFoundException {
        File file = new File("e:/java.txt");
        //stream initialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));

        //create class examples
        Solution savedObject = new Solution(14);
        out.writeObject(savedObject);

        Solution loadedObject = (Solution)in.readObject();
        System.out.println(savedObject.string.equals(loadedObject.string));
        System.out.println(savedObject);
        System.out.println(loadedObject);
        System.out.println(new Solution(4));
    }
    //try to find mistake in methods.
    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(){}

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    private void writeExternal(ObjectOutput out) throws IOException
    {
       // out.writeObject(this.currentDate);
        //out.writeInt(this.temperature);
        out.writeObject(this.string);
    }
    public void readExternal(ObjectInput in) throws IOException,ClassNotFoundException
    {
        //currentDate = (Date)in.readObject();
        //temperature = in.readInt();
        string = (String)in.readObject();
    }


    @Override
    public String toString() {
        return this.string;
    }
}
