package FinalExam;

import java.util.Scanner;

public class Number1_1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("입력 > ");
        int c = sc.nextInt();

        for(int i=0; i < 100; i++) {
            for (int j = i; j < 100; j++) {
                int i_2 = (int) Math.pow(i, 2);
                int j_2 = (int) Math.pow(j, 2);

                if( (i_2 + j_2) == c) {
                    System.out.println(true);
                    break;
                }
                else {
                    System.out.println(false);

                }

            }

        }

    }
}
