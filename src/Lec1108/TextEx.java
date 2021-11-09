package Lec1108;

import javax.swing.*;
import java.awt.*;

public class TextEx extends JFrame{

    private JTextField tf = new JTextField(20);
    private JTextArea ta = new JTextArea(7, 20);

    TextEx() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("텍스트 입력 실습");

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("입력 후 <Enter> 키를 입력하세요."));
        c.add(tf);
        c.add(ta);

        setVisible(true);
        setSize(300,300);

    }

    public static void main(String[] args) {
        new TextEx();
    }
}
