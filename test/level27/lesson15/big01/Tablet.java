package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Danya on 15/01/2017.
 */
public class Tablet extends Observable
{
    private final  int number;
    private static java.util.logging.Logger logger = Logger.getLogger(Tablet.class.getName());

    public Tablet(int number) {
        this.number = number;
    }

    public void createOrder() {
        try {
            Order order = new Order(this);
            if (order.isEmpty())  return;
            ConsoleHelper.writeMessage(order.toString());
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime());
            manager.processVideos();
            setChanged();
            notifyObservers(order);

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    public int getNumber()
    {
        return number;
    }

    @Override
    public String toString()
    {
        return "Tablet{" +
                "number=" + number +
                '}';
    }
}
