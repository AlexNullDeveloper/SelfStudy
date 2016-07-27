package applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="Demo1.class" width=210 height=60>
</applet>
*/

public class Demo1 extends JApplet {
    JLabel jlab;
    String msg = " Java moves the Web! ";
    boolean scrollLeft = true;
    ActionListener scroller;

    // This timer controls scrolling. The shorter
// its delay, the faster the scroll.
    Timer stTimer;

    // Initialize the applet.
    public void init() {
        try {
            SwingUtilities.invokeAndWait(new Runnable() {
                public void run() {
                    makeGUI();
                }
            });
        } catch (Exception exc) {
            System.out.println("Can't create because of " + exc);
        }
    }

    // Start the timer when the applet is started.
    public void start() {
        stTimer.start();
    }

    // Stop the timer when the applet is stopped.
    public void stop() {
        stTimer.stop();
    }

    // Stop the timer when the applet is destroyed.
    public void destroy() {
        stTimer.stop();
    }

    // Initialize the timer GUI.
    private void makeGUI() {
        // Use flow layout.
        setLayout(new FlowLayout());
        // Create the label that will scroll the message.
        jlab = new JLabel(msg);
        jlab.setHorizontalAlignment(SwingConstants.CENTER);
        // Create the action listener for the timer.
        scroller = new ActionListener() {
            // Each time the timer goes off, scroll the text
            // one character.
            public void actionPerformed(ActionEvent ae) {
                if (scrollLeft) {
                    // Left-scroll the message one character.
                    char ch = msg.charAt(0);
                    msg = msg.substring(1, msg.length());
                    msg += ch;
                    jlab.setText(msg);
                } else {
                    // Right-scroll the message one character.
                    char ch = msg.charAt(msg.length() - 1);
                    msg = msg.substring(0, msg.length() - 1);
                    msg = ch + msg;
                    jlab.setText(msg);
                }
            }
        };
        // Create the timer. Scroll every fifth of a second.
        stTimer = new Timer(200, scroller);
        // Add a button that reverses direction of scroll.
        JButton jbtnRev = new JButton("Reverse");
        // Create the action listener for the button.
        jbtnRev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                scrollLeft = !scrollLeft;
            }
        });
        // Add the label and button to the applet's content pane.
        add(jlab);
        add(jbtnRev);
    }
}