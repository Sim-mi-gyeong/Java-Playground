package Lec1129;

import javax.swing.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class MyFrame extends JFrame {
    MyFrame() {
        setTitle("영상 뷰어 v0.1");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new MyPanel());

        setSize(400,400);
        setVisible(true);
    }
    class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // 1. File Read
            int[] data = new int[500*500];
            int w = 256;   // 가로 크기
            int h = 256;   // 세로 크기

            int n = 0, tmp;   // 파일 불러와 읽을 때 필요한 변수

            try {
                FileInputStream fin = new FileInputStream("src/Lec1129/실험영상 업로드/회색영상/GIRL.dat");
                while( (tmp = fin.read()) != -1 ) {
                    data[n++] = tmp;
                }
                fin.close();
            }
            catch (IOException e) {
                System.out.println("파일을 읽어오지 못했습니다. ");
            }

           // 2. 1차원 배열 -> 2차원 배열
//            int bright = 100;   // 2번째 실습 : 값이 클수록 밝음
            int bright = 0;   // 4번째 실습: 필름 영상일 때
            int pix[][] = new int[300][300];
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
//                    pix[i][j] = data[i * w + j];   // 한 행 지날 때마다 곱해
//                    pix[i][j] = data[i * w + j] + bright;   // 255를 넘어가는 값에 대해서는 오히려 어두워 질 수 있음
                    pix[i][j] = 255 - data[i * w + j] + bright ;   // 4번째 실습 : 필름 영상일 때(반전된 값: 0일ㄷ 때 255, 255일 때 0)
                    if(pix[i][j] > 255) {
                        pix[i][j] = 255;
                    }
                }
            }

            // 3, GUI Graphic 출력
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    g.setColor(new Color(pix[i][j], pix[i][j], pix[i][j]));
                    // g.setColor(new Color(pix[i][j], pix[i][j], pix[i][j])) <- 컬러면
                    g.drawOval(20 + j, 20+i, 1, 1);
                }
            }

            g.drawRect(50,50,200,200);
        }
    }

    public static void main(String[] args) {
        new MyFrame();
    }
}