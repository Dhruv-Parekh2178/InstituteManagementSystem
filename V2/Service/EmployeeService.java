package V2.Service;

import V2.Model.Employee;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Implementation of employee services like add employee,view all employee.
 *
 * @author dhruvparekh
 * @version 2.0
 */

public class EmployeeService {
    public Connection con = null;

    /**
     * This method is used to add the employee with checking that employee is not already exist to prevent the overwrite.
     * @param e object of employee
     */
    public void addEmployee(Employee e) throws SQLException{
        String query = "insert into employee values(?,?,?,?,?)";
        PreparedStatement pst = null;
        try {
            pst = con.prepareStatement(query);
            pst.setInt(1, e.getEmpId());
            pst.setString(2, e.getEmpName());
            pst.setByte(3, e.getAge());
            pst.setString(4, e.getRole());
            pst.setDouble(5, e.getSalary());
            int cnt = pst.executeUpdate();
            System.out.println("Employee Created successfully");
        } catch (Exception ex) {
            System.out.println(ex);
        }    finally {
            try{
                if(con != null && pst != null){
                    pst.close();
                    con.close();
                    System.out.println("DB connection close");
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     *
     * This method is used to get the employee object by Id.
     * @param id to take employee Id
     * @return object of employee.
     */

//    public Employee getEmployee(int id){
//        return employees.get(id);
//    }

    /**
     * This method is used to print all the employee.
     */
    public void viewEmployees() throws SQLException{
        String query = "select * from employee";
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(query);

            if (!rs.next()) {   // FIRST check
                System.out.println("No Employee found.");
                return;
            }

            do {
                System.out.println(
                        "ID : " + rs.getInt(1) +
                                " | Name : " + rs.getString(2) +
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
