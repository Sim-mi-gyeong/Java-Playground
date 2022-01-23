package Lec1011;

public class Road {
    private int limit;
    Road() {
        int a = (int)(Math.random()*4) + 1;
       switch (a) {   // 도로가 생성될 때 마다 생성자 호출해 제한속도 설정
           case 1:
               limit = 60;
               break;
           case 2:
               limit = 70;
               break;
           case 3:
               limit = 80;
               break;

           case 4:
               limit = 90;
               break;
       }
    }
    int getLimit() {
        return limit;
    }
}
