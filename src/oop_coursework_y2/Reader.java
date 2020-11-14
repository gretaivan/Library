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
public class Reader {
    private String Id;
    private String name;
    private String mobileNumber;
    private String email; 
    
    //constructor
    public Reader(String ID, String name, String mobileNumber, String email){
        this.Id = Id;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email; 
    }
    //Methods setters
    public void setID (String id){
        this.Id = id; 
    }
    public void setName (String name){
        this.name = name;
    }
    public void setMobileNo (String mobileNumber){
        this.mobileNumber = mobileNumber;
    }
    public void setEmail(String email){
        this.email = email;    
    }
    //Getters
    public String getId (){
        return Id;
    }
    public String getName (){
        return name;
    }
    public String getMobileNo (){
        return mobileNumber; 
    }
    public String getEmail (){
        return email; 
    }
    public String toString(){
        return "Reader ID: " + Id + "\nName: " + name + "\nMobile Number: " + mobileNumber + "\nEmail Address: " + email; 
    }
    
}
