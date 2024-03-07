package in.tnb.backend;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")
public class RegisterClass extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String name=req.getParameter("name");
    	String email=req.getParameter("email");
    	String pass=req.getParameter("pass");
    	String gender=req.getParameter("gender");
    	String city=req.getParameter("city");
    	
    	PrintWriter out=resp.getWriter();
    	
    	try
    	{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dydb","root","tnb1");
            PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?)");
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setString(3, pass);
            ps.setString(4, gender);
            ps.setString(5, city);
            int i=ps.executeUpdate();
            if(i>0)
            {   
            	resp.setContentType("text/html");
            	out.print("<h3 style=\"color:green\">Ragistration Successful</h3>");
            	RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
            	rd.include(req,resp);
            }
            else
            {
            	resp.setContentType("text/html");
            	out.print("<h3 style=\"color:red\">Error occred...</h3>");
            	RequestDispatcher rd=req.getRequestDispatcher("/register.jsp");
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
