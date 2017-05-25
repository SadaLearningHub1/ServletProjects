package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SelectServlet() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		String qry = req.getParameter("cmd");
		ServletConfig config = getServletConfig();
		String s1 = config.getInitParameter("driver");
		String s2 = config.getInitParameter("url");
		String s3 = config.getInitParameter("user");
		String s4 = config.getInitParameter("pwd");
		try {
			System.out.println(s1 + " : " + s2 + " : " + s3 + " : " + s4);
			Class.forName(s1);
			System.out.println("Driver register on: " + s1);
			Connection con = DriverManager.getConnection(s2, s3, s4);
			System.out.println("connection is opened");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			PrintWriter pw = res.getWriter();
			pw.println("<center><table border=3>");
			pw.println("<tr>");
			for (int i = 1; i <= columnCount; i++) {
				pw.println("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			pw.println("</tr>");
			while (rs.next()) {
				pw.println("<tr>");
				for (int j = 1; j <= columnCount; j++) {
					pw.println("<td>" + rs.getString(j) + "</td>");
				}
				pw.println("</tr>");
			}
			pw.println("</table></center>");
			pw.close();
			rs.close();
			stmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
