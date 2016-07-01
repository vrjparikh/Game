import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class Parameter extends HttpServlet 
{
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        int noteams = request.getParameter("noteams");
        int duration = request.getParameter("duration");
        int inventory = request.getparameter("inventory")
        if(SetGame.add_parameters1(noteams, duration, inventory))
        {
               // if(User.user_level(email, pass))
               // {
               //      RequestDispatcher rs = request.getRequestDispatcher("progress.html");
               //      rs.forward(request, response); 
               // }
               // else
               // {
               //      RequestDispatcher rs = request.getRequestDispatcher("statistics.html");
               //      rs.forward(request, response); 
               // }
          /* THIS IS REMAINING */
        }
        else
        {
           out.println("Username or Password incorrect");
           RequestDispatcher rs = request.getRequestDispatcher("index.html");
           rs.include(request, response);
        }
    }  
}
