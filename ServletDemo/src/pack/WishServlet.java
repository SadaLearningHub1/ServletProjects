package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WishServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public WishServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		String str = req.getParameter("user");
		Calendar c = Calendar.getInstance();
		int h = c.get(Calendar.HOUR_OF_DAY);
		String msg = "";
		if (h <= 12) {
			msg = "Good Morning";
		} else if (h > 12 && h <= 16) {
			msg = "Good Afternoon";
		} else if (h > 16 && h <= 19) {
			msg = "Good Evening";
		} else {
			msg = "Good Night";
		}
		PrintWriter pw = res.getWriter();
		pw.println("<center><font color='green' size=8>" + msg + ": " + str
				+ "</font></center>");
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
