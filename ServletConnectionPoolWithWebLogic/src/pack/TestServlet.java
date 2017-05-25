package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.Context;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DataSource ds;
    public TestServlet() {
        super();
    }
    
    public void init() throws ServletException{
    	try{
    		//the following code is to obtain ds object
    		Properties p = new Properties();
    		//Register JNDI properties
    		p.put(Context.INITIAL_CONTEXT_FACTORY,"weblogic.jndi.WLInitialContextFactory");
    		p.put(Context.PROVIDER_URL, "t3://localhost:7001");
    		InitialContext ctx = new InitialContext(p);
    		Object o = ctx.lookup("orajndi");
    		ds = (DataSource)o;
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try{
			//obtain connection from the pool
			Connection con = ds.getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dept");
			PrintWriter pw = res.getWriter();
			while(rs.next()){
				pw.println("Dept No: "+rs.getString(1)+"<br/>");
				pw.println("Dept Name: "+rs.getString(2)+"<br/>");
				pw.println("Dept localtion: "+rs.getString(3)+"<br/>");
				pw.println("----------------");
				pw.println("<br/>");
			}
			rs.close();
			stmt.close();
			con.close();
			pw.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
