package Lec1025;
// [예제 9-6] 배치 관리자가 없는 컨테이너 컴포넌트 위치/크기 지정

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    Main() {   // 생성자
        setTitle("[예제 9-6] 배치 관리자 실습");

        Container c = getContentPane();   // Pane 좌측 상단이 (0,0)
        c.setLayout(null);

        JButton bt = new JButton("실습");
        bt.setLocation(100, 100);   // 배치 관리자가 없으므로 직접 위치 지정
        bt.setSize(80,30);
        bt.setBackground(Color.YELLOW);   // 다시
        bt.setOpaque(true);
        c.add(bt);   // 컨테이너에 올리기

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();

    }

}
