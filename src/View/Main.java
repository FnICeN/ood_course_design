package View;
import View.Model.DTable;
import View.Model.TextRenderer;
import View.Verify.DeleteVerify;
import com.Controller.GeneralController;
import com.Utils.ConvertUtil;
import com.pojo.Speaks;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class Main implements ActionListener {
    public static GeneralController gc = new GeneralController();
    public static String selected = "";
    static String[] cols = {"内容","来源","初义","今义","场景","造句"};
    static Object[][] objs;
    static DTable dt = new DTable(objs, cols);
    static JTable table = new JTable(dt);
    JScrollPane sp = new JScrollPane(table);

    public Main() {
        JFrame jf = new JFrame("网络用语查询系统");
        JPanel pan_top = new JPanel();
        JPanel pan_r = new JPanel();
        JPanel pan_button = new JPanel();

        FlowLayout flowLayout = new FlowLayout();

        pan_top.setLayout(new GridLayout(1,2));
        pan_r.setLayout(new FlowLayout(FlowLayout.LEFT));
        pan_button.setLayout(flowLayout);

        JLabel r = new JLabel("相关词");
        JLabel r_t = new JLabel();
        JLabel l = new JLabel("当前选中：");
        JLabel selected_l = new JLabel("none");

        JButton add_but = new JButton("增");
        JButton del_but = new JButton("删");
        JButton rev_but = new JButton("改");
        JButton search_but = new JButton("查");
        JButton refresh_but = new JButton("刷新/重置");

        r.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        r_t.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        l.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        selected_l.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        add_but.setPreferredSize(new Dimension(200,30));
        del_but.setPreferredSize(new Dimension(200,30));
        rev_but.setPreferredSize(new Dimension(200,30));
        search_but.setPreferredSize(new Dimension(200,30));

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String s = (String)table.getValueAt(table.getSelectedRow(),0);
                selected_l.setText(s);
                selected = s;
                r_t.setText(gc.getRelationsByContent(selected).replace(' ', '、'));
            }
        });
        add_but.addActionListener(e -> new EditWindow(false));
        del_but.addActionListener(e -> {
            if(selected.equals(""))
                JOptionPane.showMessageDialog(null, "请先选择一条", "提示", JOptionPane.INFORMATION_MESSAGE);
            else
                new DeleteVerify();
        });
        rev_but.addActionListener(e -> {
            if(selected.equals(""))
                JOptionPane.showMessageDialog(null, "请先选择一条", "提示", JOptionPane.INFORMATION_MESSAGE);
            else
                new EditWindow(true);
        });
        search_but.addActionListener(e -> new SearchWindow());
        refresh_but.addActionListener(this);

        pan_r.add(r);
        pan_r.add(r_t);

        pan_top.add(pan_r);
        pan_top.add(refresh_but);

        pan_button.add(l, FlowLayout.LEFT);
        pan_button.add(selected_l);
        pan_button.add(add_but);
        pan_button.add(del_but);
        pan_button.add(rev_but);
        pan_button.add(search_but);

        jf.add(pan_top, BorderLayout.NORTH);
        jf.add(sp, BorderLayout.CENTER);
        jf.add(pan_button, BorderLayout.SOUTH);

        table.setDefaultRenderer(Object.class, new TextRenderer());
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(1000,700);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }
    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        List<Speaks> speak_list = gc.getAllSpeaks();
        DTable dt = new DTable(ConvertUtil.toObjArray(speak_list), cols);
        table.setModel(dt);
        table.repaint();
        selected = "";
    }
}


