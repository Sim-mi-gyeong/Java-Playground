package Lec0908;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.print("> ");

            int n = sc.nextInt();
            int N = 2 * n;

            int cnt = 0;

            int[] arr = new int[2 * N];

            if (n == 0) {
                break;
            }

            for (int i = 2; i <= N; i++) {
                arr[i] = i;
            }

            for (int i = 2; i <= Math.sqrt(N); i++) {
                if (arr[i] == 0) {
                    continue;
                }

                int tmp = i;
                for (int j = i + 1; j <= N; j++) {
                    if (j % tmp == 0) {
                        arr[j] = 0;
                    }
                }

            }

            for (int k = n + 1; k < arr.length; k++) {
                if (arr[k] != 0)
                    cnt++;
            }

            System.out.println(cnt);
        }
    }
}
