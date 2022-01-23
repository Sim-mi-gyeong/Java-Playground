package Lec1025;

import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {

    public GridLayoutEx() {

        setTitle("GridLayout Sample");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // 프레임 종료버튼이 클릭될 때 프레임을 닫고 응용프로그램 종료

        GridLayout grid = new GridLayout(4, 2);
        grid.setVgap(5);   // 두 행 사이의 수직 간격 vGap = 5pxel로 설정

        Container c = getContentPane();   // 컨텐트 팬 알아내기
        c.setLayout(grid);

        // GridLayout 채우기
        c.add(new JLabel(" 이름 "));   // 컨텐트 팬에 컴포넌트 달기
        c.add(new JTextField(""));

        c.add(new JLabel(" 학번"));
        c.add(new JTextField(""));

        c.add(new JLabel(" 학과"));
        c.add(new JTextField(""));

        c.add(new JLabel(" 과목"));
        c.add(new JTextField(""));

        setSize(300, 200);
        setVisible(true);

    }

    public static void main(String[] args) {
        new GridLayoutEx();

    }
}
