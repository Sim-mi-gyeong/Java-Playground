package Lec0929;
// 단어장 연습 프로그램 작성

import java.util.Scanner;

public class Dictionary {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int row = 10;
        int col = 2;
        String[][] dict = new String[row][col];

        // 단어장 입력
        System.out.println("단어장 입력 ");
        for(int i=0; i<dict.length; i++) {
            for(int j=0; j<dict[0].length; j++) {
                dict[i][j] = sc.next();
            }
        }

        // 단어장 연습
        int cnt = 0;
        String ans;
        System.out.println("");
        System.out.println("단어장 문제");
        while(true) {
            int num = (int)(Math.random()*row);
            System.out.print(dict[num][1] + " > ");
            ans = sc.next();

            if(ans.equals(dict[num][0])) {
                System.out.println("YES");
                cnt++;
            }
            else {
                System.out.println("NO");
                cnt--;
            }

            if(cnt==3) {
                System.out.println("PASS");
                break;
            }
            else if(cnt==-3) {
                System.out.println("FAIL");
                break;
            }
        }

    }

}
