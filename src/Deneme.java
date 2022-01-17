
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author acokm
 */

public class Deneme {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String fileName = "girdi.txt";
        File file = new File(fileName);
        
        FileFactory fileFac = new FileFactory();
        IGirdiFactory factoryObj = fileFac.getFile(fileFac.getExtensionOfFile(fileName));
        
        EmployeeList empList = factoryObj.GirdiOku(fileName);
        
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter name");

        String name = myObj.nextLine();  // Read user input
        
        Employee a = empList.findEmployee(name);

        a.printHierarchy();
        a.printSalary();
    }
}
