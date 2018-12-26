package presentation.contacts;

import javax.swing.*;
import java.awt.*;

public class RowContact extends JPanel {

    private JButton picture = new JButton("picture");
    private JButton favorite = new JButton("fav");
    private JButton header = new JButton("ahmed (mql)");
    private JButton numberPhone = new JButton("+212 635 13 53 48");
    private JButton date = new JButton("added le 15/12/2018 at 12:45 pm");

    public RowContact(){
        setLayout(new BorderLayout());
        add(picture,BorderLayout.EAST);
        add(favorite,BorderLayout.WEST);
        add(header,BorderLayout.NORTH);
        add(numberPhone,BorderLayout.CENTER);
        add(date,BorderLayout.SOUTH);
    }
 }
