package V2.Service;

import V2.Model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService {
    public static Map<Integer , Employee> employees = new HashMap<>();

    public void addEmployee(Employee employee){
        employees.put(employee.getEmpId(),employee);
        System.out.println("Employee added successfully.");
    }

    public Employee getEmployee(int id){
        return employees.get(id);
    }

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
