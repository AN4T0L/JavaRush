package com.javarush.test.level21.lesson16.big01;

/**
 * Created by selezn on 03.05.16.
 */
public class Horse
{
     String name;
     double speed;
     double distance;

    public Horse(String name, double speed, double distance)
    {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }
    public void print(){
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < (int)distance; i++)
        {
            x.append(".");
        }
        System.out.println(x+name);
    }
    public void move(){
        this.distance+=this.
                speed*Math.random();
    }

    public String getName()
    {
        return name;
    }

    public double getSpeed()
    {
        return speed;
    }

    public double getDistance()
    {
        return distance;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSpeed(double speed)
    {
        this.speed = speed;
    }

    public void setDistance(double distance)
    {
        this.distance = distance;
    }
}
