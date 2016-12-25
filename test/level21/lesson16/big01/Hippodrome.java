package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by Danya on 25/11/2016.
 */
public class Hippodrome
{
    private static ArrayList<Horse>horses = new ArrayList<>();
    public static Hippodrome game;
    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse horse1 = new Horse("Begun",3,0);
        Horse horse2 = new Horse("Runner",3,0);
        Horse horse3 = new Horse("Slower",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();






    }

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public void run(){
        try
        {
            for (int i = 0; i < 100; i++)
            {
                move();
                print();
                Thread.sleep(200);

            }
        }
        catch(InterruptedException e){}
    }
    public void move(){
        for(Horse h :horses)
        {
            h.move();
        }
    }
    public void print(){
        for(Horse h :horses)
        {
            h.print();
        }
        System.out.println();
    }
    public Horse getWinner(){
       int indexOfWinner = 0;
        for(int i=0;i<horses.size();i++)
        {
            if(horses.get(i).getDistance()>horses.get(indexOfWinner).getDistance())
                indexOfWinner = i;

        }
        return horses.get(indexOfWinner);

    }
    public void printWinner(){
        System.out.println("Winner is " +getWinner().getName()+"!");
    }
}
