package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class VoterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VoterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String str=req.getParameter("age");
		int k = Integer.parseInt(str);
		PrintWriter pw =res.getWriter();
		if(k>=18){
			pw.println("<h1>You are valid voter</h1>");
		}else{
			pw.println("<h1>You are invalid voter</h1>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
