package algorithms;

import javax.swing.*;
import javax.xml.soap.Text;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

/**
 * Created by jude8 on 3/24/2017.
 */
public class SymmetricPlottingAlgo extends JPanel implements ActionListener,ColorScheme {

    static int height =650;
    static int width = height;
    static int framePixelHeight = 65;
    static int framePixelWidth = 65;
    static double scale = height / framePixelHeight;
    static double givenAngle = Math.toRadians(45);

    /**
     * The center of the midPointCircleAlgo
     */
    static int cx, cy;
    static int radius;

    public void setPointsTextArea(JTextArea pointsTextArea) {
        this.pointsTextArea = pointsTextArea;
    }

    static JTextArea pointsTextArea;

    /**
     * Constructor
     * @param x - the x of the center
     * @param y - the y of the center
     * @param radius - the radius of the midPointCircleAlgo
     */
    SymmetricPlottingAlgo(int x, int y, int radius, JTextArea pointsTextArea){
        setCx(x);
        setCy(y);
        setRadius(radius);
        setPointsTextArea(pointsTextArea);
        //revalidate()
        setMinimumSize(new Dimension(width,height));
        setBackground(ColorScheme.backGroundColor);
    }


    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;


        g2d.setColor(ColorScheme.lineColor);
        //drawing the sheet
        for(int x=0;x<framePixelWidth;x++){
            for(int y=0;y<framePixelHeight;y++){
                //g2d.drawString(x+","+y,(int)((x)*scale),(int)((y+1)*scale));
                g2d.draw(createRect(x,y));
            }
        }

        //filling the center
        g2d.fill(createRect(cx,cy));


        //x1=r*cos(theta)
        double currentx = radius*Math.cos(Math.toRadians(0));
        //y1=r*sin(d theta)
        double currenty = radius*Math.sin(Math.toRadians(0));
        g2d.fill(createRect(Math.round(currentx)+cx,Math.round(currenty)+cy));


        double theta =Math.toRadians(givenAngle/radius);

        //x2= r*cos(d theta)
        currentx = radius*Math.cos(theta);

        //y2 = r*sin(d theta)
        currenty = radius*Math.sin(theta);

        g2d.fill(createRect(Math.round(currentx)+cx,Math.round(currenty)+cy));


        //xn

        for(double x=0;x<Math.toRadians(45);x+=theta){
            double curx = currentx;
            double cury = currenty;
            currentx = (curx*Math.cos(theta))-(cury*Math.sin(theta));
            currenty = (cury*Math.cos(theta))+(curx*Math.sin(theta));

            g2d.setColor(ColorScheme.lineColor);
            long roundx = Math.round(currentx);
            long roundy = Math.round(currenty);
            //+x +y
            createRect(roundx+cx,roundy+cy,g2d);
            //-x -y
            createRect(-roundx+cx,-roundy+cy,g2d);
            //+x -y
            createRect(roundx+cx,-roundy+cy,g2d);
            //-x +y
            createRect(-roundx+cx,roundy+cy,g2d);

           // System.out.println(roundx + "aaa" + roundy);


            //interchange xs and ys
            //+x +y
            createRect(roundy+cx,roundx+cy,g2d);
            //-x -y
            createRect(-roundy+cx,-roundx+cy,g2d);
            //+x -y
            createRect(roundy+cx,-roundx+cy,g2d);
            //-x +y
            createRect(-roundy+cx,roundx+cy,g2d);


            //writing line

            //g2d.drawString((roundx+cx)+","+(roundy+cy),(int)((roundx+cx)*scale),(int)((roundy+cy+1)*scale));
            g2d.setColor(Color.black);

            System.out.println(roundx+","+roundy);



        }


    }
    private static Rectangle2D createRect(long x, long y){
        return new Rectangle2D.Double(x*scale,y*scale,scale,scale);
    }

    private static void createRect(double x, double y, Graphics2D g2d) {

        g2d.setColor(Color.RED);
                   pointsTextArea.append("("+x+","+y+")\n");
        //g2d.drawString(Math.round(x)+","+Math.round(y),(int) Math.round(x)*10, (int) Math.round((y))*10);
                g2d.setColor(ColorScheme.pixelColor);
        g2d.fill(new Rectangle2D.Double(x * scale, y * scale, scale, scale));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }


    public void setCx(int cx) {
        SymmetricPlottingAlgo.cx = cx;
    }

    public void setCy(int cy) {
        this.cy = cy;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}



