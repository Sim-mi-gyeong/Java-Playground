package Lec1115;

import HW1117.Graphic;

import javax.swing.*;
import java.awt.*;

public class PaintPanelEx extends JFrame {
    private MyPanel panel = new MyPanel();

    public PaintPanelEx() {
        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("dPwp 12-1 그래픽 실습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
//        setContentPane(new MyPanel());  // default로 제공하는 것 말고 새로운 것을 그리고 싶을 때 JPanel을 오버로딩 할 수 있도록 상속받아 -> 내부 클래스로 구현
        // getContentPane(): JFrame이 기본적으로 제공해주는 컨테이너에 버튼, label 등을 올림
        // setContentPane(): 내가 만든 컨테이너에 올려주는 것 -> JPanel을 상속받아 오버라이딩 한 MyPanel을 JFrame에 올려줌
        setSize(250, 220);
        setVisible(true);
    }
    class MyPanel extends JPanel {   // JPanel을 상속받아 오버라이딩 하기
        MyPanel() {
            setBackground(Color.YELLOW);
        }
        @Override
        public void paintComponent(Graphics g) {   // paintComponent를 오버라이딩 하도록!
            super.paintComponent(g);   // 원래 부모가 했어야 하는 것을 한 번 실행
            g.setColor(Color.BLUE);
            g.drawRect(10, 10, 50, 50);
            g.drawRect(50, 50, 50, 50);
            g.setColor(Color.MAGENTA);
            g.drawRect(90, 90, 50, 50);
            g.drawOval(130,130, 80, 60);
        }

    }

    public static void main(String[] args) {
        new PaintPanelEx();
    }
}
