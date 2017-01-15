package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;



/**
 * Created by Danya on 11/01/2017.
 */
  class ExitCommand implements Command
{
    @Override
    public void execute() throws InterruptOperationException
    {
            ConsoleHelper.writeMessage("Are you want to EXIT: y/n");
            String answer = ConsoleHelper.readString();
            if (answer.equalsIgnoreCase("y")) ConsoleHelper.writeMessage("Goodbye");
    }
}
