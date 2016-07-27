package threads.oldJavaThreads;

/**
 * Created by a.talismanov on 05.07.2016.
 */


public class Demo4 extends Thread {

    private boolean suspended = false;
    private boolean terminated = false;

    public Demo4() {
        this.suspended = false;
        this.terminated = false;
    }

    public Demo4(boolean susp) {
        this.suspended = susp;
        this.terminated = false;
    }

    public void terminate() {
        terminated = true;
    }

    public void mySuspend() {
        if (!suspended) {
            suspended = true;
        }
    }

    private void myResume() {
        if (suspended) {
            suspended = false;
            synchronized (this) {
                notify();
            }
            System.out.println("go....");
        }
    }

    private boolean isSuspended() {
        return suspended;
    }

    @Override
    public void run() {
        int count = 0;
        try {
            while (!terminated) {
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
                System.out.println("Count = " + count++);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.getMessage();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        Demo4 thread = new Demo4();
        thread.start();

        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            if (thread.isSuspended()) {
                thread.myResume();
            } else {
                thread.mySuspend();
            }
        }

        thread.myResume();
        thread.terminate();

        thread.join();
    }
}
