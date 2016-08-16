package threads.oldJavaThreads;

import java.util.concurrent.TimeUnit;

/**
 * Created by a.talismanov on 16.08.2016.
 */
public class StopThread {
    private static boolean stopRequested;

    private static synchronized  void requestStop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException{
        Thread backgroundThread = new Thread(() -> {
            int i =0;
            while (!stopRequested()){
                i++;
            }
        });
        backgroundThread.start();
        TimeUnit.SECONDS.sleep(1);
        requestStop();
    }
}
