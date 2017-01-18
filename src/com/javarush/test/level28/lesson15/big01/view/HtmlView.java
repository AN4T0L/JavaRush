package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import org.jsoup.nodes.Element;



import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import java.util.List;

/**
 * Created by selezn on 02.01.17.
 */
public class HtmlView implements View
{
    private final String filePath="./src/"+ this.getClass().getPackage().getName().replaceAll("\\.","/")+"/vacancies.html";
    private Controller controller;
    @Override
    public void update(List<Vacancy> vacancies)
    {

        try{
        updateFile(getUpdatedFileContent(vacancies));}
        catch (Exception e){e.printStackTrace();}

    }

    @Override
    public void setController(Controller controller)
    {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod(){
        controller.onCitySelect("Odessa");
    }

    protected Document getDocument() throws IOException{
        File f = new File(filePath);
        return Jsoup.parse(f,"UTF-8");

    }
    private String getUpdatedFileContent(List<Vacancy> vacancies)throws IOException{


         Document   document = getDocument();


        Element element = document.getElementsByClass("template").first();
        Element element1 = element.clone();
        element1.removeAttr("style");
        element1.removeClass("template");
        document.getElementsByAttributeValue("class","vacancy").remove();
        for (int i = 0; i < vacancies.size(); i++)
        {
            Element element2 = element1.clone();
            element2.getElementsByAttributeValue("class","city").append(vacancies.get(i).getCity());
            element2.getElementsByAttributeValue("class", "companyName").get(0).text(vacancies.get(i).getCompanyName());
            element2.getElementsByAttributeValue("class", "salary").get(0).text(vacancies.get(i).getSalary());
            Element link = element2.getElementsByTag("a").get(0);
            link.text(vacancies.get(i).getTitle());
            link.attr("href", vacancies.get(i).getUrl());
            element.before(element2.outerHtml());

        }
        return document.html();
    }

    private void updateFile(String s){
        try(FileWriter writer = new FileWriter(filePath, false))
        {
            writer.write(s);
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
}
