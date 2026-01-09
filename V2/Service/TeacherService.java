package V2.Service;

import V2.Model.Teacher;

import java.util.HashMap;
import java.util.Map;

public class TeacherService {
    public static Map<Integer , Teacher> teachers = new HashMap<>();

    public void addTeacher(Teacher teacher){
        teachers.put(teacher.getEmpId(), teacher);
        System.out.println("Teacher added successfully.");
    }

    public Teacher getTeacher(int id){
        return teachers.get(id);
    }

    public void viewTeachers(){
        if(teachers.isEmpty()){
            System.out.println("Teachers Not Found");
            return;
        }
        for(Teacher value : teachers.values()){
            System.out.println(value);
        }
    }
}
