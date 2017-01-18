package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;


import java.io.IOException;
import java.util.List;



public class Order
{
    private Tablet tablet;
    protected List<Dish> dishes;

    public Order(Tablet tablet) throws IOException
    {
        this.tablet = tablet;
        initDishes();
    }

    public Tablet getTab(){
        return tablet;
    }

    protected void initDishes() throws IOException{
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public int getTotalCookingTime(){
        int time = 0;
        for (int i = 0; i < dishes.size(); i++)
        {
            time+=dishes.get(i).getDuration();
        }
        return time;
    }

    public String  toString(){
        if(dishes.isEmpty())return "";
        return String.format("Your order: %s of %s",dishes,tablet);
    }



    public List<Dish> getDishes()
    {
        return dishes;
    }
}
