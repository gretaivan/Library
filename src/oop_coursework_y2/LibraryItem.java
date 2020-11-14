/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

/**
 *
 * @author ladyg
 */
public abstract class LibraryItem { 
    // States with the access modifiers that allows subclasses to access it
    private static int itemCounter = 0 ; //+ when item addedd; - when deleted
    protected int ISBN; // when item is added generates the ISBN 
    protected String title; 
    protected String sector; 
    protected DateTime publicationDate; 
    protected DateTime borrowedOn;
    protected Reader reader; 
    
    public LibraryItem (String type, String title, String sector, DateTime publicationDate){
        itemCounter ++;
        ISBN = 1000 + itemCounter; 
        this.title = title;
        this.sector = sector;
        this.publicationDate = publicationDate;
    }
    
    //Bahaviour:  methods
    //Setters
    public void setTitle (String title){
        this.title = title; 
    }
    public void setSector(String sector){
        this.sector = sector;
    }
    public void setPublicationDate(DateTime publicationDate){
        this.publicationDate = publicationDate; 
    }
    public void setReader(Reader r)
    {
        this.reader = r; 
    }
    
    public void setBorrowedOn(DateTime fullDateTime)
    {
        this.borrowedOn = fullDateTime;
    }
    
    //Getters
    public String getTitle(){
        return title; 
    }
    public String getSector(){
        return sector; 
    }
    public String getPublicationDate(){
        return sector; 
    }
    
    public int getISBN(){
        return ISBN;   
    }
    
    public Reader getReader() 
    {
        return reader; 
    }
    public DateTime getborrowedOn()
    {
        return borrowedOn;
    }
   
    public String toString(){
        return "Item ISBN: " + ISBN + "\nTitle: " + title + "\nGenre: " + sector + "\nPublished on: " + publicationDate;
    }
    
    //abstract methods
    public abstract String getItem();
    public abstract int getCount();
    public abstract int getDefaultLoan(); 
}
