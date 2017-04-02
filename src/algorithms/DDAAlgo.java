package algorithms;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class DDAAlgo extends JPanel implements ActionListener {
    static double x1;
    static double y1;
    static double x2;

    public static double getX1() {
        return x1;
    }

    public static void setX1(double x1) {
        DDAAlgo.x1 = x1;
    }

    public static double getY1() {
        return y1;
    }

    public static void setY1(double y1) {
        DDAAlgo.y1 = y1;
    }

    public static double getX2() {
        return x2;
    }

    public static void setX2(double x2) {
        DDAAlgo.x2 = x2;
    }

    public static double getY2() {
        return y2;
    }

    public static void setY2(double y2) {
        DDAAlgo.y2 = y2;
    }

    static double y2;
    static double dx, dy, steps, x, y, k;
    int pixelSize,centerX,centerY;
    
    static double xc, yc;

    public void setPointsTextArea(JTextArea pointsTextArea) {
        this.pointsTextArea = pointsTextArea;
    }

    JTextArea pointsTextArea;

    DDAAlgo(int x1, int y1, int x2, int y2, JTextArea pointsTextArea){
        setX1(x1);
        setY1(y1);
        setX2(x2);
        setY2(y2);
        setPointsTextArea(pointsTextArea);
        setMinimumSize(new Dimension(650,650));
        setBackground(ColorScheme.backGroundColor);

    }
  

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d=(Graphics2D)g;
        BasicStroke bs=new BasicStroke(1.0f); //for drawing
        g2d.setStroke(bs);

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font("Century Gothic",Font.BOLD,12));
        
        pixelSize = 10;
		centerX = pixelSize * ((getWidth() / pixelSize) / 2);
		centerY = pixelSize * ((getHeight() / pixelSize) / 2);
        g.setColor(Color.black);
        for (int i = 0; i <= getWidth(); i += pixelSize) {
	
             /*if(i==centerX|i==centerY){
                         g.setColor(new Color(255,0,0));
                        }
             else{
                 g.setColor(Color.black);
             }*/
             
            g.drawLine(i, 0, i, getHeight());
			
            g.drawLine(0, i, getWidth(), i);
                       
        }

        
        
        //DDA ALGO
        // (2,5) (8,9)
         try {
            dx = x2 - x1; //6
            dy = y2 - y1; //4
            if (Math.abs(dx) > Math.abs(dy))
                steps = Math.abs(dx);
            else
                steps = Math.abs(dy);
            
            //delta
            xc = (dx /steps);
            yc = (dy / steps);
            
            x = x1;
            y = y1;
            //center
            g.fillRect((int)x*10,(int)y*10,10,10);
            for (k = 1; k <= steps; k++) {
                x = x + xc;
                y = y + yc;


                pointsTextArea.append("("+Math.round(x)+","+Math.round(y)+")\n");
                g2d.setColor(ColorScheme.pixelColor);
                g.fillRect((int) Math.round(x)*10, (int) Math.round((y))*10, 10, 10);
                System.out.println(Math.round(x)+","+Math.round(y));

            }
        } catch (Exception e) {
        }
    }



    @Override
    public void actionPerformed(ActionEvent e) {
       repaint();
    }
}