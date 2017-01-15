package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level17.lesson10.home08.NotEnoughMoneyException;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;


/**
 * Created by Danya on 11/01/2017.
 */
class WithdrawCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {

        while(true)
        {
            String currencyCode = ConsoleHelper.askCurrencyCode();
            CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            int sum;
            ConsoleHelper.writeMessage("Введите сумму");
            String s = ConsoleHelper.readString();
            try
            {
                sum = Integer.parseInt(s);
            } catch (NumberFormatException e)
            {
                ConsoleHelper.writeMessage("Только цифры");
                continue;
            }
            if (sum <= 0)
            {
                ConsoleHelper.writeMessage("Цифры больше нуля");
                continue;
            }
            if (!currencyManipulator.isAmountAvailable(sum))
            {
                ConsoleHelper.writeMessage("Не хватает денег");
                continue;
            }
            try
            {
                currencyManipulator.withdrawAmount(sum);
            } catch (NotEnoughMoneyException e)
            {
                ConsoleHelper.writeMessage("Не хватает банкнот");
                continue;
            }
            break;
        }

    }
}
