package Lec1115;

import javax.swing.*;
import java.awt.*;

public class GraphicsDrawEx extends JFrame {

    private MyPanel panel = new MyPanel();

    public GraphicsDrawEx() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("여러 다각형 및 원호와 폐다각형 그리기 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(panel);

        setSize(400, 500);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.MAGENTA);

            // 원 그리기
            g.drawOval(20, 20, 80, 80);
            // 사각형 그리기
            g.drawRect(150, 20, 80, 80);
            // 둥근 모서리 사강형 그리기
            g.drawRoundRect(20, 150, 80, 80, 40, 60);
            // 원호 그리기
            g.drawArc(150, 150, 80, 80, 90, 270);
            g.drawArc(280, 150, 80, 80, 90, -270);
            // 폐 다각형 그리기
            int[] x = {80, 40, 80, 120};
            int[] y = {280, 340, 400, 340};
            g.drawPolygon(x, y, 4);

        }
    }
    public static void main(String[] args) {
        new GraphicsDrawEx();
    }

}
