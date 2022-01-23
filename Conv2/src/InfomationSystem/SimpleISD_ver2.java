package InfomationSystem;
import java.awt.*;
import javax.swing.*;

public class SimpleISD_ver2 extends JFrame {
    SimpleISD_ver2() {

        setTitle("SampleISD");

        Container c = getContentPane();
        c.setLayout(null);

        Font font = new Font("맑은 고딕", Font.BOLD, 20);
        JLabel label1 = new JLabel("Tune Source");
        JLabel label2 = new JLabel("Your Source for Your...");
        label1.setLocation(40, 40);
        label1.setSize(150, 50);
        label1.setFont(font);
        label2.setLocation(35, 80);
        label2.setSize(150, 50);
        c.add(label1);
        c.add(label2);

        // TextField는 한 줄의 텍스트 편집 허용 설정
        // Textarea는 여러 줄의 텍스트 보여주기 및 편집 허용 혹은 읽기 전용 설정
        JTextField textField = new JTextField();
        textField.setLocation(30, 150);
        textField.setSize(130, 30);
        c.add(textField);

        JButton bt1 = new JButton("View Your ...");
        bt1.setLocation(250, 50);
        bt1.setSize(120,50);
        c.add(bt1);
        JButton bt2 = new JButton("View your favorites");
        bt2.setLocation(400, 50);
        bt2.setSize(150,50);
        c.add(bt2);
        JButton bt3 = new JButton("Go");
        bt3.setLocation(300, 150);
        bt3.setSize(80,30);
        c.add(bt3);

        String[] music = {"Music1", "Music2", "Music3"};
        JComboBox combo = new JComboBox(music);
        combo.setLocation(180, 150);
        combo.setSize(100, 30);
        c.add(combo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleISD_ver2();
    }

}