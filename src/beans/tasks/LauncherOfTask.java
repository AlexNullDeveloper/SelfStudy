package beans.tasks;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class LauncherOfTask {
    public static void main(String[] args) throws InterruptedException {
        TaskManager taskManager = new TaskManager();
        Client client1 = new Client("perviy");
        Client client2 = new Client("vtoroi");

        taskManager.addTaskListener(client1);
        taskManager.addTaskListener(client2);

        taskManager.works();


        taskManager.removeTaskListener(client1);
        taskManager.removeTaskListener(client2);

    }
}
