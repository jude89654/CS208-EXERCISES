import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by jude8 on 2/23/2017.
 */
public class example extends Frame {

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        BasicStroke basicStroke = new BasicStroke(7.0f);
        g2d.setStroke(basicStroke);

        Ellipse2D e = new Ellipse2D.Double(40,40,400,500);
        Ellipse2D c = new Ellipse2D.Double(80,100,500,500);
        Rectangle2D.Double r = new Rectangle2D.Double(150,100,600,500);
         Rectangle2D.Double s = new Rectangle2D.Double(200,150,600,600);
        //g2d.fill(s);

        Area E = new Area(e);
        Area C = new Area(c);
        Area R = new Area(r);
        Area S = new Area(s);
        /*
            g2d.setColor(Color.BLUE);
        S.add(E);
        g2d.fill(S);
         */



        /*g2d.setColor(Color.RED);
        C.intersect(S);
        g2d.fill(C);*/

        /*g2d.setColor(Color.RED);
        C.subtract(R);
        g2d.fill(C);*/

        //example

        Ellipse2D bolollipse = new Ellipse2D.Double(100,90,20,30);
        g2d.draw(bolollipse);

        //g2d.fill(c);
        //g2d.fill(e);



    }

    public static void main(String args[]){
        example e = new example();
        e.setTitle("LOL");
        e.setSize(800,800);
       // e.setForeground(Color.RED);
        //e.setForeground(new Color(135, 2, 2));
        e.setBackground(Color.MAGENTA);
        e.setVisible(true);
        e.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }
}
