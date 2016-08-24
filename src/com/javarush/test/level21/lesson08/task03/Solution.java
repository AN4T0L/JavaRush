package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static void main(String[] args) throws CloneNotSupportedException
    {
        A a= new A(1,2);
        B b = new B(3,4,"Wo");

        C c = new C(5,6,"x");
        A aCl =(A) a.clone();
        C cCl = (C)c.clone();
        System.out.println(a);
        System.out.println(aCl);
        System.out.println(c);
        System.out.println(cCl);

    }
    public static class A implements Cloneable {
        public int i;
        public int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public Object clone()throws CloneNotSupportedException{
            Object a = super.clone();
//            a.i = i;
//            a.j = j;
            return a;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;


        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;

        }public B clone() throws CloneNotSupportedException{
            throw new CloneNotSupportedException();
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B implements Cloneable{
        public C(int i, int j, String name) {
            super(i, j, name);
        }
        public C clone()throws CloneNotSupportedException{
            C c = new C(getI(),getJ(),getName());
            return c;
        }
    }
}
