package Lec0906;
//prime_Sieve_of_Eratosthenes

import java.util.Scanner;

public class Eratosthenes {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.println("에라토스테네스 체 소수 판별");

        System.out.println("> ");
        int N = sc.nextInt();
        int sqrtN = (int)Math.sqrt(N);

        boolean[] arr = new boolean[200];
        for(int i=2; i<=N; i++) {
            arr[i] = true;  //소수라 가정하고 체를 걸러가면소 소수 판
        }

        for(int i = 2; i <= sqrtN; i++) {
            if(arr[i]) {
                // true에 해당하는 수의 배수를 소수에서 제외
                for(int j = i*i; j <= N; j+=i) {
                    arr[j] = false;
                }
            }
        }

        for(int i=2; i<N; i++) {
            if(arr[i])
                System.out.print(i + " ");
        }
        sc.close();
    }
}
