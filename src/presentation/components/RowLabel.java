package presentation.components;

import javax.swing.*;
import java.awt.*;

public class RowLabel extends JPanel {
    private JLabel title;
    private JLabel value;
    private Designer designer = new Designer();

    public RowLabel(String title,String value){
        this.title=new JLabel(title);
        this.value=new JLabel(value);
        initLabels();
        setLayout(new GridLayout(1,2,2,2));
        add(this.title);
        add(this.value);
    }

    public void initLabels(){
        title.setHorizontalAlignment(0);
        value.setHorizontalAlignment(0);
        title.setFont(designer.getFont());
        value.setFont(designer.getFont());
        title.setForeground(designer.getFontColor());
        value.setForeground(designer.getFontColor());
    }
}
