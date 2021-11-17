package Lec1115;

import javax.swing.*;

public class PanelEx extends JFrame {
    PanelEx() {
        setTitle("그래픽 실습");

//        setContentPane(new JPane());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

//    class MyPanel extends JPanel {
//        @Override
//        protected void
//
//    }

    public static void main(String[] args) {
        new PanelEx();
    }
}
