package applets;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import javax.swing.*;
/*
<applet code="Demo2.class" width="400" height="300">
	<param name="title" value="Diameters of the Planets"/>
	<param name="values" value="9"/>
	<param name="name.1" value="Mercury"/>
	<param name="name.2" value="Venus"/>
	<param name="name.3" value="Earth"/>
	<param name="name.4" value="Mars"/>
	<param name="name.5" value="Jupiter"/>
	<param name="name.6" value="Saturn"/>
	<param name="name.7" value="Uranus"/>
	<param name="name.8" value="Neptune"/>
	<param name="name.9" value="Pluto"/>
	<param name="value.1" value="3100"/>
	<param name="value.2" value="7500"/>
	<param name="value.3" value="8000"/>
	<param name="value.4" value="4200"/>
	<param name="value.5" value="88000"/>
	<param name="value.6" value="71000"/>
	<param name="value.7" value="32000"/>
	<param name="value.8" value="30600"/>
	<param name="value.9" value="1430"/>
</applet>
*/

public class Demo2 extends JApplet {
    public void init() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                String v = getParameter("values");
                if (v == null) return;
                int n = Integer.parseInt(v);
                double[] values = new double[n];
                String[] names = new String[n];
                for (int i = 0; i < n; i++) {
                    values[i] = Double.parseDouble(getParameter("value." + (i + 1)));
                    names[i] = getParameter("name." + (i + 1));
                }
                add(new ChartComponent(values, names, getParameter("title")));
            }
        });
    }
}

class ChartComponent extends JComponent {
    public ChartComponent(double[] v, String[] n, String t) {
        values = v;
        names = n;
        title = t;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        // compute the minimum and maximum values
        if (values == null) return;
        double minValue = 0;
        double maxValue = 0;
        for (double v : values) {
            if (minValue > v) minValue = v;
            if (maxValue < v) maxValue = v;
        }
        if (maxValue == minValue) return;

        int panelWidth = getWidth();
        int panelHeight = getHeight();

        Font titleFont = new Font("SansSerif", Font.BOLD, 20);
        Font labelFont = new Font("SansSerif", Font.PLAIN, 10);

        // compute the extent of the title
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D titleBounds = titleFont.getStringBounds(title, context);
        double titleWidth = titleBounds.getWidth();
        double top = titleBounds.getHeight();

        // draw the title
        double y = -titleBounds.getY(); // ascent
        double x = (panelWidth - titleWidth) / 2;
        g2.setFont(titleFont);
        g2.drawString(title, (float) x, (float) y);

        // compute the extent of the bar labels
        LineMetrics labelMetrics = labelFont.getLineMetrics("", context);
        double bottom = labelMetrics.getHeight();

        y = panelHeight - labelMetrics.getDescent();
        g2.setFont(labelFont);

        // get the scale factor and width for the bars
        double scale = (panelHeight - top - bottom) / (maxValue - minValue);
        int barWidth = panelWidth / values.length;

        // draw the bars
        for (int i = 0; i < values.length; i++) {
            // get the coordinates of the bar rectangle
            double x1 = i * barWidth + 1;
            double y1 = top;
            double height = values[i] * scale;
            if (values[i] >= 0) y1 += (maxValue - values[i]) * scale;
            else {
                y1 += maxValue * scale;
                height = -height;
            }

            // fill the bar and draw the bar outline
            Rectangle2D rect = new Rectangle2D.Double(x1, y1, barWidth - 2, height);
            g2.setPaint(Color.RED);
            g2.fill(rect);
            g2.setPaint(Color.BLACK);
            g2.draw(rect);

            // draw the centered label below the bar
            Rectangle2D labelBounds = labelFont.getStringBounds(names[i], context);

            double labelWidth = labelBounds.getWidth();
            x = x1 + (barWidth - labelWidth) / 2;
            g2.drawString(names[i], (float) x, (float) y);
        }
    }

    private double[] values;
    private String[] names;
    private String title;
}