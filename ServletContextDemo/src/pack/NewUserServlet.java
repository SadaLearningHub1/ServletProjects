package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewUserServlet extends HttpServlet {
	ArrayList al;
	public void init() throws ServletException{
		al = new ArrayList();
	}
	private static final long serialVersionUID = 1L;
    public NewUserServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String s1 = req.getParameter("uname");
		String s2 = req.getParameter("email");
		String s3[] = req.getParameterValues("hobby");
		User u = new User();
		u.setUname(s1);
		u.setEmail(s2);
		u.setHobby(s3);
		al.add(u);
		ServletContext ctx = getServletContext();
		ctx.setAttribute("users", al);
		PrintWriter pw = res.getWriter();
		pw.println("<h2>New user added successfully</h2>");
		pw.println("<a href=index.html>Home</a>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
