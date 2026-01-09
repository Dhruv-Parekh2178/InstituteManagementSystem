package V2;

import V2.CustomException.InvalidAgeException;
import V2.CustomException.InvalidMarksException;
import V2.Model.Course;
import V2.Model.Employee;
import V2.Model.Student;
import V2.Model.Teacher;
import V2.Service.CourseService;
import V2.Service.EmployeeService;
import V2.Service.StudentService;
import V2.Service.TeacherService;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Implementation of Institution management System with core Java without using database.
 *
 * Handles the menu to choose option and take input form the users and give it to the custom exception to check the input.
 *
 * @author Dhruv Parekh
 * @version 2.0
 *
 */

public class InstituteAppV2 {
    public static void main(String[] args) {
        try{
        boolean flag = true;
            StudentService studentService = new StudentService();
            EmployeeService employeeService = new EmployeeService();
            CourseService courseService = new CourseService();
            TeacherService teacherService = new TeacherService();
            do{
           /* This menu given to the user every time */
           System.out.println("<=================  Institute Management System ====================>");
           System.out.println("1. Add Student.");
           System.out.println("2. View all Students.");
           System.out.println("3. Add Employee.");
           System.out.println("4. View all Employee.");
           System.out.println("5. Add Teacher.");
           System.out.println("6. View all Teacher.");
           System.out.println("7. Create Course.");
           System.out.println("8. View all course.");
           System.out.println("9. Enroll Student to Course.");
           System.out.println("10. Show Student Course.");
           System.out.println("11. Make Payment.");
           System.out.println("12. Exit");
           System.out.println("Choose Option:");

           Scanner sc = new Scanner(System.in);

           byte option = sc.nextByte();


       //enhanced switch case for checking option and do task appropriate.
           switch(option){
               /*----------- student ------------*/

               case 1 -> {
                   int studId;
                   byte age;
                   byte marks;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                       studId = sc.nextInt();
                   } catch (InputMismatchException e) {
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }
                   // take student Name from user
                   System.out.println("Enter Student Name :");
                   String studName = sc.next();


                   //take student age
                   System.out.println("Enter Student Age : ");
                   // check that the age of student is between 6 to 100.
                   try {
                       age = sc.nextByte();
                       if (age <= 5 || age > 100) {
                           throw new InvalidAgeException("!!!! invalid age -> enter student age between 6 to 100. !!!!!");
                       }
                   } catch (InputMismatchException e) {
                       throw new RuntimeException("!!!!! enter Valid Student Age !!!!!");
                   }
                   //take student marks
                   System.out.println("Enter Student marks : ");


                   // check that the marks of student is between 0 to 100.
                   try {
                       marks = sc.nextByte();
                       if ((marks < 0) || (marks >= 100)) {
                           throw new InvalidMarksException("!!!! invalid marks -> enter student age between 0 to 100. !!!!!");
                       }
                   } catch (InputMismatchException e) {
                       throw new RuntimeException("!!!!! enter Valid Student marks !!!!!");
                   }


                   studentService.addStudent(new Student(studId,studName,age,marks));
               }


               case 2 -> {
                 studentService.viewStudents();

               }

               case 3 -> {
                   int empId;
                   byte age;
                   int salary;

                   // take employee ID form user
                   System.out.println("Enter employee ID :");
                   try {
                       empId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid employee ID. !!!!");
                   }
                   // take employee Name from user
                   System.out.println("employee Name :");
                   String empName = sc.next();
                   //take employee age
                   System.out.println("Enter employee Age : ");


                   // check that the age of employee is between 17 to 100.
                   try{
                        age = sc.nextByte();
                       if(age <= 17 || age > 100){
                           throw new InvalidAgeException("!!!! invalid age -> enter employee age between 17 to 100. !!!!!");
                       }
                   }
                   catch (InputMismatchException e){
                       throw new RuntimeException("!!!!! enter Valid employee Age !!!!!");
                   }

                   // take employee Role from user
                   System.out.println("Enter employee Role :");
                   String role  = sc.next();

                   // take employee salary form user
                   System.out.println("Enter employee Salary :");
                   try {
                        salary = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid employee salary. !!!!");
                   }
                 employeeService.addEmployee(new Employee(empId,empName,age,role,salary));


               }

               case 4 -> {
                   employeeService.viewEmployees();
               }

               case 5 -> {
                   int empId;
                   byte age;
                   int salary;
                   // take teacher ID form user
                   System.out.println("Enter teacher ID :");
                   try {
                        empId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid teacher ID. !!!!");
                   }
                   // take Teacher Name from user
                   System.out.println("teacher Name :");
                   String empName = sc.next();
                   //take Teacher age
                   System.out.println("Enter teacher Age : ");

                   // for teacher the default role is trainer
                   // check that the age of teacher is between 17 to 100.
                   try{
                        age = sc.nextByte();
                       if(age <= 17 || age > 100){
                           throw new InvalidAgeException("!!!! invalid age -> enter teacher age between 17 to 100. !!!!!");
                       }
                   }
                   catch (InputMismatchException e){
                       throw new RuntimeException("!!!!! enter Valid teacher Age !!!!!");
                   }

                   // take teacher Role from user
                   System.out.println("Enter teacher Role :");
                   String role  = sc.nextLine();

                   // take teacher salary form user
                   System.out.println("Enter teacher Salary :");
                   try {
                        salary = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid teacher salary. !!!!");
                   }

                teacherService.addTeacher(new Teacher(empId,empName,age,salary));

               }

               case 6 -> {
                  teacherService.viewTeachers();

               }

               case 7 -> {
                   int courseId;
                   //teacher Id
                   int tId;
                   // take course ID form user
                   System.out.println("Enter course ID :");
                   try {
                        courseId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid course ID. !!!!");
                   }
                   // take Teacher Name from user
                   System.out.println("course Name :");
                   String courseName= sc.next();

                   System.out.println("Enter Teacher ID :");
                   try {
                       tId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid course ID. !!!!");
                   }

                   Teacher teacher = teacherService.getTeacher(tId);
                   if(teacher == null){
                       System.out.println("Invalid Teacher ID");
                       break;
                   }
                   courseService.createCourse(new Course(courseId,courseName,teacher));

               }

               case 8 -> {
                 courseService.viewCourse();
               }

               case 9 ->{
                   int studId;
                   int courseId;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                        studId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }
                   // take course ID form user
                   System.out.println("Enter course ID :");
                   try {
                       courseId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid course ID. !!!!");
                   }

                  Student student = studentService.getStudent(studId);
                   Course course = courseService.getCourse(courseId);

                   if (student == null || course == null) {
                       System.out.println("Invalid Student ID or Course ID.");
                       break;
                   }

                   courseService.enrollStudent(student,course);
               }

               case 10 -> {
                   int studId;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                        studId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }

                   Student student = studentService.getStudent(studId);
                   if(student == null){
                       System.out.println("student not found");
                       break;
                   }

                   System.out.println("courses enrolled by Student ID" + studId + ":");
                   if(student.getCourses().isEmpty()){
                       System.out.println("No courses enrolled.");
                   }
                   else{
                       student.getCourses().forEach(c -> System.out.println(c.getCourseName()));
                   }

               }

               case 11 -> {
                   int studId;
                   double amount;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                       studId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }
                   Student student = studentService.getStudent(studId);
                   if(student == null){
                       System.out.println("Invalid Student Id.");
                       break;
                   }

                   // take amount form user
                   System.out.println("Enter amount :");
                   try {
                       amount = sc.nextDouble();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }
                   if (amount <= 0) {
                       System.out.println("Invalid amount.");
                       break;
                   }

                   System.out.println("Choose Payment Method:");
                   System.out.println("1. UPI");
                   System.out.println("2. Card");
                   int method = sc.nextInt();

                   student.addPaymentAmount(amount);
                   System.out.println("Payment of ₹" + amount +
                           " successful via " + (method == 1 ? "UPI" : "Card"));

               }

               case 12 -> {
                   System.out.println("Exiting Institute Management System...");
                   System.out.println("Thank you.");
                   flag = false;
               }

               default -> {
                   System.out.println("enter valid option");
               }
           }

       }while(flag);
       }
           catch (InputMismatchException e){
            throw new RuntimeException("!!!! Enter Valid option within range. !!!!");
        }
    }
}
