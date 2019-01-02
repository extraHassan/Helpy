package fontEnd.utils.listeners;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ToUpperCase extends KeyAdapter {

	public ToUpperCase() {
		// TODO Auto-generated constructor stub
	}
	
	public void keyTyped(KeyEvent e) {
		char c=e.getKeyChar();

		if ((c< 'a' || c> 'z') && (c<'A' || c>'Z')) {
			e.setKeyChar((char)0);
		}
		else if((c< 'A' || c> 'Z')){
			c=(char)(e.getKeyChar()-'a'+'A');
			e.setKeyChar(c);
		}
	}
}
