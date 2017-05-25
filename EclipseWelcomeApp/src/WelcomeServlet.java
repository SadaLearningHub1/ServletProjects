

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

public class WelcomeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
    public WelcomeServlet() {
        super();
    }
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		pw.println("<center><h1> Welcome to servlet</h1></center>");
		pw.close();
	}

}
