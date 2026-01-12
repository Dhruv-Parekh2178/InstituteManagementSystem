package V2.Model;

import V2.CustomException.InvalidAmountException;


import java.util.ArrayList;
import java.util.List;

/**
 * implementation of POJO student class.
 *
 * @author Dhruv Parekh
 * @version  2.0
 */

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
          //student pass criteria 60 %
        this.result = (marks >= 60)? "PASS" : "FAIL";
        //student initial paid 0
        this.totalPaid = 0;
          this.courses = new ArrayList<>();
    }

    /**
     * this method return the student Id.
     * @return student id of particular student object.
     */
    public int getStudId(){
        return studId;
    }

    /**
     * This method use to add particular student to add in some course.
     * @param course take Course object as a parameter.
     */

    public void enrollCourse(Course course){
        courses.add(course);
    }

    /**
     * This method is used for to get the list of course student enrolled.
     * @return  list of Course.
     */
    public List<Course> getCourses(){
        return courses;
    }

    /**
     * This method is used to maintain the totalpaid of the student.
     *
     * @param amount to buy particular course.
     */
    public void addPaymentAmount(double amount){
        //here i have generate one custom exception by which user can enter negative value.
        try{
            if(amount <= 0 ){
                throw new InvalidAmountException("!!!!! enter Valid amount (grater that zero)");
            }
        } catch (InvalidAmountException e) {
            throw new RuntimeException(e);
        }
        totalPaid+= amount;
    }

    public String toString(){
        return "ID : " + studId+ " | Name : " + studName+ " | Age : " + age + " | Result : "+ result + " | Total Paid ₹" + totalPaid;
    }


}
