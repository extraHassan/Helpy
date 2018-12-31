package presentation.mailing;

import presentation.components.Designer;
import presentation.components.ImagePane;
import services.MailService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MailFrame extends JFrame {
    private RowMail de=new RowMail("De");
    private RowMail destinataire = new RowMail("à");
    private RowMail object = new RowMail("Objet");
    private JLabel send = new JLabel();

    private JTextArea message = new JTextArea();
    private Designer designer = new Designer();
    private JScrollPane jScrollPane;

    private JPanel north = new JPanel(new GridLayout(3,1,0,15));
    public MailFrame(){
        initFrame();
    }

    public void initSend(){
        send.setIcon(new ImageIcon("resources/images/send.png"));
        send.setHorizontalAlignment(0);
        send.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                send.setIcon(new ImageIcon("resources/images/readySend.png"));
                send.setCursor(new Cursor(Cursor.HAND_CURSOR));
                send.setBackground(designer.getOpacityBgColor());
                send.setOpaque(true);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                send.setIcon(new ImageIcon("resources/images/send.png"));
                send.setOpaque(false);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                String password=null;
                String emetteur = de.getValue();
                String recepteur = destinataire.getValue();
                String objet = object.getValue();
                String lettre = message.getText();
                int status = 0;
                if(emetteur.isEmpty() || !emetteur.contains("@gmail.")){
                    status=-1;
                }
                else if(recepteur.isEmpty() || !recepteur.contains("@gmail.")){
                    status=-2;
                }
                else if(objet.isEmpty())
                    status=-3;
                else if(lettre.isEmpty())
                    status=-4;
                else {
                    password = JOptionPane.showInputDialog(null,"plz insert your gmail password");
                    if(password.isEmpty())
                        status=-5;
                    else {
                        //here call the service
                        status=1;
                    }
                }
                switch (status){
                    case  0 : JOptionPane.showMessageDialog(null,"une erreur s'est produite !","cannot send the message !", 2);break;
                    case -1 : JOptionPane.showMessageDialog(null,"l'email de l'emetteur n'est pas valide !","cannot send the message !", 2);break;
                    case -2 : JOptionPane.showMessageDialog(null,"l'email de recepteur n'est pas valide ! ","cannot send the message !", 2);break;
                    case -3 : JOptionPane.showMessageDialog(null,"l'objet est vide ! ","cannot send the message !", 2);break;
                    case -4 : JOptionPane.showMessageDialog(null,"le message est vide !","cannot send the message !", 2);break;
                    case -5 : JOptionPane.showMessageDialog(null,"mot de passe n'est pas valide","cannot send the message !", 2);break;
                    default : {
                        MailService mailService = new MailService();
                        mailService.sendEmail(emetteur,password,recepteur,objet,lettre);
                        JOptionPane.showMessageDialog(null,"message bien envoyé ","cannot send the message !", 1);
                    }
                }


            }
        });
    }

    public void initNorth(){
        north.add(de);
        north.add(destinataire);
        north.add(object);
        north.setBorder(BorderFactory.createEmptyBorder(0,0,15,0));
        north.setOpaque(false);
    }


    public void initMessage(){
        message.setOpaque(false);
        message.setFont(designer.getFont());
        message.setForeground(designer.getBgColor());
        message.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        jScrollPane= new JScrollPane(message) {
            @Override
            protected void paintComponent(Graphics g) {
                try {
                    Composite composite = ((Graphics2D)g).getComposite();

                    ((Graphics2D)g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
                    g.setColor(getBackground());
                    g.fillRect(0, 0, getWidth(), getHeight());

                    ((Graphics2D)g).setComposite(composite);
                    paintChildren(g);
                }
                catch(IndexOutOfBoundsException e) {
                    super.paintComponent(g);
                }
            }
        };

        jScrollPane.getViewport().setOpaque(false);
        jScrollPane.setOpaque(false);

    }
    public void initFrame(){
        initNorth();
        initMessage();
        initSend();

        ImagePane contentPane = new ImagePane("resources/images/mail.jpg");
        contentPane.setLayout(new BorderLayout());
        contentPane.add(north,BorderLayout.NORTH);
        contentPane.add(jScrollPane,BorderLayout.CENTER);
        contentPane.add(send,BorderLayout.SOUTH);
        contentPane.setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
        contentPane.setPreferredSize(new Dimension(500,600));

        setTitle("Email");
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        pack();


    }

    public static void main(String[] args) {
        new MailFrame();
    }
}
