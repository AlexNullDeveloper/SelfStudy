package awt;

import java.awt.*;
import java.awt.event.*;

/**
 * Created by a.talismanov on 06.07.2016.
 */
public class DemoAWT1 extends Frame implements MouseMotionListener, MouseListener {

    private int x;
    private int y;

    public DemoAWT1(String nameOfFrame) {
        super(nameOfFrame);
        setSize(640, 480);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.out.println(Thread.currentThread().getName());
                System.exit(0);
            }
        });

        Button btn1 = new Button("OK BUTTON");
        btn1.addActionListener(ae -> System.out.println("ok button"));
        this.add(btn1);

        Button btn2 = new Button("SOUTH BUTTON");
        btn2.addActionListener(ae -> System.out.println("south"));
        this.add(btn2);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    public static void main(String[] args) {
        new DemoAWT1("DEMO AWT");
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.drawLine(x, y, e.getX(), e.getY());
//        System.out.println(e.getX() + " " + e.getY());
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
