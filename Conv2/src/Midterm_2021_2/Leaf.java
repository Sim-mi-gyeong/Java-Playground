package Midterm_2021_2;

public class Leaf {

    private int light;

    Leaf(int a) {
        light = a;

    }

    void show() {
        System.out.println("태양 빛 : " + light + "분");
    }

    public int getLight() {
        return light;
    }

}
