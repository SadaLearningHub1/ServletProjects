package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PenDriveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public PenDriveServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		String str[] = req.getParameterValues("c1");
		session.setAttribute("pd", str);
		PrintWriter pw = res.getWriter();
		pw.println("<center>");
		pw.println("Items are added successfully");
		pw.println("<br/>");
		pw.println("<a href=laptop.html>Laptops </a>");
		pw.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
		pw.println("<a href=billsrv>Bill payment</a>");
		pw.println("</center>");
		pw.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
