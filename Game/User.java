import.java.sql.*;

public class User
{
 	 public static boolean user_level(String email,String pass) 
     {
      boolean st = false;
      try{

   //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

   //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","");
         PreparedStatement ps =con.prepareStatement
                             ("select * from login where email=? and pass=?");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         String role = rs.getString("role");
         if (role.equals("admin"))
         {
            st = true;
         }
         else if (role.quals("user"))
         {
            st = false;
         }
        
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }
}   