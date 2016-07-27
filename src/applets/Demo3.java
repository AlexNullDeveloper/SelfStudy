package applets;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

/*
    <applet code="Demo3.class" width=220 height=100>
		<param name=primarySite value=aport.ru>
		<param name=secondarySite value=specialist.ru>
		<param name=default value=0>
	</applet>
*/

public class Demo3 extends JApplet {
    JLabel jlab;
    JCheckBox jcbPrimary;
    String primary;
    String secondary;

    // Initialize the applet.
    public void init() {
        primary = getParameter("primarySite");
        secondary = getParameter("secondarySite");
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

    // Initialize the GUI.
    private void makeGUI() {
        setLayout(new FlowLayout());

        jlab = new JLabel("Transfer to " + primary);
        jcbPrimary = new JCheckBox("Use Primary Site", true);

        jcbPrimary.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                if (jcbPrimary.isSelected())
                    jlab.setText("Transfer to " + primary);
                else
                    jlab.setText("Transfer to " + secondary);
            }
        });

        JButton jbtnJump = new JButton("Show Page Now");

        jbtnJump.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                showStatus("Transferring to selected site.");
                try {
                    if (jcbPrimary.isSelected())
                        getAppletContext().showDocument(new URL("http://www." + primary), "_blank");
                    else
                        getAppletContext().showDocument(new URL("http://www." + secondary), "_self");
                } catch (MalformedURLException exc) {
                    showStatus("Error in URL.");
                }
            }
        });
        add(jcbPrimary);
        add(jlab);
        add(jbtnJump);
    }
}