package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ShowServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext ctx = getServletContext();
		Object o = ctx.getAttribute("users");
		ArrayList al= (ArrayList)o;
		PrintWriter pw = response.getWriter();
		pw.println("<center><h2><table border=2>");
		pw.println("<tr>");
		pw.println("<th>uname</th><th>Email</th><th>Hobbies</th>");
		pw.println("</tr>");
		Iterator it = al.iterator();
		while(it.hasNext()){
			Object o1 = it.next();
			User u = (User)o1;
			pw.println("<tr>");
			pw.println("<td>"+u.getUname()+"</td>");
			pw.println("<td>"+u.getEmail()+"</td>");
			StringBuffer sb = new StringBuffer();
			String h[] = u.getHobby();
			for(int i=0;i<h.length;i++){
				sb.append(h[i]+" ");
			}
			pw.println("<td>"+sb.toString()+"</td>");
			pw.println("</tr>");
		}
		pw.println("</table></center></h2>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
