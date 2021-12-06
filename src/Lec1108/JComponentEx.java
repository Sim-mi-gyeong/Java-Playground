package Lec1108;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JComponentEx extends JFrame {
    public JComponentEx() {
//        setTitle("JComponent의 공통 메소드 예제");
        super("JComponent의 공통 메소드 예제");

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Magenta / Yellow Button");
        JButton b2 = new JButton("Disabled Button");
        JButton b3 = new JButton("getX(), getY()");

        b1.setBackground(Color.YELLOW);   // 배경색 설정
        b1.setForeground(Color.MAGENTA);   // 글자색 설정
        b1.setFont(new Font("Arial", Font.ITALIC, 20));   // Airal, 20픽셀 폰트 설정

        b2.setEnabled(false);   // 버튼 비활성화

        b3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                JComponentEx frame = (JComponentEx)b.getTopLevelAncestor();
                frame.setTitle(b.getX() + ", "  + b.getY());   // 타이틀에 버튼 좌표 출력
            }
        });

        c.add(b1); c.add(b2); c.add(b3);   // 컨텐트 팬에 버튼 부착
        setSize(260, 200);
        setVisible(true);

    }
    public static void main(String[] args) {
        new JComponentEx();
    }
}
