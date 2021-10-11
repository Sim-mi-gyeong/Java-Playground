package Lec1011;

public class Main {
    public static void main(String[] args) {
        System.out.println("스피드건 모의실험");
        Car sonata = new Car();
        System.out.println("최고 속도 : " + sonata.getHighest() + "Km");
        System.out.println("현재 속도 : " + sonata.current() + "Km");

        int n = sonata.Navi.find();   // sonata 안에 있는 Navigator에게 경로 요청
        sonata.Navi.monitor();   // 요청한 결과 보여주기


        // simulation
        for (int i = 1; i <= n; i++) {   // 목적지까지 각각의 도로와 스피드 건을 지나간다.
            // 도로 생성 -> 해당 도로의 제한속도 생성됨.
            Road road = new Road();
            // 스피드건 생성
            SpeedGun speedGun = new SpeedGun();

            System.out.print("도로명" + i + "\t 제한속도 : " + road.getLimit() + "Km \t");

            System.out.print("도로명" + i + "\t");
            // 스피드건 -> 차의 속도 : 메시지 패싱
            // 스피드건 -> Monitor() : 메시지 패싱(제한속도를 불러와 차의 속도와 비교)
            System.out.println("현재 속도 : " + sonata.current() + "Km");

            System.out.println("스피드 건 획득 속도 : " + speedGun);   // 이 부분 다시

        }

//        Navigator iNavi = new Navigator();
//        iNavi.find();
//        iNavi.monitor();
    }
}
