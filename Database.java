/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Naveen Vignesh
 */
public final class Database {
    String user = "root";
    String pass = "";
    String db = "theace56";
    Connection con = null;
    PreparedStatement st = null;
    ResultSet rs = null;
    
    Database()
    {
      try
        {
          Class.forName("com.mysql.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db,user,pass);
        }
        catch(ClassNotFoundException | SQLException a)
        {
            System.out.println(a);
        }
    }
    public Connection getCon()
    {
       return con;
    }
    
    public String[] returnlist(String type,int no) throws SQLException
    {
      int size = getSize();
      String data;
      String[] list = new String[size];
      String sql = "select * from "+type+"model"+String.valueOf(no);
      st = con.prepareStatement(sql);
      rs = st.executeQuery();
      int i = 0;
      while(rs.next() && i<size)
      {
         data = rs.getString("roll")+" "+rs.getInt("m1")+" "+rs.getInt("m2")+" "
                 +rs.getInt("m2")+" "+rs.getInt("m3")+" "+rs.getInt("m4")+" "+rs.getInt("m5")+" "+rs.getInt("m6");
         list[i] = data;
         i++;
      }
      return list;
    }        
    
    private int getSize() throws SQLException
    {
      int size = 0;
      
      String sql = "select count(roll) as no from student";
      st = con.prepareStatement(sql);
      rs = st.executeQuery();
      while(rs.next())
      {
        size = rs.getInt("no");
      }
      return size;
    }
}
