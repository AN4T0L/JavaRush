package com.javarush.test.level25.lesson05.home01;

/**
 * Created by selezn on 18.09.16.
 */
public class LoggingStateThread extends Thread
{
    Thread thread;

    public LoggingStateThread(Thread t){
        thread=t;
        this.setDaemon(true);
    }

    @Override
    public void run()
    {
        Thread.State state = this.thread.getState();
        System.out.println(state);
        while (state != State.TERMINATED)
        {
            if (state != this.thread.getState())
            {
                state = this.thread.getState();
                System.out.println(thread.getState());
            }


        }
    }
}
