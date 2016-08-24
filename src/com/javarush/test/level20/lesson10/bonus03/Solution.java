//package com.javarush.test.level20.lesson10.bonus03;
//
//import java.util.ArrayList;
//import java.util.List;
//
///* Кроссворд
//1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
//2. Метод detectAllWords должен найти все слова из words в массиве crossword.
//3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
//text - это само слово, располагается между начальным и конечным элементами
//4. Все слова есть в массиве.
//5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
//6. Метод main не участвует в тестировании
//*/
//public class Solution {
//    public static void main(String[] args) {
//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
//        detectAllWords(crossword, "home", "same");
//        /*
//Ожидаемый результат
//home - (5, 3) - (2, 0)
//same - (1, 1) - (4, 1)
//         */
//    }
//
//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        List<Word> resultList = new ArrayList<>();
//        Word result = null;
//        for (int f = 0; f < words.length; f++)
//        {
//            char[] c = words[f].toCharArray();
//            for (int l = 0; l < c.length; l++)
//            {
//        for (int i = 0; i < 5; i++)
//        {
//            for (int j = 0; j < crossword[i].length; j++)
//            {
//
//                if(c[l]==crossword[i][j]){
//                    System.out.println(c[l]);
//                    System.out.println(j+" "+i);
//
//                    if (c[l+1]==crossword[i-1][j-1])
//                    {
//                        if(c[c.length-2]==crossword[i-1-(c.length-2)][j-1-(c.length-2)]){
//                            result = new Word("home");
//                            result.setStartPoint(j,i);
//                            result.setEndPoint(j-1-(c.length-2),i-1-(c.length-2));
//                            resultList.add(result);
//                            System.out.println(result);
//                        }
//                    }
////                    if()
////                    if()
////                    if()
////                    if()
////                    if()
////                    if()
////                    if()
//                }
//                else continue;
//
//
//            }
//        }}}
//        return resultList;
//    }
//
//    public static class Word {
//        private String text;
//        private int startX;
//        private int startY;
//        private int endX;
//        private int endY;
//
//        public Word(String text) {
//            this.text = text;
//        }
//
//        public void setStartPoint(int i, int j) {
//            startX = i;
//            startY = j;
//        }
//
//        public void setEndPoint(int i, int j) {
//            endX = i;
//            endY = j;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);

//
