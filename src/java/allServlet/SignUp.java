package allServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.LoginDao;
import model.Login;


@WebServlet("/SignUp")
public class SignUp extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    
    public SignUp() 
    {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		
		try
		{
			String str1 = request.getParameter("name");
			String str2 = request.getParameter("email");
			String str3 = request.getParameter("password");
			String str4 = request.getParameter("cpassword");
			
			if(str3.equals(str4))
			{
				Login l = new Login();
				
				l.setname(str1);
				l.setEmail(str2);
				l.setPassword(str3);
				
				LoginDao ed = new LoginDao();
				
				if(ed.insertData(l))
				{
					response.sendRedirect("Login.html");
				}
				
			}
			else
			{
				response.sendRedirect("SignUp.html");
			}
		}catch(Exception e)
		{
			out.println(e);
		}
		
		
	}

}
