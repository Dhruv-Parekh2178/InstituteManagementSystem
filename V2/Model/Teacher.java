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
    private List<Course> courses;

    public Teacher(int empId, String empName, byte age,double salary) {
        super(empId, empName, age,"Trainer", salary);
        this.courses = new ArrayList<>();
    }

    /**
     * This method is used to assign the courses to the teacher.
     * @param course object of the  course class.
     */
    public void addCourse(Course course){
        courses.add(course);
    }

    /**
     * this method gives us the list of courses that teacher teaches.
     * @return list of courses.
     */
    public List<Course> getCourses(){
        return courses;
    }

    public String toString(){
        return "ID : " + empId + " | Name : " + empName + "| Role : " + role + " | Salary : " + salary ;
    }
}
