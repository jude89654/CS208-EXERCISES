package Transportation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * Created by jude8 on 2/7/2017.
 */
public class transpover2moving extends JPanel implements ActionListener {


    //timer that will trigger the ActionEvent in this
    Timer t = new Timer(10, this);


    /**
     * starting pixel of the car
     */
    int x = 0, y = 0;
    /**
     * number of pixels will move from x every repaint
     */
    int xspeed = 2;


    /**
     * resolution of the original image
     */

    double picHeight = 560, picWidth = 960;

    /**
     * aspect ratio of the original image
     */
    double aspectratio = picWidth / picHeight;

    /**
     * size of the panel adjusted by the height
     */
    double height = 400, width = height * aspectratio;

    /**
     * Method to run after triggering the Timer
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        //if the object reaches the width, negate the speed
        if (x >= width*(2) | x < -(width)) xspeed = -xspeed;
        //move the original x by the xspeed
        x += xspeed;

        //draw the next frame
        repaint();
    }

    transpover2moving() {
        setSize((int) width, (int) height);
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        //para magmukhang nagaalog yung sasakyan
        y = (int) (Math.random() * 3);

        Graphics2D g2d = (Graphics2D) g;
        BasicStroke stroke = new BasicStroke(2f);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(stroke);

        //TIRES & rims
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

        //action to start the timer
        t.start();

    }


    public void createTires(Graphics2D g2d) {
        ArrayList<Ellipse2D> tires = new ArrayList<>();
        tires.add(createEllipse(118, 323, 504 - 320, 504 - 320));
        tires.add(createEllipse(587, 323, 504 - 320, 504 - 320));

        g2d.setColor(Color.black);
        for (Ellipse2D wheel : tires) {
            g2d.fill(wheel);
            g2d.draw(wheel);
        }

    }

    public void createRims(Graphics2D g2d) {
        ArrayList<Ellipse2D> rims = new ArrayList<>();
        rims.add(createEllipse(157, 360, 462 - 359, 462 - 359));
        rims.add(createEllipse(625, 360, 462 - 359, 462 - 359));

        g2d.setColor(new Color(210, 210, 210));
        for (Ellipse2D rim : rims) {
            g2d.fill(rim);
            g2d.draw(rim);
        }
    }

    public void createInnerRim(Graphics2D g2d) {
        int scale = 436 - 384;
        ArrayList<Ellipse2D> innerRims = new ArrayList<>();
        innerRims.add(createEllipse(182, 384, scale, scale));
        innerRims.add(createEllipse(650, 384, scale, scale));

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

        Ellipse2D antennaBall = createEllipse(661, 66, 20, 20);
        ///new Ellipse2D.Double(getX(661),getY(66),getX(20),getY(20));
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
        return (height / picHeight) * y + this.y;
    }


    public double getX(double x) {
        //the this.x is added pag nirerepaint.
        if (xspeed < 0) {
            return width + (this.x - (((width / picWidth) * x)));
        }
        return this.x + (width / picWidth) * x;

    }

    public Rectangle2D.Double createRect(int x, int y, int w, int h) {

        if (xspeed < 0)
            return new Rectangle2D.Double((getX(x) - getY(w)), getY(y), getY((w * (width / picWidth))), getY((h * (width / picWidth))));
        return new Rectangle2D.Double(getX(x), getY(y), getY((w * (width / picWidth))), getY((h * (width / picWidth))));
    }

    public Ellipse2D createEllipse(int x, int y, int w, int h) {
        if (xspeed < 0)
            return new Ellipse2D.Double(getX(x) - getY((w)), getY(y), getY(w), getY(h));
        return new Ellipse2D.Double(getX(x), getY(y), getY(w), getY(h));
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


    public static void main(String args[]) {

        JFrame jframe = new JFrame();
        transpover2moving frame = new transpover2moving();
        jframe.setMinimumSize(new Dimension(frame.getWidth() * 2, frame.getHeight()));
        jframe.add(frame);
        jframe.pack();
        jframe.setVisible(true);
        jframe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });


    }


}
