package presentation.components;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

public class FileChooserImageListener extends MouseAdapter {
    private String imagePath="noSelect";
    private JLabel picLabel ;

    public FileChooserImageListener(JLabel picLabel) {
        this.picLabel = picLabel;
    }

    public String getImagePath() {
        return imagePath;
    }

    public ImageIcon resizeImage(String path ) {
        ImageIcon icon = new ImageIcon(path);
        Image image = icon.getImage();
        Image image2 = image.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon icon2 = new ImageIcon(image2);
        return icon2;
    }
    public void mouseClicked(MouseEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images","jpeg","png","JPEG","PNG","GIF","gif");
        fileChooser.addChoosableFileFilter(filter);
        int result = fileChooser.showSaveDialog(null);
        if(result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            imagePath= file.getPath();
            System.out.println("image choisie : "+imagePath);
            if(picLabel!= null) {
                picLabel.setIcon(resizeImage(imagePath));
            }
        }else if(result == JFileChooser.CANCEL_OPTION) {
            imagePath="noSelect";
        }
    }


}
