package presentation.contacts;

import presentation.components.ImagePane;
import presentation.components.LabeledTextField;
import presentation.components.RowField;

import javax.swing.*;
import java.awt.*;

public class ManageContact extends JPanel {

    private JPanel image = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel form = new JPanel(new GridLayout(7,1));
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));

    public ManageContact() {
        setLayout(new BorderLayout());
        setBackground(Color.blue);
        buildPane();
    }
    public void initSaveOrRest(){
        saveOrReset.add(new JButton("yes"));
        saveOrReset.add(new JButton("no"));
    }
    public void initImage(){
        ImagePane imagePane = new ImagePane("resources/images/contact-logo-colour.png");
        imagePane.setPreferredSize(new Dimension(180,180));
        image.add(imagePane);
    }

    public void initForm(){
       form.add(new RowField("nom : ",15));
       form.add(new RowField("prénom : ",15));
       form.add(new RowField("groupe : ",15));
       form.add(new RowField("numéro de téléphone 1: ",15));
       form.add(new RowField("numéro de téléphone 2: ",15));
       form.add(new RowField("numéro de téléphone 3: ",15));
       form.add(new RowField("numéro de téléphone 4: ",15));
       form.setPreferredSize(new Dimension(330,form.getPreferredSize().height));
    }

    public void buildPane(){
        initSaveOrRest();
        initImage();
        initForm();
        add(image,BorderLayout.NORTH);
        add(form,BorderLayout.CENTER);
        add(saveOrReset,BorderLayout.SOUTH);
    }

}
