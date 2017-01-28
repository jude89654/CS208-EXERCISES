import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;

/**
 * Created by Jude Bismonte on 1/26/2017.
 */

public class string extends Frame {
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(7.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Comic Sans MS",Font.BOLD,40));
        g2d.drawString("" +Math.random(), 50, 70);

        g2d.setPaint(Color.DARK_GRAY);
        Line2D.Double l1 = new Line2D.Double(50,70,250,300);
        while(true) {
            g2d.draw(l1);
            l1.setLine(50, 70, Math.random()*500, Math.random()*500);
        }

    }

    public static void main(String args[]){
        string s = new string();
        s.setTitle("String in Java");
        s.setBackground(Color.WHITE);
        s.setSize(500,500);
        s.setForeground(Color.ORANGE);
        s.setVisible(true);
    }

}
