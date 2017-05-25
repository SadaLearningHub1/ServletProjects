package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class RequestInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RequestInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw=res.getWriter();
		pw.println("<h2>");
		StringBuffer sb = req.getRequestURL(); 
		pw.println("UPL: "+sb.toString());
		pw.println("<br/>");
		pw.println("URI: "+req.getRequestURI());
		pw.println("<br/>");
		pw.println("Context path: "+req.getContextPath());
		pw.println("<br/>");
		pw.println("Servlet path: "+req.getServletPath());
		pw.println("<br/>");
		pw.println("Protocol :"+req.getScheme());
		pw.println("<br/>");
		pw.println("Server IP: "+req.getServerName());
		pw.println("<br/>");
		pw.println("Port number :"+req.getServerPort());
		pw.println("<br/>");
		pw.println("Query String: "+req.getQueryString());
		pw.println("<br/>");
		pw.println("Remote Address: "+req.getRemoteAddr());
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
