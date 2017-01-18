package com.javarush.test.level19.lesson10.bonus03;

/* Знакомство с тегами
Считайте с консоли имя файла, который имеет HTML-формат
Пример:
Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>
Первым параметром в метод main приходит тег. Например, "span"
Вывести на консоль все теги, которые соответствуют заданному тегу
Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
Количество пробелов, \n, \r не влияют на результат
Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
Тег может содержать вложенные теги
Пример вывода:
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>

Шаблон тега:
<tag>text1</tag>
<tag text2>text1</tag>
<tag
text2>text1</tag>

text1, text2 могут быть пустыми
*/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        String s = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\n" +
                "</span></b></span><span>Super</span><span>girl</span>";

        Pattern p = Pattern.compile("(<.*?>)");
        Pattern p1 = Pattern.compile("(</.*?>)");
        Matcher m = p.matcher(s);
        Matcher m1 = p1.matcher(s);
        s.replaceAll("\\n","");
        int count = 0;
        int endOfFirstPattern = 0;
        int o = 0;

        do{
            if(count!=0){
                String g = m.group();
                if(Pattern.matches("(</.*?>)",g)){break;}
                System.out.print(g);
                endOfFirstPattern =  m.end();}
            count++;
        }while (m.find());
        count--;
//        System.out.println(endOfFirstPattern);
//        m1.find();
//        final int startOfSecPattern = m1.start();
        String pat = "(</.*?>)"+"{"+count+"}";
//        System.out.println(pat);
        Pattern p2 = Pattern.compile(pat);
        Matcher m2 = p2.matcher(s);
        m2.find(endOfFirstPattern);
        int endOfTwoPart = m2.end();
//        while(m1.find()){
//            m1.find()
//            System.out.print(s.substring(endOfFirstPattern,m1.start()));
//            if(count==0){
////                o = startOfSecPattern;
//                break;}
//            System.out.print(m1.group());
//            count--;
//        }
        System.out.print(s.substring(endOfFirstPattern,endOfTwoPart));
    }
}