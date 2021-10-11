package Lec1011;

public class SpeedGun {

    private int theSpeed;

    int shot(Car car) {   // 스피드건 -> 차 속도를 얻어오는 메시지 패싱 구현
        theSpeed = car.current();
        return theSpeed;

    }
}
