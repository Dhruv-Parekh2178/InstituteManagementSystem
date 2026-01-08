package model;

import java.util.ArrayList;
import java.util.List;


public class Teacher extends Employee {

    private List<Course> courses;

    public Teacher(int empId, String empName, byte age,double salary) {
        super(empId, empName, age,"Trainer", salary);
        this.courses = new ArrayList<>();
    }
    
    public void addCourse(Course course){
          courses.add(course);
    }

    public List<Course> getCourses(){
        return courses;
    }

    public String toString(){
         return "ID : " + empId +
               "| Name : " + empName +
                "| Role : " + role +
                "| Salary : " + salary ;
    }
}
