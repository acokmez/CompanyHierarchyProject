// Employee iterator
class EmployeeIterator implements Iterator
{
    Employee[] empList;
  
    // maintains curr pos of iterator over the array
    int pos = 0;
  
    // Constructor takes the array of empList are
    // going to iterate over.
    public  EmployeeIterator (Employee[] empList)
    {
        this.empList = empList;
    }

    @Override
    public Employee next()
    {
        // return next element in the array and increment pos
        Employee emp =  empList[pos];
        pos += 1;
        return emp;
    }
  
    @Override
    public boolean hasNext()
    {
        if (pos >= empList.length || empList[pos] == null)
            return false;
        else
            return true;
    }
}