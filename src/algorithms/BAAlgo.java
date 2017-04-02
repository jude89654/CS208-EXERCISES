package algorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class BAAlgo extends JPanel implements ActionListener {

    static int pixelSize=10;
    static int x1;
    static int y1;
    static int x2;

    public static void setX1(int x1) {
        BAAlgo.x1 = x1;
    }

    public static void setY1(int y1) {
        BAAlgo.y1 = y1;
    }

    public static void setX2(int x2) {
        BAAlgo.x2 = x2;
    }

    public static void setY2(int y2) {
        BAAlgo.y2 = y2;
    }

    static int y2;
    Graphics g;
    Graphics2D g2d;

    public void actionPerformed(ActionEvent ae) {

    }

    BAAlgo(int x1, int y1, int x2, int y2) {
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setMinimumSize(new Dimension(650, 650));
        setBackground(ColorScheme.backGroundColor);
    }

    // draw one pixel with center (x, y)

    void drawBresenham() {
        BasicStroke bs = new BasicStroke(4.0f);
        g2d.setStroke(bs);
        int x, y, dx, dy;
        double gradient, f;
        dy = y2 - y1;
        dx = x2 - x1;

        x = x1;
        y = y1;

        f = 0.0;
        gradient = (double) dy / (double) dx;

        while (x <= x2) {
            x++;
            f += gradient;
            if (f > 0.5) {
                y++;
                f--;
            }
        }
        g2d.setColor(ColorScheme.lineColor);
        g2d.drawLine(x1 * pixelSize /*- (pixelSize / 2)*/, y1 * pixelSize /*- (pixelSize / 2)*/, x2 * pixelSize, y2 * pixelSize);

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g = g;
        g2d = (Graphics2D) g;
        pixelSize = 10;


        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // coordinate grid
        g2d.setColor(ColorScheme.pixelColor);

        for (int i = 0; i <= getWidth(); i += pixelSize) {
            g2d.drawLine(i, 0, i, getHeight());
            g2d.drawLine(0, i, getWidth(), i);
        }

        drawBresenham();
        //drawBresenham(1,2,3,4);


    }


}


