package Lec1013;

class Navigator {
    private int shortest;
    // 5개에서 10개 이내의 도로
    int find() {
        shortest = 5 + (int)(Math.random() * 6);
        return shortest;
    }

    void monitor() {
        System.out.println("\n--------------네비게이션 화면--------------");
        System.out.print("목적지까지 도로의 개수 : " + shortest);
        System.out.println("\n--------------네비게이션 화면--------------");
    }
}
