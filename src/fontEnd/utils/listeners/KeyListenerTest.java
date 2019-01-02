package fontEnd.utils.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest implements KeyListener {

	public KeyListenerTest() {
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keypressed : "+e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {	
		System.out.println("released : "+e.getKeyCode());
	}

	public void keyTyped(KeyEvent e) {
		System.out.println("typed:pour les touches imprimables : "+ e.getKeyCode()+": "+e.getKeyChar());
	}
}
