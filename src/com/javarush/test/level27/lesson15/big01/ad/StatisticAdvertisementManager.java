package com.javarush.test.level27.lesson15.big01.ad;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by selezn on 13.12.16.
 */
public class StatisticAdvertisementManager
{
    private static StatisticAdvertisementManager instance = new StatisticAdvertisementManager();
    private static AdvertisementStorage adStor = AdvertisementStorage.getInstance();

    private StatisticAdvertisementManager(){}

    public static StatisticAdvertisementManager getInstance()
    {
        if(instance == null)instance = new StatisticAdvertisementManager();
        return instance;
    }

    public List<Advertisement> getActiveAdvertisements() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : adStor.list()) {
            if (advertisement.getHits() > 0)
                result.add(advertisement);
        }
        return result;
    }

    public List<Advertisement> getNonActiveAdvertisements() {
        List<Advertisement> result = new ArrayList<>();
        for (Advertisement advertisement : adStor.list()) {
            if (advertisement.getHits() == 0)
                result.add(advertisement);
        }
        return result;
    }

}
