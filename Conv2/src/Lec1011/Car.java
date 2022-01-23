package Lec1011;

public class Car {
    private int highest;
    Navigator Navi;   // Navigator가 구성관계로 -> 두 개의 클래스에서 다른 하나의 클래스를 현재 클래스의 Field로 만들 때 레퍼런스로 선언 =>

    Car() {
        highest = 140 + 10*(int)(Math.random()*8);   // 속도 구간 140~210
        Navi = new Navigator();
    }
    // 최고속도
    int getHighest() {
        return highest;
    }
    int current() {   // Field로 만들지 않은 이유: 요청할 때마다 반환
        return (int)(Math.random()*highest + 1);
    }

}
