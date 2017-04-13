import java.awt.*;
import java.awt.geom.*;

public class SantosSample extends Frame
{
    public void paint(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(5.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("Lines", 100, 380);

        g2d.setPaint(Color.BLACK);
        Line2D.Double l1 = new Line2D.Double(40,490,600,130);
        g2d.draw(l1);
        g2d.setPaint(Color.BLACK);
        Line2D.Double l2 = new Line2D.Double(600,130,400,300);
        g2d.draw(l2);
        g2d.setPaint(Color.BLACK);
        Line2D.Double l3 = new Line2D.Double(400,300,450,600);
        g2d.draw(l3);
        g2d.setPaint(Color.BLACK);
        Line2D.Double l4 = new Line2D.Double(450,600,300,390);
        g2d.draw(l4);
        g2d.setPaint(Color.BLACK);
        Line2D.Double l5 = new Line2D.Double(300,390,40,490);
        g2d.draw(l5);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("QuadCurve", 380, 400);
        g2d.setPaint(Color.GREEN);
        QuadCurve2D.Double q1 = new QuadCurve2D.Double(270,500,380,300,600,550);
        g2d.draw(q1);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("CubicCurve", 570, 330);
        g2d.setPaint(Color.BLUE);
        CubicCurve2D.Double c1 = new CubicCurve2D.Double(390, 400, 490, 650, 580, 550, 575, 350);
        g2d.draw(c1);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("Rectangle", 315, 88);
        g2d.setPaint(Color.RED);
        Rectangle2D.Double r1 = new Rectangle2D.Double(200, 100, 350, 200);
        g2d.draw(r1);
        //g2d.setPaint(Color.green);
        //g2d.fill(r);
        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("Ellipse", 315, 235);
        g2d.drawString("algorithms.MidPointCircleAlgo", 325, 50);
        g2d.setPaint(Color.YELLOW);
        Ellipse2D.Double elli = new Ellipse2D.Double(230,250,240,300);
        g2d.draw(elli);

        Ellipse2D.Double circ = new Ellipse2D.Double(-50,60,700,700);
        g2d.draw(circ);

        g2d.setPaint(Color.BLACK);
        g2d.setFont(new Font("Arial",Font.BOLD,20));
        g2d.drawString("Arc: Pie", 470, 490);
        Rectangle2D.Double r2 = new Rectangle2D.Double(300, 500, 300, 100);
        g2d.setPaint(Color.ORANGE);
        Arc2D.Double a1 = new Arc2D.Double(r2, 25, 65, Arc2D.PIE);
        g2d.draw(a1);
    }

    public static void main(String args[])
    {
        SantosSample p1 = new SantosSample();
        p1.setTitle("String in Java");
        p1.setBackground(Color.WHITE);
        p1.setSize(900,900);
        p1.setForeground(Color.black);
        p1.setVisible(true);
    }
}
