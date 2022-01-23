package FinalPractice_2021_1;
import java.util.Scanner;

public class Number1_1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Scanner sc = new  Scanner(System.in);

        System.out.print("정수 입력> ");
        int input = sc.nextInt();

        int[] 십육진법 = new int[100];
        int count_16진 =0;
        while(input != 0) {
            십육진법[count_16진++] = input%16;
            input  = input/16;
        }



        System.out.print("0x");

        for(int j = 0 ; j < 8-count_16진 ; j ++) {
            System.out.print("0");
        }

        for(int i =0 ; i < count_16진 ; i++) {
            if(십육진법[count_16진-1-i] <= 9) {
                System.out.print(십육진법[count_16진-1-i]);
            }
            else if(십육진법[count_16진-1-i] == 10) {
                System.out.print("a");
            }
            else if(십육진법[count_16진-1-i] == 11) {
                System.out.print("b");
            }
            else if(십육진법[count_16진-1-i] == 12) {
                System.out.print("c");
            }
            else if(십육진법[count_16진-1-i] == 13) {
                System.out.print("d");
            }
            else if(십육진법[count_16진-1-i] == 14) {
                System.out.print("e");
            }
            else if(십육진법[count_16진-1-i] == 15) {
                System.out.print("f");
            }
        }

    }
}
