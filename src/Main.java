

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<Thread> threds= new LinkedList<>();
        MonitorDrukarek monitor = new MonitorDrukarek(4);

        for (int i =0; i<10 ;i++)
            threds.add(new Thread(new Drukowanie( i,monitor)));
        for(Thread t : threds)
            t.start();

    }
}
