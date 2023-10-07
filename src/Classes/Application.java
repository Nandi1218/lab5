package Classes;


import java.util.Random;

public class Application {
    public static void main(String[] Args) {
        Random rnd = new Random();
        Fifo sor = new Fifo();
        Producer prod1 = new Producer("prod1", sor, rnd.nextInt(1000));
        Thread t1 = new Thread(prod1);
        t1.start();
        Producer prod2 = new Producer("prod2", sor,rnd.nextInt(1000));
        Thread t2 = new Thread(prod2);
        t2.start();
        Producer prod3 = new Producer("prod3", sor,rnd.nextInt(1000));
        Thread t3 = new Thread(prod3);
        t3.start();
        Consumer cons1 = new Consumer(sor, "cons1", rnd.nextInt(100));
        cons1.start();
        Consumer cons2 = new Consumer(sor, "cons2", rnd.nextInt(100));
        cons2.start();
        Consumer cons3 = new Consumer(sor, "cons3", rnd.nextInt(100));
        cons3.start();
        Consumer cons4 = new Consumer(sor, "cons4", rnd.nextInt(100));
        cons4.start();

    }
}
