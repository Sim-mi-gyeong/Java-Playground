package HW1117;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class Graphic extends JFrame {
    MyPanel panel = new MyPanel();

    Graphic() {
        setTitle("실습 과제 - 다각형 만들기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);

        setSize(400,400);
        setVisible(true);
    }

    class MyPanel extends JPanel {
        Vector<Point> vStart = new Vector<Point>();
        Vector<Point> vEnd = new Vector<Point>();

        Point start = null;
        Point end = null;

        public MyPanel() {

            addMouseListener(new MouseAdapter() {
                public void MousePressed(MouseEvent e) {
                    Point startP = e.getPoint();
                    vStart.add(startP);
                }

                public void MouseReleased(MouseEvent e) {
                    Point endP = e.getPoint();
                    vEnd.add(endP);

                    repaint();
                }
            });
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.MAGENTA);

            for (int i = 0; i < vStart.size(); i++) {
                Point s = vStart.elementAt(i);
                Point e = vEnd.elementAt(i);
//              g.drawPolyline(vStart.indexOf(o), vEnd, vStart.size());

                g.drawLine((int)s.getX(), (int)s.getY(), (int)e.getX(), (int)e.getY());

            }

        }
//            int[] arr_x = {};
//            int[] arr_y = {};
//
//            if(start == null) return;
//            int x = Math.min(start.x, start.y);
//            int y = Math.min(start.y, start.y);
//
//            int width = Math.abs(start.x - end.x);
//            int height = Math.abs(start.y - end.y);
//
//            g.drawPolyline();
    }
    public static void main(String[] args) {
        new Graphic();
    }
}
