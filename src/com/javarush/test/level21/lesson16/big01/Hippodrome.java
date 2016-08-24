package com.javarush.test.level21.lesson16.big01;

import java.util.ArrayList;

/**
 * Created by selezn on 03.05.16.
 */
public class Hippodrome
{
    public Horse getWinner(){
        Horse winner =  null;
        int distance = 0;
        for (int i = 0; i < getHorses().size(); i++)
        {
            if(getHorses().get(i).distance>distance){
                distance = (int)getHorses().get(i).distance;
                winner = getHorses().get(i);
            }
        }
        return winner;

    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().name+"!");
    }
    public void run(){
        for (int i = 0; i < 100; i++)
        {
            try{
                move();
                print();
            Thread.sleep(200);}
            catch (InterruptedException e){}

        }
    }
    public void move(){
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).move();
        }
    }
    public void print(){
        for (int i = 0; i < horses.size(); i++)
        {
            horses.get(i).print();
            System.out.println();
            System.out.println();
        }
    }
    ArrayList<Horse> horses = new ArrayList<>();

    public ArrayList<Horse> getHorses()
    {
        return horses;
    }
    public static Hippodrome game;

    public static void main(String[] args)
    {
        game = new Hippodrome();
        Horse h1 = new Horse("01",3,0);
        Horse h2 = new Horse("02",3,0);
        Horse h3 = new Horse("03",3,0);
        game.getHorses().add(h1);
        game.getHorses().add(h2);
        game.getHorses().add(h3);
        game.run();
        game.printWinner();


    }
}
