package Classes;

import java.util.Arrays;
import java.util.LinkedList;

public class Fifo{
    LinkedList<String> sor =new LinkedList<>();
    public synchronized void put(String input) throws InterruptedException {
        while(true)
        {
            if(sor.size()<10)
            {
                sor.addLast(input);
                System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()) +" "+ Thread.currentThread().getId());
                notifyAll();
                return;
            }
            wait();
        }
    }
    public synchronized String get() throws InterruptedException {
        while(true)
        {
            if(!sor.isEmpty())
            {
                String output =sor.removeFirst();
                notifyAll();
                System.out.println(Arrays.toString(Thread.currentThread().getStackTrace()) +" "+Thread.currentThread().getId());
                return output;
            }
            wait();
        }
    }
    public int hossz(){return  sor.size();}
}
