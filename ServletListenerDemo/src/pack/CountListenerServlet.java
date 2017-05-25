package pack;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CountListenerServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	public CountListenerServlet() {
		super();
	}

	@Override
	public void service(ServletRequest req, ServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		req.setAttribute("k1", "java");
		req.setAttribute("k2", "jsp");
		req.setAttribute("k3", "javase");
		req.setAttribute("k4", "javaee");
		req.removeAttribute("k3");
		req.setAttribute("k4", "servlet");
		ServletOutputStream sos = res.getOutputStream();
		sos.println("<center><h1>");
		sos.println("Number of attributes are added = "
				+ CountListener.getCount1() + "<br/>");
		sos.println("Number of attributes are Removed = "
				+ CountListener.getCount2() + "<br/>");
		sos.println("</h1></center>");
		sos.close();
	}

}
