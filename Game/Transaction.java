import java.sql.*;

public class Transaction
 {
     public static boolean retail(String email,String pass) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","");
         PreparedStatement gi =con.prepareStatement
                             ("ALTER ");
         ps.setString(1, email);
         ps.setString(2, pass);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
         String role = rs.getString("role");
         boolean allow = rs.getBoolean("Allow");
         if (!allow)
         {
            st = false;
         }
         else
         {
            PreparedStatement ps1 =con.prepareStatement
                             ("UPDATE login SET logged_in = TRUE WHERE email = ? ");
            ps1.setString(1, email);
            ResultSet rs =ps1.executeQuery();
            st = true;  
         }
      }catch(Exception e)
      {
          e.printStackTrace();
      }
      con.close();
         return st;                 
  }   
 
}