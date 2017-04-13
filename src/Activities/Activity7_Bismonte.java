package Activities;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;

import static java.awt.Color.yellow;

/**
 * Created by jude8 on 3/2/2017.
 */
public class Activity7_Bismonte extends Frame {

    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
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



        g2d.setColor(Color.BLACK);
        g2d.fill(boatPath);




        //1.1
        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(100,150);
        g2d.setColor(Color.red);
        boatPath.getPathIterator(translate);



        Shape translated = translate.createTransformedShape(boatPath);
        g2d.fill(translated);

        //1.2
        g2d.setColor(Color.cyan);
        AffineTransform rotate = new AffineTransform();
        rotate.setToRotation(Math.PI/6);
        g2d.fill(rotate.createTransformedShape(boatPath));

        //1.3
        g2d.setColor(Color.BLUE);
        AffineTransform scale = new AffineTransform();
        scale.setToScale(0.25,3);
        g2d.fill(scale.createTransformedShape(boatPath));

        //1.4
        g2d.setColor(yellow);
        AffineTransform shear = new AffineTransform();
        shear.setToShear(0.5,0);
        g2d.fill(shear.createTransformedShape(boatPath));


        //1.5
        g2d.setColor(Color.green);
        g2d.fill(rotate.createTransformedShape(translate.createTransformedShape(boatPath)));

        //1,6
        g2d.setColor(Color.magenta);
        g2d.fill(shear.createTransformedShape(scale.createTransformedShape(boatPath)));



    }



    public static void main(String[] args) {
        Activity7_Bismonte activity7_bismonte = new Activity7_Bismonte();
        activity7_bismonte.setSize(640,480);
        activity7_bismonte.setVisible(true);

    }

}
