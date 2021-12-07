package Lec1115;

import javax.swing.*;
import java.awt.*;

public class ClassPracticeGraphics extends JFrame {
    public ClassPracticeGraphics() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("11월 15일 수업시간 그래픽 실습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        setContentPane(new MyPanel());
        Container c = getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new MyPanel(), BorderLayout.CENTER);

        setSize(400, 400);
        setVisible(true);
    }
    class NorthPanel extends JPanel {
        NorthPanel() {
            setBackground(Color.PINK);

            add(new JButton("버튼을 눌러요!"));
        }
    }
    class MyPanel extends JPanel {
        MyPanel() {
            setBackground(Color.ORANGE);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(20, 80, 80, 80);

            g.setColor(Color.lightGray);
            g.fillOval(80, 120, 100, 60);
        }
    }

    public static void main(String[] args) {
        new ClassPracticeGraphics();
    }
}
