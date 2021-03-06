import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends HttpServlet 
{
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("username");
          String pass = request.getParameter("password");
        if(Validate.checkUser(email, pass))
        {
               if(User.user_level(email, pass))
               {
                    RequestDispatcher rs = request.getRequestDispatcher("progress.html");
                    rs.forward(request, response); 
               }
               else
               {
                    RequestDispatcher rs = request.getRequestDispatcher("statistics.html");
                    rs.forward(request, response); 
               }
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}
