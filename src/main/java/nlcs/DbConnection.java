/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package nlcs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author vkhanhqui
 */
public class DbConnection {

    public static Connection conn;
    private static final String DB_URL = "jdbc:mysql://localhost:3306/nien_luan1?sessionVariables=sql_mode='NO_ENGINE_SUBSTITUTION'&jdbcCompliantTruncation=false";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "Nguyen123@";
 

    public static boolean Open() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
//            System.out.println("connected");
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    public static boolean Close() {
        try {
            conn.close();
//            System.out.println("disconnected");
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }
}
