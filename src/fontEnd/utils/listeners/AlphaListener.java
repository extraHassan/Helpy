package fontEnd.utils.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AlphaListener implements KeyListener{

	public AlphaListener() {
		// TODO Auto-generated constructor stub
	}

	public void keyPressed(KeyEvent arg0) {
		
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent e) {
		char c=e.getKeyChar();
		if ((c< 'a' || c> 'z') && (c<'A' || c>'Z')) {
			e.setKeyChar((char)0);
		}
	}

}
