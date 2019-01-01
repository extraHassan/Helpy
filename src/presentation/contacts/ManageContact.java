package presentation.contacts;

import models.Contact;
import presentation.components.Designer;
import presentation.components.FileChooserImageListener;
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
    private JPanel form = new JPanel();
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));
    private ContactService contactService = new ContactService() ;
    private JButton add;
    private static int index = 0;
    private ListContact communicator;
    private FileChooserImageListener browsImage;


    public ManageContact(ListContact communicator) {
        this.communicator=communicator;
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

                if (!firstName.isEmpty() && !lastName.isEmpty() && !group.isEmpty() && !tel.isEmpty()){
                    String image ;
                    image=browsImage.getImagePath();

                    Contact contact = new Contact();
                    contact.setId(index);index++;
                    contact.setDateAdded(LocalDate.now());
                    contact.setFavorite(false);
                    contact.setGroup(group);
                    contact.setName(firstName+" "+lastName);
                    contact.setNumber(tel);

                    System.out.println("ManageContact contact.setImage :  "+browsImage.getImagePath());

                    if(image!= null && !image.equals("null") ){
                        contact.setImage(browsImage.getImagePath());
                    }else {
                        contact.setImage("resources/images/contact.png");
                    }


                    try{
                        contactService.addContact(contact);
                        communicator.refresh();
                    }catch (Exception i){
                        System.out.println(i.getMessage());
                    }finally {

                    }
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

    public ImageIcon resizeImage(String path,int width,int height ) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image image2 = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image2);
        return icon2;
    }


    public void initImage(){
        JLabel label = new JLabel(resizeImage("resources/images/add-contacts.png",100,100));
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        label.setPreferredSize(new Dimension(100,100));

        browsImage= new FileChooserImageListener(label);
        label.addMouseListener(browsImage);

        image.add(label);
        image.setBackground(designer.getBgColor());
        image.setBorder(designer.getBlackBottomMatteBorder());
    }

    public void initForm(){

        BoxLayout boxLayout = new BoxLayout(form,BoxLayout.Y_AXIS);

       form.setLayout(boxLayout);
       form.add(new RowField("nom : ",15));
       form.add(new RowField("prénom : ",15));
       form.add(new RowField("groupe : ",15));
       form.add(new RowField("numéro de téléphone : ",15));

       Component[] components = form.getComponents();
       for (Component c : components){
           ((RowField)c).getInput().setFont(new Font("Georgia",Font.PLAIN, 25));
       }

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
        setPreferredSize(new Dimension(400,500));

    }
}
