package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class MyHttpDBLogin extends HttpServlet {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs;
	private static final long serialVersionUID = 1L;

	public MyHttpDBLogin() {
		super();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String user = req.getParameter("user");
		String pwd = req.getParameter("pwd");
		try {

			Context initContext = new InitialContext();
			System.out.println("got initialcontext");
			Context envContext = (Context) initContext.lookup("java:comp/env");
			// get database object
			DataSource ds = (DataSource) envContext.lookup("jdbc/TestDB");
			// get connection object
			con = ds.getConnection();

			pstmt = con
					.prepareStatement("select * from users where uname=? and pwd=?");
			pstmt.setString(1, user);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				pw.println("valid user");
			} else {
				pw.println("not valid");
			}
		} catch (Exception e) {

		} finally {
			try {
				con.close();
				pstmt.close();
			} catch (Exception e) {

			}
		}
	}

}
