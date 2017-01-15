package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level17.lesson10.home08.NotEnoughMoneyException;

import java.util.*;


/**
 * Created by Danya on 11/01/2017.
 */
public class CurrencyManipulator
{
    private String currencyCode;

    private Map<Integer, Integer> denominations ;

    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        denominations = new HashMap<Integer,Integer>();
    }

    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if(denominations.containsKey(denomination))
        {
            denominations.put(denomination, denominations.get(denomination) + count);
        }
        else
        {
            denominations.put(denomination, count);
        }
    }
    public int getTotalAmount()
    {
        int total=0;
        for(Map.Entry<Integer,Integer> map : denominations.entrySet())
        {
            total+=map.getValue()*map.getKey();
        }
        return total;
    }
    public boolean hasMoney()
    {
        boolean result = true;
        if(denominations.isEmpty())  result = false;
        else
        {
            int countZero = 0;
            for(Map.Entry<Integer,Integer> pair : denominations.entrySet())
            {
                if(pair.getValue() ==0) countZero++;
            }
            if(countZero == denominations.size()) result = false;
        }
        return result;
    }
    public boolean isAmountAvailable(int expectedAmount)
    {
        if(getTotalAmount()-expectedAmount>0)
            return true;
        else return false;
    }
    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException
    {
        int sum = expectedAmount;
        HashMap<Integer, Integer> temp = new HashMap<>();
        temp.putAll(denominations);
        ArrayList<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> pair : temp.entrySet())
            list.add(pair.getKey());

        Collections.sort(list);
        Collections.reverse(list);

        TreeMap<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());

        for (Integer aList : list) {
            int key = aList;
            int value = temp.get(key);
            while (true) {
                if (sum < key || value <= 0) {
                    temp.put(key, value);
                    break;
                }
                sum -= key;
                value--;

                if (result.containsKey(key))
                    result.put(key, result.get(key) + 1);
                else
                    result.put(key, 1);
            }
        }

        if (sum > 0)
            throw new NotEnoughMoneyException();
        else
        {
            for (Map.Entry<Integer, Integer> pair : result.entrySet())
                ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());

            denominations.clear();
            denominations.putAll(temp);
            ConsoleHelper.writeMessage("Transaction was successful!");
        }
        return result;
    }
}
