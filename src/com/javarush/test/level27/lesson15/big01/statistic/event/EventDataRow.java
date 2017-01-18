package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by selezn on 10.12.16.
 */
public interface EventDataRow
{
    EventType getType();
    Date getDate();
    int getTime();
}
