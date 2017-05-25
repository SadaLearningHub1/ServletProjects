package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class BillPaymetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public BillPaymetServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		HttpSession session = req.getSession();
		double price=0;
		String str1[] = (String[])session.getAttribute("pd");
		String str2[] = (String[])session.getAttribute("lap");
		if(str1!=null){
			for(int i=0;i<str1.length;i++){
				price = price+250;
			}
		}
		
		if(str2!=null){
			for(int i=0;i<str2.length;i++){
				price = price+2500;
			}
		}
		PrintWriter pw = res.getWriter();
		pw.println("U are seleted the following items <br>");
		pw.println("<ul>");
		if(str1!=null){
			for(int i=0;i<str1.length;i++){
				pw.println("<li>"+str1[i]+"</li>");
				pw.println("<br/>");
			}
		}
		
		if(str2!=null){
			for(int i=0;i<str2.length;i++){
				pw.println("<li>"+str2[i]+"</li>");
				pw.println("<br/>");
			}
		}
		pw.println("</ul>");
		pw.println("Total price: "+price);
		pw.println("<br/>");
		pw.println("<a href=logoutsrv>Logout</a>");
		pw.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
