package presentation.components;

import javax.swing.*;
import java.awt.*;

public class SeeThroughTabbedPane extends JTabbedPane {

    private float alpha;

    public SeeThroughTabbedPane() {
        setOpaque(false);
        setAlpha(1f);
    }

    public void setAlpha(float value) {
        if (alpha != value) {
            float old = alpha;
            this.alpha = value;
            firePropertyChange("alpha", old, alpha);
            repaint();
        }
    }

    public float getAlpha() {
        return alpha;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
        g2d.fillRect(0, 0, getWidth(), getHeight());
        g2d.dispose();
        super.paintComponent(g);
    }

}