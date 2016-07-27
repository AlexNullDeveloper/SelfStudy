package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class MyShellClass {
    private Shell sShell = null;
    private Label textLabel;
    private Button myButton;

    private int buttonPressedN = 0;

    public static void main(String[] args) {
        Display display = Display.getDefault();
        MyShellClass thisClass = new MyShellClass();
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
        RowData rowData1 = new RowData();
        rowData1.height = 30;
        rowData1.width = 200;
        RowData rowData = new RowData();
        rowData.height = 30;
        rowData.width = 100;
        sShell = new Shell();
        sShell.setText("THIS IS SHELL");
        sShell.setLocation(new Point(110, 185));
        sShell.setLayout(new RowLayout());
        sShell.setSize(new Point(300, 200));
        sShell.setSize(new Point(300, 200));
        textLabel = new Label(sShell, SWT.CENTER | SWT.BORDER);
        textLabel.setText("THIS IS TEXT");
        textLabel.setLayoutData(rowData1);
        myButton = new Button(sShell, SWT.NONE);
        myButton.setText("THIS IS BUTTON");
        myButton.setLayoutData(rowData);
        myButton.addKeyListener(new KeyAdapter() {
            public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
                System.out.println("e.keyCode " + e.keyCode);
                if (e.keyCode == SWT.CR) {
                    buttonPressedN++;
                    textLabel.setText("Кнопка нажата" + buttonPressedN);
                }
                System.out.println("keyPressed()");
            }
        });
        myButton.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                buttonPressedN++;
                textLabel.setText("Key pressed " + buttonPressedN);
                System.out.println("WidgetSelected()");
            }
        });

    }
}
