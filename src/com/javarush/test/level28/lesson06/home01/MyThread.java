package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Created by selezn on 20.11.16.
 */
public class MyThread extends Thread
{    private static int counter1 = 0;
     private  int counter = ++counter1;

    public  void setPrior(){



    int i = counter;
        if(i==10)counter1 = 0;
        if(i>Thread.currentThread().getThreadGroup().getMaxPriority()){
            this.setPriority(this.getThreadGroup().getMaxPriority());
            return;
        }
        this.setPriority(i);}

    public MyThread()
    {this.setPrior();
    }



    public MyThread(Runnable target)
    {
        super(target);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target)
    {
        super(group, target);
        setPrior();
    }

    public MyThread(String name)
    {
        super(name);
        setPrior();
    }

    public MyThread(ThreadGroup group, String name)
    {
        super(group, name);
        this.setPrior();

    }

    public MyThread(Runnable target, String name)
    {
        super(target, name);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name)
    {
        super(group, target, name);
        setPrior();
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize)
    {
        super(group, target, name, stackSize);
        setPrior();
    }
}
