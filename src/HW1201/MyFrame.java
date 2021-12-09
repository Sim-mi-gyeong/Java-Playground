package HW1201;

import Lec1122.FileOutputStreamEx;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;

public class MyFrame extends JFrame {
    public MyFrame() {
        setTitle("컬러 영상 뷰어 ver0.2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());

        setSize(400,400);
        setVisible(true);

    }

    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. File Read
            int[] data = new int[600 * 2000];
            int h = 512;
            int w = 512;

            int n = 0, tmp;

            // 컬러의 경우 1 pixel = 3bite 이므로 w를 3배 늘려준 colorW 선언
            int colorW = w * 3;

            try{

                FileInputStream fin = new FileInputStream("src/HW1201/resource/girl.raw");

                while( (tmp = fin.read()) != -1 ) {
                    data[n++] = tmp;
                }
                fin.close();

            }
            catch (Exception e) {
                System.out.println("src/HW1201/resource/girl.raw 에서 파일을 읽어오지 못했습니다.");
                return;
            }

            // 2. 1차원 배열 -> 2차원 배열로
            int R[][] = new int[600][600];
            int G[][] = new int[600][600];
            int B[][] = new int[600][600];

            for (int i = 0; i < h; i++) {   // 세로
                for (int j = 0; j < colorW; j++) {   // 가로
                    switch (j % 3) {   // data = [1.1.R, 1.1.G, 1.1.B, ... , 512 * 3.512 * 3.R, 512 * 3.512 * 3.G, 512 * 3.512 * 3.B]
                        case 0:
                            R[i][j / 3] = data[i * colorW + j];   // j를 3으로 나눈 나머지가 0이면 R 배열
                            break;
                        case 1:
                            G[i][j / 3] = data[i * colorW + j];   // j를 3으로 나눈 나머지가 0이면 R 배열
                            break;
                        case 2:
                            B[i][j / 3] = data[i * colorW + j];   // j를 3으로 나눈 나머지가 0이면 R 배열
                            break;
                    }

                }
            }

            // 3. 화면에 영상 그리기
            // 반복문으로 image를 구성하는 data를 배열하는 방식
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    g.setColor(new Color(R[i][j], G[i][j], B[i][j]));   // 컬러 설정
                    g.drawRect(30 + j, 20+ i, 1, 1);   // data를 직사각형 형태로 배열
                }
            }
        }
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}
