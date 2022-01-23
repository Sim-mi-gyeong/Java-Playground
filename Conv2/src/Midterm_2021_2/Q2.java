package Midterm_2021_2;

import java.util.Scanner;

public class Q2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr_2d = new int[col][row];

//        int min = 10;
//        int max = 100;
//        int random = (int) ((Math.random() * (max - min)) + min);

        for (int i = 0; i<arr_2d.length; i++) {
            for (int j = 0; j < arr_2d[0].length; j++) {
                arr_2d[i][j] = (int)(Math.random()*100);
            }
        }

        System.out.println("Q2-1");
        System.out.println();
        for (int i = 0; i<arr_2d.length; i++) {
            System.out.println();
            for (int j = 0; j < arr_2d[0].length; j++) {
                System.out.print(arr_2d[i][j] + " ");
            }
        }

        int[][] reverse_arr_2d = new int[row][col];
        for(int i=0; i<reverse_arr_2d.length; i++){
            for(int j=0; j<reverse_arr_2d[0].length; j++){
                reverse_arr_2d[i][j] = arr_2d[arr_2d.length-j-1][i];
            }
        }
        System.out.println();

        System.out.println("Q2-2");
        System.out.println();
        for (int i = 0; i<reverse_arr_2d.length; i++) {
            System.out.println();
            for (int j = 0; j < reverse_arr_2d[0].length; j++) {
                System.out.print(reverse_arr_2d[i][j] + " ");
            }
        }

    }

}
