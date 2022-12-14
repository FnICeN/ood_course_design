package View;

import com.Controller.GeneralController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditWindow implements ActionListener{
    boolean isEdit;
    JFrame jf;
    JPanel pan_grid;
    JPanel pan_button;
    JLabel title;
    JLabel co;
    JLabel or;
    JLabel om;
    JLabel nm;
    JLabel us;
    JLabel sen;
    JLabel rela;
    JTextField content;
    JTextField origin;
    JTextField origin_mean;
    JTextField now_mean;
    JTextField using;
    JTextField sentence;
    JTextField relation;
    JButton confirm;
    JButton cancel;
    public EditWindow(boolean isEdit) {
        this.isEdit = isEdit;

        jf = new JFrame("编辑网络用语信息");
        pan_grid = new JPanel();
        pan_button = new JPanel();

        pan_grid.setLayout(new GridLayout(7,2));
        pan_button.setLayout(new FlowLayout());

        co = new JLabel("内容 *：");
        or = new JLabel("来源：");
        om = new JLabel("初义：");
        nm = new JLabel("今义：");
        us = new JLabel("使用场景：");
        sen = new JLabel("造句：");
        rela = new JLabel("相关词（以空格隔开）：");
        content = new JTextField();
        origin = new JTextField();
        origin_mean = new JTextField();
        now_mean = new JTextField();
        using = new JTextField();
        sentence = new JTextField();
        relation = new JTextField();
        confirm = new JButton("确定");
        cancel = new JButton("取消");

        co.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        or.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        om.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        nm.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        us.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        sen.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        rela.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        confirm.addActionListener(this);
        cancel.addActionListener(e -> jf.dispose());

        pan_grid.add(co);
        pan_grid.add(content);
        pan_grid.add(or);
        pan_grid.add(origin);
        pan_grid.add(om);
        pan_grid.add(origin_mean);
        pan_grid.add(nm);
        pan_grid.add(now_mean);
        pan_grid.add(us);
        pan_grid.add(using);
        pan_grid.add(sen);
        pan_grid.add(sentence);
        pan_grid.add(rela);
        pan_grid.add(relation);
        pan_button.add(confirm);
        pan_button.add(cancel);
        jf.add(pan_grid, BorderLayout.CENTER);
        jf.add(pan_button, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(400, 500);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);

        setDefaultText(isEdit);
    }

    private void setDefaultText(boolean isEdit) {
        if(!isEdit)
            return;
        GeneralController gc = Main.gc;
        String selected = Main.selected;
        String[] arr = gc.getSpeakArrayByContent(selected);
        String relations = gc.getRelationsByContent(selected);
        if(relations.length() != 0 && relations.charAt(0) == '：')
            relations = relations.substring(1);
        content.setText(arr[0]);
        origin.setText(arr[1]);
        origin_mean.setText(arr[2]);
        now_mean.setText(arr[3]);
        using.setText(arr[4]);
        sentence.setText(arr[5]);
        relation.setText(relations);
        content.setEditable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(content.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "请输入内容", "提示", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        if(!isEdit) {
            boolean flag = Main.gc.addSpeakAndRelation(content.getText(), origin.getText(), origin_mean.getText(), now_mean.getText(), using.getText(), sentence.getText(), relation.getText());
            if(flag)
                JOptionPane.showMessageDialog(null, "插入成功", "提示", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "插入失败，检查是否有重复项", "错误", JOptionPane.ERROR_MESSAGE);
        }
        else {
            boolean flag = Main.gc.reviseSpeakAndRelationsBySelected(origin.getText(), origin_mean.getText(), now_mean.getText(), using.getText(), sentence.getText(), relation.getText(), Main.selected);
            if(flag)
                JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
            else
                JOptionPane.showMessageDialog(null, "修改失败，检查是否有重复项", "错误", JOptionPane.ERROR_MESSAGE);
        }
        jf.dispose();
    }
}
