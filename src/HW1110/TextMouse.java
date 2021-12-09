package HW1110;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextMouse extends JFrame {
    private JLabel la = new JLabel("Sim");
    private JTextField tf = new JTextField();

    public TextMouse() {
        setTitle("실습과제 마우스 이벤트 응용");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(null);

        setSize(300, 300);
        setVisible(true);

        JLabel guide = new JLabel("입력 후 <Enter> ");
        guide.setSize(100, 20);
        guide.setLocation(20, 20);
        c.add(guide);

        la.setSize(50, 20);
        la.setLocation(30, 70);   // 초기 위치 설정
        c.add(la);

        c.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                la.setLocation(e.getX(), e.getY());    // 컨텐트 내부를 클릭하면 la 라벨 위치 이디ㅗㅇ
            }
        });

        tf.setSize(100,20);
        tf.setLocation(120, 20);   // 텍스트 필드 위치 지정
        c.add(tf);

        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField content = (JTextField)e.getSource();   // 바꿀 텍스트 저장
                la.setText(content.getText());   // 바꿀 텍스트로 변경
                content.setText(" ");   // 텍스트 필드를 빈칸으로 초기화
            }
        });

    }

    public static void main(String[] args) {
        new TextMouse();
    }

}
