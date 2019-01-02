package presentation.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePane  extends JPanel{
	
	private String image; 
	private BufferedImage imagebuffer;
    private Color bgColor = new Color(250,227,214);

    public BufferedImage getImagebuffer() {
    	setBackground(Color.green);
		return imagebuffer;
	}

	public void setImagebuffer(BufferedImage imagebuffer) {
		this.imagebuffer = imagebuffer;
	}

	public ImagePane(String image) {
		setBackground(bgColor);

		try {
    	   imagebuffer = ImageIO.read(new File(image));
       } catch (IOException ex) {
       }
    }
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(imagebuffer, 0, 0,this.getWidth(),this.getHeight(), null);
	}
}
