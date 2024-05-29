package allServlet;

import dao.LoginDao;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

    
    public Login() 
    {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out = response.getWriter();
		String str1 = request.getParameter("email");
		String str2 = request.getParameter("password");
		
                try{
                        if(str1!=null && str2!=null)
                        {
                            LoginDao ed = new LoginDao();
                            if(ed.checkLogin(str1, str2))
                            {   
//                                session.setAttribute("username",str1 );
//                                session.setAttribute("password", str2);
                                response.sendRedirect("Home.html");
                            }
                            else
                            {
                                response.sendRedirect("Login.html");
                            }
                        } 
                        else
                        {
                                                              
                        }
                    }
                    catch (Exception e)
                    {
                        out.println(e);
                    }
	}

}
