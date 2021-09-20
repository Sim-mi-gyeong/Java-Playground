package Lec0920;

public class BitOperation {
    public static void main(String[] args) {
        byte flag = 0b00001010;
//      byte flag = 0xa;
//      byte flag = 10;

//      byte flag = 0b00000110;
//      byte flag = 0x6;   // 2진수 값을 16진수 값으로
//      byte flag = 6;   // 10진수 값과 16진수 값이 동일
        if ((flag & 0b00001000) == 0) {
            System.out.println("온도는 0도 미만");
        } else {
            System.out.println("온도는 0도 이상");
        }
    }
}
