package HW1027;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ColorGUI extends JFrame {

    public static void main(String[] args) {
        new ColorGUI();
    }

    public ColorGUI() {

        try {   // UIManager 사용
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
        } catch (Exception e) {
            e.printStackTrace();
        }

        setTitle("10 Colors Button");

        Container c = getContentPane();
        c.setLayout(new GridLayout(1, 10) );

        int[][] arrColor = { { 255, 0, 0 }, { 255, 100, 0 }, { 255, 255, 0 }, { 0, 255, 0 },
                { 0, 100, 255 }, { 0, 0, 255 }, { 100, 0, 255 }, { 102, 102, 102 },
                { 255, 204, 204 }, { 204, 204, 204 } };

        Color colorArr;

        JButton[] bt = new JButton[10];
        for (int i = 0; i <= 9; i++) {
            colorArr = new Color(arrColor[i][0], arrColor[i][1], arrColor[i][2]);
            bt[i] = new JButton("" + i + "");
            bt[i].setBackground(colorArr);
            bt[i].setOpaque(true);
            bt[i].addActionListener(new MyActionListener());
            c.add(bt[i]);
        }
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 100);
        setVisible(true);

    }
}

class MyActionListener implements ActionListener {
    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {   // 이벤트 객체
        JButton b = (JButton) e.getSource();
        b.setBackground(Color.WHITE);
    }
}
