package V2.Service;

import V2.Model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *Implementation of the basic students service.
 *
 * @author Dhruv Parekh
 * @version 2.0
 */

public class StudentService {
    public static Map<Integer, Student> students = new HashMap<>();

    public void addStudent(Student student) {
        students.put(student.getStudId(), student);
        System.out.println("student added successfully");
    }

    public void viewStudents() {
        if(students.isEmpty()){
            System.out.println("No Students found");
            return;
        }
        for (Student value : students.values()) {
            System.out.println(value);
        }

    }
    public Student getStudent(int id){
        return students.get(id);
    }
}