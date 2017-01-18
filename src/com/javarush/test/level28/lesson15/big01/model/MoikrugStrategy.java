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
 * Created by selezn on 16.01.17.
 */
public class MoikrugStrategy implements Strategy {
    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";

    public List<Vacancy> getVacancies(String searchString){

        List<Vacancy> result = new ArrayList<>();
        int page = 1;
        try {
            for (Document html = getDocument(searchString, page); html != null; html = getDocument(searchString, ++page)) {
                //Document html = getDocumentFromFile(searchString, page);
                Elements elements = html.select("[id^=job_]");
                if (elements.size() == 0) break;

                for (Element element : elements) {

                    Vacancy vacancy = new Vacancy();

                    vacancy.setSiteName("https://moikrug.ru/");

                    Elements el;

                    el = element.getElementsByClass("title").first().getElementsByTag("a");
                    vacancy.setTitle(el.first().text());
                    vacancy.setUrl(vacancy.getSiteName() + el.attr("href").substring(1));

                    el = element.getElementsByClass("salary");
                    vacancy.setSalary(el.size() != 0 ? el.first().getElementsByTag("div").first().text() : "");

                    el = element.getElementsByClass("location");
                    vacancy.setCity(el.size() != 0 ? el.first().getElementsByTag("a").first().text() : "");

                    el = element.getElementsByClass("company_name").first().getElementsByTag("a");
                    vacancy.setCompanyName(el.first().text());

                    result.add(vacancy);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    protected Document getDocument(String searchString, int page) throws IOException {
        Document html;
        html = Jsoup.connect(String.format(URL_FORMAT, searchString, page))
                .userAgent("Mozilla/5.0 (jsoup)")
                .referrer("https://hh.ua/search/vacancy?text=java+%D0%BA%D0%B8%D0%B5%D0%B2")
                .get();

        return html;
    }

}

//public class MoikrugStrategy implements Strategy
//{
//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
//    private static final String userAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:47.0) Gecko/20100101 Firefox/47.0";
//    private static final String referrer = "";
//
//    @Override
//    public List<Vacancy> getVacancies(String searchString)
//    {
//        List<Vacancy> listVacancy = new ArrayList<>();
//        int page = 0;
//        while(page <10){
//
//            Document document = null;
//            try{
//
//
//                document = getDocument(searchString, page);
//                page++;
//            }
//            catch (Exception e)
//            {
//            }
//            if(document!=null){}
//            else {break;}
//
//            Elements elements = document.getElementsByAttributeValue("class","job  ");
//            if (!elements.isEmpty())
//            {
//                for (Element E : elements)
//                {
//                    Vacancy vacancy = new Vacancy();
//                    Elements nameVcncy = E.getElementsByAttributeValue("class","title");
//                    Elements slryVcncy = E.getElementsByAttributeValue("class","count");
//                    Elements adrsVcncy = E.getElementsByAttributeValue("class","location");
//                    Elements cmpnVcncy = E.getElementsByAttributeValue("class" ,"company_name");
//                    vacancy.setCity(adrsVcncy.text());
//                    vacancy.setCompanyName(cmpnVcncy.get(0).getElementsByTag("a").text());
//                    vacancy.setSalary(slryVcncy.text());
//                    vacancy.setTitle(nameVcncy.text());
//                    vacancy.setUrl("https://moikrug.ru" + nameVcncy.get(0).getElementsByTag("a").attr("href"));
//                    vacancy.setSiteName("https://moikrug.ru");
//
//                    listVacancy.add(vacancy);
//
//
//                }
//            }
//        }
//
//        return listVacancy;
//
//    }
//
//
//
//
//
//
//    protected Document getDocument(String searchString, int page) throws IOException
//    {
//        String url = String.format(URL_FORMAT, URLEncoder.encode(searchString, "UTF-8"),page);
//        url = "http://javarush.ru/testdata/big28data2.html";
//        return Jsoup.connect(url).userAgent(userAgent).referrer(referrer).get();
//    }
//}
