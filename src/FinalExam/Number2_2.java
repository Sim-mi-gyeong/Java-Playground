package FinalExam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;


//
//public class GraphicsDrawEx extends JFrame {
//
//    private Lec1115.GraphicsDrawEx.MyPanel panel = new Lec1115.GraphicsDrawEx.MyPanel();
//
//    public GraphicsDrawEx() {
//
//        try {   // UIManager 사용
//            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        setTitle("여러 다각형 및 원호와 폐다각형 그리기 연습");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        setContentPane(panel);
//
//        setSize(400, 500);
//        setVisible(true);
//    }
//
//    class MyPanel extends JPanel {
//        public void paintComponent(Graphics g) {
//            super.paintComponent(g);
//
//            g.setColor(Color.MAGENTA);
//
//            // 원 그리기
//            g.drawOval(20, 20, 80, 80);
//            // 사각형 그리기
//            g.drawRect(150, 20, 80, 80);
//            // 둥근 모서리 사강형 그리기
//            g.drawRoundRect(20, 150, 80, 80, 40, 60);
//            // 원호 그리기
//            g.drawArc(150, 150, 80, 80, 90, 270);
//            g.drawArc(280, 150, 80, 80, 90, -270);
//            // 폐 다각형 그리기
//            int[] x = {80, 40, 80, 120};
//            int[] y = {280, 340, 400, 340};
//            g.drawPolygon(x, y, 4);
//
//        }
//    }
//    public static void main(String[] args) {
//        new Lec1115.GraphicsDrawEx();
//    }
//
//}


public class Number2_2 extends JFrame {
    private JButton bt1;
    private JLabel la1;
    private JLabel la2;
    private int num1;
    private int num2;

    public Number2_2() {

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
            setLocation(0, 0);
            setBackground(Color.YELLOW);
            JButton bt1 = new JButton("찬성");
            JLabel la1 = new JLabel(" 이름: 심미경 ");
            JLabel la2 = new JLabel("학번 : 2019112463 ");
            add(la1);
            add(la2);

            bt1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    JButton bt_content = (JButton) e.getSource();

                    if (bt_content.equals("찬성")) {
                        bt1.setText("반대");
                    } else {
                        bt1.setText("찬성");
                    }

                }
            });
            add(bt1);

        }
    }

    class RightFrame extends JPanel {
        public RightFrame() {
            setBackground(Color.lightGray);
            setSize(400, 400);
            setLocation(100, 0);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


//            if(bt1.getText().equals("찬성")) {
//                g.setColor(Color.BLUE);
//                for (int i = 0; i < num1; i++) {
//                    g.fillOval( (int)Math.random()*200, (int)Math.random()*300, 5, 5);
//                }
//            }
//            else {
//                g.setColor(Color.RED);
//                for (int i = 0; i < num2; i++) {
//                    g.fillOval( (int)Math.random()*200, (int)Math.random()*300, 5, 5);
//                }
//
//            }

        }
    }
    public static void main(String[] args) {

        new Number2_2();
    }
}


//public class Number2_2 extends JFrame {
//    JLabel la = new JLabel("파일명 입력 (Enter)");
//    JTextField tf = new JTextField(20);
//    JButton bt = new JButton("영상보기 (Toggle)");
//
//    Number2_2(){
//        setTitle("김유탄");
//
//        Container c = getContentPane();
//        c.add(new FinalPractice_2021_1.Number2_2.NorthPanel(), BorderLayout.NORTH);
//        c.add(new FinalPractice_2021_1.Number2_2.MyPanel(), BorderLayout.CENTER);
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
//        boolean exit = false;
//
//        MyPanel(){
//            setBackground(Color.PINK);
//            add(bt);
//            bt.addMouseListener(new MouseAdapter() {
//
//
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                    // TODO Auto-generated method stub
//                    super.mouseClicked(e);
//                    JButton bt = (JButton)e.getSource();
//
//                    if(exit) {
//                        bt.setText("미표시");
//                    }else {
//                        bt.setText("영상표시");
//                    }
//
//                    if(exit) {
//                        exit = false;
//                    }else {
//                        exit = true;
//                    }
//                    repaint();
//                }
//            });
//        }
//
//
//
//        @Override
//        protected void paintComponent(Graphics g) {
//            // TODO Auto-generated method stub
//            super.paintComponent(g);
//            int[] data = new int[400*400];
//            int W,H;
//            W = 256;
//            H = 256;
//            int n = 0,temp;
//            try {
//                FileInputStream fin = new FileInputStream("c:\\Temp\\PEPPERS256X256.dat");
//                while((temp = fin.read()) !=-1) {
//                    data[n++] = temp;
//                }
//                fin.close();
//            }catch(Exception e) {
//                System.out.println("경로 오류");
//                return;
//            }
//
//            int pix[][] = new int[400][400];
//            for(int i=0;i<H;i++) {
//                for(int j=0;j<W;j++) {
//                    pix[i][j] = data[i*W+j];
//                    if(pix[i][j]>255) {
//                        pix[i][j] = 255;
//                    }
//                }
//            }
//            if(exit) {
//                for(int i=0;i<H;i++) {
//                    for(int j=0;j<W;j++) {
//                        g.setColor(new Color(pix[i][j],pix[i][j],pix[i][j]));
//                        g.drawOval(50+j,50+i,1,1);
//                    }
//                }
//            }
//
//        }
//    }
//
//    public static void main(String[] args) {
//        new FinalPractice_2021_1.Number2_2();
//
//    }
//
//}