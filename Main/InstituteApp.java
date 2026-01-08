package Main;
import model.*;
import Service.*;
import Util.InputUtil;
/**
 * this class is main entry point of the Application & here the user can tell which task he/She want to perform.
 * @author Dhruv Parekh
 * @version 1.0
 */

public class InstituteApp {

    public static void main(String[] args) {

        boolean flag = true;

        StudentService studentService = new StudentService();
        TeacherService teacherService = new TeacherService();
        EmployeeService employeeService = new EmployeeService();
        CourseService courseService = new CourseService();

        do {
            System.out.println("\n========== Institute Management System ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Add Employee (Admin / Staff)");
            System.out.println("4. View All Employees");
            System.out.println("5. Add Teacher");
            System.out.println("6. View All Teachers");
            System.out.println("7. Create Course");
            System.out.println("8. View All Courses");
            System.out.println("9. Enroll Student to Course");
            System.out.println("10. Show Student Courses");
            System.out.println("11. Make Payment");
            System.out.println("12. Exit");
            System.out.print("Choose option: ");

            int choice = InputUtil.readInt();

            switch (choice) {

                /* ---------------- STUDENT ---------------- */

                case 1 -> {
                    System.out.print("Enter Student ID: ");
                    int id = InputUtil.readInt();

                    System.out.print("Enter Name: ");
                    String name = InputUtil.readString();

                    System.out.print("Enter Age: ");
                    byte age = InputUtil.readByte();

                    System.out.print("Enter Marks: ");
                    byte marks = InputUtil.readByte();

                    if (age <= 0 || marks < 0 || marks > 100) {
                        System.out.println("Invalid age or marks.");
                        break;
                    }

                    studentService.addStudent(new Student(id, name, age, marks));
                }

                case 2 -> studentService.viewStudents();

                /* ---------------- EMPLOYEE ---------------- */

                case 3 -> {
                    System.out.print("Enter Employee ID: ");
                    int id = InputUtil.readInt();

                    System.out.print("Enter Name: ");
                    String name = InputUtil.readString();

                    System.out.print("Enter Age: ");
                    byte age = InputUtil.readByte();

                    System.out.print("Enter Role (ADMIN / ACCOUNT / STAFF): ");
                    String role = InputUtil.readString().toUpperCase();

                    System.out.print("Enter Salary: ");
                    double salary = InputUtil.readDouble();

                    employeeService.addEmployee(
                            new Employee(id, name, age, role, salary)
                    );
                }

                case 4 -> employeeService.viewEmployees();

                /* ---------------- TEACHER ---------------- */

                case 5 -> {
                    System.out.print("Enter Teacher ID: ");
                    int id = InputUtil.readInt();

                    System.out.print("Enter Name: ");
                    String name = InputUtil.readString();

                    System.out.print("Enter Age: ");
                    Byte age = InputUtil.readByte();

                    System.out.print("Enter Salary: ");
                    double salary = InputUtil.readDouble();

                    teacherService.addTeacher(
                            new Teacher(id, name, age, salary)
                    );
                }

                case 6 -> teacherService.viewTeachers();

                /* ---------------- COURSE ---------------- */

                case 7 -> {
                    System.out.print("Enter Course ID: ");
                    int cid = InputUtil.readInt();

                    System.out.print("Enter Course Name: ");
                    String cname = InputUtil.readString();

                    System.out.print("Enter Teacher ID: ");
                    int tid = InputUtil.readInt();

                    Teacher teacher = teacherService.getTeacher(tid);
                    if (teacher == null) {
                        System.out.println("Invalid Teacher ID.");
                        break;
                    }

                    courseService.createCourse(
                            new Course(cid, cname, teacher)
                    );
                }

                case 8 -> courseService.viewCourses();

                /* ---------------- ENROLLMENT ---------------- */

                case 9 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = InputUtil.readInt();

                    System.out.print("Enter Course ID: ");
                    int cid = InputUtil.readInt();

                    Student student = studentService.getStudent(sid);
                    Course course = courseService.getCourse(cid);

                    if (student == null || course == null) {
                        System.out.println("Invalid Student ID or Course ID.");
                        break;
                    }

                    courseService.enrollStudent(student, course);
                }

                case 10 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = InputUtil.readInt();

                    Student student = studentService.getStudent(sid);
                    if (student == null) {
                        System.out.println("Student not found.");
                        break;
                    }

                    System.out.println("Courses enrolled by Student ID " + sid + ":");
                    if (student.getCourses().isEmpty()) {
                        System.out.println("No courses enrolled.");
                    } else {
                        student.getCourses()
                               .forEach(c -> System.out.println("- " + c.getCourseName()));
                    }
                }

                /* ---------------- PAYMENT ---------------- */

                case 11 -> {
                    System.out.print("Enter Student ID: ");
                    int sid = InputUtil.readInt();

                    Student student = studentService.getStudent(sid);
                    if (student == null) {
                        System.out.println("Invalid Student ID.");
                        break;
                    }

                    System.out.print("Enter Amount: ");
                    double amount = InputUtil.readDouble();

                    if (amount <= 0) {
                        System.out.println("Invalid amount.");
                        break;
                    }

                    System.out.println("Choose Payment Method:");
                    System.out.println("1. UPI");
                    System.out.println("2. Card");
                    int method = InputUtil.readInt();

                    student.addPayment(amount);
                    System.out.println("Payment of ₹" + amount +
                            " successful via " + (method == 1 ? "UPI" : "Card"));
                }

                /* ---------------- EXIT ---------------- */

                case 12 -> {
                    System.out.println("Exiting Institute Management System...");
                    flag = false;
                }

                default -> System.out.println("Invalid option. Try again.");
            }
        }while(flag);
    }
}