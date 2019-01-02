package frontEnd.utils.components;

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

        JPanel pane = new JPanel();
        pane.setLayout(new GridLayout(1,2,2,2));
        pane.add(this.title);
        pane.add(this.value);
        pane.setOpaque(false);

        setLayout(new BorderLayout());
        add(pane,BorderLayout.CENTER);
        setOpaque(false);
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
