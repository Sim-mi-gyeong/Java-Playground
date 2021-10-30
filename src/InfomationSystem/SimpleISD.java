package InfomationSystem;

import java.awt.*;
import javax.swing.*;

public class SimpleISD extends JFrame {

    private JTextField textField1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    SimpleISD() {

        setTitle("SampleISD");
        setSize(500, 400);
        setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        JLabel label1 = new JLabel("Tune Source");
        JLabel label2 = new JLabel("Your Source for Your...");

        // TextField는 한 줄의 텍스트 편집 허용 설정
        // Textarea는 여러 줄의 텍스트 보여주기 및 편집 허용 혹은 읽기 전용 설정
        JTextField textField = new JTextField();
        textField.setLocation(0, 150);

        JButton bt1 = new JButton("View Your ...");
        bt1.setLocation(250, 50);
        c.add(bt1);
        JButton bt2 = new JButton("View your favorites");
        bt2.setLocation(350, 50);
        c.add(bt2);
        JButton bt3 = new JButton("Go");
        bt3.setLocation(300, 150);
        c.add(bt3);

        String[] music = {"Music1", "Music2", "Music3"};
        JLabel musicLabel = new JLabel(music[0]);
        JComboBox combo = new JComboBox(music);
        combo.setLocation(100, 150);
        c.add(combo);
        c.add(musicLabel);

    }

    public static void main(String[] args) {
        new SimpleISD();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
