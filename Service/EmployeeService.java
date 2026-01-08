package Service;

import Repo.EmployeeRepo;
import model.Employee;

public class EmployeeService {
    public void addEmployee(Employee employee){
        EmployeeRepo.employees.put(employee.getEmpId(),employee);
        System.out.println("Employee added successfully");
    }

    public void viewEmployees(){
        if(EmployeeRepo.employees.isEmpty()){
            System.out.println("No employee found");
            return;
        }

        EmployeeRepo.employees.values().forEach(System.out::println);

    }

     public Employee getEmployee(int id){
        return EmployeeRepo.employees.get(id);
     }
}
