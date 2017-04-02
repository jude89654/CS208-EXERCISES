
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class carracing_BISMONTE extends JPanel implements ActionListener {

    int count = 0;

    double height = 560;
    double picHeight = 560;
    double picWidth = 906;
    double aspectratio = picWidth/picHeight;
    double width = height*aspectratio;

    Timer timer = new Timer(10, this);

    static ArrayList<Integer[]> firstLinePoints = createPoints(74, 660, 248, 561);
    static ArrayList<Integer[]> secondLinePoints = createPoints(248, 561, 483, 561);
    static ArrayList<Integer[]> thirdLinePoints = createPoints(490,561, 550, 400);
    static ArrayList<Integer[]> fourthLinePoints = createPoints(500,350,253,121);
    static ArrayList<Integer[]> fifthLinePoints = createPoints(233,111,647,110);
    static ArrayList<Integer[]> sixthLinePoints = createPoints(700,110,700,630);
    static ArrayList<Integer[]> seventhLinePoints = createPoints(650,649,690,655);
    static ArrayList<Integer[]> eighthLinePoints = createPoints(720,655,1030,80);

    static Iterator<Integer[]> firstPathIterator = firstLinePoints.iterator();
    static Iterator<Integer[]> secondPathIterator = secondLinePoints.iterator();
    static Iterator<Integer[]> thirdPathIterator = thirdLinePoints.iterator();
    static Iterator<Integer[]> fourthPathIterator = fourthLinePoints.iterator();
    static Iterator<Integer[]> fifthPathIterator = fifthLinePoints.iterator();
    static Iterator<Integer[]> sixthPathIterator = sixthLinePoints.iterator();
    static Iterator<Integer[]> seventhPathIterator = seventhLinePoints.iterator();
    static Iterator<Integer[]> eighthPathIterator = eighthLinePoints.iterator();
    static double angle;

    double scalex=1,scaley=1;
    Integer[] points;
    public void actionPerformed(ActionEvent e) {
      if(firstPathIterator.hasNext()){
           angle =-30*Math.PI/180;// hindi pa to
           points=firstPathIterator.next();
           x = points[0];
           y = points[1];
       }else if(secondPathIterator.hasNext()){
           angle =0;//hindi pa to
           points=secondPathIterator.next();
           x = points[0];
           y = points[1];
       } else if(thirdPathIterator.hasNext()){
           angle = Math.toRadians(-70);
           points = thirdPathIterator.next();
           x=points[0];
           y=points[1];
       }else  if(fourthPathIterator.hasNext()){
           angle = Math.toRadians(30);
           scalex=-1;
           points = fourthPathIterator.next();
           x=points[0];
           y=points[1];
       }else if(fifthPathIterator.hasNext()){
           angle = 0;
           scalex=1;
           points = fifthPathIterator.next();
           x=points[0];
           y=points[1];
       }else if(sixthPathIterator.hasNext()){
           angle = 90*Math.PI/180;
           points = sixthPathIterator.next();
           x=points[0];
           y=points[1];
       }else  if(seventhPathIterator.hasNext()){
           angle = 0;
           points = seventhPathIterator.next();
           x=points[0];
           y=points[1];
       }else if(eighthPathIterator.hasNext()){
           angle = Math.toRadians(-60);
           scalex=0.5;
           scaley=0.5;
           points = eighthPathIterator.next();
           x=points[0];
           y=points[1];
       }

       repaint();
    }

    static int x, y;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(10.0f);
        g2d.setStroke(bs);
        g2d.setFont(new Font("Arial", Font.BOLD, 15));
        g2d.drawString("Start Here", 60, 650);
        g2d.drawString("Finish Line", 1060, 80);
        AffineTransform original = ((Graphics2D) g).getTransform();

        GeneralPath a = new GeneralPath();
        a.moveTo(50, 600);
        a.lineTo(250, 500);
        a.lineTo(450, 500);
        a.lineTo(480, 350);
        a.lineTo(50, 50);
        a.lineTo(700, 50);
        a.lineTo(710, 600);
        a.lineTo(1000, 60);
        g2d.setPaint(Color.black);
        g2d.draw(a);

        GeneralPath b = new GeneralPath();
        b.moveTo(70, 700);
        b.lineTo(270, 600);
        b.lineTo(520, 600);
        b.lineTo(600, 330);
        b.lineTo(350, 150);
        b.lineTo(620, 150);
        b.lineTo(620, 680);
        b.lineTo(720, 680);
        b.lineTo(1050, 80);
        g2d.setPaint(Color.black);
        g2d.draw(b);
        BasicStroke bs2 = new BasicStroke(1.0f);
        g2d.setStroke(bs2);
        sub(g2d, 0.08*scalex, 0.08*scaley,x,y , 1, 1, angle);

        timer.start();
    }

    public void sub(Graphics2D g2d, double scx, double scy, int tx, int ty, int sx, int sy, double angle) {

         g2d.translate((int) (tx-((width)*scx)/2),(ty-((height)*scy)/2));
        g2d.rotate(angle);
        g2d.scale(scx,scy);

       createCar(g2d);

    }

    public void createCar(Graphics2D g2d){
        createTires(g2d);
        createRims(g2d);
        createInnerRim(g2d);

        //Chassis clockwise
        createChassis(g2d);

        //windows and sideMirror
        createWindows(g2d);

        //lights and antenna
        createCarLights(g2d);

        //door
        createDoor(g2d);

        //grills and bumpers
        createGrillsAndBumpers(g2d);

    }



    public void createTires(Graphics2D g2d){
        ArrayList<Ellipse2D.Double> tires = new ArrayList<>();
        tires.add(new Ellipse2D.Double(getX(118), getY(323), getY(504-320), getY(504-323)));
        tires.add(new Ellipse2D.Double(getX(587), getY(323), getY(504-320), getY(504-323)));

        g2d.setColor(Color.black);
        for(Ellipse2D wheel: tires){
            g2d.fill(wheel);
            g2d.draw(wheel);
        }

    }

    public void createRims(Graphics2D g2d){
        ArrayList<Ellipse2D.Double> rims = new ArrayList<>();
        rims.add(new Ellipse2D.Double(getX(157), getY(360), getY(462-359), getY(462-359)));
        rims.add(new Ellipse2D.Double(getX(625), getY(360), getY(462-359), getY(462-359)));
        g2d.setColor(new Color(210,210,210));
        for(Ellipse2D rim: rims){
            g2d.fill(rim);
            g2d.draw(rim);
        }
    }

    public void createInnerRim(Graphics2D g2d){
        double scale = getY(436-384);
        ArrayList<Ellipse2D.Double> innerRims = new ArrayList<>();
        innerRims.add(new Ellipse2D.Double(getX(182), getY(384),scale,scale));
        innerRims.add(new Ellipse2D.Double(getX(650), getY(384),scale,scale));

        for(Ellipse2D innerRim:innerRims){
            g2d.setColor(new Color(49,49,49));
            g2d.fill(innerRim);
            g2d.setColor(Color.black);
            g2d.draw(innerRim);

        }

    }

    public void createChassis(Graphics2D g2d){
        ArrayList<Shape> chassisLineAndCurves = new ArrayList<>();
        chassisLineAndCurves.add(createLine(111,410,35,413));
        chassisLineAndCurves.add(createLine(35,413,42,242));
        chassisLineAndCurves.add(createLine(42,242,167,217));
        chassisLineAndCurves.add(createLine(167,217,278,100));
        chassisLineAndCurves.add(createLine(278,100,579,85));
        chassisLineAndCurves.add(createQuadCurve(579,85,596,163,638,205));
        chassisLineAndCurves.add(createQuadCurve(638,205,713,203,830,229));
        chassisLineAndCurves.add(createLine(830,229,844,294));
        chassisLineAndCurves.add(createLine(844,294,840,409));
        chassisLineAndCurves.add(createLine(840,409,779,408));
        chassisLineAndCurves.add(createCubicCurve(779,408,731,350,611,340,581,409));
        chassisLineAndCurves.add(createLine(581,409,310,414));
        chassisLineAndCurves.add(createCubicCurve(310,414,320,350,100,350,111,410));
        GeneralPath chassisPath = new GeneralPath();
        chassisPath.moveTo(getX(111),getY(410));
        for (Shape shape :chassisLineAndCurves){
            chassisPath.append(shape,true);
        }
        g2d.setColor(new Color(21,146,20));
        g2d.fill(chassisPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(chassisPath);
    }

    public void createWindows(Graphics2D g2d){
        ArrayList<Line2D.Double> backWindows = new ArrayList<>();
        backWindows.add(createLine(204,211,276,123));
        backWindows.add(createLine(276,123,341,119));
        backWindows.add(createLine(341,119,320,209));
        backWindows.add(createLine(320,209,204,211));
        GeneralPath backWindowPath = new GeneralPath();
        for (Shape shape :backWindows){
            backWindowPath.append(shape,true);
        }


        ArrayList<Line2D.Double> frontWindows= new ArrayList<>();
        frontWindows.add(createLine(378,116,556,107));
        frontWindows.add(createLine(556,107,586,201));
        frontWindows.add(createLine(586,201,361,205));
        frontWindows.add(createLine(361,205,378,116));
        GeneralPath frontWindowPath = new GeneralPath();

        for (Shape shape :frontWindows){
            frontWindowPath.append(shape,true);
        }





        ArrayList<Shape> sideMirrorHolder = new ArrayList<>();
        sideMirrorHolder.add(createLine(578,209,591,220));
        sideMirrorHolder.add(createLine(591,220,577,230));
        GeneralPath sideMirrorHolderPath = new GeneralPath();
        for (Shape shape :sideMirrorHolder){
            //g2d.draw(shape);
            sideMirrorHolderPath.append(shape,true);
        }

        ArrayList<Shape> sideMirror = new ArrayList<>();
        sideMirror.add(createQuadCurve(565,184,570,210,564,238));
        sideMirror.add(createQuadCurve(564,238,574,236,577,227));
        sideMirror.add(createLine(577,227,578,200));
        sideMirror.add(createQuadCurve(578,200,576,188,565,184));
        GeneralPath sideMirrorPath = new GeneralPath();
        for (Shape shape :sideMirror){
            sideMirrorPath.append(shape,true);
        }
        g2d.setColor(new Color(160,160,160));
        g2d.fill(backWindowPath);
        g2d.fill(frontWindowPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(frontWindowPath);
        g2d.setColor(new Color(112,97,100));
        g2d.fill(sideMirrorHolderPath);
        g2d.fill(sideMirrorPath);
        g2d.setColor(Color.BLACK);
       // g2d.draw(frontWindowPath);
        g2d.draw(backWindowPath);
        g2d.draw(sideMirrorHolderPath);
        g2d.draw(sideMirrorPath);
    }

    void createCarLights(Graphics2D g2d){
        Rectangle2D brakeLight = createRect(30,254,20,50);
        g2d.setColor(new Color(235,49,34));
        g2d.fill(brakeLight);
        g2d.setColor(Color.black);
        g2d.draw(brakeLight);

        ArrayList<Shape> headlights = new ArrayList<>();
        headlights.add(createQuadCurve(821,240,831,236,844,237));
        headlights.add(createQuadCurve(844,237,855,265,853,297));
        headlights.add(createQuadCurve(853,297,841,316,828,302));
        headlights.add(createQuadCurve(828,302,834,268,821,240));
        GeneralPath headlightPath = new GeneralPath();
        for(Shape shape : headlights) {
           headlightPath.append(shape,true);
        }
        g2d.setColor(new Color(255,251,170));
        g2d.fill(headlightPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(headlightPath);

        //antenna
        Line2D.Double antennaLine = createLine(686,214,672,83);
        g2d.draw(antennaLine);

        Ellipse2D.Double antennaBall = new Ellipse2D.Double(getX(661),getY(66),getY(20),getY(20));
        g2d.setColor(new Color(103,103,103));
        g2d.fill(antennaBall);
        g2d.setColor(Color.black);
        g2d.draw(antennaBall);
    }

    public void createDoor(Graphics2D g2d){

        ArrayList<Shape> doorOutline = new ArrayList<>();
        doorOutline.add(createLine(371,110,561,100));
        doorOutline.add(createCubicCurve(561,100,590,203,595,212,627,236));
        doorOutline.add(createQuadCurve(627,236,609,317,614,354));
        doorOutline.add(createQuadCurve(614,354,583,369,575,397));
        doorOutline.add(createLine(575,397,341,401));
        doorOutline.add(createQuadCurve(341,401,337,365,305,351));
        doorOutline.add(createLine(305,351,304,246));
        doorOutline.add(createLine(304,246,344,218));
        doorOutline.add(createLine(344,218,371,110));
        g2d.setColor(new Color(4,125,10));
        for(Shape shape:doorOutline){
            g2d.draw(shape);
        }


        ArrayList<Shape> doorHandle = new ArrayList<>();
        doorHandle.add(createLine(337,258,349,259));
        doorHandle.add(createQuadCurve(349,259,377,271,406,260));
        doorHandle.add(createQuadCurve(406,260,417,254,426,261));
        doorHandle.add(createQuadCurve(426,261,425,273,422,278));
        doorHandle.add(createLine(422,278,337,278));
        doorHandle.add(createLine(337,278,337,258));
        GeneralPath doorHandlePath = new GeneralPath();
        for(Shape shape:doorHandle){
            doorHandlePath.append(shape,true);
        }
        g2d.setColor(new Color(99,97,108));
        g2d.fill(doorHandlePath);
        g2d.setColor(Color.BLACK);
        g2d.draw(doorHandlePath);

    }

    public void createGrillsAndBumpers(Graphics2D g2d){

        ArrayList<Shape> frontBumper = new ArrayList<>();
        frontBumper.add(createQuadCurve(794,395,840,393,844,387));
        frontBumper.add(createQuadCurve(844,387,849,414,842,431));
        frontBumper.add(createLine(842,431,802,431));
        frontBumper.add(createQuadCurve(802,431,782,406,794,395));
        GeneralPath frontBumperPath = new GeneralPath();
        for(Shape shape:frontBumper){
            frontBumperPath.append(shape,true);
        }


        ArrayList<Shape> middleBumper = new ArrayList<>();
        middleBumper.add(createQuadCurve(309,411,389,406,580,410));
        middleBumper.add(createQuadCurve(580,410,583,422,579,431));
        middleBumper.add(createQuadCurve(579,431,354,428,311,436));
        middleBumper.add(createLine(311,436,309,411));
        GeneralPath middleBumperPath = new GeneralPath();
        for(Shape shape:middleBumper){
            middleBumperPath.append(shape,true);
        }

        ArrayList<Shape> muffler = new ArrayList<>();
        muffler.add(createLine(71,413,111,410));
        muffler.add(createQuadCurve(111,410,119,437,112,444));
        muffler.add(createQuadCurve(112,444,54,445,24,452));
        muffler.add(createLine(24,452,18,437));
        muffler.add(createLine(18,437,68,434));
        muffler.add(createLine(68,434,71,413));
        GeneralPath mufflerPath = new GeneralPath();
         for(Shape shape:muffler){
             mufflerPath.append(shape,true);
         }

        ArrayList<Shape> backBumper = new ArrayList<>();
        backBumper.add(createLine(19,388,35,389));
        backBumper.add(createLine(35,389,37,401));
        backBumper.add(createLine(37,401,68,401));
        backBumper.add(createQuadCurve(68,401,80,415,62,431));
        backBumper.add(createLine(62,431,18,435));
        backBumper.add(createQuadCurve(18,435,10,418,19,388));
        GeneralPath backBumperPath = new GeneralPath();
        for(Shape shape:backBumper){
            backBumperPath.append(shape,true);
        }



        ArrayList<Shape> grill = new ArrayList<>();
        grill.add(createLine(838,307,849,307));
        grill.add(createQuadCurve(849,307,850,378,832,395));
        grill.add(createQuadCurve(832,393,840,355,838,307));
        GeneralPath grillPath = new GeneralPath();
        for(Shape shape: grill){
            grillPath.append(shape,true);
        }

        g2d.setColor(new Color(153,147,153));
        g2d.fill(frontBumperPath);
        g2d.fill(middleBumperPath);
        g2d.fill(backBumperPath);

        g2d.setColor(new Color(209,215,211));
        g2d.fill(grillPath);
        g2d.fill(mufflerPath);

        g2d.setColor(Color.BLACK);
        g2d.draw(frontBumperPath);
        g2d.draw(middleBumperPath);
        g2d.draw(backBumperPath);

        g2d.draw(mufflerPath);

        g2d.setColor(new Color(209,215,211));
        g2d.fill(grillPath);
        g2d.setColor(Color.BLACK);
         g2d.draw(grillPath);




    }


    public double getY(double y){
        return (height/picHeight)*y;
    }
    public double getX(double x){
        return (width/picWidth)*x;
    }

    public Rectangle2D.Double createRect(int x, int y, int w, int h){
        return new Rectangle2D.Double(getX(x),getY(y),getX(w),getY(h));
    }

    public Line2D.Double createLine(int x1, int y1, int x2, int y2){
        return new Line2D.Double(getX(x1),getY(y1),getX(x2),getY(y2));
    }
    public CubicCurve2D.Double createCubicCurve(int x1,int y1, int cx1,int cy1,int cx2,int cy2,int x2, int y2){
        return new CubicCurve2D.Double(getX(x1),getY(y1),getX(cx1),getY(cy1),getX(cx2),getY(cy2),getX(x2),getY(y2));
    }
    public QuadCurve2D createQuadCurve(int x1, int y1, int cx, int cy,int x2,int y2){
       return new QuadCurve2D.Double(getX(x1),getY(y1),getX(cx),getY(cy),getX(x2),getY(y2));
    }

    public static ArrayList<Integer[]> createPoints(int x1, int y1, int x2, int y2) {
        double dx, dy, xc, yc, steps, x, y;

        ArrayList<Integer[]> points = new ArrayList<>();
        dx = x2 - x1;
        dy = y2 - y1;
        if (Math.abs(dx) > Math.abs(dy)) {
            steps = Math.abs(dx);
        } else {
            steps = Math.abs(dy);
        }
        xc = (dx / steps);
        yc = (dy / steps);
        x = x1;
        y = y1;
        for (int k = 1; k <= steps; k++) {
            x = x + xc;
            y = y + yc;

            points.add(new Integer[]{(int) x, (int) y});

        }

        return points;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        carracing_BISMONTE s = new carracing_BISMONTE();
        frame.setTitle("String in Java");
        //s.setBackground(Color.MAGENTA);
        //s.setMinimumSize(new Dimension(1300, 700));
        frame.add(s);
        frame.pack();
        frame.setMinimumSize(new Dimension(1300, 700));

        //s.setForeground(Color.blue);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });

    }
}
