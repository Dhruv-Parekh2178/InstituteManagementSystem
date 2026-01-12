package V2.Service;

import V2.Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Implementation of the basic students service like add student and View Student.
 *
 * @author Dhruv Parekh
 * @version 2.0
 */

public class StudentService {
    public static Map<Integer, Student> students = new HashMap<>();
    /**
     * This method is used to add the student with checking that student is not already exist to prevent the overwrite.
     * @param student object of student
     */
    public void addStudent(Student student) {
        if(students.containsKey(student.getStudId())){
            System.out.println("Student Already exist");
            return;
        }
        students.put(student.getStudId(), student);
        System.out.println("student added successfully");
    }

    /**
     * This method is used to print all the student.
     */

    public void viewStudents() {
        if(students.isEmpty()){
            System.out.println("No Students found");
            return;
        }
        for (Student value : students.values()) {
            System.out.println(value);
        }

    }

    /**
     *
     * This method is used to get the student object by Id.
     * @param id to take student Id
     * @return object of employee.
     */
    public Student getStudent(int id){
        return students.get(id);
    }
}