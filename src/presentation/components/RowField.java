package presentation.components;

import javax.swing.*;
import java.awt.*;

public class RowField  extends JPanel{
    private JLabel title ;
    private JTextField input;

    public RowField(String label, int size){
        Color bgColor = new Color(135, 206, 231);
        setBackground(bgColor);
        title = new JLabel(label);
        title.setBackground(bgColor);
        input = new JTextField(size);
        input.setBackground(bgColor);
        JPanel rowContainer = new JPanel();
        rowContainer.setLayout(new GridLayout(1,2));
        rowContainer.add(title);
        rowContainer.add(input);
        setLayout(new BorderLayout());
        rowContainer.setPreferredSize(new Dimension(54,30));
        add(rowContainer,BorderLayout.NORTH);
    }
}
