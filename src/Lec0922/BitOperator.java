package Lec0922;

import java.util.Scanner;

public class BitOperator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short a = 0;
        while (true) {
            int b = sc.nextInt();
            if (b == 13) {
                System.out.println("비트 설정 종료~");
                break;
            }
            a = (short)(a | (1 << (b-1)));
            System.out.printf("%03x\n",a);
//            System.out.println("a: "+a);
//            System.out.println("Integer.toHexString(a) : "+Integer.toHexString(a));
//            System.out.println("Integer.toBinaryString(a) : "+Integer.toBinaryString(a));
//            System.out.println("(byte)a : "+(byte)a);
        }
    }
}


