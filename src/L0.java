import java.util.*;
import java.io.*;

//Exception - класс, который сигнализирует о сообщении об ошибке.
//new Exception ("message")
//throw - ключевое слово, которое позволяет выбросить ошибку.
//throws SomeExceptionType - конструкция, которая говорит о возможных
//исключениях в методе.
//ResultType methodName (...) throws Exception

class Engine {
    private Random r;

    Engine() { r = new Random(); }
    void start() throws Exception {
        if (r.nextInt(10) == 2) {
            throw new Exception("Engine has broken");
        }
        System.out.println("Started engine");
    }
    int get() throws Exception {
        if (r.nextInt(10) == 2) {
            throw new Exception("Engine has broken in get");
        }
        return r.nextInt(1000);
    }
}

class Car {
    private Engine engine;
    private Random r;

    Car(Engine engine) {
        this.engine = engine;
        this.r = new Random();
    }
    void move() throws Exception {
       engine.start();
       if (r.nextInt(4) == 1) {
           throw new Exception("Too much snow");
       }
       int speed = engine.get() / 100;
       System.out.println("Moving car with speed " + speed);
    }
}

public class L0 {
    public static void main(String[] args) throws Exception {
        Car car = new Car(new Engine());
        for (int i=0; i<30; i++){
            System.out.println("=== " + i + " ===");
            car.move();
        }
    }
}
