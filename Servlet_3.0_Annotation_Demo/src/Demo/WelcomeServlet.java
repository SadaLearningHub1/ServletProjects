package Demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet(name = "welcome", value = "/srv1")
public class WelcomeServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public WelcomeServlet() {
		super();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		pw.println("<center><h2>Welcome to servlet 3.0 programming</h2></center>");
		pw.close();
	}
}
