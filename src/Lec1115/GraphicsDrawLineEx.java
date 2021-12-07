package Lec1115;

import javax.swing.*;
import java.awt.*;

public class GraphicsDrawLineEx extends JFrame {
    private MyPanel panel = new MyPanel();

    public GraphicsDrawLineEx() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("예제 12-4 drawLine 사용 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);

        setSize(200, 170);
        setVisible(true);

    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.RED);
            g.drawLine(20, 20, 100, 100);
//            g.drawRoundRect(20, 20, 120, 80, 40, 60);
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawLineEx();
    }
}
