
package pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExcelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ExcelServlet() {
        super();
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("application/und.MS-Excel");
		PrintWriter pw = res.getWriter();
		pw.println("<table border =2>");
		pw.println("<tr><th>sno</th><th>sname</th></tr>");
		pw.println("<tr><td>101</td><td>xxx</td></tr>");
		pw.println("<tr><td>102</td><td>yyy</td></tr>");
		pw.println("</table>");
		pw.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
