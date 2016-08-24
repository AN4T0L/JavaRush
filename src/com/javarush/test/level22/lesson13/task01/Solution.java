package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
//    public static void main(String[] args)
//    {
//        String h[] = getTokens("level22.lesson13.task01", ".");
//        for (int i = 0; i < h.length; i++)
//        {
//            System.out.println(h[i]);
//        }
//
//    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query,delimiter);
        ArrayList<String> lsit = new ArrayList<>();
        int count = 0;
        String[] h;
        while(st.hasMoreTokens()){
//
            lsit.add(st.nextToken());
//            System.out.println(st.nextToken());

        }
        String[] l = new String[lsit.size()];
        for (int i = 0; i < lsit.size(); i++)
        {
            l[i]  = lsit.get(i);
        }



        return l;
    }
}
