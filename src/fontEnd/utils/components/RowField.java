package fontEnd.utils.components;

import javax.swing.*;
import java.awt.*;

public class RowField  extends JPanel{
    private JLabel title ;
    private JTextField input;
    private Designer designer = new Designer();
    private JPanel rowContainer ;
    @Override
    public void setName(String name) {
        title.setText(name);
    }

    public JLabel getTitle() {
        return title;
    }

    public JTextField getInput() {
        return input;
    }

    public JPanel getRowContainer() {
        return rowContainer;
    }

    public void fillInput(String text){
        this.input.setText(text);
    }

    public void setInput(JTextField input) {
        this.input = input;
    }

    public RowField(String label, int size){
        title = new JLabel(label);
        title.setForeground(designer.getFontColor());
        title.setFont(designer.getFont());
        input = new JTextField(size);
        rowContainer = new JPanel();
        rowContainer.setLayout(new GridLayout(1,2));
        rowContainer.add(title);
        rowContainer.add(input);
        rowContainer.setBackground(designer.getHeavyBgColor());
        setLayout(new BorderLayout());
        rowContainer.setPreferredSize(new Dimension(54,30));
        rowContainer.setBorder(designer.getBlackBottomMatteBorder());
        add(rowContainer,BorderLayout.CENTER);
    }
}
