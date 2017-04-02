import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by jude8 on 3/28/2017.
 */
public class FourWayTraffic extends JPanel implements ActionListener {

    double height = 400;
    double picHeight = 560;
    double picWidth = 906;
    double aspectratio = picWidth / picHeight;
    double width = height * aspectratio;


    Timer T = new Timer(50, this);

    //movement ng cars
    static int car1speed = 0;
    static int car2speed = 0;
    static int car3speed = 0;
    static int car4speed = 0;

    AffineTransform original;


   static  boolean northAndSouthGreen;
   static boolean northAndSouthYellow;
   static boolean northAndSouthRed;

   static  boolean eastAndWestGreen;
   static boolean eastAndWestYellow;
   static boolean eastAndWestRed;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Calendar time = Calendar.getInstance();
         original = ((Graphics2D) g).getTransform();

        //StopLight booleansou
        if (time.get(Calendar.SECOND)< 30) {
            northAndSouthGreen = true;
        } else {
            northAndSouthGreen = false;
        }
        if(time.get(Calendar.SECOND)>=30&time.get(Calendar.SECOND)<35){
            northAndSouthYellow = true;
        }else{
            northAndSouthYellow = false;
        }
        if(time.get(Calendar.SECOND)>=35){
            northAndSouthRed = true;
        }else{
            northAndSouthRed = false;
        }

        if (time.get(Calendar.SECOND)< 5) {
            eastAndWestYellow= true;
        } else {
            eastAndWestYellow = false;
        }
        if(time.get(Calendar.SECOND)>=5&time.get(Calendar.SECOND)<30){
            eastAndWestRed = true;
        }else{
            eastAndWestRed= false;
        }
        if(time.get(Calendar.SECOND)>=30){
            eastAndWestGreen = true;
        }else{
            eastAndWestGreen = false;
        }




        Graphics2D g2d = (Graphics2D) g;



        drawStreet(g2d);
        Graphics2D firstCarGraphics = (Graphics2D) g;
        AffineTransform scale = new AffineTransform();
        scale.setToScale(0.2, 0.2);
        scale.translate(car1speed, 1800);
        firstCarGraphics.setTransform(scale);

        createCar(firstCarGraphics);


        Graphics2D secondCarGraphics = (Graphics2D) g;
        AffineTransform secondCarRotationAndScaling = new AffineTransform();
        secondCarRotationAndScaling.setToScale(0.2, 0.2);
        secondCarRotationAndScaling.translate(1800
                , car2speed);
        secondCarRotationAndScaling.rotate(Math.toRadians(90));
        secondCarGraphics.setTransform(secondCarRotationAndScaling);


        createCar(secondCarGraphics);
        Graphics2D thirdCarGraphics = (Graphics2D) g;
        AffineTransform thirdCarRotationAndScaling = new AffineTransform();
        thirdCarRotationAndScaling.setToScale(-0.2, 0.2);
        thirdCarRotationAndScaling.translate(-3400 + car3speed, 1350);
        thirdCarGraphics.setTransform(thirdCarRotationAndScaling);

        createCar(thirdCarGraphics);
        //thirdCarGraphics


        Graphics2D fourthCarGraphics = (Graphics2D) g;
        AffineTransform fourthCarRotationAndScaling = new AffineTransform();
        fourthCarRotationAndScaling.setToScale(0.2, 0.2);
        fourthCarRotationAndScaling.translate(1900, 3400 - car4speed);
        fourthCarRotationAndScaling.rotate(Math.toRadians(-90));
        fourthCarGraphics.setTransform(fourthCarRotationAndScaling);

        createCar(fourthCarGraphics);

        g2d.setTransform(original);

        stoplight(g2d);

