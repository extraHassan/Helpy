package frontEnd.medicaments;

import backEnd.models.Medicament;
import frontEnd.utils.components.Designer;
import frontEnd.utils.components.RowLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RowMedicament extends JPanel {

    private Medicament medicament;
    private Designer designer = new Designer();
    private ListMedicament bigContainer;

    public RowMedicament(ListMedicament bigContainer, Medicament medicament){
        this.medicament = medicament;
        this.bigContainer=bigContainer;
        buildPane();
    }


    public JPanel getNorth(){
        JLabel name = new JLabel();
        name.setText(medicament.getName());
        name.setHorizontalAlignment(0);
        name.setFont(designer.getFont());
        name.setForeground(designer.getFontColor());

        JPanel north = new JPanel(new GridLayout(1,1,4,4));
        north.add(name);
        north.setOpaque(false);
        north.setPreferredSize(new Dimension(north.getWidth(),45));

        return north;
    }

    public JPanel getSouth(){
        JLabel delete = new JLabel();
        delete.setIcon(new ImageIcon("resources/images/x.png"));
        delete.setHorizontalAlignment(0);

        JPanel south = new JPanel(new GridLayout(1,1,4,4));
        south.add(delete);
        south.setOpaque(false);
        south.setPreferredSize(new Dimension(south.getWidth(),65));

        delete.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                int response = JOptionPane.showConfirmDialog(null,"vous voulez vraiment supprimer ce médicament ? ");
                if(response==0){
                    bigContainer.deleteRowMedicament(medicament.getId());
                }
            }
        });

        return south;
    }

    public JPanel getCenter(){
        JLabel icon = new JLabel();
        icon.setIcon(new ImageIcon("resources/images/sa3a.png"));
        icon.setHorizontalAlignment(0);
        icon.setVerticalAlignment(0);

        RowLabel v1 = new RowLabel("date de fin",medicament.getEnd().toString());
        RowLabel v2 = new RowLabel("Quand ?",medicament.getWhen());
        RowLabel v3 = new RowLabel("A quel heure ?",medicament.getTime().toString());

        JPanel centerLeft = new JPanel();
        centerLeft.setLayout(new GridLayout(3,1,4,4));
        centerLeft.add(v2);
        centerLeft.add(v3);
        centerLeft.add(v1);
        centerLeft.setBackground(designer.getBgColor());
        centerLeft.setOpaque(false);

        JPanel centerLeftContainer = new JPanel(new BorderLayout());
        centerLeftContainer.setOpaque(false);
        centerLeftContainer.add(icon,BorderLayout.NORTH);
        centerLeftContainer.add(centerLeft,BorderLayout.CENTER);

        JLabel icon2 = new JLabel();
        icon2.setIcon(new ImageIcon("resources/images/info.png"));
        icon2.setHorizontalAlignment(0);
        icon2.setVerticalAlignment(0);

        RowLabel i1 = new RowLabel("Case d'utilisation",medicament.getUseCase());
        RowLabel i2 = new RowLabel("Prix",medicament.getPrice().toString());

        JPanel centerRight = new JPanel();
        centerRight.setLayout(new GridLayout(2,1,4,4));
        centerRight.add(i1);
        centerRight.add(i2);
        centerRight.setOpaque(false);

        JPanel centerRightContainer = new JPanel(new BorderLayout());
        centerRightContainer.setOpaque(false);
        centerRightContainer.add(icon2,BorderLayout.NORTH);
        centerRightContainer.add(centerRight,BorderLayout.CENTER);
        centerRightContainer.setBorder(BorderFactory.createMatteBorder(0,1,0,0,new Color(0, 0, 0)));

        JPanel center =new JPanel(new GridLayout(1,2,4,4));
        center.add(centerLeftContainer);
        center.add(centerRightContainer);
        center.setOpaque(false);

        JPanel centerContainer = new JPanel(new BorderLayout());
        centerContainer.add(center,BorderLayout.CENTER);
        centerContainer.setOpaque(false);

        return centerContainer;
    }

    public void buildPane(){
        JPanel block_pane = new JPanel();
        block_pane.setOpaque(false);
        block_pane.setLayout(new BorderLayout());
        block_pane.add(getNorth(),BorderLayout.NORTH);
        block_pane. add(getCenter(),BorderLayout.CENTER);
        block_pane.add(getSouth(),BorderLayout.SOUTH);
        block_pane.setOpaque(false);

        setLayout(new BorderLayout());
        add(block_pane,BorderLayout.CENTER);
        setBackground(designer.getOpacityBgColor());
        setPreferredSize(new Dimension(700,300));
    }

}
