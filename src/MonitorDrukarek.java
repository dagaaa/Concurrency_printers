import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MonitorDrukarek {

    private LinkedList<Integer> dostepneDrukarki;

    private Lock lock = new ReentrantLock();
    private Condition dostepna = lock.newCondition();

    public MonitorDrukarek(int liczbaDrukarek) {
        dostepneDrukarki= new LinkedList<>();
        for (int i = 0; i < liczbaDrukarek; i++)
            dostepneDrukarki.add(new Integer(i));

    }

    public Integer zarezerwuj() throws InterruptedException {
        lock.lock();
        try {
            while (dostepneDrukarki.size() == 0)
                dostepna.await();

            return dostepneDrukarki.removeFirst();

        } finally {
            lock.unlock();
        }

    }

    public void zwolnij(Integer drukarka) {
        lock.lock();
        try {
            dostepneDrukarki.add(drukarka);
            dostepna.signal();
        } finally {
            lock.unlock();
        }

    }

}
