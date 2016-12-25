package com.javarush.test.level19.lesson03.task03;

/* Адаптация нескольких интерфейсов
Адаптировать IncomeData к Customer и Contact.
Классом-адаптером является IncomeDataAdapter.
Инициализируйте countries перед началом выполнения программы. Соответствие кода страны и названия:
UA Ukraine
RU Russia
CA Canada
Дополнить телефонный номер нулями до 10 цифр при необходимости (смотри примеры)
Обратите внимание на формат вывода фамилии и имени человека
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static{
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args)
    {
        IncomeDataAdapter adapter = new IncomeDataAdapter(new IncomeData()
        {
            @Override
            public String getCountryCode()
            {
                return "RU";
            }

            @Override
            public String getCompany()
            {
                return "JavaRush Ltd";
            }

            @Override
            public String getContactFirstName()
            {
                return "Danya";
            }

            @Override
            public String getContactLastName()
            {
                return "Redin";
            }

            @Override
            public int getCountryPhoneCode()
            {
                return +7;
            }

            @Override
            public int getPhoneNumber()
            {
                return 2840309;
            }
        });
        System.out.println(adapter.getName());
        System.out.println(adapter.getPhoneNumber());
        System.out.println(adapter.getCompanyName());
        System.out.println(adapter.getCountryName());

    }

    public static class IncomeDataAdapter implements Customer , Contact {
        IncomeData data;
        public IncomeDataAdapter(IncomeData data)
        {
            this.data = data;
        }

        @Override
        public String getName()
        {
            return this.data.getContactLastName()+", "+ this.data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber()
        {
            String phoneNumber = this.data.getPhoneNumber()+"";
            String nulls = "";
            if(phoneNumber.length()<10)
            {
                for(int i = 0;i <(10-phoneNumber.length());i++)
                {
                    nulls = nulls + 0;
                }
            }
            phoneNumber = nulls+phoneNumber;
            String firstPart = phoneNumber.substring(0,3);
            String secongPart = phoneNumber.substring(3,6);
            String thirdPart = phoneNumber.substring(6,8);
            String foursPart = phoneNumber.substring(8,10);
            return "+"+this.data.getCountryPhoneCode()+"("+firstPart+")"+secongPart+"-"+thirdPart+"-"+foursPart;
        }

        @Override
        public String getCompanyName()
        {
            return this.data.getCompany();
        }

        @Override
        public String getCountryName()
        {
            return countries.get(this.data.getCountryCode());
        }
    }

    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +038(50)123-45-67
    }
}