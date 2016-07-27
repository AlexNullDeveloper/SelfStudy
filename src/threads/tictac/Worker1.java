package threads.tictac;

/**
 * Created by a.talismanov on 05.07.2016.
 */
public class Worker1 extends Thread {
    private Data data;
    private int id;

    public Worker1(int i, Data d) {
        data = d;
        id = i;
        this.start();
    }

    @Override
    public void run() {
        synchronized (data) {
            for (int i = 0; i < 5; i++) {
                try {
                    while (id != data.getState()) {
                        data.wait();
                    }
                    if (id == 1) {
                        data.Tic();
                    } else {
                        data.Tak();
                    }
                    data.notify();
                } catch (InterruptedException e) {
                    e.getMessage();
                }
            }
        }
    }
}
