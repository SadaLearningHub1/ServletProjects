package pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IncludeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public IncludeServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String str1 = req.getParameter("pid");
		String str2 = req.getParameter("qty");
		int qty = Integer.parseInt(str2);
		int price = qty*100;
		PrintWriter pw = res.getWriter();
		pw.println("<center><h3>");
		pw.println("Product id: "+str1);
		pw.println("<br/>");
		pw.println("Quantity : "+str2);
		pw.println("<br/>");
		pw.println("Price: "+price);
		pw.println("<br/>");
		RequestDispatcher rd = req.getRequestDispatcher("../dd/srv3");
		rd.include(req, res);
		pw.println("</h3></center>");
		pw.close();
		System.out.println("i am in include servlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
