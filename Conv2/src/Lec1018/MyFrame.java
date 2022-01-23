package Lec1018;

import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    MyFrame() {
        setTitle("GUI Start");

        Container cp = getContentPane();   // 레퍼런스 변수 cp
        cp.setLayout(new FlowLayout());   // Defualt Layout 변경
        cp.add(new JButton("OK"));
        cp.add(new JButton("Cencel"));
        cp.add(new JButton("Ignore"));

//        //  최상위 프레임: JFrame -> JFrame에서 제공하는 Default 배치 관리자: BorderLayout
//        cp.add(new JButton("OK"), BorderLayout.WEST);
//        cp.add(new JButton("Cnacel"), BorderLayout.CENTER);
//        cp.add(new JButton("Ignore"), BorderLayout.EAST);

//        this.   + tap -> 사용 가능한 메소드 확인
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
    }
    public static void main(String[] args) {

        MyFrame frame = new MyFrame();

    }
}
