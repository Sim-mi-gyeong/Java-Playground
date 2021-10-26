package Lec1025;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ActionEvent extends JFrame {

    public ActionEvent() {
        setTitle("[예제 10-1] Action Event Listener - 독립 클래스 ");

        Container c = getContentPane();
        c.setLayout(null);

        JButton bt = new JButton("Action");
        bt.setLocation(150, 100);
        bt.setSize(100, 40);
        bt.addActionListener(new MyActionListener());   // 리스너 등록

        c.add(bt);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new ActionEvent();
    }
}

// 독립 클래스로 Listener 구현
class MyActionListener implements ActionListener {

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {   // 이벤트 객체
        // 해야할 일
        JButton b = (JButton)e.getSource();
        if(b.getText().equals("Action")) {
            b.setText("액션");
        } else {
            b.setText("Action");
        }
    }
}
