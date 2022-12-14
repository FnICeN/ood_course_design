package View;

import View.Model.DTable;
import com.Utils.ConvertUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchWindow implements ActionListener {
    JFrame jf;
    JLabel label;
    JTextField content;
    JButton confirm;
    public SearchWindow() {

        jf = new JFrame("搜索网络用语");
        label = new JLabel("输入搜索内容：");
        content = new JTextField();
        confirm = new JButton("确认");

        confirm.addActionListener(this);

        jf.add(label, BorderLayout.NORTH);
        jf.add(content, BorderLayout.CENTER);
        jf.add(confirm, BorderLayout.SOUTH);

        jf.setSize(200,150);
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] arr = Main.gc.getSpeakArrayByContent(content.getText());
        DTable dt = new DTable(new Object[][]{arr}, Main.cols);
        Main.table.setModel(dt);
        Main.table.repaint();
        Main.selected = "";
        jf.dispose();
    }
}
