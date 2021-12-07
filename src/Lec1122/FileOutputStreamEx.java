package Lec1122;
// 예제 8-5) FileOutputStream 으로 바이너리 파일 쓰기

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamEx {
    public static void main(String[] args) {
        byte b [] = {7, 51, 3, 4, -1, 24};

        try{
            FileOutputStream fout = new FileOutputStream("src/Lec1122/test1.out");

            for (int i = 0; i < b.length; i++) {
                fout.write(b[i]);   // 배열 b의 바이너리를 그대로 기록
            }
            fout.close();
        }
        catch(IOException e) {
            System.out.println("src/Lec1122/test1.out 에 저장할 수 없습니다. 경로명을 확인해주세요.");
            return;
        }
        System.out.println("src/Lec1122/test1.out 을 저장하였습니다. ");
    }
}
