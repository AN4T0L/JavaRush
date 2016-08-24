//package com.javarush.test.level19.lesson10.bonus03
//
///* Знакомство с тегами
//Считайте с консоли имя файла, который имеет HTML-формат
//Пример:
//Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
//</span></b></span><span>Super</span><span>girl</span>
//Первым параметром в метод main приходит тег. Например, "span"
//Вывести на консоль все теги, которые соответствуют заданному тегу
//Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
//Количество пробелов, \n, \r не влияют на результат
//Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
//Тег может содержать вложенные теги
//Пример вывода:
//<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
//<span>Turanga Leela</span>
//<span>Super</span>
//<span>girl</span>
//
//Шаблон тега:
//<tag>text1</tag>
//<tag text2>text1</tag>
//<tag
//text2>text1</tag>
//
//text1, text2 могут быть пустыми
//*/
//
//
//import java.util.regex.Matcher
//import java.util.regex.Pattern
//
//object Solution {
//    @JvmStatic fun main(args: Array<String>) {
//        val s = "Info about Leela <span xml:lang=\"en\" lang=\"en\"><b><span>Turanga Leela\n" + "</span></b></span><span>Super</span><span>girl</span>"
//        val pat = Pattern.compile("(?=(<span.*?>(?>[?1]|.)*?</span>))")
//        val pat1 = Pattern.compile("</.*?>")
//        val mat = pat.matcher(s)
//        val mat1 = pat.matcher(s)
//
//        val count = 0
//        val count1 = 0
//
//        val end = 0
//        val sta = 0
//        while (mat.find()) {
//            println(s.substring(mat.start(), mat.end()))
//        }
//
//
//    }
//}
