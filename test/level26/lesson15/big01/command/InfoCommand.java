package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.util.Collection;


/**
 * Created by Danya on 11/01/2017.
 */
class InfoCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
        Collection<CurrencyManipulator> arr = CurrencyManipulatorFactory.getAllCurrencyManipulators();
        if(arr.isEmpty()){ConsoleHelper.writeMessage("No money available.");}
        else
        {
            int count = 0;
            for (CurrencyManipulator map : arr)
            {
                if(map.hasMoney()&&map.getTotalAmount()>0)
                {
                    ConsoleHelper.writeMessage(map.getCurrencyCode()+" - "+map.getTotalAmount());
                    count++;
                }
            }
            if(count ==0){ConsoleHelper.writeMessage("No money available.");}
        }
    }
}


