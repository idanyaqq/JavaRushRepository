package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Danya on 11/01/2017.
 */
public final class CurrencyManipulatorFactory
{
    static private Map<String,CurrencyManipulator> manipulators = new HashMap<String,CurrencyManipulator>();

    private CurrencyManipulatorFactory()
    {}

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode){
       if(!manipulators.containsKey(currencyCode))
       {
           manipulators.put(currencyCode,new CurrencyManipulator(currencyCode));
       }
        return manipulators.get(currencyCode);
    }
    public static Collection<CurrencyManipulator> getAllCurrencyManipulators()
    {
        Collection<CurrencyManipulator> result = new ArrayList<CurrencyManipulator>();
        for(Map.Entry<String,CurrencyManipulator> manipulatorEntry : manipulators.entrySet())
        {
            result.add(manipulatorEntry.getValue());
        }
        return  result;
    }

}
