package com.javarush.test.level17.lesson10.home02;

/* Comparable
Реализуйте интерфейс Comparable<Beach> в классе Beach, который будет использоваться нитями.
*/

import java.util.TreeMap;
import java.util.TreeSet;

public class Beach implements Comparable<Beach> {
    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    @Override
    public  int compareTo(Beach o)
    {
        int resultquality = quality - o.quality;
        int resultdistance = (int)(distance - o.distance);
        return 1000*name.compareTo(getName())+ 100* resultdistance + resultquality;

    }

    public synchronized String getName() {
        return name;
    }

    public  synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public  synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

    public static void main(String[] args)
    {
        TreeSet<Beach> beachTreeMap = new TreeSet<Beach>();
        beachTreeMap.add(new Beach("kekb",200,8));
        beachTreeMap.add(new Beach("kekb1",300,9));
        beachTreeMap.add(new Beach("kekb2",400,2));
        beachTreeMap.add(new Beach("kekb3",500,5));
        for(Beach beach : beachTreeMap)
        {
            System.out.println(beach.getName()+" "+beach.getDistance()+" "+ beach.getQuality());
        }
    }

}

