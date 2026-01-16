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
    /**
     * This method is used to add the Student with checking that student is not already exist to prevent the overwrite.
     * @param s object of Student
     */

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
        }    finally {
            try{
                if(pst != null) pst.close();
                if(con != null ){
                    con.close();
                    System.out.println("DB connection close");
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }



    /**
     * This method is used to print all the student.
     */

   public void viewStudents() throws SQLException {
                String query = "select * from student";
                Statement st = null;
                ResultSet rs = null;
                try {
                    st = con.createStatement();
                    rs = st.executeQuery(query);

                    if (!rs.next()) {   // FIRST check
                        System.out.println("No Students found.");
                        return;
                    }

                    do {
                        System.out.println(
                                "ID : " + rs.getInt(1) +
                                        " | Name : " + rs.getString(2) +
                                        " | Age : " + rs.getByte(3) +
                                        " | Result : " + rs.getString(5) +
                                        " | Total Paid ₹" + rs.getDouble(6)
                        );
                    } while (rs.next());
    }
    catch(Exception e){
            System.out.println(e);
        } finally {
        try{
            if(st != null) st.close();
            if(rs != null ) rs.close();
            if(con != null){

                con.close();
                System.out.println("DB connection close.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
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
