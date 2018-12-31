package presentation.contacts;

import models.Contact;
import presentation.components.Designer;
import presentation.components.ImagePane;
import presentation.components.RowField;
import services.ContactService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class ManageContact extends JPanel {
    private Designer designer = new Designer();
    private JPanel image = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel form = new JPanel(new GridLayout(7,1));
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));
    private ContactService contactService = new ContactService() ;
    private JButton add;

    public ManageContact() {
        setLayout(new BorderLayout());
        setBackground(Color.blue);
        buildPane();
    }

    public void initAdd(){
        add = new JButton();
        add.setIcon(new ImageIcon("resources/images/add.png"));
        add.setBackground(designer.getBgColor());
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String firstName = ((RowField)form.getComponent(0)).getInput().getText();
                String lastName= ((RowField)form.getComponent(1)).getInput().getText();
                String group = ((RowField)form.getComponent(2)).getInput().getText();
                String tel = ((RowField)form.getComponent(3)).getInput().getText();
                String image ="no image";

                System.out.println(firstName);
                System.out.println(lastName);
                System.out.println(group);
                System.out.println(tel);
                System.out.println(image);

                if (!firstName.isEmpty() && !lastName.isEmpty() && !group.isEmpty() && !tel.isEmpty()){

                    Contact contact = new Contact();
                    contact.setDateAdded(LocalDate.now());
                    contact.setFavorite(false);
                    contact.setGroup(group);
                    contact.setName(firstName+" "+lastName);
                    contact.setNumber(tel);
                    contact.setImage(image);


                    contactService.addContact(contact);
                }

            }
        });
    }

    public void initSaveOrRest(){
        initAdd();

        JButton reset = new JButton();
        reset.setIcon(new ImageIcon("resources/images/eraser.png"));
        reset.setBackground(designer.getBgColor());


        reset.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Component[] components= form.getComponents();
                for (Component comp : components){
                    RowField rowField = ((RowField)comp);
                    rowField.fillInput("");
                }
            }
        });
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
        setBorder(designer.getSmallMargin());
        setBackground(designer.getHeavyBgColor());
        add(image,BorderLayout.NORTH);
        add(form,BorderLayout.CENTER);
        add(saveOrReset,BorderLayout.SOUTH);
    }

}
