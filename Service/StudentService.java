package Service;

import Repo.EmployeeRepo;
import Repo.StudentRepo;
import model.Student;



public class StudentService {
    public void addStudent(Student student){
        StudentRepo.students.put(student.getStudId(),student);
    }
    public Student getStudent(int id){
        return StudentRepo.students.get(id);
    }

    public void viewStudents(){
          if(StudentRepo.students.isEmpty()){
            System.out.println("No students found");
            return;
        }
        StudentRepo.students.values().forEach(System.out::println);
    }
}
