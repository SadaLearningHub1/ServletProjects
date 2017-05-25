package pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RedirectionServlet1() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String s1 = request.getParameter("uname");
		response.sendRedirect("http://localhost:8080/RedirectionApp2/srv2?p1="
				+ s1);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
