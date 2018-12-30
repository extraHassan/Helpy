package presentation.medicaments;

import com.sun.xml.internal.ws.wsdl.writer.document.soap.BodyType;
import jdk.nashorn.internal.scripts.JO;
import models.Medicament;
import presentation.components.Designer;
import presentation.components.ImagePane;
import presentation.components.RowField;
import services.MedicamentService;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AddMedicamentPane extends JFrame {
    private ImagePane block_page = new ImagePane("resources/images/141540-OTE8CQ-402.jpg");
    private JButton addButton = new JButton();
    private Designer designer = new Designer();
    private MedicamentService medicamentService = new MedicamentService();


    public AddMedicamentPane(){
        buildBlockPage();
        setContentPane(block_page);
        pack();
        setTitle("Ajouter un nouveau médicament");
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void buildBlockPage(){
        RowField[] rowFields  = new RowField[6];

        block_page.setLayout(new GridLayout(7,1,5,5));
            addButton.setLayout(new FlowLayout(FlowLayout.CENTER));
            addButton.setIcon(new ImageIcon("resources/images/add.png"));
            addButton.setHorizontalAlignment(0);
            addButton.setBackground(designer.getLightGreen());
            addButton.addMouseListener(new MouseAdapter() {

                public void mouseEntered(MouseEvent e) {
                    addButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                public void mouseClicked(MouseEvent e) {

                    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");
                    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    int errorCode = 0;

                    if (rowFields.length!=0){
                        for(int i=0;i<rowFields.length;i++){
                            if (rowFields[i].getInput().getText().isEmpty())
                                errorCode=1;
                        }
                    }else {
                        JOptionPane.showMessageDialog(null,"veuillez remplir tous les champs !");
                        errorCode=2;
                    }

                    if (errorCode==1){
                        JOptionPane.showMessageDialog(null,"veuillez remplir tous les champs !");
                    }
                    else {
                        try{
                            LocalTime time = LocalTime.parse(rowFields[3].getInput().getText(),timeFormatter);
                            System.out.println(rowFields[4].getInput().getText());
                            LocalDate date = LocalDate.parse(rowFields[4].getInput().getText(),dateFormatter);

                            Medicament med = new Medicament();
                            med.setName(rowFields[0].getInput().getText());
                            med.setUseCase(rowFields[1].getInput().getText());
                            med.setWhen(rowFields[2].getInput().getText());
                            med.setTime(time);
                            med.setEnd(date);
                            med.setPrice(rowFields[5].getInput().getText());
                            medicamentService.addMedicament(med);
                            JOptionPane.showMessageDialog(null,"Médicament bien ajouté","info", 1);

                        }catch (Exception i){
                            System.out.println(i.getMessage());
                            JOptionPane.showMessageDialog(null,"le format de la date et de l'heure n'est pas correcte !");
                        }
                    }
                }
            });


            for (int i=0;i<rowFields.length;i++){
                rowFields[i]= new RowField("default",15);
                rowFields[i].getRowContainer().setBackground(designer.getOpacityBgColor());
                rowFields[i].getInput().setForeground(designer.getFontColor());
                rowFields[i].getInput().setFont(designer.getFont());
                rowFields[i].getInput().setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED,designer.getOpacityBgColor(),Color.white));
            }

            rowFields[0].setName("Nom");
            rowFields[1].setName("Cas d'utilisation");
            rowFields[2].setName("Quand utiliser ? ");
            rowFields[3].setName("A quel heure ? ");
            rowFields[4].setName("Date de fin");
            rowFields[5].setName("Prix");

            for (int i=0;i<rowFields.length;i++){
                block_page.add(rowFields[i]);
            }

            block_page.setBorder(BorderFactory.createEmptyBorder(40,40,40,40));
            block_page.setPreferredSize(new Dimension(600,600));
            block_page.setBackground(designer.getBgColor());
            block_page.add(addButton);
    }

    public static void main(String[] args) {
        new AddMedicamentPane();
    }
}
