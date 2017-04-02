package algorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import javax.swing.*;

/**
 * @author jude8
 */
public class MidPointCircleAlgo extends JPanel implements ActionListener, ColorScheme {

    int pixelSize;
    static int cx;
    static int cy;
    static int radius;
    int scale = 10;
    //static

    public void setPointsTextArea(JTextArea pointsTextArea) {
        this.pointsTextArea = pointsTextArea;
    }

    JTextArea pointsTextArea;
    public void setCx(int cx) {
        this.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }



    MidPointCircleAlgo(int x, int y, int radius,JTextArea pointsTextArea) {
        setCx(x);
        setCy(y);
        setRadius(radius);
        setMinimumSize(new Dimension(650, 650));
        setPointsTextArea(pointsTextArea);
        setBackground(ColorScheme.backGroundColor);
        //repaint();
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        //this.g2d = g2d;
           g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Century Gothic",Font.BOLD,12));

        g2d.setColor(ColorScheme.lineColor);

        for (int x = 0; x < 65; x++) {
            for (int y = 0; y < 65; y++) {
                //g2d.drawString(x+","+y,(int)((x)*scale),(int)((y+1)*scale));
                g2d.draw(new Rectangle2D.Double(x * scale, y * scale, scale, scale));
            }
        }


        setPixel(cx, cy, g2d);
        CircleMidpoint(cx, cy, radius, g2d);

    }

    public void CircleMidpoint(int xcenter, int ycenter, int radius, Graphics2D g2d) {
        int x = 0;
        int y = radius;
        int rp = 1 - radius;
        CirclePlotpoint(xcenter, ycenter, x, y, g2d);

        while (x < y) {
            x++;
            if (rp < 0) {
                rp += (2 * x) + 1;
            } else {
                y--;
                rp += (2 * x) - (2 * y) + 1;
            }
            System.out.println(x + "," + y);
            CirclePlotpoint(xcenter, ycenter, x, y, g2d);
        }
        System.out.println("ALGORITHM FINISHED");
    }

    public void CirclePlotpoint(int xcenter, int ycenter, int x, int y, Graphics2D g2d) {
        setPixel(xcenter + x, ycenter + y, g2d);
        setPixel(xcenter - x, ycenter + y, g2d);
        setPixel(xcenter + x, ycenter - y, g2d);
        setPixel(xcenter - x, ycenter - y, g2d);
        setPixel(xcenter + y, ycenter + x, g2d);
        setPixel(xcenter - y, ycenter + x, g2d);
        setPixel(xcenter + y, ycenter - x, g2d);
        setPixel(xcenter - y, ycenter - x, g2d);
    }

    public void setPixel(int x, int y, Graphics2D g2d) {
        //H.fillRect(x,y,5,5);
        g2d.setColor(ColorScheme.pixelColor);
        // g2d.setColor(Color.black);
        pointsTextArea.append("("+x+","+y+")\n");
        // System.out.println(x + "," + y);g2d.setColor(Color.RED);
                 //  g2d.drawString(Math.round(x)+","+Math.round(y),(int) Math.round(x)*10, (int) Math.round((y))*10);
                g2d.setColor(ColorScheme.pixelColor);
        g2d.fill(new Rectangle2D.Double(Math.round(x) * scale, Math.round(y) * scale, scale, scale));
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


}