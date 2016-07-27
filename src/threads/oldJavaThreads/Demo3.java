package threads.oldJavaThreads;


/**
 * Created by a.talismanov on 05.07.2016.
 */

class Data {
    int count = 0;
    static int countSt = 0;
}

class MyThread2 implements Runnable {
    //    private final Object sync = new Object();
    Data obj;

    MyThread2(Data d) {
        obj = d;
        new Thread(this).start();
    }

    void add() {
        synchronized (obj) {
            try {
                Thread.sleep(10);
                int n = obj.count;
                n++;
                Thread.sleep(10);
                obj.count = n;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized static void addStatic() {
        try {
            Thread.sleep(10);
            int n = Data.countSt;
            n++;
            Thread.sleep(10);
            Data.countSt = n;
        } catch (InterruptedException ex) {

        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            add();
        }

        for (int i = 0; i < 10; i++) {
            addStatic();
        }
    }

}

public class Demo3 {
    public static void main(String[] args) throws Exception {
        Data d = new Data();
        MyThread2 t1 = new MyThread2(d);
        MyThread2 t2 = new MyThread2(d);
        MyThread2 t3 = new MyThread2(d);

        Thread.sleep(1500);
        System.out.println(d.count);
        System.out.println(Data.countSt);
    }
}
