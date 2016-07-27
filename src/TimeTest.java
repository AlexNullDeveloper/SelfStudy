import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by a.talismanov on 22.07.2016.
 */
public class TimeTest {
    private Timer mTimer;
    private MyTimerTask mMyTimerTask;
    private Vector<Connection> freeConnections = new Vector();

    public static void main(String[] args) {
        TimeTest timeTest = new TimeTest();

        timeTest.mTimer = new Timer();
        timeTest.mMyTimerTask = new MyTimerTask();

        timeTest.mTimer.schedule(timeTest.mMyTimerTask,1000,5000);

    }


}

class MyTimerTask extends TimerTask {




    @Override
    public void run() {
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
//                "dd:MMMM:yyyy HH:mm:ss a", Locale.getDefault());
//        final String strDate = simpleDateFormat.format(calendar.getTime());
        System.out.println("hello timerTask");

    }
}