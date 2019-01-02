package presentation;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	JPanel block_page; 
	
	JButton b0 = new JButton("title"); 
	JButton b1 = new JButton("contacts"); 
	JButton b2 = new JButton("agenda"); 
	JButton b3 = new JButton("priere"); 
	JButton b4 = new JButton("medicaments"); 
	JButton b5 = new JButton("email"); 

	JPanel center = new JPanel(new GridLayout(2, 2)); 
	
	public void build() {
		center.add(b1); 
		center.add(b2); 
		center.add(b3); 
		center.add(b4); 
		block_page = new JPanel(new BorderLayout());
		block_page.add(center,BorderLayout.CENTER);
		block_page.add(b5,BorderLayout.SOUTH);
		block_page.add(b0,BorderLayout.NORTH);
	}
	
	public Frame() {
		build();
		setContentPane(block_page);
		setTitle("for Ever");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
	
	
	
}
