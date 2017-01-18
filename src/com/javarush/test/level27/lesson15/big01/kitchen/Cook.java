package com.javarush.test.level27.lesson15.big01.kitchen;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;


import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;


public class Cook extends Observable implements Runnable
{
    private volatile boolean busy;
    private String name;
    private LinkedBlockingQueue<Order> queue;

    public Cook(String name)
    {
        this.name = name;
    }
    public String toString(){
        return name;
    }
    public boolean isBusy()
    {
        return busy;
    }
    public void setQueue(LinkedBlockingQueue<Order> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                startCookingOrder(queue.take());
                Thread.sleep(10);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void startCookingOrder(Order order){
        busy = true;
        Tablet tab = order.getTab();
        try{
            Thread.sleep(order.getTotalCookingTime()*10);}
        catch (InterruptedException e){}
        ConsoleHelper.writeMessage("Start cooking - " + order + ", cooking time "+  order.getTotalCookingTime()+"min");
        StatisticEventManager statMan = StatisticEventManager.getInstance();
        statMan.register(new CookedOrderEventDataRow(tab.toString(),this.name,order.getTotalCookingTime()*60,order.getDishes()));
        ConsoleHelper.writeMessage(order + " was cooked by " + this);
        setChanged();
        notifyObservers(order);
        busy = false;
    }
}
