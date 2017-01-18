package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.Tablet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


public class TestOrder extends Order
{
    public TestOrder(Tablet tablet) throws IOException
    {
        super(tablet);
        this.initDishes();
    }
    protected void initDishes(){
        ArrayList<Dish> testDishes = new ArrayList<>();
        Dish[] dishesAr = new Dish[Dish.values().length];
        for (int i = 0; i < dishesAr.length; i++)
        {
            dishesAr[i] = Dish.values()[i];
        }
        Random r = new Random();
        Random r1 = new Random();
        int lenDish = r.nextInt(dishesAr.length);
        for (int i = 0; i < lenDish; i++)
        {
            testDishes.add(dishesAr[r1.nextInt(dishesAr.length)]);
        }
        dishes = testDishes;
    }
}
