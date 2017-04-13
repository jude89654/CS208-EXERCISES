package Activities;

import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Created by jude8 on 2/9/2017.
 */
public class Activity3_Bismonte extends Frame {

      public void paint(Graphics g) {

          Graphics2D g2d = (Graphics2D) g;

          g2d.setStroke(new BasicStroke(3.0f));

          GeneralPath gp = new GeneralPath();
       /*  // shirt
          g2d.setColor(Color.blue);
        //  GeneralPath gp = new GeneralPath();
          gp.moveTo(150,200);
          gp.lineTo(200,200);
          gp.lineTo(200,150);
          gp.lineTo(250,150);
          gp.lineTo(250,450);
          gp.lineTo(450,450);
          gp.lineTo(450,150);
          gp.lineTo(500,150);
          gp.lineTo(500,200);
          gp.lineTo(550,200);
          gp.lineTo(550,100);
          gp.lineTo(500,50);
          gp.lineTo(200,50);
          gp.lineTo(150,100);
          gp.lineTo(150,200);

          g2d.fill(gp);

          //BOAT
          g2d.setColor(Color.YELLOW);
          gp.moveTo(200,300);
          //AB
          gp.lineTo(250,400);
          //BC
          gp.lineTo(550,400);
          //CD
          gp.lineTo(600,300);
          //DE
          gp.lineTo(200,300);
          gp.lineTo(405,300);
          //EF
          gp.lineTo(385,300);
          //FG
          gp.lineTo(385,100);
          //GH
          gp.lineTo(395,100);
          //HI
          gp.lineTo(491,150);
          gp.lineTo(395,150);
          gp.lineTo(395,300);
         // gp.lineTo();
          g2d.fill(gp);
          g2d.draw(gp);

         //Cross
           g2d.setPaint(Color.RED);
        gp.moveTo(300,300);
        gp.lineTo(200,300); //AB
        gp.quadTo(160,300,160,340); //BC
        gp.lineTo(160,360); //CD
        gp.quadTo(160,400,200,400); //DE
        gp.lineTo(300,400); //EF
        gp.lineTo(300,500); //FG
        gp.quadTo(300,540,340,540); //GH
        gp.lineTo(360,540); //HI
        gp.quadTo(400,540,400,500); //IJ
        gp.lineTo(400,400); //JK
        gp.lineTo(500,400);
        gp.quadTo(540,400,540,360);
        gp.lineTo(540,340);
        gp.quadTo(540,300,500,300);
        gp.lineTo(400,300);
        gp.lineTo(400,200);
        gp.quadTo(400,160,360,160);
        gp.lineTo(340,160);
        gp.quadTo(300,160,300,200);
        gp.lineTo(300,300);
        g2d.draw(gp);
        g2d.fill(gp);
*/
          //XMAS TREE
        gp.moveTo(400,160);
        gp.lineTo(420,180);
        gp.lineTo(400,200);
        gp.lineTo(380,180);
        gp.lineTo(400,160);
        g2d.setPaint(Color.yellow);
        g2d.fill(gp);
        GeneralPath gp1 = new GeneralPath();
        gp1.moveTo(400,200);
        gp1.lineTo(450,350);
        gp1.lineTo(430,350);
        gp1.lineTo(500,500);
        gp1.lineTo(480,500);
        gp1.lineTo(550,650);
        gp1.lineTo(250,650);
        gp1.lineTo(320,500);
        gp1.lineTo(300,500);
        gp1.lineTo(370,350);
        gp1.lineTo(350,350);
        gp1.lineTo(400,200);
        g2d.setPaint(Color.green);
        g2d.fill(gp1);
        GeneralPath gp2 = new GeneralPath();
        gp2.moveTo(390,650);
        gp2.lineTo(420,650);
        gp2.lineTo(420,680);
        gp2.lineTo(390,680);
        gp2.lineTo(390,650);
        g2d.setPaint(Color.gray);
        g2d.fill(gp2);


      }


    public static void main(String[] args) {
        Activity3_Bismonte shirt = new Activity3_Bismonte();
        shirt.setSize(1000,1000);
        shirt.setVisible(true);

    }

}
