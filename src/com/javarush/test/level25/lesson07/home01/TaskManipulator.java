package com.javarush.test.level25.lesson07.home01;

public class TaskManipulator implements Runnable,CustomThreadManipulator {
    String threadName;
    Thread thread;

    @Override
    public void run() {
        try{while(!thread.isInterrupted())
                {
                Thread.sleep(0);
                System.out.println(threadName);
                Thread.sleep(90);}
        }
        catch (InterruptedException e){}

    }
    public void start(String threadName){
        this.threadName = threadName;
        thread = new Thread(this);
        thread.start();
    }
    public void stop(){

        thread.interrupt();
    }
}
