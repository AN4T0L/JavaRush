package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.*;

/**
 * Created by selezn on 08.12.16.
 */
public enum Dish
{

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);
    private int duration;
     Dish(int duration){
        this.duration=duration;
    }
    public int getDuration()
    {
        return duration;
    }


    public static String allDishesToString(){


        return Arrays.toString(Dish.values()).replaceAll("\\]|\\[","");
    }
}
