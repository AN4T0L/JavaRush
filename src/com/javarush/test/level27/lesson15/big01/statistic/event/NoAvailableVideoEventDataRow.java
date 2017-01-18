package com.javarush.test.level27.lesson15.big01.statistic.event;

import java.util.Date;

/**
 * Created by selezn on 10.12.16.
 */
public class NoAvailableVideoEventDataRow implements EventDataRow
{
    int totalDuration;
    Date currentDate;

    public NoAvailableVideoEventDataRow(int totalDuration)
    {
        currentDate = new Date();
        this.totalDuration = totalDuration;

    }

    @Override
    public EventType getType()
    {
        return EventType.NO_AVAILABLE_VIDEO;
    }

    @Override
    public Date getDate()
    {
        return currentDate;
    }

    @Override
    public int getTime()
    {
        return totalDuration;
    }
}
