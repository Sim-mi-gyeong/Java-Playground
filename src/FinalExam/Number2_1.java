package FinalExam;

import javax.swing.*;
import java.awt.*;

public class Number2_1 extends JFrame {
    private JButton bt;
    private JLabel la1;
    private JLabel la2;

    public Number2_1() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("융프2 기말고사");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        setLayout(null);

        c.add(new LeftFrame());
        c.add(new RightFrame());
        setSize(400, 400);
        setVisible(true);

    }

    class LeftFrame extends JPanel {
        public LeftFrame() {
            setSize(100, 400);
            setLocation(0,0);
            setBackground(Color.YELLOW);
            JButton bt1 = new JButton("찬성");
            JLabel la1 = new JLabel(" 이름: 심미경 ");
            JLabel la2 = new JLabel("학번 : 2019112463 ");
            add(bt1);
            add(la1);
            add(la2);

        }
    }

    class RightFrame extends JPanel {
        public RightFrame() {
            setBackground(Color.lightGray);
            setSize(300, 400);
            setLocation(100, 0);
        }
    }
    public static void main(String[] args) {

        new Number2_1();

    }
}



//public class Number2_1 extends JFrame {
//    JLabel la = new JLabel("파일명 입력 (Enter)");
//    JTextField tf = new JTextField(20);
//    JButton bt = new JButton("영상보기 (Toggle)");
//
//    Number2_1(){
//
//
//        Container c = getContentPane();
//        c.add(new FinalPractice_2021_1.Number2_1.NorthPanel(), BorderLayout.NORTH);
//        c.add(new FinalPractice_2021_1.Number2_1.MyPanel(), BorderLayout.CENTER);
//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setSize(400, 400);
//        setVisible(true);
//    }
//
//    class NorthPanel extends JPanel {
//        NorthPanel(){
//            setBackground(Color.YELLOW);
//            add(la);
//            add(tf);
//
//        }
//    }
//
//    class MyPanel extends JPanel {
//        MyPanel(){
//            setBackground(Color.PINK);
//            add(bt);
//        }
//    }
//
//    public static void main(String[] args) {
//        new FinalPractice_2021_1.Number2_1();
//
//    }
//
//}
