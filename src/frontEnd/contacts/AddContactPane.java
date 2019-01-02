package frontEnd.contacts;

import backEnd.models.Contact;
import frontEnd.utils.components.Designer;
import frontEnd.utils.components.FileChooserImageListener;
import frontEnd.utils.components.RowField;
import backEnd.services.ContactService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;

public class AddContactPane extends JPanel {

    private Designer designer = new Designer();
    private JPanel image = new JPanel(new FlowLayout(FlowLayout.CENTER));
    private JPanel form = new JPanel();
    private JPanel saveOrReset = new JPanel(new GridLayout(1,2));
    private ContactService contactService = new ContactService() ;
    private JButton add=new JButton();
    private static int index=0;
    private ListContact communicator;
    private FileChooserImageListener browsImage;


    public AddContactPane(ListContact communicator) {
        this.communicator=communicator;
        setLayout(new BorderLayout());
        setBackground(Color.blue);
        buildPane();
    }

    public void initAdd(){
        add.setIcon(new ImageIcon("resources/images/add.png"));
        add.setBackground(designer.getBgColor());

        add.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                add.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                add.setEnabled(false);
                String firstName = ((RowField)form.getComponent(0)).getInput().getText();
                String lastName= ((RowField)form.getComponent(1)).getInput().getText();
                String group = ((RowField)form.getComponent(2)).getInput().getText();
                String tel = ((RowField)form.getComponent(3)).getInput().getText();
                String image = browsImage.getImagePath();
                //init after getting values
                    initImage();
                    Component[] components= form.getComponents();
                    for (Component comp : components){
                        RowField rowField = ((RowField)comp);
                        rowField.fillInput("");
                    }
                //end initializing

                if (!firstName.isEmpty() && !lastName.isEmpty() && !group.isEmpty() && !tel.isEmpty()){
                    Contact contact = new Contact();
                    contact.setId(index);index++;
                    contact.setDateAdded(LocalDate.now());
                    contact.setFavorite(false);
                    contact.setGroup(group);
                    contact.setName(firstName+" "+lastName);
                    contact.setNumber(tel);
                    contact.setImage(image);
                    try{
                        contactService.addContact(contact);
                        communicator.refresh();
                    }catch (Exception i){
                        System.out.println(i.getMessage());
                    }
                }
                add.setEnabled(true);
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
            public void mouseEntered(MouseEvent e) {
                reset.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

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
        JLabel label = new JLabel(designer.resizeImage("resources/images/add-contacts.png",100,100));
        label.setHorizontalAlignment(0);
        label.setVerticalAlignment(0);
        label.setPreferredSize(new Dimension(100,100));

        browsImage= new FileChooserImageListener(label);
        label.addMouseListener(browsImage);
        image.removeAll();
        image.add(label);
        image.setBackground(designer.getBgColor());
        image.setBorder(designer.getBlackBottomMatteBorder());
        image.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                image.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });
        image.revalidate();
        image.repaint();
    }

    public void initForm(){
       BoxLayout boxLayout = new BoxLayout(form,BoxLayout.Y_AXIS);
       form.removeAll();
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
