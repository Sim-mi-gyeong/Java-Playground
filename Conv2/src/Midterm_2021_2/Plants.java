package Midterm_2021_2;

public class Plants {
    private int water;
    private int light;
    Leaf leaf;

    Plants(int a, int b){
        leaf = new Leaf(b);
        water = a;
    }

    void show() {
        System.out.println("물 : " + water+ "L" + ",  " +"태양 빛 :" + leaf.getLight() + "분");
    }

}

