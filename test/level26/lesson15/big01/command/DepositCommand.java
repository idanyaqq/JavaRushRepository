package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;



/**
 * Created by Danya on 11/01/2017.
 */
class DepositCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {

            String currencycode = ConsoleHelper.askCurrencyCode();
            String[] values = ConsoleHelper.getValidTwoDigits(currencycode);
            CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencycode).addAmount(Integer.valueOf(values[0]), Integer.valueOf(values[1]));

    }
}
