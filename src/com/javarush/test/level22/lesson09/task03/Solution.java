package com.javarush.test.level22.lesson09.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/* Составить цепочку слов
В методе main считайте с консоли имя файла, который содержит слова, разделенные пробелом.
В методе getLine используя StringBuilder расставить все слова в таком порядке,
чтобы последняя буква данного слова совпадала с первой буквой следующего не учитывая регистр.
Каждое слово должно участвовать 1 раз.
Метод getLine должен возвращать любой вариант.
Слова разделять пробелом.
В файле не обязательно будет много слов.

Пример тела входного файла:
Киев Нью-Йорк Амстердам Вена Мельбурн

Результат:
Амстердам Мельбурн Нью-Йорк Киев Вена
*/
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        //...
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br1 = new BufferedReader(new FileReader(br.readLine()));

        StringBuilder sbb = new StringBuilder();

        String bufst = "";
        while((bufst = br1.readLine())!=null){
            sbb.append(bufst);
        }
        String[] x = sbb.toString().split(" ");

        StringBuilder result = getLine(x);
        System.out.println(result.toString());
        br.close();
        br1.close();
    }

    public static StringBuilder getLine(String... words)
    {
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();


//        System.out.println(sb.charAt(sb.toString().length() - 2));
        int xOCS = 0;
        boolean isComplete = false;
//        int count = 0;
//        while (!isComplete)
//        {
        int p = 0;
            ArrayList<String> list = new ArrayList<String>(Arrays.asList(words));
            int size = list.size();
            while(!isComplete)
            {
                if(words.length==0){
                    return sb;
                }
                if(list.size()==1){
                    return sb.append(list.get(0));
                }

                if (sb.length() == 0)
                {
                    xOCS = ran.nextInt(words.length);
                    sb.append(list.get(xOCS) + " ");
                    list.remove(xOCS);
//                    System.out.println(sb.toString());

                } else
                {
//                    int coun = list.size();

                    if ((new String((sb.charAt(sb.toString().length() - 2)+"")).equalsIgnoreCase(new String(list.get(0).charAt(0)+""))))
                    {
                        sb.append(list.get(0) + " ");

//                        System.out.println(list.get(0)+" "+p);
//                        p++;
                        list.remove(0);
//                        System.out.println(sb.toString());
//                        System.out.println(list.toString());
                    }
//                    else if(list.size()==coun){count++;
//
//                        System.out.println("ls" + list.size());
//                        if(count==list.size()){
//                            sb.setLength(0);
//                        }}
                    else
                    {
                        list.add(list.get(0));
                        list.remove(0);

//                        System.out.println(list.get(i));
//                        System.out.println(list.toString());
//                        System.out.println(list.toString());
                    }

                    if(list.size()==0) isComplete=true;


                }
            }

//        }
        return sb;
    }

}
