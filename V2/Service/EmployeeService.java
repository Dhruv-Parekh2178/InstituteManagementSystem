package V2.Service;

import V2.Model.Employee;

import java.util.HashMap;
import java.util.Map;
/**
 * Implementation of employee services like add employee,view all employee.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class EmployeeService {
    public static Map<Integer , Employee> employees = new HashMap<>();

    /**
     * This method is used to add the employee with checking that employee is not already exist to prevent the overwrite.
     * @param employee object of employee
     */
    public void addEmployee(Employee employee){
        if(employees.containsKey(employee.getEmpId())){
            System.out.println("Employee Already exist");
            return;
        }
        employees.put(employee.getEmpId(),employee);
        System.out.println("Employee added successfully.");
    }

    /**
     *
     * This method is used to get the employee object by Id.
     * @param id to take employee Id
     * @return object of employee.
     */

    public Employee getEmployee(int id){
        return employees.get(id);
    }

    /**
     * This method is used to print all the employee.
     */
    public void viewEmployees(){
        if(employees.isEmpty()){
            System.out.println("No employee found");
            return;
        }
        for (Employee value : employees.values()){
            System.out.println(value);
        }
    }
}
