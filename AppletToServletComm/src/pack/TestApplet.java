package pack;

import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class TestApplet extends Applet implements ActionListener {
	Label l;
	Button b;
	TextField tf1;
	public void init(){
		l = new Label("enter select command");
		tf1 = new TextField(30);
		b = new Button("click");
		Font f = new Font("Arial", Font.BOLD,20);
		l.setFont(f);
		add(l);
		tf1.setFont(f);
		add(tf1);
		b.setFont(f);
		add(b);
		b.addActionListener(this);
	}
	
	public void paint(Graphics g){
		setBackground(Color.cyan);
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		try{
			String s = tf1.getText();
			URL url = new URL("http://localhost:2020/AppletToServletComm/testsrv?cmd="+s);
			AppletContext ctx = getAppletContext();
			ctx.showDocument(url);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

}
