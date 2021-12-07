package Lec1115;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GraphicsDrawLineMouseEx extends JFrame {
    public GraphicsDrawLineMouseEx() {
        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }
        setTitle("예제 12-10 Draw Line by Mouse 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());

        setSize(400, 400);
        setVisible(true);

    }

    class MyPanel extends JPanel {
//        Point start, end;
        Point[] start = new Point[100];
        Point[] end = new Point[100];
        int cnt;   // 100개를 다 쓴느 것이 아니라 나머지는 스레드
        private int status = 0;   // 상태를 나누어 나타내는 상태변수
        MyPanel() {
            cnt = 0;
            setBackground(Color.lightGray);

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
//                    start = e.getPoint();
                    start[cnt] = e.getPoint();
//                    status = 1;
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
//                    end = e.getPoint();
                    end[cnt++] = e.getPoint();
                    repaint();   // 화면을 다시 그리는 Event 발생
                }
            });
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.orange);

            // 배열로 변경 전
//            if(status > 0) {
//                g.drawLine((int)start.getX(), (int)start.getY(), (int)end.getX(), (int)end.getY());
//            }
            // 배열로 변경 후
            for (int i = 0; i < cnt; i++) {
                g.drawLine((int)start[i].getX(), (int)start[i].getY(), (int)end[i].getX(), (int)end[i].getY());
            }

        }
    }
    public static void main(String[] args) {
        new GraphicsDrawLineMouseEx();
    }
}
