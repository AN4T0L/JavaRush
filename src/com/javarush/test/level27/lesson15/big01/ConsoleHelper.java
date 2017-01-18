package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by selezn on 08.12.16.
 */
public class ConsoleHelper
{
    private static BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
    public static void writeMessage(String message){
        System.out.println(message);
    }
    public static  String readString() throws IOException{
        return br.readLine();
    }
    public static List<Dish> getAllDishesForOrder()throws IOException {

        List<Dish> list = new ArrayList<>();
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        while(true)
        {

            String s = readString();
            if (s.equalsIgnoreCase("exit"))break;
            try{
            list.add(Dish.valueOf(s));}
            catch (IllegalArgumentException e){
                ConsoleHelper.writeMessage(s+" is not detected");
            }


        }

        return  list;
    }

}
