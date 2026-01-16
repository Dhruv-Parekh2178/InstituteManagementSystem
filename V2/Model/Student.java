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

    public Student(int studId, String studName, byte age, byte marks) {
        this.studId = studId;
        this.studName = studName;
        this.age = age;
          this.marks = marks;
          //student pass criteria 60 %
        this.result = (marks >= 60)? "PASS" : "FAIL";
        //student initial paid 0
        this.totalPaid = 0;

    }

    public String getStudName() {
        return studName;
    }

    public byte getAge() {
        return age;
    }

    public double getTotalPaid() {
        return totalPaid;
    }

    public String getResult() {
        return result;
    }

    public byte getMarks() {
        return marks;
    }

    /**
     * this method return the student Id.
     * @return student id of particular student object.
     */
    public int getStudId(){
        return studId;
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

}
