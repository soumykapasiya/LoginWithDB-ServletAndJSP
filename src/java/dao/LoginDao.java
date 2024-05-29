package dao;

import connect.MyConnection;
import model.Login;
import java.sql.*;


public class LoginDao 
{
    public boolean insertData(Login L) throws Exception
    {
          Connection con = MyConnection.getConnection();
          PreparedStatement ps=null;
          String sql;
//        con=MyConnection.getConnection();
          
          sql = "insert into signup values(?,?,?)";
          ps=con.prepareStatement(sql);
          
          ps.setString(1, L.getEmail());
          ps.setString(2, L.getname());
          ps.setString(3, L.getPassword());
          
          if(ps.executeUpdate()>0)
              return true;
          
          return false;
    }
    
    public boolean checkLogin(String username,String password) throws Exception
    {
           String sql;
            Connection con=null;
            PreparedStatement ps=null;
            ResultSet rs=null;
            con=MyConnection.getConnection();
           sql="select * from signup where email=? and password=?";
           ps=con.prepareStatement(sql);
           ps.setString(1,username);
           ps.setString(2,password);
           rs=ps.executeQuery();
           if(rs.next())
               return true;
        
           return false;
    }
}
