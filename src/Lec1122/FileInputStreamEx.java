package Lec1122;
// 예제 8-6) FileInputStream으로 바이너리 파일 읽기

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputStreamEx {
    public static void main(String[] args) {
        byte b[] = new byte [6];   // 비어있는 byte 파일

        try{
            FileInputStream fin = new FileInputStream("src/Lec1122/test1.out");
            int n = 0, c;

            while((c = fin.read()) != -1) {
                b[n] = (byte)c;
                n++;
            }
            System.out.println("src/Lec1122/test1.out 에서 읽은 배열을 출력합니다. ");
            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + "  ");
            }
            System.out.println();
            fin.close();
        }
        catch(IOException e) {
            System.out.println("src/Lec1122/test1.out 에서 읽지 못했습니다. 경로명 확인 필요");
        }
    }
}
