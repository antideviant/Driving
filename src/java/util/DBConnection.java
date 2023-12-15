package util;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;


public class DBConnection {
    static boolean status = false;
    private static PreparedStatement pstmt;
    static Connection conn;
    public static Connection createConnection()
    {
        
        try{
            String driver = "org.apache.derby.jdbc.ClientDriver";
            String connectionString ="jdbc:derby://localhost:1527/drive; create = true; user =app ;password=app";
            
            Class.forName(driver);
            
            conn = DriverManager.getConnection(connectionString);
        }
            catch (Exception e){e.printStackTrace();}
            
            return conn;
           
        }

    
    }
