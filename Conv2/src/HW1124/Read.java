package HW1124;

import java.io.FileInputStream;
import java.io.IOException;

public class Read {
    public static void main(String[] args) {
        // "src/HW1124/testOut.bin 에 저장 불가"
        byte b[] = new byte [10];   // 비어있는 byte 파일

        try {
            FileInputStream fin  = new FileInputStream("src/HW1124/testOut.bin");
            int n = 0, c;

            while( (c = fin.read()) != -1) {
                b[n] = (byte)c;
                n++;
            }
            System.out.println("src/HW1124/testOut.bin 에서 읽은 배열을 출력 ");

            for (int i = 0; i < b.length; i++) {
                System.out.print(b[i] + "  ");
            }
            System.out.println();
            fin.close();

        }
        catch (IOException e) {
            System.out.println("src/HW1124/testOut.bin 에서 읽지 못했습니다. ");
        }

    }
}
