package Lec1124;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Read_Binary {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> strList = new ArrayList<String>();
        String filename = "/Users/simmigyeong/Documents/GitHub/JavaLecture/src/Lec1124/text.dat";
        FileOutputStream out = new FileOutputStream(filename);
        FileInputStream File = new FileInputStream(filename);
        FileInputStream in = new FileInputStream(String.valueOf(File));

        int readIn;
        String str = new String();
        String testStr = "";



        System.out.print("(중복 없는) 난수 개수 입력 > ");
        int num = sc.nextInt();
        int[] randomNum = new int[num];
        for (int i = 0; i < num; i++) {
            int value = (int)Math.random() * 100;
            System.out.print(value + " ");
            randomNum[i] = value;
        }
        byte[] randomNumByte = new byte[num];

        for (int i = 0; i < randomNum.length; i++) {
            randomNumByte[i] = (byte)randomNum[i];
        }
        for (int i = 0; i < randomNumByte.length; i++) {
            System.out.println(randomNumByte[i]);
        }


//        public  byte[] intToByteArray(int value) {
//            byte[] byteArray = new byte[4];
//            byteArray[0] = (byte)(value >> 24);
//            byteArray[1] = (byte)(value >> 16);
//            byteArray[2] = (byte)(value >> 8);
//            byteArray[3] = (byte)(value);
//
//            return byteArray;
//        }


        try{
            for(int i = 0; i<randomNum.length; i++) {
                out.write(randomNum[i]);
            }
        }
        catch (IOException ie) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }
}
