import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by Jude Bismonte on 1/26/2017.
 */

public class Sample extends Frame {

    static int height = 500;
    static int width = 500;
    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(10.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Comic Sans MS",Font.BOLD,80));


        //Color test = new Color(2);
        Color[] colors = new Color[]{Color.BLACK,Color.GRAY};

       // Rectangle2D.Double rectangle2D = new Rectangle2D.Double()
        Line2D.Double l1 = new Line2D.Double(Math.random()*width, Math.random()*height, Math.random()*width, Math.random()*height);
        while(true) {

            g2d.setPaint(colors[(int) (Math.random() * colors.length)]);
            l1.setLine(Math.random()*width, Math.random()*height, Math.random()*width, Math.random()*height);
            g2d.draw(l1);
            g2d.setPaint(Color.WHITE);

            g2d.drawString("JUDE",4,height/2);


        }

    }

    public static void main(String args[]){
        Sample s = new Sample();
        s.setTitle("String in Java");
        s.setBackground(Color.WHITE);
        s.setSize(500,500);
        s.setForeground(Color.ORANGE);
        s.setVisible(true);
        s.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                System.exit(0);
            }
        });
    }

}
