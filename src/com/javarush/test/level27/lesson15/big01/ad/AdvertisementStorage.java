package com.javarush.test.level27.lesson15.big01.ad;

import java.util.*;



 class AdvertisementStorage
{
    private final List<Advertisement> videos = new ArrayList<>();
    private static  AdvertisementStorage instance = new AdvertisementStorage();
    private AdvertisementStorage()
    {
        Object someContent = new Object();
        videos.add(new Advertisement(someContent, "First Video", 5000, 100, 3 * 60)); // 3 m++
        videos.add(new Advertisement(someContent, "РУс", 5000, 1, 3 * 60)); // 3 m++
        videos.add(new Advertisement(someContent, "Щапла", 5000, 10, 3 * 60)); // 3 m++
        // in
        videos.add(new Advertisement(someContent, "Second Video", 100, 10, 15 * 60)); //15 min
        videos.add(new Advertisement(someContent, "Third Video", 400, 2, 10 * 60));  //10 min
        videos.add(new Advertisement(someContent, "Some v", 400, 1, 10 * 60));  //10 min

    }

    public  List<Advertisement> list(){
        return videos;
    }

    public  void add(Advertisement advertisement) {
        videos.add(advertisement);
    }

    public static AdvertisementStorage getInstance() {
        if (instance == null) {
            instance = new AdvertisementStorage();
        }
        return instance;
    }
}
