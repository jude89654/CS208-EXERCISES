import sun.reflect.generics.tree.Tree;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

/**
 * Created by jude8 on 2/23/2017.
 */
public class area_bismontejude extends Frame {

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

        GeneralPath shirtPath = new GeneralPath();
          shirtPath.moveTo(150,200);
          shirtPath.lineTo(200,200);
          shirtPath.lineTo(200,150);
          shirtPath.lineTo(250,150);
          shirtPath.lineTo(250,450);
          shirtPath.lineTo(450,450);
          shirtPath.lineTo(450,150);
          shirtPath.lineTo(500,150);
          shirtPath.lineTo(500,200);
          shirtPath.lineTo(550,200);
          shirtPath.lineTo(550,100);
          shirtPath.lineTo(500,50);
          shirtPath.lineTo(200,50);
          shirtPath.lineTo(150,100);
          shirtPath.lineTo(150,200);
          shirtPath.closePath();


        GeneralPath crossPath = new GeneralPath();
        crossPath.moveTo(300,300);
        crossPath.lineTo(200,300); //AB
        crossPath.quadTo(160,300,160,340); //BC
        crossPath.lineTo(160,360); //CD
        crossPath.quadTo(160,400,200,400); //DE
        crossPath.lineTo(300,400); //EF
        crossPath.lineTo(300,500); //FG
        crossPath.quadTo(300,540,340,540); //GH
        crossPath.lineTo(360,540); //HI
        crossPath.quadTo(400,540,400,500); //IJ
        crossPath.lineTo(400,400); //JK
        crossPath.lineTo(500,400);
        crossPath.quadTo(540,400,540,360);
        crossPath.lineTo(540,340);
        crossPath.quadTo(540,300,500,300);
        crossPath.lineTo(400,300);
        crossPath.lineTo(400,200);
        crossPath.quadTo(400,160,360,160);
        crossPath.lineTo(340,160);
        crossPath.quadTo(300,160,300,200);
        crossPath.lineTo(300,300);
        crossPath.closePath();

        GeneralPath boatPath = new GeneralPath();
          //  g2d.setColor(Color.YELLOW);
        boatPath.moveTo(200,300);

        boatPath.lineTo(250,400);//ab
        boatPath.lineTo(550,400);//bc
        boatPath.lineTo(600,300);//cd
        boatPath.lineTo(405,300);//de
        boatPath.lineTo(395,300);//ef
        boatPath.lineTo(200,300);//fa
        boatPath.moveTo(395,300);
        boatPath.lineTo(395,100);//fg
        boatPath.lineTo(405,100);//gh
        boatPath.lineTo(405,300);//hi
        boatPath.moveTo(405,100);
        boatPath.lineTo(500,150);//hj
        boatPath.lineTo(405,150);//jk
        boatPath.closePath();
       // g2d.draw(boatPath);
         // gp.lineTo();
          //g2d.fill(boatPath);
          //g2d.draw(boatPath);

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
        g2d.setPaint(Color.green);

        Area xmasTreeArea = new Area(xmasTreePath);
        Area crossArea = new Area(crossPath);
        Area boatArea = new Area(boatPath);
        Area shirtArea = new Area(shirtPath);



//        //NUMBER 1
//        g2d.setColor(Color.RED);
//        xmasTreeArea.add(crossArea);
//        g2d.fill(xmasTreeArea);

//        //number 2
//        g2d.setColor(Color.BLUE);
//        boatArea.add(shirtArea);
//        g2d.fill(boatArea);
//
//        //number 3
//        g2d.setColor(Color.magenta);
//        Area ellipseArea = new Area(new Ellipse2D.Double(20,20,1000,800));
//        ellipseArea.subtract(boatArea);
//        g2d.fill(ellipseArea);
//
//        //number 4
//        g2d.setColor(Color.YELLOW);
//        boatArea.intersect(xmasTreeArea);
//        g2d.fill(boatArea);

        //number 5
        g2d.setColor(Color.pink);
        xmasTreeArea.subtract(boatArea);
        g2d.fill(xmasTreeArea);

//        //number 6
//        g2d.setColor(Color.green);
//        crossArea.subtract(shirtArea);
//        g2d.fill(crossArea);
//
//        //number 7
//        g2d.setColor(Color.cyan);
//       boatArea.exclusiveOr(crossArea);
//        g2d.fill(boatArea);







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

        /*g2d.setPaint(Color.RED);
        C.exclusiveOr(E);
        g2d.fill(C);*/



        //g2d.fill(c);
        //g2d.fill(e);



    }

    public static void main(String args[]){
        area_bismontejude e = new area_bismontejude();
        e.setTitle("LOL");
        e.setSize(800,800);
       // e.setForeground(Color.RED);
        //e.setForeground(new Color(135, 2, 2));
        //e.setBackground(Color.MAGENTA);
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
