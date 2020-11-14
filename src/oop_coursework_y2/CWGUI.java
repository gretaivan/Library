/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author ladyg
 */
public class CWGUI extends JFrame {
    
    JTable libraryTable;
    CWTableModel tableModel;
    ArrayList<LibraryItem> itemList;
  
    //Constructor
    public CWGUI(ArrayList <LibraryItem> itemList)
    {
      
        tableModel = new CWTableModel(itemList);
        libraryTable = new JTable (tableModel);
        
        setBounds(10,10,400,300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
     
        libraryTable.setAutoCreateRowSorter(true);
        
        // color code the type of person: if it is a teacher is green, if student is blue
        libraryTable.getColumnModel().getColumn(3).setCellRenderer(new DefaultTableCellRenderer()
        {
                Color originalColor = null;

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
                {
            
                    Component renderer =  super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

     //color code the type of item if book green, if dvd blue
                    if (value == "Available") {
                        renderer.setBackground(Color.GREEN);
                    } else {
                        renderer.setBackground(Color.BLUE);
                    }

                    return renderer;
                }
        });
      
        JScrollPane scrollPane = new JScrollPane(libraryTable); 
        scrollPane.setPreferredSize(new Dimension(380,280)); 
        
        JPanel panel = new JPanel(); 
        panel.add(scrollPane); 
        add(panel,BorderLayout.CENTER); 
        
    }
}    
    
       
        
       
        
       
        
  
            
                
            
    
    
    
  
    
    
    
    
