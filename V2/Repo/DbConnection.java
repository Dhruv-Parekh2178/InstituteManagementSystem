package V2.Repo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    public static Connection con= null;
    private static final String url = "jdbc:postgresql://localhost:5432/Institute_management_system";
    private static final String user = "postgres";
    private static final String pass = "postgres";

    public static Connection connect() throws SQLException {
        try {
            con= DriverManager.getConnection(url, user,pass);
            System.out.println("DB connected.");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
