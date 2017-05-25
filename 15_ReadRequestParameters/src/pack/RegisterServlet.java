package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		// read parameter names
		Enumeration e = req.getParameterNames();
		while (e.hasMoreElements()) {
			Object o = e.nextElement();
			String str = (String) o;
			String val[] = req.getParameterValues(str);
			if (val.length > 1) {
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < val.length; i++) {
					sb.append(val[i]);
					sb.append(" ");
				}
				pw.println("<center><h2>" + str + ":" + sb.toString()
						+ "</h2></center>");
			} else {
				pw.println("<center><h2>" + str + ":" + val[0]
						+ "</h2><center>");
			}
		}
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
