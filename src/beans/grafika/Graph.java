package beans.grafika;

import javax.swing.*;
import java.awt.*;

/**
 * Created by a.talismanov on 11.07.2016.
 */
public class Graph extends JComponent {

    private int graphType;

    public int getGraphType() {
        return graphType;
    }

    public void setGraphType(int graphType) {
        this.graphType = graphType;
        repaint();
    }

    public Graph() {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("Hello world", getHeight() / 10, getWidth() / 2);
    }
}
