/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author acokm
 */
public class Direktor implements Employee{
    private String adSoyad;
    private int salary;
    private EmployeeList employeeList;
    
    public Direktor(String adSoyad, int salary, EmployeeList employeeList) {
        this.adSoyad = adSoyad;
        this.salary = salary;
        this.employeeList = employeeList;
    }

    @Override
    public String showEmployeeDetails() 
    {
        return "D(" + adSoyad + "," + salary + ")";
    }

    /**
     * @return the adSoyad
     */
    public String getAdSoyad() {
        return adSoyad;
    }

    /**
     * @param adSoyad the adSoyad to set
     */
    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    /**
     * @return the salary
     */
    public int getSalary() {
        return salary;
    }

    /**
     * @param salary the salary to set
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }


    /**
     * @param employeeList the employeeList to set
     */
    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    @Override
    public void printHierarchy() {
        if(this.getEmployeeList() != null)
        {
            System.out.println("Bu direktörün altında çalışanlar: ");
            EmployeeIterator iterator = new EmployeeIterator(this.getEmployeeList().getList());
            while(iterator.hasNext())
            {
                Employee current = iterator.next();
                System.out.println("-" + current.showEmployeeDetails());
                if(current.getEmployeeList() != null)
                {
                    current.getEmployeeList().printList();
                }
            }
        }
    }

    @Override
    public void printSalary() {
        int count = this.getSalary();  
        if(this.getEmployeeList() != null)
        {
            
            EmployeeIterator iterator = new EmployeeIterator(this.getEmployeeList().getList());
            while(iterator.hasNext())
            {
                Employee current = iterator.next();
                count += current.getSalary();
                if(current.getEmployeeList() != null)
                {
                    count += current.getEmployeeList().calculateSalary();
                }
                
            }
        }
        System.out.println("Bu çalışana ait maliyet: " + count);
    }

    

   
    
}
