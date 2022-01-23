package Lec1025;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IndepClassListener extends JFrame {

    public IndepClassListener() {
        setTitle("Action 리스너 이벤트 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        btn.addActionListener(new MyActionLi());
        c.add(btn);

        setSize(300, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        new IndepClassListener();
    }
}

class MyActionLi implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        if (b.getText().equals("Action")) {
            b.setText("액션");
        } else b.setText("Action");
    }
}
