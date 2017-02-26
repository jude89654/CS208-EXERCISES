import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;

/**
 * Created by judeBismonte on 2/23/2017.
 */
public class SelfPortrait extends Frame {

    int picWidth = 750, picHeight=605;
    double aspectRatio = picWidth/picHeight;
    double height=605,width=750;




    public void paint(Graphics g){

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);
        createEar(g2d);
        createhead(g2d);
        createPoloAndNeckTie(g2d);
        createToga(g2d);






    }

    public void createEar(Graphics2D g2d){
        GeneralPath leftEar = new GeneralPath();
        move(leftEar,306,280);
        quad(leftEar,289,283,289,270);
        quad(leftEar,290,258,286,247);
        quad(leftEar,286,235,282,227);
        quad(leftEar,280,217,283,206);
        quad(leftEar,283,198,291,198);
        line(leftEar,319,239);
        leftEar.closePath();


        GeneralPath rightEar = new GeneralPath();
        move(rightEar,506,208);
        quad(rightEar,529,208,529,218);
        quad(rightEar,533,225,530,235);
        quad(rightEar,527,245,524,252);
        quad(rightEar,523,261,518,272);
        line(rightEar,517,280);
        quad(rightEar,509,287,495,287);
        line(rightEar,474,253);
        rightEar.closePath();
         g2d.setColor(new Color(217,170,155));
         g2d.fill(leftEar);
         g2d.fill(rightEar);
    }


    public void createhead(Graphics2D g2d){


        GeneralPath hair = new GeneralPath();
        move(hair,297,241);
        quad(hair,295,220,289,202);
        quad(hair,288,166,295,130);
        quad(hair,294,143,295,130);
        quad(hair,291,113,318,82);
        quad(hair,331,58,360,46);
        quad(hair,413,30,431,48);
        quad(hair,473,48,508,91);
        quad(hair,517,101,517,128);
        quad(hair,530,164,519,208);
        quad(hair,508,215,499,271);

        g2d.setColor(Color.black);
        g2d.fill(hair);







        GeneralPath head = new GeneralPath();
        move(head,332,353);
        quad(head,330,331,319,316);
        quad(head,300,293,298,257);
        quad(head,295,234,297,203);
        quad(head,297,177,314,158);
        quad(head,313,138,324,130);
        quad(head,330,105,350,105);
        quad(head,397,98,452,107);
        quad(head,481,112,481,163);
        quad(head,502,178,502,227);
        quad(head,503,243,494,272);
        quad(head,502,244,493,268);
        line(head,498,290);
        quad(head,487,319,488,334);
        //
        line(head,483,533);
        line(head,315,499);
        head.closePath();
        g2d.setColor(new Color(217,170,155));
        g2d.fill(head);

    }

     public void createPoloAndNeckTie(Graphics2D g2d){
        GeneralPath poloPath = new GeneralPath();
        move(poloPath,332,353);
        quad(poloPath,337,371,356,397);
        quad(poloPath,370,416,373,418);
        line(poloPath,461,365);
        quad(poloPath,480,356,487,333);
        quad(poloPath,488,348,500,357);
        line(poloPath,500,500);
        line(poloPath,417,580);
        line(poloPath,212,582);
        line(poloPath,209,484);
        poloPath.closePath();

        GeneralPath neckTie = new GeneralPath();
        move(neckTie,318,522);
        line(neckTie,346,476);
        quad(neckTie,346,461,354,455);
        quad(neckTie,355,443,347,430);
        quad(neckTie,362,412,373,420);
        quad(neckTie,378,436,386,449);
        quad(neckTie,370,457,372,524);
        line(neckTie,316,575);
        neckTie.closePath();

        GeneralPath black = new GeneralPath();
        move(black,496,376);
        quad(black,500,362,494,350);
        quad(black,502,356,517,373);
        black.closePath();






        g2d.setColor(Color.WHITE);
        g2d.fill(poloPath);

        g2d.setColor(new Color(55, 55, 55));
        g2d.fill(neckTie);
        g2d.fill(black);

    }




    public void createToga(Graphics2D g2d){

        GeneralPath greyPath = new GeneralPath();
        move(greyPath,276,371);
        line(greyPath,289,363);
        line(greyPath,301,363);
        line(greyPath,311,353);
        line(greyPath,330,349);
        line(greyPath,330,359);
        quad(greyPath,324,369,326,384);
        line(greyPath,323,431);
        quad(greyPath,320,445,324,461);
        quad(greyPath,332,510,332,529);
        quad(greyPath,359,500,424,437);
        quad(greyPath,496,372,516,364);
        quad(greyPath,520,360,538,372);
        quad(greyPath,581,404,603,410);
        line(greyPath, 610,420);
        line(greyPath,322,601);
        line(greyPath,200,489);
        greyPath.closePath();





        GeneralPath redPath = new GeneralPath();
        //left shoulder
        move(redPath,199,406);
        quad(redPath,199,399,209,398);
        line(redPath,244,384);
        quad(redPath,260,381,277,370);
        //pababa
        quad(redPath,273,374,271,407);
        line(redPath,271,434);
        quad(redPath,271,453,288,495);
        line(redPath,312,551);
        line(redPath,322,562);//red midpoint
        quad(redPath,327,563,345,551);
        quad(redPath,397,529,461,488);
        line(redPath,517,447);
        quad(redPath,586,397,608,420);
        quad(redPath,623,433,644,447);
        quad(redPath,652,452,663,461);
        quad(redPath,688,477,689,509);
        line(redPath,317,605);
        line(redPath,149,570);
        redPath.closePath();






        GeneralPath blackPath = new GeneralPath();
        move(blackPath,65,604);
        line(blackPath,122,507);
        quad(blackPath,122,460,184,414);
        line(blackPath,190,413);
        quad(blackPath,194,407,198,407);
        quad(blackPath,220,510,317,591);
        quad(blackPath,338,593,371,578);
        line(blackPath,495,528);
        quad(blackPath,528,510,559,500);
        quad(blackPath,570,497,604,476);
        quad(blackPath,634,459,650,464);
        quad(blackPath,685,476,685,509);
        quad(blackPath,695,519,696,528);
        quad(blackPath,707,544,707,555);
        quad(blackPath,718,573,723,604);



        g2d.setColor(new Color(212,211,225));
        g2d.fill(greyPath);

        g2d.setColor(new Color(204,6,5));
        g2d.fill(redPath);

        g2d.setColor(new Color(26,25,30));
        g2d.draw(blackPath);
        g2d.fill(blackPath);




    }



    public void move(GeneralPath gp, double x, double y){
        gp.moveTo(getX(x),getY(y));
    }

    public void line(GeneralPath gp,double x, double y){
        gp.lineTo(getX(x),getY(y));
    }

    public void quad(GeneralPath gp, double x, double y, double x1, double y1){
        gp.quadTo(getX(x),getY(y),getX(x1),getY(y1));
    }

    public double getY(double y){
        return (height/picHeight)*y;
    }


    public double getX(double x){
        //the this.x is added pag nirerepaint.
        return  (width/picWidth)*x;
    }
     public Line2D.Double createLine(int x1, int y1, int x2, int y2) {
        return new Line2D.Double(getX(x1), getY(y1), getX(x2), getY(y2));
    }

    public CubicCurve2D.Double createCubicCurve(int x1, int y1, int cx1, int cy1, int cx2, int cy2, int x2, int y2) {
        return new CubicCurve2D.Double(getX(x1), getY(y1), getX(cx1), getY(cy1), getX(cx2), getY(cy2), getX(x2), getY(y2));
    }

    public QuadCurve2D createQuadCurve(double x1, double y1, double cx, double cy, double x2, double y2) {
        return new QuadCurve2D.Double(getX(x1), getY(y1), getX(cx), getY(cy), getX(x2), getY(y2));
    }


    public static void main(String args[]){
        SelfPortrait selfPortrait = new SelfPortrait();
        selfPortrait.setSize(746,604);
       // selfPortrait.setLocation(25,172);
       // selfPortrait.setUndecorated(true);
        selfPortrait.setBackground(new Color(137,136,142));
        selfPortrait.setVisible(true);
        selfPortrait.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

}
