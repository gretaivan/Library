
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

import java.io.BufferedWriter;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.*;
import javax.swing.*;


/**
 *
 * @author ladyg
 */
public class WestminsterLibraryManager implements LibraryManager
{
    //State: instance variables
    private ArrayList <LibraryItem> itemList;
    private static int itemCount = 150;
    private static int bookCount = 100;//library holds max 100 books
    private  static int dvdCount = 50;
    
    //Constructors: initiates the instance onject
    /*This constructor takes in the maximum number of objects (all library items)
    in the Library */
    public WestminsterLibraryManager()
    {
       // bookList = new ArrayList<Book>();
      //  dvdList = new ArrayList<DVD>(); 
        // this list is the combined arrays of book and dvd, hence no type in 2nd diamond
        itemList = new ArrayList<LibraryItem>(itemCount); //bookList, dvdList
    }
    //Behaviour: abstract method from the interface implementation
   
     //MENU
    public boolean runMenu()
    {
        boolean exit = false;
        
        //MENU OPTIONS
        System.out.println("1: to add new item");
        System.out.println("2: to delete an item");
        System.out.println("3: to print the list of the library items");
        System.out.println("4: to borrow and an item");
        System.out.println("5: to return the item");
        System.out.println("6: to generate report for items overdue and fines");
        System.out.println("7: to generate GUI");
        System.out.println("8: to exit");
        System.out.print("Your menu option: ");
        
        Scanner s = new Scanner (System.in);
        
//validatate the user input that it is integer
        int menuChoice = integerValidation();
        
//takes in the selected option numbers and runs the function
        switch(menuChoice)
        {
            case 1: // Add item
                
                System.out.println("Press 1 if you want to add a Book");
                System.out.println("Press 2 if you want to add a DVD");
                //check if input is integer
                int itemChoice = integerValidation();
                
//validate the if it is correct item option
                while(!((itemChoice == 1)||(itemChoice == 2)))
                {
                    System.out.println("Incorrect option selected");
                    itemChoice = integerValidation();
                }
  
//Take the general library item data
                    System.out.print("Enter the title of the item: ");
                    String title = s.next();

                    System.out.print("The genre: ");
                    String genre = s.next();

                    System.out.print("Publication day: ");
                    int day = s.nextInt();
                    System.out.print("Publication month: ");
                    int month = s.nextInt();
                    System.out.print("Publication year: ");
                    int year = s.nextInt();
                    DateTime publicationDate = new DateTime(day, month, year);
                
                switch (itemChoice)
                {
                    case 1: // Book
                        
                        System.out.print("Book publisher: ");
                        String publisher = s.nextLine();
                        s.nextLine();
                        
                        System.out.print("Number of pages in the book: ");
                        int pages = s.nextInt(); 
                        
                        System.out.print("Number of authors: ");
                        int authorCount = integerValidation();
                        ArrayList <Person> authors = new ArrayList <Person>(); 
                        for(int i = 0; i < authorCount; i++)
                        {
                            if(authorCount == 1)
                            {
                                System.out.print("Author name: ");
                            }
                            else
                            {
                                System.out.print((i + 1) + ". Author name: ");
                            }
                            String authorName = s.nextLine();
                            s.nextLine();
                            System.out.print("Surname: ");
                            String authorSurname = s.nextLine();
                         
                            Person author = new Person(authorName, authorSurname);
                            authors.add(author);
                        }
//add all data to create the instance of the book object
                        Book b = new Book(title, genre, publicationDate, publisher, pages, authors);
//call the method and add the object to an array list
                        this.addNewItem(b); 
                        
                        break;
                        
                    case 2: //DVD
                        
                        System.out.print("DVD language: "); 
                        String language = s.nextLine();
                        s.nextLine();
                        
                        System.out.print("DVD subtitles: ");
                        String subtitles = s.nextLine();
                        
                        System.out.print("Producer name: ");
                        String producerName = s.nextLine();
                     
                        System.out.println("Producer surname: ");
                        String producerSurname = s.nextLine();
                        
                        Person producer = new Person(producerName, producerSurname); 
                        
                        System.out.print("Number of actors: ");
                        int actorCount = s.nextInt();
                        ArrayList <Person> actors = new ArrayList <Person>(); 
                        for(int i = 0; i < actorCount; i++)
                        {
                            if(actorCount == 1)
                            {
                                System.out.print("Actor name: ");
                            }
                            else
                            {
                                System.out.print((i + 1) + ". Author name: ");
                            }
                            String actorName = s.nextLine();
                            s.nextLine();
                            System.out.print("Surname: ");
                            String actorSurname = s.nextLine();
                            
                            Person actor = new Person(actorName, actorSurname);
                            actors.add(actor);
                        }
                        
                        DVD d = new DVD(title, genre, publicationDate, language, subtitles, producer, actors);   
                        this.addNewItem(d);
                        
                        break;    
                }
                break;
                
            case 2: //Delete the item
                
                System.out.println("Please give the ISBN for the item that you want to delete: ");
                int deleteISBN = s.nextInt();
                s.nextLine();
                
                this.deleteItem(deleteISBN);
                
                break;
                
            case 3: //print the list
                
                this.printList(); 
                
                break; 
                
            case 4: //Borrow the item
                
                System.out.println("Please give the ISBN for the item that you want to borrow: ");
                int borrowISBN = s.nextInt();
                this.borrowItem(borrowISBN);

                break;
                
            case 5: //Return item
                
                System.out.println("Please give the ISBN for the item that you want to return");
                borrowISBN = s.nextInt();
                this.returnItem(borrowISBN);
                
                break;
            
            case 6: //Generate report
                
                this.generateReport();
                
                break;
                
            case 7: //Create a GUI
                
                openGUI();
                break;
            
            case 8: //exit
                
                exit = true;
                
                break;
                
            default: System.out.println("Please read menu again and choose the correct option");
                     System.out.println("===============================================================================================");
        } //end of menu options     
        return exit;
    } //menu end
    
/*allow user to choose the item to add; has to be in main add the item and 
display number of free spaces; if no spaces display warning*/
    @Override
    public void addNewItem(LibraryItem item)
    {
        switch (item.getItem()){
            case "Book": 
                //System.out.println(bookList.size());
                if(item.getCount() <= bookCount)
                {
                itemList.add(item); 
                System.out.println("===================================================================================================");
                System.out.println(item.getItem() + " has been added.\nLibrary has remaining space for " + (itemCount - itemList.size()) + " items in total out of which is for " + (bookCount - item.getCount() + " book/s"));
                System.out.println("===================================================================================================");
                }
                else
                {   
                    System.out.println("Book cannot be added as there is no space in the library");
                }
                break;
                
            case "DVD": 
                if(item.getCount() <= dvdCount)
                {
                    itemList.add(item); 
                    System.out.println("===============================================================================================");
                    System.out.println(item.getItem() + " has been added.\nLibrary has remaining space for " + (itemCount - itemList.size()) + " items in total out of which is for " + (dvdCount - item.getCount() + "  DVD/s"));
                    System.out.println("===============================================================================================");
                }
                else
                {
                   System.out.println("===============================================================================================");
                   System.out.println("DVD cannot be added as there is no space in the library ");
                   System.out.println("===============================================================================================");
                }
                
                break;
        }     
    }
    
//option 2, print the list with all added library items    
    @Override
    public void printList()
    {
        System.out.println("===============================================================================================");
        System.out.println("Library stocks " + itemList.size() + " items in total: ");
        
        for(int i=0; i < itemList.size(); i++)
        {
            System.out.println("ISBN: " + itemList.get(i).getISBN() + " | Title: " + itemList.get(i).getTitle() + " | Item type: " + itemList.get(i).getItem());
        }
        System.out.println("===============================================================================================");
        System.out.println("");
    }

//option 3:  delete library item by ISBN
    @Override
    public void deleteItem(int ISBN)
    {
        //scan array list for ISBN
        for(int i = 0; i < itemList.size(); i++)
        {
            if((itemList.get(i).getISBN()) == ISBN)
            {
                System.out.println("===============================================================================================");
                System.out.println("The " + itemList.get(i).getItem() + "is deleted from the Library");   
        //find element with this ISBN and remove it
                itemList.remove(i); 
                System.out.println("The library has remaining space for " + (itemCount - itemList.size()) + " items");
                System.out.println("===============================================================================================");
            }
            else
            {
                System.out.println("===============================================================================================");
                System.out.println("Given ISBN is incorrect please check the library list");
                System.out.println("===============================================================================================");
            }
        }
    }
    
//option 4: check if item is available and borrow if it is, else display expected return date
    @Override
    public void borrowItem(int ISBN)
    {
//check all items for the ISBN        
        for(int i = 0; i < itemList.size(); i++)
        {
//find the item with the given ISBN
            if(itemList.get(i).getISBN() == ISBN)
            {
//check if this item has a reader
                if(itemList.get(i).getReader() == null)
                {
                    System.out.println("===============================================================================================");
                    System.out.println("The " + itemList.get(i).getItem() + " is available for borrowing.");
                    Scanner s = new Scanner(System.in);
                    System.out.println("Please provide the Readers details: ");
                    System.out.print("Readers ID: ");
                    String rID = s.nextLine();
                    
                    System.out.print("Full name: ");
                    String rName = s.nextLine();
                    
                    System.out.print("Mobile No: ");
                    String rMobNo = s.nextLine();
                   
                    System.out.print("Email address: ");
                    String rEmail = s.nextLine();
                    
                    Reader r = new Reader(rID, rName, rMobNo, rEmail);
                    itemList.get(i).setReader(r);
                    
                    System.out.print("Please give borrowing day: ");
                    int day = s.nextInt();
                    
                    System.out.print("Please give borrowing month: ");
                    int month = s.nextInt();
                    
                    System.out.print("Please give borrowing year: ");
                    int year = s.nextInt();
                    
                    System.out.print("Please give borrowing hour: ");
                    int hour = s.nextInt();
                    
                    System.out.print("Please give borrowing minutes: ");
                    int minutes = s.nextInt();

                    DateTime borrowedDate = new DateTime(day, month, year, hour, minutes, 00);
                    
                    itemList.get(i).setBorrowedOn(borrowedDate);
                    System.out.println("The " + itemList.get(i).getItem() + " borrowing is complete");
                    System.out.println("===============================================================================================");
//task is complete, get back to the menu
                    runMenu();
                }
                
//if book is borrowed print the estimated return date                
                else
                {
                    
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    
                    System.out.println("===============================================================================================");
                    System.out.println(itemList.get(i).getItem() + ": " + itemList.get(i).getTitle() + " is not available for the borrowing");
                                
//get the data of borrowed date and convert to string
                    String borrowedDateData = itemList.get(i).getborrowedOn().toString();
//instanciate the calendar class
                    Calendar cal = Calendar.getInstance();
//set that formated borrowing date string to the calendar                    
                    try {
                        cal.setTime(format.parse(borrowedDateData));
                    } catch (ParseException ex) {
                        Logger.getLogger(WestminsterLibraryManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
//generate the estimated return date for a book                     
                    if(itemList.get(i).getItem().equals("Book"))
                    {
                        cal.add(Calendar.DATE, 7);
                        String returnDate = format.format(cal.getTime());
                        System.out.println("Expected book return date: " + returnDate);
                        System.out.println("===============================================================================================");
                    }
                    
//generate the estimated return date for a DVD                        
                    else
                    {
                       cal.add(Calendar.DATE, 3);
                       String returnDate = format.format(cal.getTime());
                       System.out.println("Expected book return date: " + returnDate);
                       System.out.println("===============================================================================================");
                    }
                    
                    /*
                    Add would you like to reserve option! y/n
                    */
                    
//return to the menu
                    runMenu();
                }
            }          
            
        }
    }        
              
    @Override
    public void returnItem(int ISBN)
    {
//scan the item array   
        for(int i = 0; i < itemList.size(); i++)
        {
//find the item with the given ISBN
            if(itemList.get(i).getISBN() == ISBN)
            {
                System.out.println("===============================================================================================");
                System.out.println(itemList.get(i).getItem() + ": \"" + itemList.get(i).getTitle() +  "\" matches given ISBN");
                
//item available: give option for borrowing it 
                if(itemList.get(i).getReader() == null)
                {
                    System.out.println("It is not borrowed yet: " + "\nPress 1: to borrow it\nPress 2: to come back to the main menu");
                    int option = integerValidation(); 
                    
                    switch(option)
                    {
                        case 1:
                            borrowItem(itemList.get(i).getISBN());
                            break; 
                            
                        case 2: 
                            runMenu();
                            break; 
                    }
                }
//item borrowed
                else
                {  
                    System.out.print("Type the return day: ");
                    int d = integerValidation(); 
                    System.out.print("Month: ");
                    int m = integerValidation(); 
                    System.out.print("Year: ");
                    int y = integerValidation();
                    System.out.print("Hours: ");
                    int h = integerValidation(); 
                    System.out.print("Minutes: ");
                    int min = integerValidation(); 

                    DateTime returnDate = new DateTime(d, m, y, h, min); 
                    
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");             
//get the data of borrowed date and convert to string
                    String borrowedDateData = itemList.get(i).getborrowedOn().toString();
                    String returnDateData = returnDate.toString();
                     
//calculator is taken from the date class hence we need date instances of borrowing date and return date
                    Date bDate = null;
                    Date rDate = null;
 
                    try 
                    {
//Using the Date class formatter to make sure that calculations are correct
//passing into the 2 date instances the formated Strings
                        bDate = format.parse(borrowedDateData);
                        rDate = format.parse(returnDateData);
                    } 
                    catch (ParseException ex) 
                    {
                        System.out.println(ex.getMessage());
                        Logger.getLogger(WestminsterLibraryManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
        
       //retunDate - borrowDate retutns the difference in milliseconds
	long bLength = rDate.getTime() - bDate.getTime(); 

//get the borrowed date length in days and hours
//counting hours
                    long hours = bLength / (60 * 60 * 1000);
//counting days
                    long days = bLength / (24 * 60 * 60 * 1000);
                    double fee = 0; 

//item: if item is borrowed for 7 days no fee 
                    if(days <= itemList.get(i).getDefaultLoan())
                    {
                        System.out.println("There is no fee for this item loan");
                    }
//for extra 3 days fee rate is 0.2p/h                        
                    else if((days > itemList.get(i).getDefaultLoan())&&(days <= 10))
                    {
                        fee = hours * 0.2; 
                    }
//borrowed for more than extra 3 days 0.5p/h                        
                    else
                    {
                        fee = hours * 0.5; 
                    }
                    
                    System.out.println("You borrowed this item for " + days + " days and " + (hours % 24) + " hours.\nThe overdue fee for this item is: £" + fee); 
                    System.out.println("===============================================================================================");
//the selected item reset to available again
                itemList.get(i).setReader(null);
                itemList.get(i).setBorrowedOn(null);
                   
                runMenu();
                } 
            }
            else
            {
                System.out.println("===============================================================================================");
                System.out.println("There are no items matching given ISBN");
                System.out.println("===============================================================================================");
                runMenu();
            }
        }
    }    
    
    @Override
    public void generateReport()
    {
        System.out.print("Type report day: ");
                    int d = integerValidation(); 
                    System.out.print("Month: ");
                    int m = integerValidation(); 
                    System.out.print("Year: ");
                    int y = integerValidation();
                    System.out.print("Hours: ");
                    int h = integerValidation(); 
                    System.out.print("Minutes: ");
                    int min = integerValidation(); 

                    DateTime reportDate = new DateTime(d, m, y, h, min); 
                    
                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");             
//get the data of borrowed date and convert to string
                    
                    String returnDateData = reportDate.toString();
                    
                    long bLength = 0;
        
        try {
            //open
            FileWriter fw = new FileWriter("libraryList.txt", false);
            BufferedWriter bw = new BufferedWriter(fw);
            
            for(int i = 0; i < itemList.size(); i++){
                if(!(itemList.get(i).getReader() == null))
                {
                    Date bDate = null;
                    Date rDate = null;
                    
                    String borrowedDateData = itemList.get(i).getborrowedOn().toString();
                    try 
                    {
//Using the Date class formatter to make sure that calculations are correct
//passing into the 2 date instances the formated Strings
                        bDate = format.parse(borrowedDateData);
                        rDate = format.parse(returnDateData);
                    } 
                    catch (ParseException ex) 
                    {
                        System.out.println(ex.getMessage());
                        Logger.getLogger(WestminsterLibraryManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    bLength = rDate.getTime() - bDate.getTime(); 

//get the borrowed date length in days and hours
//counting hours
                    long hours = bLength / (60 * 60 * 1000);
//counting days
                    long days = bLength / (24 * 60 * 60 * 1000);
                    double fee = 0; 

//only add to report if item is overdue
                    if(days > itemList.get(i).getDefaultLoan())
                    {
                        
                        if((days > itemList.get(i).getDefaultLoan())&&(days <= 10))
                        {
                             fee = hours * 0.2; 
                        }
//borrowed for more than extra 3 days 0.5p/h                        
                        else
                        {
                            fee = hours * 0.5; 
                        }    
                                      
                        bw.write("ISBN: " + itemList.get(i).getISBN() + "\n");
                        bw.write("Title:" + itemList.get(i).getTitle() + "\n");
                        bw.write("Borrowing Date: " + itemList.get(i).borrowedOn + "\n");
                        bw.write("Reader name: " + itemList.get(i).getReader() + "\n");
                        bw.write("Total fine: £" + fee);
                    }
                }
            }
            
            bw.flush();
            System.out.println("Done");
            
            //close
            bw.close();
            fw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void openGUI()
    {
        // create a table
        CWGUI table = new CWGUI(itemList);
        table.setVisible(true);   
    }
    
    //validate user input that it would be an integer
    public int integerValidation()
    {
        Scanner input = new Scanner(System.in);
        int value = 0;
    
        boolean isValidNumber = false;
                
        while (!isValidNumber) 
        {
            try 
            {
                value = input.nextInt();
                isValidNumber = true;
                 
            } 
            catch (Exception e) 
            {
                System.out.println("Enter a valid number");
                isValidNumber = false;
                input.next();
            }
        }
        return value;
    }
    
  
    
    public static void main(String[] args)
    {                            
        //use the interface and instantiate the westminster library manager object 
        LibraryManager system = new WestminsterLibraryManager(/*150*/);      
        boolean exit = false;
        
        while (!exit)
        {
            exit = system.runMenu(); 
        }  
    }
}

