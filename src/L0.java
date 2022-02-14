import java.util.*;

class Engine{
    private Random r;
    Engine() { r = new Random(); }
    int start() {
        if (r.nextInt(10)== 2) {
            System.out.println("Engine has broken");
            return 1;
        }
        System.out.println("Started engine");
        return 0;
    }
    int get() {
        if (r.nextInt(10)== 2) {
            System.out.println("Engine has broken");
            return 1;
        }
        return r.nextInt(1000);
    }
}

class Car{
    private Engine engine;
    private Random r;

    Car(Engine engine) {
        this.engine = engine;
        this.r = new Random();
    }
    int move() {
       int engineOk = engine.start();
       if (engineOk == 0) {
           if (r.nextInt(4) == 1) {
               System.out.println("Too much snow");
               return 2;
           }
           int n = engine.get();
           if (n < 0) {
               return n;
           }
           int speed = n / 100;
           System.out.println("Mooving car with speed " + speed);
           return 0;
       } else {
           return engineOk;
       }
    }
}

public class L0 {
    public static void main(String[] args) {
        Car car = new Car(new Engine());
        for (int i=0; i<30; i++){
            System.out.println("=== " + i + " ===");
            int moveOk = car.move();
            System.out.println(moveOk);
        }
    }
}
