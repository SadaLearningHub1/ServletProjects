package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UrlRewritingServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UrlRewritingServlet1() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession(true);
		PrintWriter pw = res.getWriter();
		String s1 = req.getParameter("uname");
		String s2 = req.getParameter("pwd");
		session.setAttribute("user", s1);
		session.setAttribute("pass", s2);
		pw.println("<form action="+res.encodeURL("srv2")+">");
		pw.println("Email : <input type=text name='email'><br/>");
		pw.println("<input type=submit value='click'>");
		pw.println("</form>");
		pw.close();
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
