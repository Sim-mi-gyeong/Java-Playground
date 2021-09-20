package Lec0915;
//3 개 이상의 수의 최대공약수
import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("3개 이상의 수의 최대공약수");

        System.out.print("입력 수의 개수 : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int min = arr[0];
        for(int i = 0; i < n; i++) {
            if(min>arr[i]) min = arr[i];
        }
        int ans = 0;
        for(int i = 2; i<= min; i++) {
            for(int j=0; j<n; j++) {
                if(arr[j] % i == 0) ans=i;
            }
        }

        System.out.println(ans);
    }
}
