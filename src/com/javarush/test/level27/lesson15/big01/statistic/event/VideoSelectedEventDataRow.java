package com.javarush.test.level27.lesson15.big01.statistic.event;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;

import java.util.Date;
import java.util.List;

/**
 * Created by selezn on 10.12.16.
 */
public class VideoSelectedEventDataRow implements EventDataRow
{
    List<Advertisement> optimalVideoSet;
    long amount;
    int totalDuration;
    Date currentDate;

    public VideoSelectedEventDataRow(List<Advertisement> optimalVideoSet, long amount, int totalDuration)
    {
        currentDate = new Date();
        this.optimalVideoSet = optimalVideoSet;
        this.amount = amount;
        this.totalDuration = totalDuration;

    }

    public long getAmount()
    {
        return amount;
    }

    @Override
    public EventType getType()
    {
        return EventType.SELECTED_VIDEOS;
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
