package V2.Service;

import V2.Model.Course;
import V2.Model.Student;


import java.sql.*;


/**
 * Implementation of course services like create course,view course,enroll student to course.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class CourseService {
    public Connection con = null;

    /**
     * This method is used to create the employee with checking that course is not already exist to prevent the overwrite.
     *
     * @param c take object of course.
     */
    public void createCourse(Course c){
        String query = "insert into course values(?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, c.getCourseId());
            pst.setString(2, c.getCourseName());
            pst.setInt(3, c.getTeacherId());
            int cnt = pst.executeUpdate();
            System.out.println("Course Created successfully");
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
     *
     * This method is used to enroll the student into particular course.
     * @param stud_id take student ID.
     * @param course_id take course ID.
     */
    public void enrollStudent(int stud_id ,int course_id){
         String query = "insert into enroll values(?,?,?)";
         PreparedStatement pst = null;
         try{
             pst = con.prepareStatement(query);
             int enroll_id =Integer.parseInt(stud_id +""+ course_id) ;
             pst.setInt(1,enroll_id);
             pst.setInt(2,stud_id);
             pst.setInt(3,course_id);
             pst.executeUpdate();
             System.out.println("Student Enrolled into the course.");

         } catch (Exception ex) {
             System.out.println(ex);
         }finally {
             try{
                 if(pst != null) pst.close();
                 if(con != null){

                     con.close();
                     System.out.println("DB connection close.");
                 }

             } catch (SQLException e) {
                 System.out.println(e);
             }
         }
    }

    /**
     * this method is used to show all the courses.
     */
    public void viewCourse(){
        String query = "select * from course";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            if (!rs.next()) {   // FIRST check
                System.out.println("No courses found.");
                return;
            }

            do {
                System.out.println(
                        "Course_ID : " + rs.getInt(1) +
                                " | Course_Name : " + rs.getString(2) +
                                " | Teacher_id : " + rs.getInt(3)
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
