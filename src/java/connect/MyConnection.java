package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class MyConnection 
{
    static Connection con=null;
    static
    {
        try
        {    
          Class.forName("com.mysql.cj.jdbc.Driver");
        // System.out.println("Driver load....");
        }
        catch(Exception e)
        {
            System.out.println(e);
        }    
    }
   public static Connection getConnection() throws SQLException
   {
     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/firstlogin", "root","root");
//       System.out.println(con);
        return(con);     
   }
}