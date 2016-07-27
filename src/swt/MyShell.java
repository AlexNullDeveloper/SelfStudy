package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class MyShell {


    private Shell sShell;
    private Button myButton;
    private Label myLabel;
    private int count;

    public static void main(String[] args) {
        Display display = Display.getDefault();
        MyShell thisClass = new MyShell();
        thisClass.createSShell();
        thisClass.sShell.open();

        while (!thisClass.sShell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }

        display.dispose();
    }

    private void createSShell() {
        FormData formData = new FormData();
        formData.bottom = new FormAttachment(30, 0);
        formData.left = new FormAttachment(40, 0);
        FormData formData_lab = new FormData();
        formData_lab.top = new FormAttachment(myButton, 10);
        formData_lab.width = 100;
        formData_lab.left = new FormAttachment(40, 0);
        FormLayout formLayout = new FormLayout();
        formLayout.spacing = 0;
        formLayout.marginWidth = 5;
        formLayout.marginHeight = 5;
        sShell = new Shell();
        sShell.setText("Shell");
        sShell.setLayout(formLayout);
        sShell.setSize(new Point(300, 181));
        myButton = new Button(sShell, SWT.PUSH);
        myButton.setText("OK");
        myButton.setLayoutData(formData);
        myButton.setToolTipText("This is a good button");
        myLabel = new Label(sShell, SWT.SHADOW_OUT | SWT.BORDER | SWT.HORIZONTAL | SWT.WRAP);
        myLabel.setText("");
        myLabel.setLayoutData(formData_lab);
        myButton.addSelectionListener(new org.eclipse.swt.events.SelectionAdapter() {
            public void widgetSelected(SelectionEvent e) {
                count++;
                System.out.println("widgedSelected(), count = " + count);
                DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM, Locale.GERMANY);
                String str = dateFormat.format(new Date());
                myLabel.setText(str);
            }
        });

    }
}
