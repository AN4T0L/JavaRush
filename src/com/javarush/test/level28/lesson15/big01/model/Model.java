package com.javarush.test.level28.lesson15.big01.model;

;
import com.javarush.test.level28.lesson15.big01.view.View;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by selezn on 02.01.17.
 */
public class Model
{
    private  View view;
    private  Provider[] providers;


    public Model(View view, Provider[] providers)
    {
        if(view==null || providers==null || providers.length==0) throw new IllegalArgumentException();
        this.view = view;
        this.providers = providers;
    }

    public void selectCity(String city){
        List<Vacancy> list = new ArrayList<>();
        for (int i = 0; i < providers.length; i++)
        {
           list.addAll(providers[i].getJavaVacancies(city));

        }
        view.update(list);
    }
}
