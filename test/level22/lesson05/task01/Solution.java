package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args)
    {
        String str = "JavaRush - лучший сервис обучения Java.";
        System.out.println(getPartOfString(str));

    }
    public static String getPartOfString(String string)
    {
        if(string == null || string.isEmpty()) throw new TooShortStringException();
        int firstSpace = string.indexOf(" ");
        if(firstSpace == -1)
            throw new TooShortStringException();
        int lastSpace = string.indexOf(" ",firstSpace+1);
        if(lastSpace == -1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ",lastSpace+1);
        if(lastSpace==-1)
            throw new TooShortStringException();
        lastSpace = string.indexOf(" ",lastSpace+1);
        if(lastSpace==-1)
            throw new TooShortStringException();
        String agterLastSpace = string.substring(lastSpace+1);
        System.out.println(agterLastSpace);
        char[] buff = agterLastSpace.toCharArray();
        int index = 0;
        if(!Character.isLetter(buff[0]))
            throw new TooShortStringException();
        for(int i = 0 ; i < buff.length;i++)
        {
            if(Character.isLetter(buff[i]))
                index = i;
            else
                break;
        }



        return string.substring(firstSpace+1,lastSpace+index+2);
    }

    public static class TooShortStringException extends  RuntimeException{
    }
}
