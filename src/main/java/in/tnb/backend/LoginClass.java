package in.tnb.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.Session;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/loginForm")
public class LoginClass extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String email=req.getParameter("email");
    	String pass=req.getParameter("pass");
    	
    	PrintWriter out=resp.getWriter();
    	
    	try
    	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dydb","root","tnb1");
            PreparedStatement ps=con.prepareStatement("select * from register where password=? and email=?");
            ps.setString(1,pass);
            ps.setString(2,email); 
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {   
            	HttpSession session=req.getSession();
            	session.setAttribute("name",rs.getString("name"));
            	resp.setContentType("text/html");
            	out.print("<h3 style=\"color:green\">Login Successful</h3>");
            	RequestDispatcher rd=req.getRequestDispatcher("/profile.jsp");
            	rd.include(req,resp);
            	
            	
            }
            else
            {
            	resp.setContentType("text/html");
            	out.print("<h3 style=\"color:red\">Email and Password did not matched</h3>");
            	RequestDispatcher rd=req.getRequestDispatcher("/index.jsp");
            	rd.include(req,resp);
            }
            
        }
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		resp.setContentType("text/html");
        	out.print("<h3 style=\"color:red\">Exception occred: "+e.getMessage()+"</h3>");
        	RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
        	rd.include(req,resp);
    	}
	}
}
