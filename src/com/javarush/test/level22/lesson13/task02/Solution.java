package com.javarush.test.level22.lesson13.task02;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing


    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");
        if(args.length > 0){
            FileInputStream fis  = new FileInputStream(args[0]);
            FileOutputStream fos = new FileOutputStream(args[1]);
            byte[] buf0 = new byte[fis.available()];
            fis.read(buf0);


            String s0 = new String(buf0);


//            System.out.println(new String(buf1,utf8));
            buf0 = s0.getBytes(windows1251);

//            String s1 = new String(buf0);
//            System.out.println(s1);
            fos.write(buf0);
            fis.close();
            fos.close();
            };
        }
    }

