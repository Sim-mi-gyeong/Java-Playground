package Lec1108;

import javax.swing.*;
import java.awt.*;

public class CheckBoxEx extends JFrame {

    public CheckBoxEx() {
        setTitle("예제 11-4 체크박스 예제");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JCheckBox apple = new JCheckBox("사과");
        JCheckBox pear = new JCheckBox("배");

        c.add(apple);
        c.add(pear);

        setSize(250, 150);
        setVisible(true);

    }
    public static void main(String[] args) {
        new CheckBoxEx();
    }
}
