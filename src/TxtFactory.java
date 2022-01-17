
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acokm
 */
public class TxtFactory implements IGirdiFactory {

    @Override
    public EmployeeList GirdiOku(String file) {
        EmployeeList listOfAllEmployees = new EmployeeList();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
        int lineNumbers = getLineNumberOfFile(file); //kişi sayısı alınır
        String line;
        LineNumberReader lineNumberReader =  new LineNumberReader(new FileReader(file));
        while ((line = br.readLine()) != null) {
            String[] arrOfStr = line.split(",");
            String adSoyad = arrOfStr[1];
            int salary=Integer.parseInt(arrOfStr[2]); 
            
            if(arrOfStr[0].equals("D"))
            {
                EmployeeList list = new EmployeeList();
                Direktor direktor = new Direktor(adSoyad,salary,list);
                if(!arrOfStr[3].equals("Root"))
                {
                    Employee master = getEmployeerWithName(arrOfStr[3],listOfAllEmployees);
                    if(master!=null)
                    {
                        master.getEmployeeList().add(direktor);
                    }
                }
                listOfAllEmployees.add(direktor);
            }
            else if(arrOfStr[0].equals("M"))
            {
                Memur memur = new Memur(adSoyad,salary);
                if(!arrOfStr[3].equals("Root"))
                {
                    Employee master = getEmployeerWithName(arrOfStr[3],listOfAllEmployees);
                    if(master!=null)
                    {
                        master.getEmployeeList().add(memur);
                    }
                }
                listOfAllEmployees.add(memur);
            }     
        }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TxtFactory.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TxtFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfAllEmployees;
    }
    
    public Employee getEmployeerWithName(String name,EmployeeList listOfAllEmployees){
        Employee[] empList = listOfAllEmployees.getList();
        EmployeeIterator empIterator = new EmployeeIterator(empList);
        while(empIterator.hasNext())
        {
            Employee current = empIterator.next();
            if(current.getAdSoyad().contains(name))
            {
                return current;
            }
        }
        return null;
    }
    
    public int getLineNumberOfFile(String file) throws FileNotFoundException, IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int lines = 0;
        while (reader.readLine() != null) lines++;
        reader.close();
        return lines;
    }
}
