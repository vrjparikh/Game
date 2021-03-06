import java.sql.*;

public class Validate
 {
     public static boolean checkUser(String email,String pass) 
     {
      boolean st =false;
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
         boolean allow = rs.getBoolean("Allow");
         if (!allow)
         {
            st = false;
         }
         else
         {
            boolean st2 = false;
            PreparedStatement ps =con.prepareStatement
                             ("SELECT logged_in FROM login WHERE  email = ? ");
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            st2 = rs.next();
            if (st2)
            {
              boolean st3 = false;
              PreparedStatement ps5 = con.prepareStatement
                                ("SELECT tlogin FROM login WHERE email = ?");
              ps5.setString(1,email);
              ResultSet rs5 = ps5.executeQuery();
              st3 = rs5.next();
              /* REad TIMESTAMP HERE AND COMPARE IF THE SESSION IS RUNNING FOR MORE THAN 1800 SECONDS (INACTIVITY), IF YES RE - LOGIN 
                 Else Go on normally */

            }
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