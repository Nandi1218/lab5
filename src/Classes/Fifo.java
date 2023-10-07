package Classes;

import java.util.LinkedList;

public class Fifo{
    LinkedList<String> sor =new LinkedList<>();
    public synchronized void put(String input) throws InterruptedException {
        if(sor.size()<10)
        {
            sor.addLast(input);

            notify();
        }
        else {

            wait();
            sor.addLast(input);

        }
    }
    public synchronized String get() throws InterruptedException {
       if(!sor.isEmpty())
       {

           String output =sor.removeFirst();
           notify();
           return output;
       }
       wait();
       return sor.removeFirst();
    }
    public int hossz(){return  sor.size();}
}
