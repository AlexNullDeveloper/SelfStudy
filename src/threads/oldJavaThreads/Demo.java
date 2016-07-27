package threads.oldJavaThreads;

/**
 * Created by a.talismanov on 05.07.2016.
 */
class MyThread implements Runnable {
    public Thread thread;
    public volatile boolean cancel = false;

    public MyThread() {
        this.thread = new Thread(this);
    }

    @Override
    public void run() {
        try {
            double d = 9999.0;
            for (int i = 0; i < 30; i++) {
                if (cancel) {
                    throw new InterruptedException();
                }
                for (int j = 0; j < 1000000; j++) {
                    d = d * d / d;
                }
                System.out.println("Name = " + Thread.currentThread().getName() + " i= " + i);
            }
        } catch (InterruptedException e){
            e.getMessage();
        }
    }
}

public class Demo {
    public static void main(String[] args) throws InterruptedException {

        MyThread myThread = new MyThread();
//        myThread.thread.setDaemon(true);
        myThread.thread.start();

        Thread.sleep(50);
        myThread.thread.interrupt();
        myThread.cancel = true;


        System.out.println("end of main");
    }
}
