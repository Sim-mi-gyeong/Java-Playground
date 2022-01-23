package Lec0920;
// 십진수를 이진수로 변환하는 비트 연산

import java.util.Scanner;

public class Dec2Bin {
    public static void main(String[] args) {

        System.out.println("십진수 -> 이진수로 변환");

        System.out.print("> ");
        Scanner sc = new Scanner(System.in);
        int dec = sc.nextInt();

        sc.close();

//      int[] bin = new int[100];
        byte[] bin = new byte[100];
        int cnt = 0;

        // 10진수를 2로 나누다가 몫(다시 나눠지는 값)이 0이 되기 전까지
        // 더 이상 나누어지지 않을 때까지
        while(dec != 0) {
            // 나머지를 배열에 저장 후 거꾸로 출력 -> 몫부터 출력
            bin[cnt++] = (byte)(dec % 2);   // 강제 casting
            dec /= 2;
        }
        for (int i = 0; i < cnt; i++) {
            System.out.print(bin[cnt - 1 - i]);
        }

    }
}
