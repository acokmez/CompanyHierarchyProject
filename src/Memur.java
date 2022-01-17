
/**
 *
 * @author acokm
 */
public class Memur implements Employee {

    private String adSoyad;
    private int salary;
    private EmployeeList employeeList;
    
    public Memur(String adSoyad, int salary) {
        this.adSoyad = adSoyad;
        this.salary = salary;
    }

    public Memur(String adSoyad, int salary, EmployeeList list) {
        this.adSoyad = adSoyad;
        this.salary = salary;
        this.employeeList = employeeList;
    }

   

    @Override
    public String showEmployeeDetails() {
        return "M(" + adSoyad + "," + salary + ")";
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

    @Override
    public EmployeeList getEmployeeList() {
        return employeeList;
    }

    /**
     * @param employeeList the employeeList to set
     */
    public void setEmployeeList(EmployeeList employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public void printHierarchy() {
        System.out.println("Memurun altında çalışan olamaz.");
    }

    @Override
    public void printSalary() {
        int count =this.getSalary();  
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
