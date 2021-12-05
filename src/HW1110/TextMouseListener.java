package HW1110;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TextMouseListener extends JFrame {
//    Container c = getContentPane();
    private JTextField tf = new JTextField(20);
    JLabel label1 = new JLabel("입력 후 <Enter>");
    JLabel label2 = new JLabel("Sim");

    public TextMouseListener() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("실습과제 Event 응용");

        setVisible(true);
        setSize(400, 400);

        Container c = getContentPane();
        c.setLayout(null);

//        JLabel label1 = new JLabel("입력 후 <Enter>");
        label1.setSize(120, 30);
        label1.setLocation(20, 20);
        c.add(label1);

        tf.setSize(150, 30);
        tf.setLocation(150, 20);
        c.add(tf);

//        JLabel label2 = new JLabel("Sim");
        label2.setSize(50,20);
        label2.setLocation((int)Math.random()*300, (int)Math.random()*300);
        c.add(label2);

        c.addMouseListener(new MouseLi());
        c.addKeyListener(new KeyboardLi());

//        label2.addMouseListener(new MouseLi());
////        label2.addKeyListener(new KeyboardLi() {
////            public void textValueChanged(TextEvent e) {
////                label2.setText(tf.getText());
////            }
////        });
//        label2.addKeyListener(new KeyboardLi());

//        label2.addTextListener(new TextListener() {
//            @Override
//            public void textValueChanged(TextEvent e) {
//                label2.setText(tf.getText());
//            }
//        });

    }

    public static void main(String[] args) {
        new TextMouseListener();
    }

    class MouseLi extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int x = (int)(Math.random()* 300);
            int y = (int)(Math.random()* 300);
            label2.setLocation(x, y);
        }
    }

    class KeyboardLi extends KeyAdapter {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                JTextField change = (JTextField)e.getSource();
                label2.setText(change.getText());
//                label2.setSize(50,20);
//                label2.setLocation((int)Math.random()*300, (int)Math.random()*300);

            }
//            label2.setText(tf.getText());

        }

    }
}
