package com.javarush.test.level22.lesson05.task01;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws TooShortStringException
    {

        String u = "JavaRush - лучший сервис обучения Java.";
        String i = getPartOfString(u);
        System.out.println(i);

    }
    public static String getPartOfString(String string) throws TooShortStringException{
            if(string == null || string.isEmpty()){

                throw new TooShortStringException();
            }
            int s = string.indexOf(" ");
            String r = string.substring(s);
        int index = 0;
        char[] x= r.toCharArray();
        int count = 0;
        for (int i = 0; i < x.length; i++)
        {

            if(x[i]==' '){count++;

                }
            if(count == 5){
                index = i;

                break;
            }
        }
        if(count<4){
            throw new TooShortStringException();
        }
        String result = r.substring(1,index);
            return result;

    }

    public static class TooShortStringException extends Exception{
    }
}
