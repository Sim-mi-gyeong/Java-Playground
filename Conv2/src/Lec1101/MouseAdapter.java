package Lec1101;

import javax.swing.*;
import java.awt.*;

// 예제 10-5) Adapter 클래스
// 사용하지 않는 추상 메소드도 구현해야하는 부담 -> Adapter
public abstract class MouseAdapter extends JFrame{
    // 내부 클래스로 등록 -> 객체 생성 필요 X
    JLabel label = new JLabel("Hello");   // Field

    MouseAdapter() {
        setTitle("[예제 10-4] 마우스 이벤트 실습");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);
        // Listener 등록

//        JLabel label = new JLabel("Hello");   // 생성자 안에서만 유효한 지역변수
//        label.setBackground();
        // setLayout(null) -> 컴포넌트의 크기와 위치 지정 필요
//        label.setSize(50, 20);
//        label.setLocation(30,30);
        c.add(label);
    }

    public static void main(String[] args) {
        new Lec1101.MouseEvent();
    }

}
