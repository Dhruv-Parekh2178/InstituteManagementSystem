package V2;

import V2.CustomException.InvalidAgeException;
import V2.CustomException.InvalidMarksException;
import V2.Model.Course;
import V2.Model.Employee;
import V2.Model.Student;
import V2.Model.Teacher;
import V2.Repo.DbConnection;
import V2.Service.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

    public static void main(String[] args) throws SQLException {
        Connection con = null;
        try{
        boolean flag = true;
            StudentService studentService = new StudentService();
            EmployeeService employeeService = new EmployeeService();
            CourseService courseService = new CourseService();
            TeacherService teacherService = new TeacherService();
            PaymentService paymentService = new PaymentService();
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
               // case 1 : to add student
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

                   studentService.con = DbConnection.connect();
                   studentService.addStudent(new Student(studId,studName,age,marks));
               }

                // case 2: to view Student
               case 2 -> {
                   studentService.con = DbConnection.connect();
                 studentService.viewStudents();

               }
                // case 3 : to Add Employee
               case 3 -> {
                   //declare the variable outside try catch to solve the scope issue.
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
                   String role = sc.next().toUpperCase();

                   // take employee salary form user
                   System.out.println("Enter employee Salary :");
                   try {
                        salary = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid employee salary. !!!!");
                   }
                   employeeService.con = DbConnection.connect();
                 employeeService.addEmployee(new Employee(empId,empName,age,role,salary));


               }
                // case 4: to view Employee
               case 4 -> {
                   employeeService.con = DbConnection.connect();
                   employeeService.viewEmployees();
               }
               //case 5 : to add Teacher
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

                   // take teacher salary form user
                   System.out.println("Enter teacher Salary :");
                   try {
                        salary = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid teacher salary. !!!!");
                   }

                teacherService.con = DbConnection.connect();
                teacherService.addTeacher(new Teacher(empId,empName,age,salary));

               }
                //case 6 :to view Teacher
               case 6 -> {
                   teacherService.con = DbConnection.connect();
                   teacherService.viewTeachers();

               }

               //case 7 : to Creat course

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
                       throw new RuntimeException("!!!! Enter valid Teacher ID. !!!!");
                   }

                    String query = "select emp_id from employee where emp_id = ? and emp_role = ?";
                   PreparedStatement pst = null;
                   ResultSet rs = null;
                   con = DbConnection.connect();
                   try{
                       pst = con.prepareStatement(query);
                       pst.setInt(1,tId);
                       pst.setString(2,"TRAINER");
                       rs = pst.executeQuery();

                       if (!rs.next()) {
                           System.out.println("No Teacher found with this Id.");
                           break;
                       }

                   }catch (Exception ex){
                       System.out.println(ex);
                   }finally {
                       try {
                           if (pst != null) pst.close();
                           if (rs != null) rs.close();
                           if (con != null) {

                               con.close();
                               System.out.println("DB connection close.");
                           }
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
                   courseService.con = DbConnection.connect();
                   courseService.createCourse(new Course(courseId,courseName,tId));

               }
                //case 8 : to view all courses
               case 8 -> {
                 courseService.con = DbConnection.connect();
                 courseService.viewCourse();
               }
               // case 9 : enroll student to course
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

                   String query1 = "select stud_id from student where stud_id = ?";

                   String query2 = "Select course_id from course where course_id = ?";
                   PreparedStatement pst = null;
                   ResultSet rs1 = null;
                   ResultSet rs2 = null;

                   con = DbConnection.connect();
                   try{
                       pst = con.prepareStatement(query1);
                       pst.setInt(1,studId);
                       rs1 = pst.executeQuery();

                       pst = con.prepareStatement(query2);
                       pst.setInt(1,courseId);
                       rs2 = pst.executeQuery();

                       if ((!rs1.next()) && (!rs2.next())) {
                           System.out.println("Invalid Student ID or Course ID.");
                           break;
                       }

                   }catch (Exception ex){
                       System.out.println(ex);
                   }finally {
                       try {
                           if (pst != null) pst.close();
                           if (rs1 != null) rs1.close();
                           if (rs1 != null) rs1.close();
                           if (con != null) {

                               con.close();
                               System.out.println("DB connection close.");
                           }
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }
                   courseService.con = DbConnection.connect();
                   courseService.enrollStudent(studId,courseId);
               }
                //case 10 : courses enroll by student
               case 10 -> {
                   int studId;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                        studId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }

                   String query1 = "select stud_id from student where stud_id = ?";

                   String query2 = "Select course_name from course where course_id = (Select course_id from enroll where stud_id = ?)";
                   PreparedStatement pst = null;
                   ResultSet rs1 = null;
                   ResultSet rs2 = null;

                   con = DbConnection.connect();
                   try{
                       pst = con.prepareStatement(query1);
                       pst.setInt(1,studId);
                       rs1 = pst.executeQuery();
                       if (!rs1.next()) {
                           System.out.println("Invalid Student ID.");
                           break;
                       }

                       pst = con.prepareStatement(query2);
                       pst.setInt(1,studId);
                       rs2 = pst.executeQuery();

                       if (!rs2.next()) {
                           System.out.println("No courses enrolled by student ID"+studId);
                           break;
                       }

                       System.out.println("courses enrolled by Student ID" + studId + ":");
                       int i = 1;
                       do {
                           System.out.println(
                                 i + ".Course_Name: " + rs2.getString(1)
                           );
                           i++;
                       } while (rs2.next());


                   }catch (Exception ex){
                       System.out.println(ex);
                   }finally {
                       try {
                           if (pst != null) pst.close();
                           if (rs1 != null) rs1.close();
                           if (rs1 != null) rs1.close();
                           if (con != null) {

                               con.close();
                               System.out.println("DB connection close.");
                           }
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
                   }

               }
                //case 11 : to make payment
               case 11 -> {
                   int studId;
                   int courseId;
                   double amount;
                   // take student ID form user
                   System.out.println("Enter student ID :");
                   try {
                       studId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }


                   // take Course ID form user
                   System.out.println("Enter course ID :");
                   try {
                       courseId = sc.nextInt();
                   }catch (InputMismatchException e){
                       throw new RuntimeException("!!!! Enter valid Student ID. !!!!");
                   }


                   String query1 = "select stud_id from student where stud_id = ?";

                   String query2 = "Select course_id from course where course_id = ?";
                   PreparedStatement pst = null;
                   ResultSet rs1 = null;
                   ResultSet rs2 = null;

                   con = DbConnection.connect();
                   try{
                       pst = con.prepareStatement(query1);
                       pst.setInt(1,studId);
                       rs1 = pst.executeQuery();

                       pst = con.prepareStatement(query2);
                       pst.setInt(1,courseId);
                       rs2 = pst.executeQuery();

                       if ((!rs1.next()) && (!rs2.next())) {
                           System.out.println("Invalid Student ID or Course ID.");
                           break;
                       }

                   }catch (Exception ex){
                       System.out.println(ex);
                   }finally {
                       try {
                           if (pst != null) pst.close();
                           if (rs1 != null) rs1.close();
                           if (rs1 != null) rs1.close();
                           if (con != null) {

                               con.close();
                               System.out.println("DB connection close.");
                           }
                       } catch (SQLException e) {
                           System.out.println(e);
                       }
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
                   int opt = sc.nextInt();
                   String method = (opt == 1) ? "UPI" : "Card" ;

                   paymentService.con = DbConnection.connect();

                   if(paymentService.checkIfStudentEnroll(studId,courseId)){
                       studentService.con = DbConnection.connect();
                       studentService.addPaymentAmount(amount,method,studId);
                       System.out.println("Payment of ₹" + amount +
                              " successful via " + method);
                   }
                   else{
                       System.out.println("Student is not enroll to any course yet.");
                   }


               }
                // case 12 : to exit from the menu
               case 12 -> {
                   try{
                       if(con != null ){
                           con.close();
                           System.out.println("DB connection close");
                       }
                   } catch (SQLException e) {
                       System.out.println(e);
                   }
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
           catch (InputMismatchException | SQLException e){
            throw new RuntimeException("!!!! Enter Valid option within range. !!!!");
        }
    }
}
