import java.util.*;
import java.io.*;

// Exception - класс, который сигнализирует о сообщении об ошибке.
// new Exception ("message")
// throw - ключевое слово, которое позволяет выбросить ошибку.
// throws SomeExceptionType - конструкция, которая говорит о возможных
// исключениях в методе.
// ResultType methodName (...) throws Exception
// try {...} catch (...) {...} - позволяет обрабатывать
// ошибки (Пишется внутри метода класса).

// !ОШИБКИ НУЖНО ОБРАБАТЫВАТЬ ТАМ, ГДЕ ИМЕЕТСЯ ДОСТАТОЧНО СРЕДСТВ И ИНФОРМАЦИИ
// ДЛЯ ИХ ОБРАБОТКИ!

// Для каждого вида ошибки можно унаследовать собственный класс от эксепшена,
// чтобы указывать на то, что у нас происходят ошибки.

class EngineException extends Exception {}
class TooMuchSnowException extends Exception {
    private int height;
    TooMuchSnowException(int height) {
        this.height = height;
    }
    int getHeight() { return height; }
}

class Engine {
    private Random r;

    Engine() { r = new Random(); }
    void start() throws EngineException {
        if (r.nextInt(10) == 2) {
            throw new EngineException();
        }
        System.out.println("Started engine");
    }
    int get() throws EngineException {
        if (r.nextInt(10) == 2) {
            throw new EngineException();
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
    void move() throws EngineException, TooMuchSnowException {
        int snow = r.nextInt(10);
       engine.start();
       if (snow > 6) {
           throw new TooMuchSnowException(snow);
       }
       int speed = engine.get() / 100;
       System.out.println("Moving car with speed " + speed);
    }
}

public class L0 {
    public static void main(String[] args) {
        Car car = new Car(new Engine());
        for (int i=0; i<30; i++){
            try {
                System.out.println("=== " + i + " ===");
                car.move();
            } catch (TooMuchSnowException e) {
                System.out.println(e);
                for (int j = 0; j < e.getHeight(); j++) {
                    System.out.println("- Clean Snow");
                }
            } catch (EngineException e) {
                System.out.println(e);
                System.out.println("Repair engine");
            }
        }
    }
}
