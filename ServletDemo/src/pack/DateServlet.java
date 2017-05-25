package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public DateServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Date d = new Date();
		PrintWriter pw = res.getWriter();
		res.setHeader("refresh", "1");
		pw.println("<h2>"+d.toString()+"</h2>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
