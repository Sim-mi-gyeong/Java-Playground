package HW1117;

import HW1201.MyFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main extends JFrame {

    public Main() {
        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTitle(" ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());

        setSize(400,400);
        setVisible(true);
    }

    class MyPanel extends JPanel {   // 사용자가 그래픽을 통해 다양한 UI를 창출하는 일종의 컨버스인 JPanel을 상속받아 MyPanel 클래스 생성

        private int cnt = 0;
        private int[] x = new int[100];    // x 좌표를 기억할 배열
        private int[] y = new int[100];    // y 좌표를 기억할 배열

        public MyPanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    x[cnt] = e.getX();
                    y[cnt++] = e.getY();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    x[cnt] = e.getX();
                    y[cnt++] = e.getY();
                    repaint();
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) {   // Graphics를 이용해 폐다각형 그림
            super.paintComponent(g);
            g.setColor(Color.orange);
            g.drawPolygon(x, y, cnt);
        }

    }
    public static void main(String[] args) {
        new Main();
    }
}
