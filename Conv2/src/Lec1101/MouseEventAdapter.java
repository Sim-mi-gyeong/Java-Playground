package Lec1101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventAdapter extends JFrame {

    JLabel la = new JLabel("Hello");

    public MouseEventAdapter() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("에제 10-4 Adapter 클래스 Ver");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        c.addMouseListener(new MyMouseAdapter());

        la.setSize(50, 20);
        la.setLocation(30, 30);
        c.add(la);

        setSize(400, 300);
        setVisible(true);
    }
    // Adapter 클래스
    class MyMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            Point p = e.getPoint();
            la.setLocation(p);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);

            Component c = (Component)e.getSource();
            c.setBackground(Color.CYAN);

        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);

            Component c = (Component)e.getSource();
            c.setBackground(Color.WHITE);

        }

    }
    public static void main(String[] args) {
        new MouseEventAdapter();
    }
}
