package beans.tasks;

import java.util.Calendar;
import java.util.EventObject;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class TaskData extends EventObject {

    private String name;
    private String date;

    public TaskData(Object source, String name) {
        super(source);
        this.name = name;

        date = Calendar.getInstance().getTime().toString();
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

}
