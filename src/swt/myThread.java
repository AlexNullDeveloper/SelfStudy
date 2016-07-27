package swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class myThread extends Thread {
    Display display;
    Label label;

    public myThread(Display disp, Label lab) {
        display = disp;
        label = lab;
    }

    public void run() {
        try {
            while (true) {
                DateFormat df = DateFormat.getTimeInstance(DateFormat.FULL);
                String str = df.format(new Date());

                if (!display.isDisposed()) {
                    display.asyncExec(() -> {
                        if (!label.isDisposed()) {
                            label.setText(str);
                        }
                    });
                } else {
                    break;
                }

                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
