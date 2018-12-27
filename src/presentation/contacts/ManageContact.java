package presentation.contacts;

import presentation.components.Designer;
import presentation.components.ImagePane;
import presentation.components.RowField;
import services.ContactService;

import javax.swing.*;
import java.awt.*;

public class ManageContact extends JPanel {
    private Designer designer = new Designer();
    private JPanel image = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel form = new JPanel(new GridLayout(7,1));
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));
    private ContactService contactService = new ContactService() ;

    public ManageContact() {
        setLayout(new BorderLayout());
        setBackground(Color.blue);
        buildPane();
    }
    public void initSaveOrRest(){
        JButton add = new JButton();
        add.setIcon(new ImageIcon("resources/images/add.png"));

        JButton reset = new JButton();
        reset.setIcon(new ImageIcon("resources/images/eraser.png"));
        add.setBackground(designer.getBgColor());
        reset.setBackground(designer.getBgColor());
        saveOrReset.add(add);
        saveOrReset.add(reset);
        saveOrReset.setBackground(designer.getBgColor());
    }
    public void initImage(){
        ImagePane imagePane = new ImagePane("resources/images/add-contacts.png");
        imagePane.setPreferredSize(new Dimension(180,180));
        image.add(imagePane);
        image.setBackground(designer.getBgColor());
        image.setBorder(designer.getBlackBottomMatteBorder());
    }

    public void initForm(){
       form.add(new RowField("nom : ",15));
       form.add(new RowField("prénom : ",15));
       form.add(new RowField("groupe : ",15));
       form.add(new RowField("numéro de téléphone 1: ",15));
       form.add(new RowField("numéro de téléphone 2: ",15));
       form.add(new RowField("numéro de téléphone 3: ",15));
       form.add(new RowField("numéro de téléphone 4: ",15));
       //form.setPreferredSize(new Dimension(360,form.getPreferredSize().height));
       form.setBackground(designer.getLightGreen());
    }

    public void buildPane(){
        initSaveOrRest();
        initImage();
        initForm();
        setBorder(designer.getEmptyBorder());
        setBackground(designer.getHeavyBgColor());
        add(image,BorderLayout.NORTH);
        add(form,BorderLayout.CENTER);
        add(saveOrReset,BorderLayout.SOUTH);
    }

}
