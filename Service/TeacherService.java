package Service;

import model.Teacher;

import Repo.TeacherRepo;

public class TeacherService {
    public void addTeacher(Teacher teacher){
        TeacherRepo.teachers.put(teacher.getEmpId(), teacher);
        System.out.println("teacher Added successfully");
    }

    public Teacher getTeacher(int id){
        return TeacherRepo.teachers.get(id);
    }

    public void viewTeachers(){
        if(TeacherRepo.teachers.isEmpty()){
            System.out.println("No teachers found");
            return;
        }
        TeacherRepo.teachers.values().forEach(System.out::println);
    }
}
