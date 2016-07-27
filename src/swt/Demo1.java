package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class Demo1 {
    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        RowLayout layout = new RowLayout(SWT.VERTICAL);

        shell.setLayout(layout);
        new Button(shell, SWT.PUSH).setText("one");
        new Button(shell, SWT.PUSH).setText("2");
        new Button(shell, SWT.PUSH).setText("3");
        new Button(shell, SWT.PUSH).setText("four");
        new Button(shell, SWT.PUSH).setText("five");
        new Button(shell, SWT.PUSH).setText("6");

        Button b = new Button(shell, SWT.PUSH);
        b.setText("seven");

        shell.open();

        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();

    }
}