        T.start();

    }


    public void stoplight(Graphics2D g2d) {


        //squares
        g2d.setColor(Color.black);
        g2d.fillRect(300, 200, 100, 50);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillRect(300, 200, 100, 50);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillRect(300, 200, 100, 50);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillRect(300, 200, 100, 50);

        //yellow lights

        g2d.setTransform(original);
        g2d.setColor(Color.yellow);
        //north
         if(northAndSouthYellow)
            g2d.setColor(Color.yellow);
        else
            g2d.setColor(Color.gray);
        g2d.fillOval(335, 210, 30, 30);
        g2d.rotate(Math.toRadians(90), 350, 350);

        //east
        if(eastAndWestYellow)
            g2d.setColor(Color.yellow);
        else
            g2d.setColor(Color.gray);
        g2d.fillOval(335, 210, 30, 30);

        //south
        if(northAndSouthYellow)
            g2d.setColor(Color.yellow);
        else
            g2d.setColor(Color.gray);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(335, 210, 30, 30);
        g2d.rotate(Math.toRadians(90), 350, 350);
        //west
        if(eastAndWestYellow)
            g2d.setColor(Color.yellow);
        else
            g2d.setColor(Color.gray);
        g2d.fillOval(335, 210, 30, 30);
        g2d.rotate(Math.toRadians(90), 350, 350);

        //red lights
        g2d.setTransform(original);
       // g2d.setColor(Color.red);
        //north
         if(northAndSouthRed)
            g2d.setColor(Color.red);
        else
            g2d.setColor(Color.gray);
        g2d.fillOval(305, 210, 30, 30);

        //east
        if(eastAndWestRed)
            g2d.setColor(Color.red);
        else
            g2d.setColor(Color.gray);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(305, 210, 30, 30);
        //south
        if(northAndSouthRed)
            g2d.setColor(Color.red);
        else
            g2d.setColor(Color.gray);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(305, 210, 30, 30);
        //west
        if(eastAndWestRed)
            g2d.setColor(Color.red);
        else
            g2d.setColor(Color.gray);
        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(305, 210, 30, 30);
        g2d.rotate(Math.toRadians(90), 350, 350);

        //green lights
        g2d.setTransform(original);
        //north
        if(northAndSouthGreen)
            g2d.setColor(Color.green);
        else
            g2d.setColor(Color.gray);

        g2d.fillOval(365, 210, 30, 30);
        //east
        if(eastAndWestGreen)
            g2d.setColor(Color.green);
        else
            g2d.setColor(Color.gray);

        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(365, 210, 30, 30);

        //south
        if(northAndSouthGreen)
            g2d.setColor(Color.green);
        else
            g2d.setColor(Color.gray);

        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(365, 210, 30, 30);

        //west
        if(eastAndWestGreen)
            g2d.setColor(Color.green);
        else
            g2d.setColor(Color.gray);

        g2d.rotate(Math.toRadians(90), 350, 350);
        g2d.fillOval(365, 210, 30, 30);
        g2d.rotate(Math.toRadians(90), 350, 350);

    }


    public void drawStreet(Graphics g) {
        Graphics2D gd = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(1.5f);
        //gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setStroke(bs);

        GeneralPath cross = new GeneralPath();
        cross.moveTo(300, 300);
        cross.lineTo(300, 200);
        cross.quadTo(300, 160, 340, 160); //C
        cross.lineTo(360, 160); //D
        cross.quadTo(400, 160, 400, 200); //E
        cross.lineTo(400, 300); //F
        cross.lineTo(500, 300); //G
        cross.quadTo(540, 300, 540, 340);//H
        cross.lineTo(540, 360); //I
        cross.quadTo(540, 400, 500, 400);//J
        cross.lineTo(400, 400); //K
        cross.lineTo(400, 500); //L
        cross.quadTo(400, 540, 360, 540); //M
        cross.lineTo(340, 540); //N
        cross.quadTo(300, 540, 300, 500); //O
        cross.lineTo(300, 400); //P
        cross.lineTo(200, 400); //Q
        cross.quadTo(160, 400, 160, 360);
        cross.lineTo(160, 340);
        cross.quadTo(160, 300, 200, 300);
        cross.lineTo(300, 300);
        //gd.setPaint(Color.RED);
        //gd.fill(cross);

        Area street = new Area(cross);
        gd.setPaint(Color.gray);
        AffineTransform scale = new AffineTransform();
        scale.setToScale(2.4, 2.4);

        AffineTransform translate = new AffineTransform();
        translate.setToTranslation(-490, -485);
        gd.fill(translate.createTransformedShape(scale.createTransformedShape(street)));


        //STREET LINES
        Rectangle2D.Double s1 = new Rectangle2D.Double(340, 50, 10, 80);
        Rectangle2D.Double s2 = new Rectangle2D.Double(340, 250, 10, 80);
        Rectangle2D.Double s3 = new Rectangle2D.Double(340, 450, 10, 80);
        Rectangle2D.Double s4 = new Rectangle2D.Double(340, 650, 10, 80);

        Rectangle2D.Double s5 = new Rectangle2D.Double(10, 350, 80, 10);
        Rectangle2D.Double s6 = new Rectangle2D.Double(210, 350, 80, 10);
        Rectangle2D.Double s7 = new Rectangle2D.Double(410, 350, 80, 10);
        Rectangle2D.Double s8 = new Rectangle2D.Double(610, 350, 80, 10);

        gd.setColor(Color.yellow);
        gd.fill(s1);
        gd.fill(s2);
        gd.fill(s3);
        gd.fill(s4);
        gd.fill(s5);
        gd.fill(s6);
        gd.fill(s7);
        gd.fill(s8);

    }


    public void createCar(Graphics2D g2d) {
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


    public void createTires(Graphics2D g2d) {
        ArrayList<Ellipse2D.Double> tires = new ArrayList<>();
        tires.add(new Ellipse2D.Double(getX(118), getY(323), getY(504 - 320), getY(504 - 323)));
        tires.add(new Ellipse2D.Double(getX(587), getY(323), getY(504 - 320), getY(504 - 323)));

        g2d.setColor(Color.black);
        for (Ellipse2D wheel : tires) {
            g2d.fill(wheel);
            g2d.draw(wheel);
        }

    }

    public void createRims(Graphics2D g2d) {
        ArrayList<Ellipse2D.Double> rims = new ArrayList<>();
        rims.add(new Ellipse2D.Double(getX(157), getY(360), getY(462 - 359), getY(462 - 359)));
        rims.add(new Ellipse2D.Double(getX(625), getY(360), getY(462 - 359), getY(462 - 359)));
        g2d.setColor(new Color(210, 210, 210));
        for (Ellipse2D rim : rims) {
            g2d.fill(rim);
            g2d.draw(rim);
        }
    }

    public void createInnerRim(Graphics2D g2d) {
        double scale = getY(436 - 384);
        ArrayList<Ellipse2D.Double> innerRims = new ArrayList<>();
        innerRims.add(new Ellipse2D.Double(getX(182), getY(384), scale, scale));
        innerRims.add(new Ellipse2D.Double(getX(650), getY(384), scale, scale));

        for (Ellipse2D innerRim : innerRims) {
            g2d.setColor(new Color(49, 49, 49));
            g2d.fill(innerRim);
            g2d.setColor(Color.black);
            g2d.draw(innerRim);

        }

    }

    public void createChassis(Graphics2D g2d) {
        ArrayList<Shape> chassisLineAndCurves = new ArrayList<>();
        chassisLineAndCurves.add(createLine(111, 410, 35, 413));
        chassisLineAndCurves.add(createLine(35, 413, 42, 242));
        chassisLineAndCurves.add(createLine(42, 242, 167, 217));
        chassisLineAndCurves.add(createLine(167, 217, 278, 100));
        chassisLineAndCurves.add(createLine(278, 100, 579, 85));
        chassisLineAndCurves.add(createQuadCurve(579, 85, 596, 163, 638, 205));
        chassisLineAndCurves.add(createQuadCurve(638, 205, 713, 203, 830, 229));
        chassisLineAndCurves.add(createLine(830, 229, 844, 294));
        chassisLineAndCurves.add(createLine(844, 294, 840, 409));
        chassisLineAndCurves.add(createLine(840, 409, 779, 408));
        chassisLineAndCurves.add(createCubicCurve(779, 408, 731, 350, 611, 340, 581, 409));
        chassisLineAndCurves.add(createLine(581, 409, 310, 414));
        chassisLineAndCurves.add(createCubicCurve(310, 414, 320, 350, 100, 350, 111, 410));
        GeneralPath chassisPath = new GeneralPath();
        chassisPath.moveTo(getX(111), getY(410));
        for (Shape shape : chassisLineAndCurves) {
            chassisPath.append(shape, true);
        }
        g2d.setColor(new Color(21, 146, 20));
        g2d.fill(chassisPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(chassisPath);
    }

    public void createWindows(Graphics2D g2d) {
        ArrayList<Line2D.Double> backWindows = new ArrayList<>();
        backWindows.add(createLine(204, 211, 276, 123));
        backWindows.add(createLine(276, 123, 341, 119));
        backWindows.add(createLine(341, 119, 320, 209));
        backWindows.add(createLine(320, 209, 204, 211));
        GeneralPath backWindowPath = new GeneralPath();
        for (Shape shape : backWindows) {
            backWindowPath.append(shape, true);
        }


        ArrayList<Line2D.Double> frontWindows = new ArrayList<>();
        frontWindows.add(createLine(378, 116, 556, 107));
        frontWindows.add(createLine(556, 107, 586, 201));
        frontWindows.add(createLine(586, 201, 361, 205));
        frontWindows.add(createLine(361, 205, 378, 116));
        GeneralPath frontWindowPath = new GeneralPath();

        for (Shape shape : frontWindows) {
            frontWindowPath.append(shape, true);
        }


        ArrayList<Shape> sideMirrorHolder = new ArrayList<>();
        sideMirrorHolder.add(createLine(578, 209, 591, 220));
        sideMirrorHolder.add(createLine(591, 220, 577, 230));
        GeneralPath sideMirrorHolderPath = new GeneralPath();
        for (Shape shape : sideMirrorHolder) {
            //g2d.draw(shape);
            sideMirrorHolderPath.append(shape, true);
        }

        ArrayList<Shape> sideMirror = new ArrayList<>();
        sideMirror.add(createQuadCurve(565, 184, 570, 210, 564, 238));
        sideMirror.add(createQuadCurve(564, 238, 574, 236, 577, 227));
        sideMirror.add(createLine(577, 227, 578, 200));
        sideMirror.add(createQuadCurve(578, 200, 576, 188, 565, 184));
        GeneralPath sideMirrorPath = new GeneralPath();
        for (Shape shape : sideMirror) {
            sideMirrorPath.append(shape, true);
        }
        g2d.setColor(new Color(160, 160, 160));
        g2d.fill(backWindowPath);
        g2d.fill(frontWindowPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(frontWindowPath);
        g2d.setColor(new Color(112, 97, 100));
        g2d.fill(sideMirrorHolderPath);
        g2d.fill(sideMirrorPath);
        g2d.setColor(Color.BLACK);
        // g2d.draw(frontWindowPath);
        g2d.draw(backWindowPath);
        g2d.draw(sideMirrorHolderPath);
        g2d.draw(sideMirrorPath);
    }

    void createCarLights(Graphics2D g2d) {
        Rectangle2D brakeLight = createRect(30, 254, 20, 50);
        g2d.setColor(new Color(235, 49, 34));
        g2d.fill(brakeLight);
        g2d.setColor(Color.black);
        g2d.draw(brakeLight);

        ArrayList<Shape> headlights = new ArrayList<>();
        headlights.add(createQuadCurve(821, 240, 831, 236, 844, 237));
        headlights.add(createQuadCurve(844, 237, 855, 265, 853, 297));
        headlights.add(createQuadCurve(853, 297, 841, 316, 828, 302));
        headlights.add(createQuadCurve(828, 302, 834, 268, 821, 240));
        GeneralPath headlightPath = new GeneralPath();
        for (Shape shape : headlights) {
            headlightPath.append(shape, true);
        }
        g2d.setColor(new Color(255, 251, 170));
        g2d.fill(headlightPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(headlightPath);

        //antenna
        Line2D.Double antennaLine = createLine(686, 214, 672, 83);
        g2d.draw(antennaLine);

        Ellipse2D.Double antennaBall = new Ellipse2D.Double(getX(661), getY(66), getY(20), getY(20));
        g2d.setColor(new Color(103, 103, 103));
        g2d.fill(antennaBall);
        g2d.setColor(Color.black);
        g2d.draw(antennaBall);
    }

    public void createDoor(Graphics2D g2d) {

        ArrayList<Shape> doorOutline = new ArrayList<>();
        doorOutline.add(createLine(371, 110, 561, 100));
        doorOutline.add(createCubicCurve(561, 100, 590, 203, 595, 212, 627, 236));
        doorOutline.add(createQuadCurve(627, 236, 609, 317, 614, 354));
        doorOutline.add(createQuadCurve(614, 354, 583, 369, 575, 397));
        doorOutline.add(createLine(575, 397, 341, 401));
        doorOutline.add(createQuadCurve(341, 401, 337, 365, 305, 351));
        doorOutline.add(createLine(305, 351, 304, 246));
        doorOutline.add(createLine(304, 246, 344, 218));
        doorOutline.add(createLine(344, 218, 371, 110));
        g2d.setColor(new Color(4, 125, 10));
        for (Shape shape : doorOutline) {
            g2d.draw(shape);
        }


        ArrayList<Shape> doorHandle = new ArrayList<>();
        doorHandle.add(createLine(337, 258, 349, 259));
        doorHandle.add(createQuadCurve(349, 259, 377, 271, 406, 260));
        doorHandle.add(createQuadCurve(406, 260, 417, 254, 426, 261));
        doorHandle.add(createQuadCurve(426, 261, 425, 273, 422, 278));
        doorHandle.add(createLine(422, 278, 337, 278));
        doorHandle.add(createLine(337, 278, 337, 258));
        GeneralPath doorHandlePath = new GeneralPath();
        for (Shape shape : doorHandle) {
            doorHandlePath.append(shape, true);
        }
        g2d.setColor(new Color(99, 97, 108));
        g2d.fill(doorHandlePath);
        g2d.setColor(Color.BLACK);
        g2d.draw(doorHandlePath);

    }

    public void createGrillsAndBumpers(Graphics2D g2d) {

        ArrayList<Shape> frontBumper = new ArrayList<>();
        frontBumper.add(createQuadCurve(794, 395, 840, 393, 844, 387));
        frontBumper.add(createQuadCurve(844, 387, 849, 414, 842, 431));
        frontBumper.add(createLine(842, 431, 802, 431));
        frontBumper.add(createQuadCurve(802, 431, 782, 406, 794, 395));
        GeneralPath frontBumperPath = new GeneralPath();
        for (Shape shape : frontBumper) {
            frontBumperPath.append(shape, true);
        }


        ArrayList<Shape> middleBumper = new ArrayList<>();
        middleBumper.add(createQuadCurve(309, 411, 389, 406, 580, 410));
        middleBumper.add(createQuadCurve(580, 410, 583, 422, 579, 431));
        middleBumper.add(createQuadCurve(579, 431, 354, 428, 311, 436));
        middleBumper.add(createLine(311, 436, 309, 411));
        GeneralPath middleBumperPath = new GeneralPath();
        for (Shape shape : middleBumper) {
            middleBumperPath.append(shape, true);
        }

        ArrayList<Shape> muffler = new ArrayList<>();
        muffler.add(createLine(71, 413, 111, 410));
        muffler.add(createQuadCurve(111, 410, 119, 437, 112, 444));
        muffler.add(createQuadCurve(112, 444, 54, 445, 24, 452));
        muffler.add(createLine(24, 452, 18, 437));
        muffler.add(createLine(18, 437, 68, 434));
        muffler.add(createLine(68, 434, 71, 413));
        GeneralPath mufflerPath = new GeneralPath();
        for (Shape shape : muffler) {
            mufflerPath.append(shape, true);
        }

        ArrayList<Shape> backBumper = new ArrayList<>();
        backBumper.add(createLine(19, 388, 35, 389));
        backBumper.add(createLine(35, 389, 37, 401));
        backBumper.add(createLine(37, 401, 68, 401));
        backBumper.add(createQuadCurve(68, 401, 80, 415, 62, 431));
        backBumper.add(createLine(62, 431, 18, 435));
        backBumper.add(createQuadCurve(18, 435, 10, 418, 19, 388));
        GeneralPath backBumperPath = new GeneralPath();
        for (Shape shape : backBumper) {
            backBumperPath.append(shape, true);
        }


        ArrayList<Shape> grill = new ArrayList<>();
        grill.add(createLine(838, 307, 849, 307));
        grill.add(createQuadCurve(849, 307, 850, 378, 832, 395));
        grill.add(createQuadCurve(832, 393, 840, 355, 838, 307));
        GeneralPath grillPath = new GeneralPath();
        for (Shape shape : grill) {
            grillPath.append(shape, true);
        }

        g2d.setColor(new Color(153, 147, 153));
        g2d.fill(frontBumperPath);
        g2d.fill(middleBumperPath);
        g2d.fill(backBumperPath);

        g2d.setColor(new Color(209, 215, 211));
        g2d.fill(grillPath);
        g2d.fill(mufflerPath);

        g2d.setColor(Color.BLACK);
        g2d.draw(frontBumperPath);
        g2d.draw(middleBumperPath);
        g2d.draw(backBumperPath);

        g2d.draw(mufflerPath);

        g2d.setColor(new Color(209, 215, 211));
        g2d.fill(grillPath);
        g2d.setColor(Color.BLACK);
        g2d.draw(grillPath);


    }


    public double getY(double y) {
        return (height / picHeight) * y;
    }

    public double getX(double x) {
        return (width / picWidth) * x;
    }

    public Rectangle2D.Double createRect(int x, int y, int w, int h) {
        return new Rectangle2D.Double(getX(x), getY(y), getX(w), getY(h));
    }

    public Line2D.Double createLine(int x1, int y1, int x2, int y2) {
        return new Line2D.Double(getX(x1), getY(y1), getX(x2), getY(y2));
    }

    public CubicCurve2D.Double createCubicCurve(int x1, int y1, int cx1, int cy1, int cx2, int cy2, int x2, int y2) {
        return new CubicCurve2D.Double(getX(x1), getY(y1), getX(cx1), getY(cy1), getX(cx2), getY(cy2), getX(x2), getY(y2));
    }

    public QuadCurve2D createQuadCurve(int x1, int y1, int cx, int cy, int x2, int y2) {
        return new QuadCurve2D.Double(getX(x1), getY(y1), getX(cx), getY(cy), getX(x2), getY(y2));
    }


    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setBackground(Color.GREEN);
        frame.setMinimumSize(new Dimension(700, 700));
        FourWayTraffic traffic = new FourWayTraffic();
        traffic.setBackground(Color.green);
        frame.add(traffic);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }


    @Override
    public void actionPerformed(ActionEvent e) {



        // while (car1speed<3500){
        if (car1speed > 3500) car1speed = -500;
        if (car2speed > 3500) car2speed = -500;
        if (car3speed > 3500) car3speed = -500;
        if (car4speed > 3500) car4speed = -500;

        //car1speed += 10;
       // car3speed += 10;

        if((eastAndWestGreen)|((car1speed<500|car1speed>1000)&(eastAndWestRed|eastAndWestYellow))){
              car1speed += 50;
              System.out.println(car1speed);
        }else{
            car1speed+=0;
        }
        
        if((eastAndWestGreen)|((car3speed<500|car3speed>1000)&(eastAndWestRed|eastAndWestYellow))){
              car3speed += 50;
              System.out.println(car3speed);
        }else{
            car3speed+=0;
        }
        
        
        if((northAndSouthGreen)|((car4speed<500|car4speed>1000)&(northAndSouthRed|northAndSouthYellow))){
              car4speed += 50;
              System.out.println(car4speed);
        }else{
            car4speed+=0;
        }

        if((northAndSouthGreen)|((car2speed<500|car2speed>1000)&(northAndSouthRed|northAndSouthYellow))){
              car2speed += 50;
              System.out.println(car2speed);
        }else{
            car2speed+=0;
        }


        
        repaint();
        //}
    }
}
