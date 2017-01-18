package com.javarush.test.level27.lesson15.big01.statistic;



import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;



import java.util.*;

/**
 * Created by selezn on 10.12.16.
 */
public class StatisticEventManager
{
    private static StatisticEventManager instance = new StatisticEventManager();
    private StatisticStorage statStore = new StatisticStorage();


    private StatisticEventManager(){}

    public void register(EventDataRow data){
        statStore.put(data);
    }




    public static StatisticEventManager getInstance()
    {
        if(instance==null) instance= new StatisticEventManager();
        return instance;
    }





    private static final int[] TIME_FIELDS =
            {
                    Calendar.HOUR_OF_DAY,
                    Calendar.HOUR,
                    Calendar.AM_PM,
                    Calendar.MINUTE,
                    Calendar.SECOND,
                    Calendar.MILLISECOND
            };

    public TreeMap<Date, Long> getAdvertisementRevenueAgregatedByDay() {
        TreeMap<Date, Long> result = new TreeMap<>();
        for (EventDataRow eventDataRow : statStore.getEvents(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow vEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(vEventDataRow.getDate());
            for(int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            Long dayRevenue = result.get(date) ;
            if (dayRevenue == null) dayRevenue = Long.valueOf(0);
            result.put(date, dayRevenue + vEventDataRow.getAmount());
        }
        return result;
    }

    public TreeMap<Date, HashMap<String, Integer>> getCookWorkloadingAgregatedByDay() {
        TreeMap<Date, HashMap<String, Integer>> result = new TreeMap<>();

        for (EventDataRow eventDataRow : statStore.getEvents(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookDataRow = (CookedOrderEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(cookDataRow.getDate());
            for(int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            HashMap<String, Integer> cooksNameWorkDuration = result.get(date);
            if (cooksNameWorkDuration == null) {
                cooksNameWorkDuration = new HashMap<>();
                result.put(date, cooksNameWorkDuration);
            }
            String cookName = cookDataRow.getCookName();
            Integer cookWorkDuration = cooksNameWorkDuration.get(cookName);
            if (cookWorkDuration == null) cookWorkDuration = Integer.valueOf(0);
            cooksNameWorkDuration.put(cookName, cookWorkDuration + cookDataRow.getTime());
        }
        return result;
    }

    private class StatisticStorage{
        private Map<EventType, List<EventDataRow>> map = new HashMap<>();
        private StatisticStorage(){
            EventType[] evType = EventType.values();
            for (int i = 0; i < evType.length;i++)
            {
                map.put(evType[i],new ArrayList<EventDataRow>());
            }
        }

        private void put(EventDataRow data){
           map.get(data.getType()).add(data);
        }

        private List<EventDataRow> getEvents(EventType eventType) {
            return map.get(eventType);
        }
    }
}
