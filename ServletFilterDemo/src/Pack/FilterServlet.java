package Pack;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;
    public FilterServlet() {
        super();
    }

	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		System.out.println("Servlet logic starts");
		PrintWriter pw = response.getWriter();
		try{
			Thread.sleep(8900);
		}catch(Exception e){
		}
		pw.println("<center><h2>Hello</h2></center>");
		pw.close();

	}

}
