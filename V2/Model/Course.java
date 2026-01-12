package V2.Model;

import java.util.HashSet;
import java.util.Set;

/**
 * Implementation of POJO Course Class
 *
 * @author dhruvparekh
 * @version 2.0
 *
 */

public class Course {
    private int courseId;
    private String courseName;
    private Teacher teacher;
    private Set<Student> students;
    public Course(int courseId, String courseName, Teacher teacher) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.teacher = teacher;
        this.students = new HashSet<>();
    }

    /**
     * This method return the courseId.
     * @return  courseId of the particular course.
     */

    public int getCourseId() {
        return courseId;
    }

    /**
     *This method Return the Teacher Object who is Teach particular course.
     *
     * @return Object of Teacher class
     */
    public Teacher getTeacher() {
        return teacher;
    }

    /**
     * This methos return the Course Name.
     * @return courseName of type String.
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * this method is used to add the student to particular course.
     * @param student take student object as a parameter
     */
    public void addStudents(Student student){
        students.add(student);
    }

    /**
     * This method return the set of student who bought the particular course.
     *
     * @return set of student for particular course
     */
    public Set<Student> getStudSet(){
        return students;
    }

    public String toString(){
        return "Course ID : " +courseId+ " | Name : " + courseName+ " | Teacher : "+ teacher.empName;
    }
}
