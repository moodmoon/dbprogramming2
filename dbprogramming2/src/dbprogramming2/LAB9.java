package dbprogramming2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LAB9 {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root" ;
        String password = "Pearmai60" ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection(url , username , password);
            Statement statement= connection.createStatement();
            String sql = "INSERT INTO student(studentID,firstName,lastName,email,deptID)" 
                    + "values('65056','Pearmai','Wannasiri','pearmai.wann@kmutt.ac.th','IT')";
            statement.executeUpdate(sql);
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
