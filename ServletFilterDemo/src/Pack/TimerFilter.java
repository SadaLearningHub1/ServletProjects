package Pack;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class TimerFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain fchain) throws IOException, ServletException {
		System.out.println("Pre process start");
		long x = System.currentTimeMillis();
		fchain.doFilter(req, res);
		System.out.println("Post process start");
		long y =System.currentTimeMillis();
		System.out.println("Time taken is "+(y-x)+" ms");
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
