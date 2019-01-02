package frontEnd.agenda;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;

//use it only if you want to decorate the actual date
public class CellOfTheDay extends DefaultTableCellRenderer {
    private int rowSearched;
    private int columnSearched;

    public CellOfTheDay(int rowSearched,int columnSearched){
        this.rowSearched=rowSearched;
        this.columnSearched=columnSearched;
    }
    public Component getTableCellRendererComponent(JTable table,Object value,boolean isSelected,boolean hasFocus,int row,int column) {
        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        // Only for specific cell
        if (row == rowSearched && column == columnSearched) {
            c.setBackground(Color.red);
            c.setForeground(Color.green);
        }
        return c;
    }
}