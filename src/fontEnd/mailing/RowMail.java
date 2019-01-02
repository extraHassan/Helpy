package fontEnd.mailing;

import fontEnd.utils.components.Designer;

import javax.swing.*;
import java.awt.*;

public class RowMail extends JPanel {
    private JLabel destinationLabel = new JLabel();
    private JTextField destinationField = new JTextField(15);
    private Designer designer = new Designer();

    public  RowMail(String text){
        buildPane(text);
    }


    public void buildPane(String textLabel){
        initDestinationLabel(textLabel);
        initDestinationField();
        setBackground(new Color(250,227,214,80));
        setLayout(new BorderLayout());

        JPanel labelContainer = new JPanel(new GridLayout(1,2));
        labelContainer.add(destinationLabel);
        labelContainer.add(destinationField);
        labelContainer.setOpaque(false);
        add(labelContainer,BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(10,5,10,5));
        setPreferredSize(new Dimension(this.getWidth(),45));
    }

    public void initDestinationLabel(String text){
        destinationLabel.setText(text);
        destinationLabel.setFont(designer.getFont());
        destinationLabel.setForeground(Color.white);
        destinationLabel.setHorizontalAlignment(0);
        destinationLabel.setPreferredSize(new Dimension(destinationField.getWidth(),15));
    }

    public void initDestinationField(){
        destinationField.setBackground(new Color(232, 232, 232));
        destinationField.setPreferredSize(new Dimension(destinationField.getWidth(),25));
        destinationField.setBorder(BorderFactory.createSoftBevelBorder(2));
        destinationField.setBorder(BorderFactory.createLoweredSoftBevelBorder());
        destinationField.setFont(designer.getFont());
        destinationField.setForeground(designer.getFontColor());
    }

    public String getValue(){
        return destinationField.getText();
    }
}
