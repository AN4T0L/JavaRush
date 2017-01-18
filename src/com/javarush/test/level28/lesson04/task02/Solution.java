package com.javarush.test.level28.lesson04.task02;

import java.util.concurrent.ThreadLocalRandom;

/* ThreadLocalRandom
Класс Solution будет использоваться трэдами.
Реализуйте логику всех методов, используйте класс ThreadLocalRandom.
getRandomIntegerBetweenNumbers должен возвращать случайный int между from и to
getRandomDouble должен возвращать случайный double
getRandomLongBetween0AndN должен возвращать случайный long между 0 и n
*/
public class Solution {
    public static int getRandomIntegerBetweenNumbers(int from, int to) {

        int tlr1 = ThreadLocalRandom.current().nextInt(from,to);
        return tlr1;
    }

    public static double getRandomDouble() {

        double tlr2 = ThreadLocalRandom.current().nextDouble();
        return tlr2;
    }

    public static long getRandomLongBetween0AndN(long n) {

        long tlr3 = ThreadLocalRandom.current().nextLong(0,n);
        return tlr3;
    }
}
