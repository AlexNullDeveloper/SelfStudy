package threads.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;

/**
 * Created by a.talismanov on 05.07.2016.
 */
public class Locks {
    public static void main(String[] args) throws Exception {
        BigData d = new BigData();

        ExecutorService es = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++)
            es.submit(new WorkWData(d));


        TimeUnit.SECONDS.sleep(3);
        es.shutdown();
        //es.shutdownNow();
        es.awaitTermination(10000, TimeUnit.MILLISECONDS);
    }
}

class WorkWData implements Runnable {
    BigData obj;
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock rl = lock.readLock();
    Lock wl = lock.writeLock();

    WorkWData(BigData d) {
        obj = d;
    }

    public void run() {
        int n;
        n = obj.read();

        System.out.println("First read" + " " + Thread.currentThread().getName() + " " + new Integer(n).toString());
        obj.write();

        System.out.println("Write" + " " + Thread.currentThread().getName() + " " + new Integer(n).toString());
        n = obj.read();

        System.out.println("Second read" + " " + Thread.currentThread().getName() + " " + new Integer(n).toString());
    }
}

class BigData {
    int count = 1;
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock rl = lock.readLock();
    Lock wl = lock.writeLock();

    int read() {
        try {
            rl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(100);
            count = n;
        } catch (InterruptedException ex) {
        } finally {
            rl.unlock();
        }
        return count;
    }

    void write() {
        try {
            wl.lock();
            int n = count;
            TimeUnit.MILLISECONDS.sleep(100);
            n++;
            count = n;
        } catch (InterruptedException ex) {
        } finally {
            wl.unlock();
        }
    }
}


