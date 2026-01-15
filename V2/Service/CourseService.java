package V2.Service;

import V2.Model.Course;
import V2.Model.Student;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Implementation of course services like create course,view course,enroll student to course.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class CourseService {
    public static Map<Integer , Course> courses = new HashMap<>();

    /**
     * This method is used to create the employee with checking that course is not already exist to prevent the overwrite.
     *
     * @param course take object of course.
     */
    public void createCourse(Course course){

        if(courses.containsKey(course.getCourseId())){
            System.out.println("Course Already exist");
            return;
        }
        courses.put(course.getCourseId(),course);
        course.getTeacher().addCourse(course);
        System.out.println("course Created successfully.");
    }

    /**
     * This method used to get course from course Id.
     * @param id take courseId.
     * @return object of course.
     */
    public Course getCourse(int id){
        return courses.get(id);
    }

    /**
     *
     * This method is used to enroll the student into particular course.
     * @param student take student object.
     * @param course take course object.
     */
    public void enrollStudent(Student student ,Course course){
//        student.enrollCourse(course);
//        course.addStudents(student);
//        System.out.println("Student enrolled to course successfully.");
    }

    /**
     * this method is used to show all the courses.
     */
    public void viewCourse(){
        if(courses.isEmpty()){
            System.out.println("No courses Found");
        }
        for(Course value : courses.values()){
            System.out.println(value);
        }
    }
}
