/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_coursework_y2;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ladyg
 */
public class CWTableModel extends AbstractTableModel
{
    private String[] columnNames = {"Item","ISBN","Title", "Availability"}; 
    private ArrayList<LibraryItem> itemList; 
    
    public CWTableModel(ArrayList<LibraryItem> itemList)
    {
        this.itemList = itemList;
    }

    @Override
    public int getRowCount() 
    {
        return itemList.size();   
    }

    @Override
    public int getColumnCount() 
    {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) 
    {
        Object temp = null; 
        if (columnIndex == 0) 
        { 
         temp = itemList.get(rowIndex).getItem(); 
        } 
      else if (columnIndex == 1) 
      { 
         temp = itemList.get(rowIndex).getISBN(); 
      } 
      else if (columnIndex == 2) 
      { 
         temp = itemList.get(rowIndex).getTitle(); 
      } 
      else if (columnIndex == 3) 
      { 
          if(itemList.get(rowIndex).getReader() == null)
          {
            temp = "Available";
          }
          else
          {
            temp = "Borrowed";
          }
      } 
      return temp; 
        
    }
    
    @Override
   public String getColumnName(int col) { 
      return columnNames[col]; 
   }
}
   
 
