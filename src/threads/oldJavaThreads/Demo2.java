package threads.oldJavaThreads;

import java.util.Random;

/**
 * Created by a.talismanov on 05.07.2016.
 */
public class Demo2 {
    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return new Random().nextInt(100);
        }
    };

    public static void main(String[] args) {
        threadLocal.set(new Random().nextInt(100));
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                threadLocal.set(new Random().nextInt(100));
                System.out.println("Thread " + Thread.currentThread().getName() + " " + threadLocal.get());
            }
        };

        for (int i = 0; i < 3; i++) {
            (new Thread(runnable)).start();
        }
        System.out.println("Main thread, " + Thread.currentThread().getName() + " value is " + threadLocal.get());


    }
}
