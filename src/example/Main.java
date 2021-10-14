package example;
import example2.Test;

public class Main extends Test{
    public static void main(String[] args) {
//        Test test = new Test();
        Main main = new Main();

        System.out.println("protected 필드 접근 : " + main.one);
        System.out.println("protected 메소드 접근 : " + main.setOne());
    }
}
