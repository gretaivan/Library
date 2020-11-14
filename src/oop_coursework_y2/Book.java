/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

import java.util.ArrayList;

/**
 *
 * @author ladyg
 */
public class Book extends LibraryItem{
    
    //private int totalAuthors; //variable sets the total number of authors
    private ArrayList <Person> listAuthors = new ArrayList <Person> ();
    private String publisher; 
    private int pages; 
    private static int bookCounter; //counts number how many books have been added at the class level
    private static int loan = 7; //number of days that book is borrowed for free
    
//Constructors  
    public Book(String title, String sector, DateTime publicationDate, String publisher, int pages, ArrayList <Person> givenAuthorsList)
    {  
        super("Book", title, sector, publicationDate); 
        this.publisher = publisher; 
        this.pages = pages;
        //element below needs testing!
        listAuthors.addAll(givenAuthorsList);
        bookCounter++;
    }

//Setters    
    public void setAuthors(ArrayList <Person> givenAuthorsList)
    {
        listAuthors.addAll(givenAuthorsList);
    }
    
    public void setPublisher (String publisher)
    {
        this.publisher = publisher;
    }     
    
    public void setPager(int pages)
    {
        this.pages = pages;
    }

//Getters
    public String getPublisher()
    {
        return publisher;
    }
    
    public int getPages()
    {
        return pages;                     
    }
                    
    @Override
    public String getItem ()
    {
       return "Book"; 
    }
    @Override
    public int getCount()
    {
       return bookCounter;
    }
    
    @Override
    public int getDefaultLoan()
    {
        return loan; 
    }
    @Override
    public String toString()
    {
       return super.toString() + "\nAuthors: " + listAuthors + "\npublished by: " + publisher + "\nno of pages: " + pages + "\nTotal number of books in the library: " + bookCounter; 
    }
    
   
}
