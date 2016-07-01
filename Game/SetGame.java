import java.sql.*;

public class SetGame
 {
     public static boolean add_parameters1(int noteams,int duration,int inventory) 
     {
      boolean st =false;
      try{

	 //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

 	 //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","");
         PreparedStatement ps =con.prepareStatement
                             ("INSERT INTO parameter1 (`#Team`, `Duration`, `Inventory`) VALUES ('?', '?', '?')");
         ps.setInt(1, noteams);
         ps.setInt(2, duration);
         ps.setInt(3,inventory)
         ResultSet rs =ps.executeQuery();
         st = rs.next();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }
  public static boolean add_parameters2(int coi,int cob,int od,int sd) 
     {
      boolean st =false;
      try{

   //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

   //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","");
         PreparedStatement ps =con.prepareStatement
                             ("INSERT INTO parameter2 (`COI`, `COB`, `OD`, 'SD') VALUES ('?', '?', '?')");
         ps.setInt(1, coi);
         ps.setInt(2, cob);
         ps.setInt(3, od);
         ps.setInt(4, sd);
         ResultSet rs =ps.executeQuery();
         st = rs.next();
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }    
  public static boolean start_game(String name, String admin) 
     {
      boolean st =false;
      try{
    
   //loading drivers for mysql
         Class.forName("com.mysql.jdbc.Driver");

   //creating connection with the database 
         Connection con=DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test","root","");
         PreparedStatement ps =con.prepareStatement
                             ("SELECT * from login WHERE role = 'admin' & logged_in = TRUE");

         ResultSet rs =ps.executeQuery();
         
         st = rs.next();
         if (st)
         {
            boolean st1 = false;
            String admin = rs.email();
            PreparedStatement ps1 = con.prepareStatement
                                    ("SELECT * FROM running WHERE admin = ?");
            ps1.setString(1,admin);
            ResultSet rs1 = ps1.executeQuery();
            st1 = rs1.next();
            if(!st1)
            {
              boolean st2 = false;
              PreparedStatement ps2 = con.prepareStatement
                                    ("INSERT INTO running ('admin','name') VALUES ('?','?')");
                      ps2.setString(1,admin);
                      ps2.setString(2,name);
              ResultSet rs2 = ps2.executeQuery();
              st2 = rs2.next();
            }
            else
            {
             boolean st3 = false;
              PreparedStatement ps3 = con.prepareStatement
                                    (" DELETE FROM running WHERE admin = '?'");
                      ps3.setString(1,admin);
              ResultSet rs3 = ps3.executeQuery();
              st3 = rs3.next();
              boolean st4 = false;
               PreparedStatement ps4 = con.prepareStatement
                                    ("INSERT INTO running ('admin','name') VALUES ('?','?')");
                      ps4.setString(1,admin);
                      ps4.setString(2,name);
              ResultSet rs4 = ps4.executeQuery();
              st4 = rs4.next();
              return st4;  
            }
         }
         /* First Add foreign Key Here*/
      }catch(Exception e)
      {
          e.printStackTrace();
      }
         return st;                 
  }   

}