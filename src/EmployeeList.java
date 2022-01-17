public class EmployeeList { 
    private Employee[] list = {};
    
    //constructor
    public EmployeeList() {}
    
    public void add(Employee employee) {
        list = addtoList(list,employee);
    }
    
    public Employee[] getList(){
        return list;
    }
    
    
    // array'in boyutunu 1 artırır ve yeni değer ekler
    public static Employee[] addtoList(Employee[] array, Employee emp){
        Employee[] newArray = new Employee[array.length+1];
        
        for(int i=0; i<array.length; i++){
            newArray[i] = array[i];
        }
        
        newArray[newArray.length-1] = emp;
        return newArray;
    }
    
   public Employee findEmployee(String nameString)
    {
        EmployeeIterator empIterator = new EmployeeIterator(list);
        while(empIterator.hasNext())
        {
            Employee current = empIterator.next();
            if(current.getAdSoyad().contains(nameString))
            {
                return current;
            }
        }
        return null;
    }
   
   public void printList()
   {
        for (Employee headEmployee : list) {
            System.out.println("     -" + headEmployee.showEmployeeDetails());
         
            for (Employee employee : headEmployee.getEmployeeList().list) {
                System.out.println("         -" + employee.showEmployeeDetails());
            }
        }
   }
   
   public int calculateSalary()
   {
       int count = 0;
        for (Employee headEmployee : list) {
            count += headEmployee.getSalary();
            for (Employee employee : headEmployee.getEmployeeList().list) {
                count += employee.getSalary();
            }
        }
        return count;
   }

}
