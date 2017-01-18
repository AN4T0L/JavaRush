package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by selezn on 23.12.16.
 */
public class HHStrategy implements  Strategy
{
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0";
    private static final String referrer = "";

    @Override
    public List<Vacancy> getVacancies(String searchString)
    {
        List<Vacancy> listVacancy = new ArrayList<>();
        int page = 0;
            while(page <10){

            Document document = null;
            try{


            document = getDocument(searchString, page);
            page++;
            }
            catch (Exception e)
            {
            }
                if(document!=null){}
                else {break;}

            Elements elements = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
            if (!elements.isEmpty())
            {
            for (Element E : elements)
            {
                Vacancy vacancy = new Vacancy();
                Elements nameVcncy = E.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title");
                Elements slryVcncy = E.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation");
                Elements adrsVcncy = E.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address");
                Elements cmpnVcncy = E.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer");
                Elements serchres = E.getElementsByAttribute("href");
                vacancy.setCity(adrsVcncy.text());
                vacancy.setCompanyName(cmpnVcncy.text());
                vacancy.setSalary(slryVcncy.text());
                vacancy.setTitle(nameVcncy.text());
                vacancy.setUrl(serchres.attr("href"));
                vacancy.setSiteName("http://hh.ua");

                listVacancy.add(vacancy);


                }
            }
        }

            return listVacancy;

        }



    protected Document getDocument(String searchString, int page) throws IOException{
        String url = String.format(URL_FORMAT, URLEncoder.encode(searchString, "UTF-8"), page);
        url = "http://javarush.ru/testdata/big28data.html";
        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
    }

}
