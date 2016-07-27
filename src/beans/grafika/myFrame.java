package beans.grafika;

import javax.swing.*;
import java.awt.*;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class myFrame extends JFrame {
    public myFrame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 400, Short.MAX_VALUE)
        );

        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 300, Short.MAX_VALUE)
        );
        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new myFrame().setVisible(true));
    }
}
