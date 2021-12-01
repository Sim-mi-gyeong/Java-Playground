package Lec1201;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ColorImage extends JFrame {
    MyPanel panel;
    public static void main(String[] args) {
//        Image image1 = null;
//        Image image2 = null;
//        Image image3 = null;
//
////        File sourceImage = new File("girl.raw");
//        try {
//            // 파일로부터 이미지 읽기
//            // 프로젝트 내의 현재 패키지 안의 images/smile.jpg 를 로드함
//            // InputStream is = getClass().getResourceAsStream("images/smile.jpg")
//            File sourceImage = new File(String.valueOf(ColorImage.class.getResource("resource/girl.raw")));
//
////            File sourceImage = new File("src/Lec1201/girl.raw");
//            image1 = ImageIO.read(sourceImage);
//
//            // InputStream 으로 부터 이미지 읽기
//            InputStream is = new BufferedInputStream(new FileInputStream("girl.raw"));
//            image2 = ImageIO.read(is);
//
//            // URL 로 부터 이미지 읽기
////            URL url = new URL("");
////            image3 = ImageIO.read(url);
//
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        // Use a label to display the image
//        JFrame frame = new JFrame();
//
//        JLabel label1 = new JLabel(new ImageIcon(image1));
//
//        frame.getContentPane().add(label1, BorderLayout.CENTER);
//
//        frame.pack();
//        frame.setVisible(true);

        ColorImage colorImage = new ColorImage("Color Image");

    }

    ColorImage(String title) {
        super(title);

        this.setLayout(null);
        this.setBounds(100, 100, 800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new MyPanel();
        this.getContentPane().add(panel);
        this.setVisible(true);
    }
}

class MyPanel extends JPanel {
    BufferedImage img;

    MyPanel() {
        this.setBackground(Color.WHITE);
        this.setBounds(100, 100, 500, 400);

        InputStream is = getClass().getResourceAsStream("resource/girl.raw");

        try{
            img = ImageIO.read(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // 기존에 그려진 화면을 지정된 배경색으로 지우는 역할을 한다
        Graphics2D g2d = (Graphics2D) g;

        g2d.drawImage(img, 0, 0, null);
    }

}
