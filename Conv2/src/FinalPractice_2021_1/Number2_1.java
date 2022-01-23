package FinalPractice_2021_1;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Number2_1 extends JFrame {
    JLabel la = new JLabel("파일명 입력 (Enter)");
    JTextField tf = new JTextField(20);
    JButton bt = new JButton("영상보기 (Toggle)");

    Number2_1(){
        setTitle("김유탄");

        Container c = getContentPane();
        c.add(new NorthPanel(), BorderLayout.NORTH);
        c.add(new MyPanel(), BorderLayout.CENTER);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    class NorthPanel extends JPanel {
        NorthPanel(){
            setBackground(Color.YELLOW);
            add(la);
            add(tf);

        }
    }

    class MyPanel extends JPanel {
        MyPanel(){
            setBackground(Color.PINK);
            add(bt);
        }
    }

    public static void main(String[] args) {
        new Number2_1();

    }

}