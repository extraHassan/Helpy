package presentation.prieres;

import models.Prayer;
import presentation.components.Designer;

import javax.swing.*;
import java.awt.*;

public class RowPray extends  JPanel{

    private JLabel frenchName;
    private JLabel arabicName;
    private JLabel time;

    private Designer designer = new Designer();
    private Prayer prayer;

    public RowPray(Prayer prayer ){
        this.prayer=prayer;
        initLabels();
        buildPane();
        setOpaque(false);
    }

    public void buildPane(){
        setLayout(new GridLayout(1,3));
        setBackground(designer.getBgColor());
        setBorder(designer.getBottomMatteBorder());
        add(frenchName);
        add(time);
        add(arabicName);
    }

    public void initLabels(){
        frenchName= new JLabel(prayer.getFrenchName());
        arabicName= new JLabel(prayer.getArabicName());
        time= new JLabel(prayer.getTime().toString());

        arabicName.setFont(designer.getFont());
        arabicName.setForeground(designer.getFontColor());
        frenchName.setFont(designer.getFont());
        frenchName.setForeground(designer.getFontColor());
        time.setFont(designer.getFont());
        time.setForeground(designer.getFontColor());
    }
}
