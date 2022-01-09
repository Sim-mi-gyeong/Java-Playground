package FinalPractice_2021_1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Number2_3 extends JFrame {
    FileInputStream fin = null;
    JLabel la = new JLabel("파일명 입력 (Enter)");
    JTextField tf = new JTextField(20);
    JButton bt = new JButton("영상보기 (Toggle)");


    String want = "C:\\Temp\\회색영상\\PEPPERS256X256.dat";


    Number2_3 (){
        setTitle("심미경");

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

            tf.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    JTextField t = (JTextField)e.getSource();
                    want = t.getText();
                    try {
                        fin = new FileInputStream(want);
                    } catch (FileNotFoundException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }


            });

        }
    }

    class MyPanel extends JPanel {
        boolean exit = false;

        MyPanel(){
            setBackground(Color.PINK);
            add(bt);
            bt.addMouseListener(new MouseAdapter() {


                @Override
                public void mouseClicked(MouseEvent e) {
                    // TODO Auto-generated method stub
                    super.mouseClicked(e);
                    JButton bt = (JButton)e.getSource();

                    if(exit) {
                        bt.setText("미표시");
                    }else {
                        bt.setText("영상표시");
                    }

                    if(exit) {
                        exit = false;
                    }else {
                        exit = true;
                    }
                    repaint();
                }
            });
        }


        @Override
        protected void paintComponent(Graphics g) {
            // TODO Auto-generated method stub
            super.paintComponent(g);
            //1. 영상파일 읽기
            int data[] = new int[400 * 400];
            int W, H;
            W = 256;
            H = 256;
            int n = 0, temp;
            try {
                fin = new FileInputStream(want);
                while((temp = fin.read()) != -1) {
                    data[n++] = temp;
                }
                fin.close();

            } catch(Exception e) {
                System.out.println("오류 발생");
                return;
            }

            int pix[][] = new int[400][400];
            for(int i = 0; i < H; i++)
                for(int j = 0; j < W; j++) {
                    pix[i][j] = data[i * W + j];
                    if(pix[i][j] > 255)
                        pix[i][j] = 255;
                }


            if(exit) {
                for(int i = 0; i < H; i++)
                    for(int j = 0; j < W; j++) {
                        g.setColor(new Color(pix[i][j], pix[i][j], pix[i][j]));
                        g.drawOval(50+j, 50+i, 1, 1);
                    }

            }
        }
    }


    public static void main(String[] args) {
        new Number2_3 ();

    }

}