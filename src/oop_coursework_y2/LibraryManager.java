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
public interface LibraryManager 
{
    public abstract void addNewItem(LibraryItem item);
    public abstract void deleteItem(int ISBN); 
    public abstract void printList();
    public abstract void borrowItem(int ISBN); 
    public abstract void returnItem(int ISBN); 
    public abstract void generateReport(); 

    public abstract boolean runMenu();
    
    
    //public abstract openGUI(); 
    
}
