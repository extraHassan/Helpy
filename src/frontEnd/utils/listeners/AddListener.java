package frontEnd.utils.listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

public class AddListener implements ActionListener {
	private JTextField source1;
	private JTextField source2;
	private JLabel target;
	


	public AddListener(JTextField source1, JTextField source2, JLabel target) {
		super();
		this.source1 = source1;
		this.source2 = source2;
		this.target = target;
	}



	public void actionPerformed(ActionEvent arg0) { 
		double s=0;
		try{
			s=Double.parseDouble(source1.getText()) + Double.parseDouble(source1.getText());
		}catch(Exception ex){}
		
		target.setText(""+s);
	}

}
