package Classes;


public class Application {
    public static void main(String[] Args) {
        Fifo sor = new Fifo();
        Producer elso = new Producer("put", sor,30);
        elso.start();
        Consumer masodik = new Consumer(sor, "get", 50);
        masodik.start();

    }
}
