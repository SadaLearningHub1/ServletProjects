package pack;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;

public class CountListener implements ServletRequestAttributeListener{
	private static int count1,count2, count3;

	@Override
	public void attributeAdded(ServletRequestAttributeEvent srae) {
		count1++;
	}

	@Override
	public void attributeRemoved(ServletRequestAttributeEvent srae) {
		count2++;
	}

	@Override
	public void attributeReplaced(ServletRequestAttributeEvent srae) {
		count3++;
	}
	public static int getCount1(){
		return count1;
	}
	public static int getCount2(){
		return count2;
	}
	public static int getCount3(){
		return count3;
	}
	

}
