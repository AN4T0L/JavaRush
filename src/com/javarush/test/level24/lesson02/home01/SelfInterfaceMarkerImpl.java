package com.javarush.test.level24.lesson02.home01;

/**
 * Created by selezn on 17.08.16.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker
{
    public SelfInterfaceMarkerImpl(){}
    public void firstmethod(){
        System.out.println("THIS is FIRST method");
    }
    public void secondmethod(){
        System.out.println("THIS is SECOND method");
    }
}
