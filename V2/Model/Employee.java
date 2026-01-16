package V2.Model;

/**
 * implementation of POJO Employee Class.
 *
 * @author Dhruv Parekh
 * @version 2.0
 *
 */

public class Employee {
    //here we use below variable as protected cause we innherit this properties in Teacher class.
    protected int empId;
    protected String empName;
    protected byte age;
    protected String role;
    protected double salary;

    public Employee(int empId, String empName, byte age, String role, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.age = age;
        this.role = role;
        this.salary = salary;
    }

    /**
     * This method return the employee Id.
     * @return employee Id of particular employee object.
     */

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public byte getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    /**
     * this method return the role of Employee
     * @return role of employee in string.
     */
    public String getRole(){
        return role;
    }

    public String toString(){
        return "ID : " + empId +" | Name : " + empName + "  | Role : " + role + " |  Salary : " + salary ;

    }
}
