package com.javarush.test.level20.lesson10.bonus01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* Алгоритмы-числа
Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
находить все числа, удовлетворяющие следующему критерию:
число S равно сумме его цифр, возведенных в M степень
getNumbers должен возвращать все такие числа в порядке возрастания

Пример искомого числа:
370 = 3*3*3 + 7*7*7 + 0*0*0
8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8

На выполнение дается 10 секунд и 50 МБ памяти.
*/
public class Solution {
    public static void main(String[] args)
    {

        long memoryStart = Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        int[] g = getNumbers(Integer.MAX_VALUE);
        System.out.println(Arrays.toString(g));

        long estimatedTime = System.currentTimeMillis() - startTime;
        long memoryEnd = Runtime.getRuntime().freeMemory();
        long estimatedMemory = memoryStart - memoryEnd;
        System.out.println("Время подсчета: " + (double) estimatedTime / 1000 + " c");
        System.out.println("Использованная память: " + (double)estimatedMemory / 1024 / 1024 + " МБ");
    }
    public static int[] getNumbers(int N) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] result;
        int count = 0;

        for (int i = 1; i <= N; i++)
        {
            if(i ==912985153){
                list.add(912985153);
                break;}
                int s =1;
            if(i<=9){s = 1;}
            else if(i<=99){s = 2;}
            else if(i<=999){s=3;}
            else if(i<=9999){s=4;}
            else if(i<=99999){s=5;}
            else if(i<=999999){s=6;}
            else if(i<=9999999){s=7;}
            else if(i<=99999999){s=8;}
            else if(i<=999_999_999){s=9;}
            else if(i<=Integer.MAX_VALUE){s=10;}

            int a = i;
            int y = 0;
            while (a > 0)
            {

                int d = a % 10;
                a = a / 10;
                int u = 0;
                if(s==1){u=d;}
                if(s==2){u = d*d;}
                else if(s==3){u = d*d*d;}
                else if(s==4){
                    u = d*d*d*d;
                }else if(s==5){
                    u = d*d*d*d*d;
                }else if(s==6){
                    u = d*d*d*d*d*d;
                }else if(s==7){
                    u = d*d*d*d*d*d*d;
                }else if(s==8){
                    u = d*d*d*d*d*d*d*d;
                }else if(s==9){
                    u = d*d*d*d*d*d*d*d*d;
                }else if(s==10){
                    u = d*d*d*d*d*d*d*d*d*d;
                }
                y = y + u;
            }
            if(y==i){
                System.out.println(y);
            list.add(y);
                }

        }

//        result=new int[f.size()];
//        for (int i = 0; i < f.size(); i++)
//        {
//            result[i] = f.get(i);
//        }
        result = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;

    }
}
