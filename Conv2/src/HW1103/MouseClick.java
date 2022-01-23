package HW1103;
// 초기에 랜덤한 위치에 있는 라벨의 위치에 해당하는 부분을 클릭했을 때 위치 랜덤으로 변경하도록
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseClick extends JFrame {

    JLabel label = new JLabel("C");
    Font font = new Font("맑은 고딕", Font.BOLD, 20);
//    label.setFont(font);

    public MouseClick() {
        setTitle("Mouse Click Random Position");
        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(null);

        c.addMouseListener(new MouseLi());

        label.setSize(20,20);
        label.setLocation((int)Math.random()*200, (int)Math.random()*200);
        c.add(label);

    }

    public static void main(String[] args) {
        new MouseClick();
    }

    class MouseLi extends MouseAdapter {

        public void mouseClicked(MouseEvent e) {
            int x = (int)(Math.random()* 300);
            int y = (int)(Math.random()* 300);
            label.setLocation(x, y);
        }
    }

}
