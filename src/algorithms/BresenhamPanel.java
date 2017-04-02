package algorithms;

import javax.swing.*;
import java.awt.*;

/**
 * Created by jude8 on 3/29/2017.
 */
public class BresenhamPanel extends JPanel {
    static int centerX, centerY;

    public void setPointsTextArea(JTextArea pointsTextArea) {
        this.pointsTextArea = pointsTextArea;
    }

    JTextArea pointsTextArea;

    public static void setX1(int x1) {
        BresenhamPanel.x1 = x1;
    }

    public static void setY1(int y1) {
        BresenhamPanel.y1 = y1;
    }

    public static void setX2(int x2) {
        BresenhamPanel.x2 = x2;
    }

    public static void setY2(int y2) {
        BresenhamPanel.y2 = y2;
    }

    static int x1, y1, x2, y2;

    public BresenhamPanel(int x1, int y1, int x2, int y2, JTextArea textArea) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setPointsTextArea(textArea);


        setMinimumSize(new Dimension(650, 650));
        setBackground(ColorScheme.backGroundColor);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setFont(new Font("Century Gothic", Font.BOLD, 14));
        for (int i = 0; i <= getWidth(); i += 10) {

            g.drawLine(i, 0, i, getHeight());

            g.drawLine(0, i, getWidth(), i);

        }

        drawLine(g, x1, y1, x2, y2); // NNE

    }

    private void plot(Graphics g, int x, int y) {
        // g.setColor(ColorScheme.lineColor);

        g.setColor(Color.RED);
        pointsTextArea.append("(" + x + "," + y + ")\n");
        //  g.drawString(Math.round(x)+","+Math.round(y),(int) Math.round(x)*10, (int) Math.round((y))*10);
        g.setColor(ColorScheme.pixelColor);
        g.fillRect(x * 10, y * 10, 10, 10);

    }

    private void drawLine(Graphics g,
                          int x1, int y1, int x2, int y2) {
        // delta of exact value and rounded value of the dependant variable
        int d = 0;

        int dy = Math.abs(y2 - y1);
        int dx = Math.abs(x2 - x1);

        int dy2 = dy << 1; // slope scaling factors to avoid floating
        int dx2 = dx << 1; // point

        int ix = x1 < x2 ? 1 : -1; // increment direction
        int iy = y1 < y2 ? 1 : -1;
        if (dy <= dx) {

            for (; ; ) {
                plot(g, x1, y1);
                if (x1 == x2)
                    break;
                x1 += ix;
                d += dy2;
                if (d > dx) {
                    y1 += iy;
                    d -= dx2;
                }
            }
        } else {
            for (; ; ) {
                plot(g, x1, y1);
                if (y1 == y2)
                    break;
                y1 += iy;
                d += dx2;
                if (d > dy) {
                    x1 += ix;
                    d -= dy2;
                }
            }
        }
    }

}
