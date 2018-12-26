package presentation.contacts;

import presentation.components.ImagePane;
import presentation.components.LabeledTextField;

import javax.swing.*;
import java.awt.*;

public class ManageContact extends JPanel {

    private ImagePane image = new ImagePane("resources/images/contact-logo-colour.png");
    private JPanel form = new JPanel(new GridLayout(7,1));
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));

    public ManageContact() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(Color.blue);
        buildPane();
    }
    public void initSaveOrRest(){
        saveOrReset.add(new JButton("yes"));
        saveOrReset.add(new JButton("no"));
    }
    public void initImage(){
    }

    public void initForm(){


        form.add(new LabeledTextField("Nom : ",15));
        form.add(new LabeledTextField("Prénom : ",15));
        form.add(new LabeledTextField("Groupe : ",15));
        form.add(new LabeledTextField("Numéro de téléphone 1 : ",15));
        form.add(new LabeledTextField("Numéro de téléphone 2 : ",15));
        form.add(new LabeledTextField("Numéro de téléphone 3 : ",15));
        form.add(new LabeledTextField("Numéro de téléphone 4 : ",15));
    }

    public void buildPane(){
        initSaveOrRest();
        initImage();
        initForm();
        add(image);
        add(form);
        add(saveOrReset);
    }

}
