package View.Verify;

import View.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteVerify implements ActionListener{
    JFrame jf;
    JPanel pan;
    JLabel ques;
    JButton confirm;
    JButton cancel;
    public DeleteVerify() {
        jf = new JFrame("确认");
        pan = new JPanel();

        pan.setLayout(new FlowLayout());

        ques = new JLabel("确定要删除此条吗？", JLabel.CENTER);
        confirm = new JButton("确定");
        cancel = new JButton("取消");

        ques.setFont(new Font("微软雅黑", Font.PLAIN, 16));

        confirm.addActionListener(this);
        cancel.addActionListener(e -> jf.dispose());

        jf.add(ques, BorderLayout.CENTER);
        jf.add(pan, BorderLayout.SOUTH);
        pan.add(confirm);
        pan.add(cancel);

        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jf.setSize(300,150);
        jf.setVisible(true);
        jf.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!Main.gc.deleteSpeakAndRelationsBySelected(Main.selected))
            JOptionPane.showMessageDialog(null, "删除失败", "错误", JOptionPane.ERROR_MESSAGE);
        else
            JOptionPane.showMessageDialog(null, "删除成功", "提示", JOptionPane.PLAIN_MESSAGE);
        jf.dispose();
    }
}
