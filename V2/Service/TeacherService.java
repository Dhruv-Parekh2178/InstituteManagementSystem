package V2.Service;

import V2.Model.Teacher;

import java.sql.*;


/**
 * Implementation of Teacher services like Add Teacher,view Teacher.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class TeacherService {
    public Connection con = null;

    /**
     * This method is used to add the Teacher with checking that teacher is not already exist to prevent the overwrite.
     * @param t object of Teacher.
     */

    public void addTeacher(Teacher t){
        String query = "insert into employee values(?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, t.getEmpId());
            pst.setString(2, t.getEmpName());
            pst.setByte(3, t.getAge());
            pst.setString(4, t.getRole());
            pst.setDouble(5, t.getSalary());
            int cnt = pst.executeUpdate();
            System.out.println("Teacher Created successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }    finally {
            try{
                   if(pst != null) pst.close();
                if(con != null){
                    con.close();
                    System.out.println("DB connection close");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     *This method is used to print all the Teacher.
     */

    public void viewTeachers(){
        String query = "select * from employee where emp_role = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = con.prepareStatement(query);
            pst.setString(1,"TRAINER");
            rs = pst.executeQuery();

            if (!rs.next()) {   // FIRST check
                System.out.println("No Teacher found.");
                return;
            }

            do {
                System.out.println(
                        "Teacher_ID : " + rs.getInt(1) +
                                " | Teacher_Name : " + rs.getString(2) +
                                " | Age : " + rs.getByte(3) +
                                " | Role : " + rs.getString(4) +
                                " | Salary ₹" + rs.getDouble(5)
                );
            } while (rs.next());
        }
        catch(Exception e){
            System.out.println(e);
        } finally {
            try{
                if(pst != null) pst.close();
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
