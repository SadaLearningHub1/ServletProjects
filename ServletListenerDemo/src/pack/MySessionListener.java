package pack;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener {

	public static int count;

	@Override
	public void sessionCreated(HttpSessionEvent hse) {
		count++;
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent hse) {
		count--;
	}

	public static int getCount() {
		return count;
	}
}
