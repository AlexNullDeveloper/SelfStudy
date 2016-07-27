package beans.tasks;

import beans.tasks.TaskData;
import beans.tasks.TaskListener;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by a.talismanov on 06.07.2016.
 */

public class TaskManager {
    ArrayList<TaskListener> listOfTaskListeners = new ArrayList<>();

    public void works() throws InterruptedException {
        Random random = new Random();

        Thread.sleep(random.nextInt(2000));
        fireTask(1,"");
        Thread.sleep(random.nextInt(2000));
        fireTask(2,"");
    }

    public synchronized void addTaskListener(TaskListener taskListener) {
        listOfTaskListeners.add(taskListener);
    }

    synchronized public void removeTaskListener(TaskListener taskListener) {
        listOfTaskListeners.remove(taskListener);
    }

    private void fireTask(int eventId, String name) {
        ArrayList<TaskListener> copy;
        synchronized (this) {
            copy = (ArrayList<TaskListener>) listOfTaskListeners.clone();
        }

        TaskData ev = new TaskData(this, name);

        for (TaskListener taskListener : copy) {
            if (eventId == 1) {
                taskListener.start(ev);
            } else {
                taskListener.stop(ev);
            }
        }

    }
}
