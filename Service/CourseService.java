package Service;

import Repo.CourseRepo;
import model.Course;
import model.Student;

public class CourseService {
    
    public void createCourse(Course course){
        CourseRepo.courses.put(course.getCourseId(),  course);
        course.getTeacher().addCourse(course);
        System.out.println("course created successfully");
    }
    
    public Course getCourse(int id){
        return CourseRepo.courses.get(id);
    }
    
    public void enrollStudent(Student student , Course course){
        student.enrollCourse(course);
        course.addStudents(student);
        System.out.println("Student enrolled to course successfully.");
    }

    public void viewCourses(){
        if(CourseRepo.courses.isEmpty()){
            System.out.println("no courses found");
            return;
        }
        CourseRepo.courses.values().forEach(System.out::println);
    }
}
    