package com.javarush.test.level23.lesson13.big01;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;

/**
 * Created by selezn on 10.08.16.
 */
public class test
{
    public static void main(String[] args)
    {
        ArrayList<SnakeSection> ss = new ArrayList<>();
        ss.add(new SnakeSection(5,5));

        char[][] matrix = new char[10][10];
//        System.out.println(matrix.length);
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                matrix[i][j]='.';
            }
        }
        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                for (int k = 0; k < ss.size(); k++)
                {
                    if(i==ss.get(k).getX() && j==ss.get(k).getY()){
                        if(k==0){
                    matrix[i][j]='X';}
                        else{matrix[i][j]='x';}
                }}
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

}
