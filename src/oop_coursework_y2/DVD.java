/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

import java.util.ArrayList;


public class DVD extends LibraryItem 
{
    private String languages; 
    private String subtitles;  
    private Person producer; 
    private ArrayList <Person> actors = new ArrayList<Person>();
    private static int dvdCounter;
    private static int loan = 3; //number of days that DVD can be borrowed for free
    
    //Contructor 
   public DVD(String title, String sector, DateTime publicationDate, String languages, String subtitles, Person producer, ArrayList <Person> actors)
   {
       super("DVD", title, sector, publicationDate);
       this.languages = languages;
       this.subtitles = subtitles; 
       this.producer = producer; 
       this.actors.addAll(actors);
       dvdCounter++;
   }
   
   //BEHAVIOUR: Setters
    public void setLanguage(String languages)
    {
       this.languages = languages;
    }
   
   public void setSubtitles(String subtitles)
     {
       this.subtitles = subtitles;
    }
   
    public void setProducer(Person producer)
    {
       this.producer = producer;
    }
   
    public void setActors (ArrayList <Person> actors)
    {
       this.actors.addAll(actors);
    }
   
   //Getters
    public String getLanguage()
    {
       return languages;
    }
   
    public String getSubtitles()
    {
        return subtitles; 
    }
    
    public Person getProducer()
    {
        return producer;
    }
    
    public ArrayList <Person> actors ()
    {
        return actors;
    }
    
    @Override
    public String getItem()
    {
        return "DVD";
    }
    @Override
    public int getCount()
    {
        return dvdCounter;
    }
    
    @Override
    public int getDefaultLoan()
    {
        return loan; 
    }
}
