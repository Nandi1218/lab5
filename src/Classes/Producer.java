package Classes;

public class Producer implements Runnable{
    private String prod;
    Fifo sor;
    int wait;

    public Producer(String prod, Fifo sor, int wait)
    {
        this.sor = sor;
        this.prod = prod;
        this.wait=wait;
    }
@Override
    public void run(){go();}
    public void go() {

        int i =0;
        while(true)
        {

            try {
                sor.put(prod+i);
                System.out.println("produced "+ prod + "\t" + i + "\t"+ System.currentTimeMillis()%100000+ "\t" + sor.hossz());
                i++;
                Thread.sleep(wait);
                } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
