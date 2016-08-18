package threads.concurrent;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by a.talismanov on 16.08.2016.
 */
public class AtomicLongTest {
    public static final AtomicLong nextSerialNum = new AtomicLong();
    public static long generateSerialNumber() {
        return nextSerialNum.getAndIncrement();
    }
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 100; i++) {
            executor.execute(()-> {
                System.out.println("Thread name" + Thread.currentThread().getName() + " generatedNumber " + generateSerialNumber());
            });
        }
    }
}
