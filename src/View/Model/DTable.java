package View.Model;

import javax.swing.table.DefaultTableModel;

public class DTable extends DefaultTableModel {
    public DTable(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
}
