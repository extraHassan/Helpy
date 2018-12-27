package presentation.components;

import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class Designer {

    private Font font =new Font("Georgia",Font.ROMAN_BASELINE, 20);
    private Color bgColor = new Color(250,227,214);
    private Color HeavyBgColor = new Color(227,204,189);
    private Color fontColor= new Color(17,47,59);
    private Color borderColor= new Color(227,204,189);
    private EmptyBorder smallMargin = new EmptyBorder(4,2,4,2);
    private MatteBorder BottomMatteBorder = new MatteBorder(0,0,1,0,borderColor);
    private MatteBorder BlackBottomMatteBorder = new MatteBorder(0,0,1,0,Color.black);
    private EmptyBorder prayerTimesMargin = new EmptyBorder(100,100,100,50);
    private Color lightGreen = new Color(107,186,181);
    private Color heavyGreen = new Color(43,115,121);

    public EmptyBorder getPrayerTimesMargin() {
        return prayerTimesMargin;
    }

    public void setPrayerTimesMargin(EmptyBorder prayerTimesMargin) {
        this.prayerTimesMargin = prayerTimesMargin;
    }

    public Color getHeavyGreen() {
        return heavyGreen;
    }

    public void setHeavyGreen(Color heavyGreen) {
        this.heavyGreen = heavyGreen;
    }

    public Color getLightGreen() {
        return lightGreen;
    }

    public void setLightGreen(Color lightGreen) {
        this.lightGreen = lightGreen;
    }

    public Color getHeavyBgColor() {
        return HeavyBgColor;
    }

    public void setHeavyBgColor(Color heavyBgColor) {
        HeavyBgColor = heavyBgColor;
    }

    public MatteBorder getBlackBottomMatteBorder() {
        return BlackBottomMatteBorder;
    }

    public void setBlackBottomMatteBorder(MatteBorder blackBottomMatteBorder) {
        BlackBottomMatteBorder = blackBottomMatteBorder;
    }

    public void setBottomMatteBorder(MatteBorder bottomMatteBorder) {
        BottomMatteBorder = bottomMatteBorder;
    }

    public MatteBorder getBottomMatteBorder() {
        return BottomMatteBorder;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public Color getBgColor() {
        return bgColor;
    }

    public void setBgColor(Color bgColor) {
        this.bgColor = bgColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public Color getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(Color borderColor) {
        this.borderColor = borderColor;
    }

    public EmptyBorder getSmallMargin() {
        return smallMargin;
    }

    public void setSmallMargin(EmptyBorder smallMargin) {
        this.smallMargin = smallMargin;
    }
}
