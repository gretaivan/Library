/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

/**
 *
 * @author Greta Ivanauskaite w1670486
 * Class has been created to avoid unnecessary code for author: Author[] in Book 
 * class;  Producer and actor: Actor[] in the DVD
 * 
 */

public class Person 
{
   

    // State: instance variable
    
   private String name; 
   private String surname; 
    
    // Constructor: initialize the objects to create new instance of the Person
   
   public Person()
   {
       System.out.println("Please provide person details");
   }
   public Person (String name)
   {
       this.name = name;       
   }
    public Person(String name, String surname)
   {
       this.name = name.toUpperCase(); 
       this.surname = surname;
   }

   // Behaviour: instance methods, to change or show the state
  // setters
    
   public void setName(String name)  
   {
       this.name = name; 
   }
   public void setSurname(String surname)
   {
       this.surname = surname; 
   }
  
   //getters
   
   public String getName()
   {
       return name; 
   }
   public String getSurname()
   {
       return surname; 
   }
   //Provides class description and Full Name
   public String toString()
   {
       return name + " " + surname;
   }

    void setName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
}

   
