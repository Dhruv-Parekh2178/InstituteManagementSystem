package V2.Service;

import V2.Model.Course;
import V2.Model.Student;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseService {
    public static Map<Integer , Course> courses = new HashMap<>();

    public void createCourse(Course course){
        courses.put(course.getCourseId(),course);
        course.getTeacher().addCourse(course);
        System.out.println("course Created successfully.");
    }

    public Course getCourse(int id){
        return courses.get(id);
    }

    public void enrollStudent(Student student ,Course course){
        student.enrollCourse(course);
        course.addStudents(student);
        System.out.println("Student enrolled to course successfully.");
    }


    public void viewCourse(){
        if(courses.isEmpty()){
            System.out.println("No courses Found");
        }
        for(Course value : courses.values()){
            System.out.println(value);
        }
    }
}
