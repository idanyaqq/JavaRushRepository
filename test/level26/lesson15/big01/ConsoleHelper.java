package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Danya on 11/01/2017.
 */
public class ConsoleHelper
{
    public static void writeMessage(String message)
    {
        System.out.println(message);
    }
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static String readString() throws InterruptOperationException
    {

        String line = null;
        try
        {
            line = reader.readLine();
            if (line.equalsIgnoreCase("EXIT"))
            {
                throw new InterruptOperationException();
            }
        }
        catch (IOException e)
        {}
        return line;
    }

    public static String askCurrencyCode() throws InterruptOperationException
    {
        while(true)
        {
            writeMessage("Enter currency code");
            String query = readString();
            if (query.length() != 3)
            {
                writeMessage("Incorrect data, try again");
            }
            else
            {
                return query.toUpperCase();
            }
        }
    }
    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException
    {
            while(true)
            {
                System.out.println("Enter rating and amount");
                String[] result = readString().split(" ");
                try
                {
                    if(result.length == 2 && Integer.valueOf(result[0]) > 0 && Integer.valueOf(result[1]) > 0)
                    {
                        return result;
                    }
                    else
                    {
                        writeMessage("Incorrect data, try again");
                    }
                }
                catch(Exception e)
                {
                    writeMessage("Incorrect data, try again");
                    getValidTwoDigits(currencyCode);
                }
            }
        }
    public static Operation askOperation() throws InterruptOperationException
    {
        while (true)
        {
            try
            {
                writeMessage("CHOOSE OPERATION:");
                writeMessage("1 - INFO");
                writeMessage("2 -DEPOSIT");
                writeMessage("3 - WITHDRAW");
                writeMessage("4 - EXIT");
                String operation = readString();
                if (Integer.valueOf(operation) >= 1 || Integer.valueOf(operation) <= 4)
                {
                    return Operation.getAllowableOperationByOrdinal(Integer.valueOf(operation));
                }
                else
                {
                    writeMessage("Incorrect data, try again");
                    continue;
                }
            }
            catch(NumberFormatException e)
            {
                writeMessage("Incorrect data, try again");
                askOperation();
            }

        }
    }

    }

