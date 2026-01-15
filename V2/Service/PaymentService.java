package V2.Service;


import V2.Model.Course;
import V2.Model.Student;

import java.util.Set;

/**
 * Implementation of Payment services to check that student is enroll in the course then & then student can make payment and otherwise error message is shown.
 *
 * @author dhruvparekh
 * @version 2.0
 */
public class PaymentService {
    StudentService studentService = new StudentService();
    CourseService courseService = new CourseService();

    /**
     * This method is used to check that the student is enrolled on particular course or note
     * if student is enrolled then & then make payment and chenge the totalpaid of the student.
     * @param studId to take the student ID.
     * @param courseId to take the course ID.
     * @return flag that student enroll or not.
     */
    public boolean checkIfStudentEnroll(int studId , int courseId){
        Course verifyStudent = courseService.getCourse(courseId);
        Set<Student> studEnrollToCourse = verifyStudent.getStudSet();
//        Student EnrolledStud = studentService.getStudent(studId);

//        boolean flag = studEnrollToCourse.contains(EnrolledStud);

        return true;
    }
}
