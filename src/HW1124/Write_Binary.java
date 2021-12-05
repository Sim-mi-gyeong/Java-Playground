package HW1124;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Write_Binary {

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
        byte[] randomNumByte = new byte[num];

        for (int i = 0; i < num; i++) {
            int value = (int)(Math.random() * 100);
            System.out.print(value + " ");
            randomNum[i] = value;
            intToByteArray(value);
            System.out.print(intToByteArray(value) + " ");
        }
        System.out.println();

        for (int i = 0; i < randomNum.length; i++) {
            randomNumByte[i] = (byte)randomNum[i];
        }
        try{
            for (int i = 0; i < num; i++) {
                int value = (int)(Math.random() * 100);
                System.out.print(value + " ");
                randomNum[i] = value;
                intToByteArray(value);
                out.write(intToByteArray(value));
            }
            out.flush();
            System.out.println("파일 저장 완료!");

//            while(readIn = in.read()) != -1 ) {
//                strList.add(str + readIn);
//            }
        }
        catch (IOException ie) {
            System.out.println("파일이 존재하지 않습니다.");
        }
        catch (Exception e) {
            System.out.println(e.getStackTrace());
        }

    }

    private static byte[] intToByteArray(int value) {
        byte[] byteArray=new byte[4];
        byteArray[0]=(byte)((value&0xFF000000)>>24);
        byteArray[1]=(byte)((value&0x00FF0000)>>16);
        byteArray[2]=(byte)((value&0x0000FF00)>>8);
        byteArray[3]=(byte) (value&0x000000FF);

        return byteArray;
    }
}
