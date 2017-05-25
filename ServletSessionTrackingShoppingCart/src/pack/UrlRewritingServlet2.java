package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlRewritingServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UrlRewritingServlet2() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession hs = req.getSession(true);
		PrintWriter pw = res.getWriter();
		String s1 = (String)hs.getAttribute("user");
		String s2 = (String)hs.getAttribute("pwd");
		String s3 = req.getParameter("email");
		pw.println("user name: "+s1);
		pw.println("<br>");
		pw.println("password: "+s2);
		pw.println("<br/>");
		pw.println("Email : "+s3);
		pw.close();
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
