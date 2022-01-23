package Lec1115;
// 예제 12-2 drawString 메소드를 통한 문자열 출력 예제
import javax.swing.*;
import java.awt.*;

public class GraphicsDrawStringEx extends JFrame {
    public GraphicsDrawStringEx() {
        setTitle("예제 12-2 drawString 메소드를 통한 문자열 출력");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());

        setSize(400, 200);
        setVisible(true);

    }

    class MyPanel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("자바는 재미없어!!!!!!", 30, 30);
            g.drawString("그렇지만 어쩔 수 없이 해야해,,", 60, 60);
        }
    }

    public static void main(String[] args) {
        new GraphicsDrawStringEx();
    }

}
