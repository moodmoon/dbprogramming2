package dbprogramming2;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class LAB15 {
        public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/mydb2";
        String username = "root" ;
        String password = "Pearmai60" ;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection =  DriverManager.getConnection(url , username , password);
            Statement statement= connection.createStatement();
            String sql = "SELECT * FROM student";
            ResultSet results = statement.executeQuery(sql);
            ResultSetMetaData rsMetaData = results.getMetaData();
            
            System.out.println(rsMetaData.getColumnCount());
            
            for (int i = 1; i <= rsMetaData.getColumnCount(); i++) {
            System.out.println(rsMetaData.getColumnName(i));
        }
            
            while (results.next()) {
            for(int i=1; i <= rsMetaData.getColumnCount(); i++)
            System.out.printf("%-12s\t",results.getString(i)+ " ");
            }
            
            System.out.println();
            connection.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LAB8.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
