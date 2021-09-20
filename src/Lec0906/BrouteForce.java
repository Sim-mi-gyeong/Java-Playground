package Lec0906;

import java.util.Scanner;

public class BrouteForce {
    public static void main(String[] args) {   //Entry Point 시작점(컴파일을 시작하는 부분)
        System.out.println("소수 판별법");

        Scanner sc = new Scanner(System.in);

        System.out.print("> ");
        int N = sc.nextInt();
        int sqrtN = (int)Math.sqrt(N);

        boolean prime = true;
        for(int i=2; i<=sqrtN; i++) {
            if(N%i==0) {
                prime = false;
                break;
            }
        }

        if(prime)
            System.out.println(N + "은(는) 소수입니다.");
        else
            System.out.println(N + "은(는) 소수가 아닙니다.");

        sc.close();
    }
}
