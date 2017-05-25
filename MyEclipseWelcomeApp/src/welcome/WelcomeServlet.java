package welcome;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WelcomeServlet extends GenericServlet {

	public WelcomeServlet() {
		super();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		pw.println("<center><h1>Welcome to servlet</h1></center>");
		pw.close();
		
	}

	

	
	

}
