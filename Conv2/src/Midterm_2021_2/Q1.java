package Midterm_2021_2;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        String b;
        a=sc.nextInt();
        b=Integer.toHexString(a);
        System.out.println("1번");
        System.out.println(b);


        short ans = 0;

        ans = (short)(ans | (1 << (a-1)));
            System.out.printf("%03x\n",ans);
    }
}
