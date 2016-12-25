package com.javarush.test.level22.lesson09.task02;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/* Формируем Where
Сформируйте часть запроса WHERE используя StringBuilder.
Если значение null, то параметр не должен попадать в запрос.
Пример:
{"name", "Ivanov", "country", "Ukraine", "city", "Kiev", "age", null}
Результат:
"name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'"
*/
public class Solution {
    public static void main(String[] args) throws IOException
    {
        Map<String,String> example2 = new LinkedHashMap<String,String>();
       example2.put("bsdsad","fdsfds");
       example2.put(null,"dsadsaf");
       example2.put("Alog",null);
        example2.put(null,null);
        example2.put("ldsaldlsa","kek");
        example2.put(null,"sdads");
       example2.put("kfdkf","dsadsd");
        System.out.println(getCondition(example2));

    }

    public static StringBuilder getCondition(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        for(Map.Entry<String,String> pair : params.entrySet())
        {
            String first = pair.getKey();
            String second = pair.getValue();
            if(first!= null && second == null)
            {
                builder.append("");
                count++;

            }
            if(first==null && second!=null)
            {
                builder.append("");
                count++;

            }
            if(first == null&&second==null)
            {
                builder.append("");
                count++;

            }
            if(first != null && second != null && count < params.size())
            {
                builder.append(first + " = '" + second + "' and ");
                count++;
            }
        }
        if(builder.toString().lastIndexOf("and")!= -1)
        {
            builder.replace(builder.length()-5,builder.length(),"");
        }

        return builder;
    }
}
