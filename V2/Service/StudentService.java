package V2.Service;

import V2.Model.Student;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.postgresql.Driver;



/**
 *Implementation of the basic students service like add student and View Student.
 *
 * @author Dhruv Parekh
 * @version 2.0
 */

public class StudentService {
    public Connection con = null;

    public void addStudent(Student s) throws SQLException {
        String query = "insert into student values(?,?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, s.getStudId());
            pst.setString(2, s.getStudName());
            pst.setInt(3, s.getAge());
            pst.setInt(4, s.getMarks());
            pst.setString(5, s.getResult());
            pst.setDouble(6, s.getTotalPaid());
            int cnt = pst.executeUpdate();
            System.out.println("Student Created successfully");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            pst.close();
        }


    }



    /**
     * This method is used to print all the student.
     */

    public void viewStudents() throws SQLException {
        String query = "select * from student";
        Statement st = null;
    try {
         st = con.createStatement();
        ResultSet rs = st.executeQuery(query);

        while(rs.next()){
//            System.out.println( "ID : " + rs.getInt("stud_id")+ " | Name : " + rs.getString("stud_Name")+ " | Age : " + rs.getByte("age") + " | Result : "+ rs.getString("stud_result") + " | Total Paid ₹" + rs.getDouble("total_paid"));
            System.out.println( "ID : " + rs.getInt(1)+ " | Name : " + rs.getString(2)+ " | Age : " + rs.getByte(3) + " | Result : "+ rs.getString(5) + " | Total Paid ₹" + rs.getDouble(6));
        }
        if(!rs.next()){
            System.out.println("No Students found");
            return;
        }
    }
    catch(Exception e){
            System.out.println(e);
        }
    finally {  st.close();
    }

    }

}
//
//    /**
//     *
//     * This method is used to get the student object by Id.
//     * @param id to take student Id
//     * @return object of employee.
//     */
//    public Student getStudent(int id){
//        return students.get(id);
//    }
