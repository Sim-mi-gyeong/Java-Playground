package Lec1101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class MouseEvent_Practice extends JFrame {

    JLabel la = new JLabel("Hello");   // 필드로 선언하기

    public MouseEvent_Practice() {
        setTitle("예제 10-4 마우스로 문자열 이동시키기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        // 컨텐트 팬이 이벤트를 받아들임 -> 컨텐트 팬에 이벤트 리스너 등록!
        c.addMouseListener(new MyMouseLi());

//        JLabel la = new JLabel("Hello");  // 지역변수로 선언 - 생성자 안에서만 유효 -> 필드로 선언하기
        la.setSize(50, 20);
        la.setLocation(30, 30);   // label에 대한 정보를 알아야 위치 변경 가능
        c.add(la);

        setSize(400, 300);
        setVisible(true);
    }

    class MyMouseLi implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
//            int x = e.getX();
//            int y = e.getY();
//            la.setLocation(x, y);

            Point p = e.getPoint();
            la.setLocation(p);
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }
    }

    public static void main(String[] args) {
        new MouseEvent_Practice();
    }
}