package model;



import java.util.HashSet;
import java.util.Set;

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
    public int getCourseId() {
        return courseId;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    public String getCourseName() {
        return courseName;
    }
    public void addStudents(Student student){
         students.add(student);
    }

    public String toString(){
        return "Course ID : " +courseId+
                " | Name : " + courseName+
                " | Teacher : "+ teacher.empName;
    }

}
