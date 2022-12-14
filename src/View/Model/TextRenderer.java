package View.Model;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TextRenderer extends JTextArea implements TableCellRenderer {
    public TextRenderer() {
        //将表格设为自动换行
        setLineWrap(true); //利用JTextArea的自动换行方法
        setWrapStyleWord(true);
    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        int maxPreferredHeight = 0;
        for (int i = 0; i < table.getColumnCount(); i++) {
            setText("" + table.getValueAt(row, i));
            setSize(table.getColumnModel().getColumn(column).getWidth(), 0);
            maxPreferredHeight = Math.max(maxPreferredHeight, getPreferredSize().height);

        }
        if (table.getRowHeight(row) != maxPreferredHeight) // 少了这行则处理器瞎忙
            table.setRowHeight(row, maxPreferredHeight);
        setText(value == null ? "" : value.toString());
        return this;
    }
}
