package Lec1013;

public class SpeedGun {

    private int theSpeed;

    public void  shot(Car car) {
        System.out.println("—————speedgun monitor ———————");

        int n = car.Navi.find();
        for(int i=1 ; i <= n ; i++) {

            theSpeed = car.current();
            Road road = new Road();
            int limit = road.getLimit();
            System.out.println("Road" + i + "\t current speed:" + theSpeed + "km\t speed limit: :" + limit + "Km");
            if (theSpeed >= limit) {
                System.out.println("\t\t*\t\t ticked by" + (theSpeed - limit) + "Km over");
            }

        }

    }
}
