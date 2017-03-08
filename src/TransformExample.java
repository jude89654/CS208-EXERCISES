import javafx.scene.transform.Affine;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;

/**
 * Created by jude8 on 2/23/2017.
 */
public class TransformExample extends Frame {

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

        GeneralPath xmasTreePath = new GeneralPath();
        xmasTreePath.moveTo(400,200);
        xmasTreePath.lineTo(450,350);
        xmasTreePath.lineTo(430,350);
        xmasTreePath.lineTo(500,500);
        xmasTreePath.lineTo(480,500);
        xmasTreePath.lineTo(550,650);
        xmasTreePath.lineTo(250,650);
        xmasTreePath.lineTo(320,500);
        xmasTreePath.lineTo(300,500);
        xmasTreePath.lineTo(370,350);
        xmasTreePath.lineTo(350,350);
        xmasTreePath.lineTo(400,200);
        xmasTreePath.closePath();
        g2d.draw(xmasTreePath);

        AffineTransform scale1 = new AffineTransform();
        scale1.setToScale(3,0.3);
        g2d.draw(scale1.createTransformedShape(xmasTreePath));

        AffineTransform rotate1 = new AffineTransform();
        rotate1.setToRotation(Math.PI/6);
        g2d.draw(rotate1.createTransformedShape(xmasTreePath));

        AffineTransform shear1 = new AffineTransform();
        shear1.setToShear(2,0.3);
        g2d.draw(shear1.createTransformedShape(xmasTreePath));

        AffineTransform translate1 = new AffineTransform();
        translate1.setToTranslation(60,70);
        g2d.draw(translate1.createTransformedShape(xmasTreePath));

    }

    public static void main(String args[]){
        TransformExample e = new TransformExample();
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
