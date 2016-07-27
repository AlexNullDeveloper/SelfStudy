package beans.tasks;

import beans.tasks.TaskData;

import java.util.EventListener;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public interface TaskListener extends EventListener {
    public void start(TaskData taskData);
    public void stop(TaskData taskData);
}
