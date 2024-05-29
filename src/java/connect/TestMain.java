package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;



public class TestMain 
{
    public static void main(String[] args) throws Exception
    {
    	Connection con = MyConnection.getConnection();
        PreparedStatement ps=null;
        String sql = "insert into signup values(?,?,?)";
        System.out.println(con);
        ps=con.prepareStatement(sql);
        
        ps.setString(1, "papa");
        ps.setString(2, "kvjd");
        ps.setString(3, "papa");
        if(ps.executeUpdate()>0)
            System.out.println("done");
    }   
}