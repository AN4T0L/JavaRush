package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {

    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {

    }

    public static Solution[] getTwoSolutions() {

        Solution sol = new Solution();
        sol.innerClasses[0] = sol.new InnerClass();
        sol.innerClasses[1] = sol.new InnerClass();
        Solution sol1 = new Solution();
        sol1.innerClasses[0] = sol1.new InnerClass();
        sol1.innerClasses[1] = sol1.new InnerClass();
        Solution masSol[] = new Solution[2];
        masSol[0] = sol;
        masSol[1] = sol1;
        /*вернуть 2 экземпляра
        Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями*/
        return masSol;
    }
}
