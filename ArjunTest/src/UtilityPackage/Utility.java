/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilityPackage;

import fix.me.im.broken.CSVReader;
import fix.me.im.broken.PersonInfo;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Arjun
 */
public class Utility {
   public Scanner scan;
   
    public void StartScanner() throws FileNotFoundException{
    File csvFile= new File("C:\\Users\\Arjun\\Documents\\TestCSV.csv");
         
 scan= new Scanner(csvFile);
scan.nextLine();
}
    
  
    public boolean ComapareTestParameters() throws FileNotFoundException
    {
       
      
        ArrayList<String>attributes=new ArrayList();
        ArrayList<String>attributes2=new ArrayList();
        
           String entry=scan.nextLine();
          String [] indivFields= entry.split(",");
          

        
        PersonInfo info=new PersonInfo();
      
        info.setFirstName(indivFields[1]);
        info.setLastName(indivFields[0]);
        info.setAge(Integer.parseInt(indivFields[2]));
        info.setZipcode(indivFields[3]);
      
        ArrayList<PersonInfo>l=new ArrayList();
        l.add(info);
        
       for(PersonInfo p:l)
       {
           attributes.add(p.getFirstName());
           attributes.add(p.getLastName());
           attributes.add(Integer.toString(p.getAge()));
           attributes.add(p.getZipcode());
     }
       
          CSVReader r= new CSVReader();
         
          Map m= r.readCSV("C:\\Users\\Arjun\\Documents\\TestCSV.csv");
         ArrayList<PersonInfo> l2= (ArrayList<PersonInfo>)m.get(indivFields[3]);
         
        for (PersonInfo pe:l2)
        {
            attributes2.add(pe.getFirstName());
            attributes2.add(pe.getLastName());
            attributes2.add(Integer.toString(pe.getAge()));
            attributes2.add(pe.getZipcode());
        }
         
               
  
        
        
           return attributes.equals(attributes2);
         
        }
    
}
