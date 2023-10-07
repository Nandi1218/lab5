package Classes;

public class Consumer extends Thread {
    private final Fifo f;
    private final String s;
    private final int n;

    public Consumer(Fifo f, String s, int n) {
        this.f = f;
        this.s = s;
        this.n = n;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("consumed " + s +" "+ f.get() + " " + System.currentTimeMillis() % 100000 + "\t" + f.hossz());
                Thread.sleep(n);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
