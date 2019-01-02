package presentation.components;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import listeners.AlphaListener;
import listeners.NumericListener;
import listeners.ToUpperCase;


public class LabeledTextField extends JPanel{
	
	public static final NumericListener NUM_LOCK=new NumericListener();
	public static final AlphaListener ALPHA_LOCK=new AlphaListener();
	public static final ToUpperCase To_Upper_Case=new ToUpperCase();
	
	public LabeledTextField(String label,int size) {
		setBackground(Color.white);
		
		if(!label.contains(":")) label = label+" : ";
		JLabel l1 = new JLabel(label);
		l1.setFont(new Font("Georgia", Font.BOLD, 20));
		JTextField t1 = new JTextField(size);
		setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints(); 
		constraints.fill=GridBagConstraints.NONE;
		constraints.weighty=1;
		
		constraints.gridx=0;
		constraints.gridy=0; 
		constraints.weightx=1; 
		constraints.fill=GridBagConstraints.NONE;
		add(l1,constraints);
		constraints.fill=GridBagConstraints.HORIZONTAL;
		constraints.weightx=2;
		constraints.gridx=1;
		constraints.gridy=0; 
		add(t1,constraints); 
		
		
		
		setFieldHeight(35);
	}
	
	public void setFieldHeight(int size) {
		JTextField field = (JTextField)this.getComponent(1) ; 
		field.setPreferredSize(new Dimension(field.getPreferredSize().width, size));
	}
	
	public void setBackgroudField(Color color) {
		((JTextField)getComponent(1)).setBackground(color);
	}

	public void setValue(Object value) {
		((JTextField)getComponent(1)).setText(value.toString());
	}
	public String getValue() {
		return ((JTextField)getComponent(1)).getText();
	}
	public int getIntValue() {
		try {
			return Integer.parseInt(((JTextField)getComponent(1)).getText());
		}catch(Exception e) {
			return -1;
		}
	}
	public double getDoubleValue() {
		try {
			return Double.parseDouble(((JTextField)getComponent(1)).getText());
		}catch(Exception e) {
			return -1;
		}
	}
	
	
	public synchronized void addKeyListener(KeyListener listener){
		getComponent(1).removeKeyListener(NUM_LOCK);
		getComponent(1).removeKeyListener(ALPHA_LOCK);
		getComponent(1).removeKeyListener(To_Upper_Case);
		getComponent(1).addKeyListener(listener);
	}
	public void setNumLock(boolean state){
		if(state){
			addKeyListener(NUM_LOCK);
		}
	}
	public void setAlphaLock(boolean state){
		if(state){
			addKeyListener(ALPHA_LOCK);
		}
	}
	public void setUpperCase(boolean state){
		if(state){
			addKeyListener(To_Upper_Case);
		}
	}

}
