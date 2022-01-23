package Lec1101;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

// 예제 10-4
public class MouseEvent extends JFrame {
// 내부 클래스로 등록 -> 객체 생성 필요 X
    JLabel label = new JLabel("Hello");   // Field

    MouseEvent() {
        setTitle("[예제 10-4] 마우스 이벤트 실습");
        setSize(400,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        // Listener 등록
        c.addMouseListener(new MyMouseLi());

//        JLabel label = new JLabel("Hello");   // 생성자 안에서만 유효한 지역변수
//        label.setBackground();
        // setLayout(null) -> 컴포넌트의 크기와 위치 지정 필요
//        label.setSize(50, 20);
//        label.setLocation(30,30);
        c.add(label);
    }

    public static void main(String[] args) {
        new MouseEvent();
    }
    // 내부클래스
    class MyMouseLi implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
//            label.setLocation(x, y);   // 현재 label을 (100,100) 위치로 옮기기 -> 한 번만 동작 유효
            Point p = e.getPoint();  // (x, y) 좌표값
            label.setLocation(x, y);

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

}