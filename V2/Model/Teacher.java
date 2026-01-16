package V2.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation Of POJO Teacher Class.
 *
 * @author Dhruv Parekh
 * @version 2.0
 *
 */

public class Teacher extends Employee{


    public Teacher(int empId, String empName, byte age,double salary) {
        super(empId, empName, age,"TRAINER", salary);
    }



    public String toString(){
        return "ID : " + empId + " | Name : " + empName + "| Role : " + role + " | Salary : " + salary ;
    }
}
