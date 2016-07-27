package beans.tasks;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class Client implements TaskListener, Runnable {

    private String name;
    private boolean work;

    public Client(String name) {
        this.name = name;
        (new Thread(this)).start();
    }

    @Override
    public void start(TaskData taskData) {
        System.out.println("start " + name + " " + taskData.getDate());
        work = true;
        synchronized (this) {
            notify();
        }
    }

    @Override
    public void stop(TaskData taskData) {
        System.out.println("stop " + name + " " + taskData.getDate());
        work = false;
    }


    @Override
    public void run() {
        try {
            synchronized (this) {
                while (!work) wait();
            }
            while (work) {
                System.out.println("works...");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ends");
    }
}
