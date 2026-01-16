package V2.Service;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Implementation of Payment services to check that student is enroll in the course then & then student can make payment and otherwise error message is shown.
 *
 * @author dhruvparekh
 * @version 2.0
 */
public class PaymentService {
    public Connection con = null;
    /**
     * This method is used to check that the student is enrolled on particular course or note
     * if student is enrolled then & then make payment and change the totalpaid of the student.
     * @param studId to take the student ID.
     * @param courseId to take the course ID.
     * @return flag that student enroll or not.
     */
    public boolean checkIfStudentEnroll(int studId , int courseId){
       String query = "Select enroll_id form enroll where stud_id = ? and course_id = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;

        try{
            pst = con.prepareStatement(query);
            pst.setInt(1,studId);
            pst.setInt(2,courseId);
            rs = pst.executeQuery();

            if(!rs.next()){
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
        }finally {

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
        return true;
    }
}
