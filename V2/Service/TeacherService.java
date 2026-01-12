package V2.Service;

import V2.Model.Teacher;

import java.util.HashMap;
import java.util.Map;


/**
 * Implementation of Teacher services like Add Teacher,view Teacher.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class TeacherService {
    public static Map<Integer , Teacher> teachers = new HashMap<>();

    /**
     * This method is used to add the Teacher with checking that teacher is not already exist to prevent the overwrite.
     * @param teacher object of Teacher.
     */

    public void addTeacher(Teacher teacher){
        if(teachers.containsKey(teacher.getEmpId())){
            System.out.println("Teacher Already exist");
            return;
        }
        teachers.put(teacher.getEmpId(), teacher);
        System.out.println("Teacher added successfully.");
    }
    /**
     *
     * This method is used to get the teacher object by Id.
     * @param id to take teacher Id
     * @return object of teacher.
     */
    public Teacher getTeacher(int id){
        return teachers.get(id);
    }

    /**
     *This method is used to print all the Teacher.
     */

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
