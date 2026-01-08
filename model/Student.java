package model;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studId;
    private String studName;
    private byte age;
    private byte marks;
    private String result;
    private double totalPaid;
    private List<Course> courses;

    public Student(int studId, String studName, byte age, byte marks) {
        this.studId = studId;
        this.studName = studName;
        this.age = age;
        this.marks = marks;
        this.result = (marks >= 60)? "PASS" : "FAIL";
        this.totalPaid = 0;
        this.courses = new ArrayList<>();
    }

    public int getStudId(){
        return studId;
    }
    public void enrollCourse(Course course){
        courses.add(course);
    }
    public List<Course> getCourses(){
        return courses;
    }
    public void addPayment(double amount){
        totalPaid+= amount;
    }

    public String toString(){
        return "ID : " + studId+
                " | Name : " + studName+
                " | Age : " + age +
                " | Result : "+ result +
                " | Total Paid ₹" + totalPaid;
    }
}
