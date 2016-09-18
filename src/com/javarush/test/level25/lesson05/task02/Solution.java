package com.javarush.test.level25.lesson05.task02;


import java.util.logging.Level;
import java.util.logging.Logger;

/* Без дураков
1. Создай private class MyUncaughtExceptionHandler, который на перехват исключения должен подождать половину секунды,
а затем вывести на экран secretKey, имя трэда и сообщение возникшего исключения.
Используй String.format(...). Пример:
super secret key, Thread-0, it's an example
2. Разберитесь в последовательности выполняемого кода и обеспечьте логирование возникновения исключения в п.1.
3. Метод main в тестировании не участвует.
*/
public class Solution {

    public static void main(String[] args) {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
    }

    public class MyThread extends Thread {
        private String secretKey;

        public MyThread(final String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            setDaemon(false);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }


        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler{
            Logger log = Logger.getLogger(MyUncaughtExceptionHandler.class.getName());
            public void uncaughtException(final Thread t,final Throwable e){
                try{
                    Thread.sleep(500);

                    System.out.println(secretKey+", "+t.getName()+", "+ e.getMessage());;
                    System.out.println();
                    log.log(Level.INFO,secretKey+", "+t.getName()+", "+ e.getMessage());


                }
                catch (InterruptedException x){x.printStackTrace();}


            }
        }
    }



}

