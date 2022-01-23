package HW1124;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Write {
    public static void main(String[] args) {
        byte[] data = new byte[50];   // 난수를 넣을 배열 생성
        int size;   // 난수 개수 저장할 size

        Scanner sc = new Scanner(System.in);
        System.out.print("(중복없는) 난수 개수 입력 > ");
        size = sc.nextInt();

        // 중복없는 난수 발생기
        for (int i = 0; i < size; i++) {
            data[i] = (byte)(Math.random() * 90 + 10);   // 10~99까지의 정수 배열에 넣기
            for (int j = 0; j < i; j++) {   // 중복 방지를 위한 반복문
                if(data[i] == data[j]) {   // 중복이 발생하면
                    i--;   // i를 1만큼 줄이고
                    j = i;   // j를 i에 대입하여 다시 상위 반복문으로 돌아가 난수 생성
                }

            }
        }

        // 예외 처리 및 파일 쓰기
        try {
            FileOutputStream fout = new FileOutputStream("src/HW1124/testOut.bin");
            for (int i = 0; i < size; i++) {
                fout.write(data[i]);
            }
            fout.close();
        }
        catch (IOException e) {
            System.out.println("src/HW1124/testOut.bin 에 저장 불가");
            return;
        }
        System.out.println("src/HW1124/testOut.bin 을 저장하였습니다. ");
    }
}
