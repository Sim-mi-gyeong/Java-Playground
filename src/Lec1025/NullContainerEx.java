package Lec1025;

import javax.swing.*;
import java.awt.*;

public class NullContainerEx extends JFrame {
    public NullContainerEx() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("Null Container Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel la = new JLabel("Hello, Press Button");
        la.setLocation(130, 50);
        c.add(la);

        for (int i = 0; i <= 9 ; i++) {
            JButton bt = new JButton(Integer.toString(i));   // 버튼 생성
            bt.setLocation(i * 15, i * 15);
            bt.setSize(50, 20);
            bt.setBackground(Color.YELLOW);
            c.add(bt);
        }

        setSize(300,200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new NullContainerEx();
    }

}
