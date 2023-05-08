package dbprogramming2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

public class LAB12 {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root" ;
        String password = "Pearmai60" ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection(url , username , password);
            
            String sql = "INSERT INTO student(studentID,firstName,lastName,email,deptID)" 
                    + "values(?,?,?,?,?)";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"65056");
            preparedStatement.setString(2,"Pearmai");
            preparedStatement.setString(3,"Wannasiri");
            preparedStatement.setString(4,"pearmai.wann@kmutt.ac.th");
            preparedStatement.setString(5,"IT");
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
