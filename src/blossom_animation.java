import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class blossom_animation extends JPanel implements ActionListener {
    double picHeight = 480;
    double picWidth = 480;
    double height = 480;
    double aspectratio = picWidth / picHeight;
    double width = height * aspectratio;
    static double angle;
    static int x, y;
    static double scx = 0.1, scy = 0.1;
    Area first, second, third, fourth, fifth;
    static float firstHeartSize = 0;
    static float secondHeartSize = 0;
    static float thirdHeartSize = 0;
    int cx = 512 / 2;
    int cy = 230;

    int count1 = 1;
    Timer timer = new Timer(10, this);
    long start = System.nanoTime();

    @Override
    public void actionPerformed(ActionEvent e) {
        // firstHeartSize +=.1;
        if (firstHeartSize > 7) {
            firstHeartSize =0.1f;
            System.out.println(System.nanoTime() - start );
        } else {
            firstHeartSize += .03;
        }

        if (System.nanoTime() - start > (long)(2851718126.0*(1/3))) {
            if (secondHeartSize > 7) {
                secondHeartSize = .00001f;
            } else {
                secondHeartSize += .03;
            }
        }

        if (System.nanoTime() - start >(long)(2851718126.0*2/3)) {
            if (thirdHeartSize > 7) {
                thirdHeartSize = 0.000000000000000000000001f;
            } else {
                thirdHeartSize += .03;
            }
        }
        //if(firstHeartSize>4) secondHeartSize+=.1;
       // System.out.println("HEART SIZE" + firstHeartSize);
        repaint();
    }


    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        AffineTransform original = ((Graphics2D) g).getTransform();
        BasicStroke bs = new BasicStroke(2f);
        g2d.translate(0, -30);

      //  void[]{}

        firstheart(g2d,firstHeartSize);


        if(firstHeartSize>secondHeartSize&secondHeartSize>thirdHeartSize) {
            firstheart(g2d,firstHeartSize);
            secondheart(g2d, secondHeartSize);
            thirdheart(g2d,thirdHeartSize);
        }

         else if(secondHeartSize>thirdHeartSize&thirdHeartSize>firstHeartSize) {
            secondheart(g2d, secondHeartSize);
            thirdheart(g2d,thirdHeartSize);
            firstheart(g2d,firstHeartSize);
        }
        else if(secondHeartSize>firstHeartSize&firstHeartSize>thirdHeartSize) {
            secondheart(g2d, secondHeartSize);
            firstheart(g2d,firstHeartSize);
            thirdheart(g2d,thirdHeartSize);

        }
        else if(thirdHeartSize>firstHeartSize&firstHeartSize>secondHeartSize) {

            thirdheart(g2d,thirdHeartSize);
            firstheart(g2d,firstHeartSize);
            secondheart(g2d, secondHeartSize);
        }
        else if(firstHeartSize>thirdHeartSize&thirdHeartSize>secondHeartSize) {

            firstheart(g2d,firstHeartSize);
            thirdheart(g2d,thirdHeartSize);
            secondheart(g2d, secondHeartSize);
        }else if(thirdHeartSize>secondHeartSize&secondHeartSize>firstHeartSize) {

            thirdheart(g2d,thirdHeartSize);

            secondheart(g2d, secondHeartSize);
             firstheart(g2d,firstHeartSize);
        }

//        thirdheart(g2d,thirdHeartSize);



        g2d.transform(original);

        createChar(g2d);


        //background((Graphics2D) g, scx, scy, x, y, 1, 1, angle);


       // System.out.print("REPAINTED");
        timer.start();
        // System.out.print("REPAINTED");
    }

    public void createChar(Graphics g) {
        g.translate(50, 0);
        faceFill(g);
        Ears(g);
        backHair(g);
        feet(g);
        bodyAndClothes(g);
        Hands(g);
        Eyes(g);
        hair(g);
        Mouth(g);
        faceOutline(g);
    }

    Area sample;

    public void background(Graphics2D g2d, double scx, double scy, int tx, int ty, int sx, int sy, double angle) {
        AffineTransform scaleHeart = new AffineTransform();
        scaleHeart.setToScale(scx + (tx / 10), scy + (ty / 10));
        sample = new Area(scaleHeart.createTransformedShape(first));
        g2d.fill(sample);
    }

    public void firstheart(Graphics g, double heartsize) {
        Graphics2D gd = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(3f); //for drawing
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setStroke(bs);

        GeneralPath heart1 = new GeneralPath();
        heart1.moveTo(231, 143);
        heart1.curveTo(304, 36, 406, 92, 426, 143);
        heart1.curveTo(466, 243, 419, 311, 331, 391);
        heart1.curveTo(299, 417, 264, 443, 232, 465);
        heart1.curveTo(182, 435, 135, 396, 93, 354);
        heart1.curveTo(34, 286, 0, 205, 40, 137);
        heart1.curveTo(92, 44, 197, 86, 231, 143);


        //Iterator<Shape> path= heart1.getPathIterator();
        Color heartOne = new Color(254, 24, 4);
        gd.setColor(heartOne);
        first = new Area(heart1);

        AffineTransform scale = new AffineTransform();
        scale.translate(cx - ((first.getBounds().getWidth() * heartsize) / 2), cy - ((first.getBounds().getHeight() * heartsize) / 2));
        scale.scale(heartsize, heartsize);


        gd.fill(scale.createTransformedShape(first));
    }

    public void secondheart(Graphics g, double heartsize) {
        Graphics2D gd = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(3f); //for drawing
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setStroke(bs);


        //Iterator<Shape> path= heart1.getPathIterator();
        Color heartOne = new Color(255, 187, 212);
        gd.setColor(heartOne);


        AffineTransform scale = new AffineTransform();
        scale.translate(cx - ((first.getBounds().getWidth() * heartsize) / 2), cy - ((first.getBounds().getHeight() * heartsize) / 2));
        scale.scale(heartsize, heartsize);


        gd.fill(scale.createTransformedShape(first));
    }

    public void thirdheart(Graphics g, double heartsize) {
        Graphics2D gd = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(3f); //for drawing
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setStroke(bs);


        //Iterator<Shape> path= heart1.getPathIterator();
        Color heartOne = new Color(255, 112, 116);
        gd.setColor(heartOne);


        AffineTransform scale = new AffineTransform();
        scale.translate(cx - ((first.getBounds().getWidth() * heartsize) / 2), cy - ((first.getBounds().getHeight() * heartsize) / 2));
        scale.scale(heartsize, heartsize);


        gd.fill(scale.createTransformedShape(first));
    }

    public void Ears(Graphics g) {
        Graphics2D g1d = (Graphics2D) g;
        BasicStroke bs1 = new BasicStroke(4f); //for drawing
        g1d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g1d.setStroke(bs1);

        ArrayList<Shape> LEar = new ArrayList<>();
        LEar.add(createCubicCurve(161, 158, 150, 113, 190, 60, 263, 52));
        LEar.add(createCubicCurve(263, 52, 262, 88, 221, 145, 199, 151));
        LEar.add(createLine(199, 151, 161, 158));
        GeneralPath leftEar = new GeneralPath();
        for (Shape shape : LEar) {
            leftEar.append(shape, true);
        }

       /* GeneralPath leftEar=new GeneralPath();
        leftEar.moveTo(161, 158);
        leftEar.curveTo(150, 113, 190, 60, 263, 52);
        leftEar.curveTo(262, 88, 221, 145, 199, 151);
        leftEar.lineTo(161, 158);*/

        Color redLeftEar = new Color(216, 46, 57);
        g1d.setColor(redLeftEar);
        g1d.fill(leftEar);
        g1d.setColor(Color.black);
        g1d.draw(leftEar);

        ArrayList<Shape> bow = new ArrayList<>();
        bow.add(createCubicCurve(195, 151, 196, 145, 197, 137, 203, 134));
        bow.add(createCubicCurve(203, 134, 217, 133, 242, 134, 245, 138));
        bow.add(createCubicCurve(245, 138, 241, 143, 241, 148, 240, 155));
        bow.add(createLine(240, 155, 195, 151));
        GeneralPath centerBow = new GeneralPath();
        for (Shape shape : bow) {
            centerBow.append(shape, true);
        }

       /* GeneralPath centerBow=new GeneralPath();
        centerBow.moveTo(195,151);
        centerBow.curveTo(196, 145, 197, 137, 203, 134);
        centerBow.curveTo(217, 133, 242, 134, 245, 138);
        centerBow.curveTo(241, 143, 241, 148, 240, 155);
        centerBow.lineTo(195, 151);*/

        Color RedcenterBow = new Color(216, 46, 57);
        g1d.setColor(RedcenterBow);
        g1d.fill(centerBow);
        g1d.setPaint(Color.BLACK);
        g1d.draw(centerBow);


        ArrayList<Shape> right = new ArrayList<>();
        right.add(createCubicCurve(240, 155, 241, 128, 277, 67, 371, 72));
        right.add(createCubicCurve(371, 72, 360, 129, 310, 175, 291, 180));
        right.add(createCubicCurve(291, 180, 284, 173, 268, 159, 240, 155));
        GeneralPath RightEar = new GeneralPath();
        for (Shape shape : right) {
            RightEar.append(shape, true);
        }

        /*GeneralPath RightEar=new GeneralPath();
        RightEar.moveTo(240,155);
        RightEar.curveTo(241, 128, 277, 67, 371, 72);
        RightEar.curveTo(360, 129, 310, 175, 291, 180);
        RightEar.curveTo(284, 173, 268, 159, 240, 155);*/

        Color RedRightEar = new Color(216, 46, 57);
        g1d.setColor(RedRightEar);
        g1d.fill(RightEar);
        g1d.setPaint(Color.BLACK);
        g1d.draw(RightEar);

    }

    public void hair(Graphics g) {
        //hair
        Graphics2D g4d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(4f); //for drawing
        g4d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g4d.setStroke(bs);

        GeneralPath hairFill = new GeneralPath();
        hairFill.moveTo(114, 200);
        hairFill.quadTo(116, 200, 120, 199);
        hairFill.quadTo(127, 198, 129, 198);
        hairFill.quadTo(135, 197, 138, 196);
        hairFill.quadTo(144, 196, 147, 195);
        hairFill.quadTo(153, 195, 156, 194);
        hairFill.quadTo(159, 194, 160, 194);
        hairFill.quadTo(163, 193, 165, 193);

        hairFill.curveTo(168, 190, 169, 187, 172, 185);
        hairFill.curveTo(174, 183, 177, 180, 179, 178);
        hairFill.curveTo(181, 176, 183, 174, 185, 172);
        hairFill.curveTo(189, 171, 190, 169, 192, 167);

        hairFill.curveTo(181, 176, 183, 174, 185, 172);
        hairFill.curveTo(189, 171, 190, 169, 192, 167);
        hairFill.curveTo(196, 165, 198, 164, 199, 163);
        hairFill.curveTo(201, 162, 203, 161, 209, 158);

        hairFill.curveTo(210, 161, 211, 164, 211, 167);
        hairFill.curveTo(212, 170, 212, 174, 214, 177);
        hairFill.curveTo(214, 180, 215, 183, 216, 187);
        hairFill.curveTo(218, 191, 219, 194, 219, 196);
        hairFill.curveTo(221, 197, 224, 197, 226, 197);
        hairFill.curveTo(228, 198, 231, 198, 233, 199);
        hairFill.curveTo(235, 199, 238, 199, 240, 200);
        hairFill.curveTo(243, 201, 246, 201, 249, 202);
        hairFill.curveTo(251, 202, 253, 203, 255, 204);
        hairFill.curveTo(259, 205, 263, 206, 265, 206);
        hairFill.curveTo(268, 207, 272, 209, 276, 209);
        hairFill.curveTo(278, 210, 283, 212, 287, 213);
        hairFill.curveTo(285, 209, 284, 206, 282, 203);
        hairFill.curveTo(282, 201, 280, 197, 279, 195);
        hairFill.curveTo(277, 192, 276, 190, 274, 187);
        hairFill.curveTo(267, 176, 266, 173, 265, 173);
        hairFill.curveTo(265, 174, 267, 174, 270, 176);
        hairFill.curveTo(272, 177, 274, 179, 277, 182);
        hairFill.curveTo(281, 184, 284, 188, 287, 192);
        hairFill.curveTo(289, 196, 291, 199, 294, 203);
        hairFill.curveTo(296, 206, 298, 210, 300, 217);
        hairFill.curveTo(304, 220, 309, 222, 320, 229);

        hairFill.curveTo(319, 217, 316, 210, 311, 201);
        hairFill.curveTo(305, 193, 298, 184, 286, 174);
        hairFill.curveTo(275, 168, 259, 160, 241, 154);
        hairFill.curveTo(224, 151, 209, 149, 192, 151);
        hairFill.curveTo(180, 155, 160, 160, 149, 165);
        hairFill.curveTo(143, 171, 137, 171, 126, 184);
        hairFill.quadTo(119, 191, 111, 200);

        Color hairLeftFill = new Color(241, 169, 49);
        g4d.setColor(hairLeftFill);
        g4d.fill(hairFill);

        GeneralPath hair = new GeneralPath();
        hair.moveTo(112, 200);
        hair.quadTo(116, 200, 120, 199);
        hair.quadTo(127, 198, 129, 198);
        hair.quadTo(135, 197, 138, 196);
        hair.quadTo(144, 196, 147, 195);
        hair.quadTo(153, 195, 156, 194);
        hair.quadTo(159, 194, 160, 194);
        hair.quadTo(163, 193, 165, 193);

        hair.curveTo(168, 190, 169, 187, 172, 185);
        hair.curveTo(174, 183, 177, 180, 179, 178);
        hair.curveTo(181, 176, 183, 174, 185, 172);
        hair.curveTo(189, 171, 190, 169, 192, 167);

        hair.curveTo(181, 176, 183, 174, 185, 172);
        hair.curveTo(189, 171, 190, 169, 192, 167);
        hair.curveTo(196, 165, 198, 164, 199, 163);
        hair.curveTo(201, 162, 203, 161, 209, 158);

        hair.curveTo(210, 161, 211, 164, 211, 167);
        hair.curveTo(212, 170, 212, 174, 214, 177);
        hair.curveTo(214, 180, 215, 183, 216, 187);
        hair.curveTo(218, 191, 219, 194, 219, 196);
        hair.curveTo(221, 197, 224, 197, 226, 197);
        hair.curveTo(228, 198, 231, 198, 233, 199);
        hair.curveTo(235, 199, 238, 199, 240, 200);
        hair.curveTo(243, 201, 246, 201, 249, 202);
        hair.curveTo(251, 202, 253, 203, 255, 204);
        hair.curveTo(259, 205, 263, 206, 265, 206);
        hair.curveTo(268, 207, 272, 209, 276, 209);
        hair.curveTo(278, 210, 283, 212, 287, 213);
        hair.curveTo(285, 209, 284, 206, 282, 203);
        hair.curveTo(282, 201, 280, 197, 279, 195);
        hair.curveTo(277, 192, 276, 190, 274, 187);
        hair.curveTo(267, 176, 266, 173, 265, 173);
        hair.curveTo(265, 174, 267, 174, 270, 176);
        hair.curveTo(272, 177, 274, 179, 277, 182);
        hair.curveTo(281, 184, 284, 188, 287, 192);
        hair.curveTo(289, 196, 291, 199, 294, 203);
        hair.curveTo(296, 206, 298, 210, 300, 217);
        hair.curveTo(304, 220, 309, 222, 320, 229);

        g4d.setPaint(Color.BLACK);
        g4d.draw(hair);

        Graphics2D g5d = (Graphics2D) g;
        BasicStroke bs3 = new BasicStroke(1.5f); //for drawing
        g5d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g5d.setStroke(bs3);

        GeneralPath bangsLeftFill = new GeneralPath();
        bangsLeftFill.moveTo(129, 196.42);
        bangsLeftFill.curveTo(140, 184, 150, 174, 167, 165);
        bangsLeftFill.curveTo(152, 176, 141, 185, 133.75, 195);
        bangsLeftFill.quadTo(132, 196, 129, 196.42);
        g5d.setColor(Color.BLACK);
        g5d.fill(bangsLeftFill);

        GeneralPath bangsLeft = new GeneralPath();
        bangsLeft.moveTo(129, 196.42);
        bangsLeft.curveTo(140, 184, 150, 174, 167, 165);
        bangsLeft.curveTo(152, 176, 141, 185, 133.75, 195);
        g5d.setPaint(Color.BLACK);
        g5d.draw(bangsLeft);

    }

    public void Hands(Graphics g) {

        Graphics2D HandLine = (Graphics2D) g;
        BasicStroke shoes_line = new BasicStroke(4f); //for drawing
        HandLine.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        HandLine.setStroke(shoes_line);

        //FILL LEFT HAND COLOR
        GeneralPath leftHandFill = new GeneralPath();
        leftHandFill.moveTo(189, 336);
        leftHandFill.curveTo(174, 346, 157, 351, 146, 351);
        leftHandFill.curveTo(136, 350, 126, 346, 117, 339);
        leftHandFill.curveTo(113, 330, 117, 325, 125, 324);
        leftHandFill.curveTo(133, 324, 140, 324, 152, 324);

        Color HandColor = new Color(252, 221, 201);
        HandLine.setColor(HandColor);
        HandLine.fill(leftHandFill);

        //LEFT HAND
        GeneralPath leftHand = new GeneralPath();
        leftHand.moveTo(189, 336);
        leftHand.curveTo(174, 346, 157, 351, 146, 351);
        leftHand.curveTo(136, 350, 126, 346, 117, 339);
        leftHand.curveTo(113, 330, 117, 325, 125, 324);
        leftHand.curveTo(133, 324, 140, 324, 152, 324);
        HandLine.setPaint(Color.BLACK);
        HandLine.draw(leftHand);

        //RIGHT HAND COLOR
        GeneralPath rightHandFill = new GeneralPath();
        rightHandFill.moveTo(255, 330);
        rightHandFill.curveTo(263, 333, 273, 334, 285, 335);
        rightHandFill.curveTo(295, 334, 305, 332, 317, 328);
        rightHandFill.curveTo(325, 323, 332, 317, 337, 310);
        rightHandFill.curveTo(340, 304, 341, 299, 337, 294);
        rightHandFill.curveTo(335, 293, 330, 293, 325, 294);
        rightHandFill.curveTo(320, 296, 313, 298, 308, 301);
        rightHandFill.curveTo(304, 302, 301, 302, 299, 303);
        HandLine.setColor(HandColor);
        HandLine.fill(rightHandFill);

        //RIGHT HAND
        GeneralPath rightHand = new GeneralPath();
        rightHand.moveTo(255, 330);
        rightHand.curveTo(263, 333, 273, 334, 285, 335);
        rightHand.curveTo(295, 334, 305, 332, 317, 328);
        rightHand.curveTo(325, 323, 332, 317, 337, 310);
        rightHand.curveTo(340, 304, 341, 299, 337, 294);
        rightHand.curveTo(335, 293, 330, 293, 325, 294);
        rightHand.curveTo(320, 296, 313, 298, 308, 301);
        rightHand.curveTo(304, 302, 301, 302, 299, 303);
        HandLine.setPaint(Color.BLACK);
        HandLine.draw(rightHand);
    }

    public void bodyAndClothes(Graphics g) {
        //body
        Graphics2D g11d = (Graphics2D) g;
        BasicStroke bs10 = new BasicStroke(5f); //for drawing
        g11d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g11d.setStroke(bs10);

        GeneralPath bodyFill = new GeneralPath();
        bodyFill.moveTo(195, 336);
        bodyFill.curveTo(195, 342, 195, 348, 196, 352);
        bodyFill.curveTo(198, 360, 198, 364, 200, 370);
        bodyFill.curveTo(202, 376, 203, 379, 205, 385);
        bodyFill.curveTo(205, 389, 207, 393, 209, 397);
        bodyFill.curveTo(210, 401, 212, 405, 214, 406);
        bodyFill.curveTo(221, 398, 226, 391, 232, 386);
        bodyFill.curveTo(238, 382, 245, 376, 250, 373);
        bodyFill.curveTo(255, 370, 260, 367, 266, 365);
        bodyFill.curveTo(258, 356, 250, 348, 240, 334);
        Color bodyFillColor = new Color(236, 107, 111);
        g11d.setColor(bodyFillColor);
        g11d.fill(bodyFill);

        GeneralPath body = new GeneralPath();
        body.moveTo(195, 336);
        body.curveTo(195, 342, 195, 348, 196, 352);
        body.curveTo(198, 360, 198, 364, 200, 370);
        body.curveTo(202, 376, 203, 379, 205, 385);
        body.curveTo(205, 389, 207, 393, 209, 397);
        body.curveTo(210, 401, 212, 405, 214, 406);
        body.curveTo(221, 398, 226, 391, 232, 386);
        body.curveTo(238, 382, 245, 376, 250, 373);
        body.curveTo(255, 370, 260, 367, 266, 365);
        body.curveTo(258, 356, 250, 348, 240, 334);
        g11d.setPaint(Color.BLACK);
        g11d.draw(body);

        //clothes
        Graphics2D clothesLine = (Graphics2D) g;
        BasicStroke line_clothes = new BasicStroke(2f); //for drawing
        clothesLine.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        clothesLine.setStroke(line_clothes);

        GeneralPath clothes = new GeneralPath();
        clothes.moveTo(199, 354);
        clothes.curveTo(201, 350, 204, 352, 206, 350);
        clothes.curveTo(209, 350, 214, 348, 217, 347);
        clothes.curveTo(220, 346, 224, 345, 228, 345);
        clothes.curveTo(231, 344, 236, 344, 245, 343);

        clothes.curveTo(255, 354, 249, 354, 255, 353);
        clothes.curveTo(237, 357, 241, 356, 244, 355);
        clothes.curveTo(224, 363, 228, 361, 233, 359);
        clothes.curveTo(215, 370, 217, 368, 220, 366);
        clothes.curveTo(205, 377, 209, 375, 201, 380);
        clothesLine.setPaint(Color.BLACK);
        clothesLine.fill(clothes);

    }

    public void Eyes(Graphics g) {

        //eyes
        Graphics2D g6d = (Graphics2D) g;
        BasicStroke bs4 = new BasicStroke(2.25f); //for drawing
        //g6d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g6d.setStroke(bs4);

        //left white eyes
        GeneralPath leftWhiteEyes = new GeneralPath();
        leftWhiteEyes.moveTo(104, 265);
        leftWhiteEyes.curveTo(106, 271, 110, 275, 115, 280);
        leftWhiteEyes.curveTo(120, 283, 123, 283, 131, 282);
        leftWhiteEyes.curveTo(137, 280, 142, 277, 151, 269);
        g6d.setColor(Color.white);
        g6d.fill(leftWhiteEyes);

        //outer Pink eyes
        Graphics2D g7d = (Graphics2D) g;
        BasicStroke bs5 = new BasicStroke(2.3f); //for drawing
        g7d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g7d.setStroke(bs5);
        Color pink_outline = new Color(236, 107, 111);

        GeneralPath leftPinkEye = new GeneralPath();
        leftPinkEye.moveTo(147.85, 269);
        leftPinkEye.curveTo(146, 270, 144, 271, 142, 272);
        leftPinkEye.curveTo(133, 275, 131, 275, 128, 275);
        leftPinkEye.curveTo(125, 275, 123, 275, 121, 274);
        leftPinkEye.curveTo(119, 274, 116, 273, 113, 271);
        leftPinkEye.curveTo(111, 270, 110, 270, 108, 268);
        leftPinkEye.curveTo(106, 266, 107, 266, 103, 262);
        leftPinkEye.curveTo(103, 260, 102, 257, 102, 255);
        leftPinkEye.curveTo(102, 253, 102, 250, 101, 247);
        leftPinkEye.curveTo(101, 244, 101, 242, 101, 240);
        leftPinkEye.curveTo(100, 238, 101, 235, 101, 232);
        leftPinkEye.curveTo(101, 229, 102, 227, 103, 225);
        leftPinkEye.curveTo(102, 222, 103, 219, 104, 217);
        leftPinkEye.curveTo(105, 215, 105, 214, 106, 212);
        leftPinkEye.curveTo(107, 209, 108, 209, 108, 208);
        leftPinkEye.curveTo(107, 206, 106, 206, 109, 204);
        leftPinkEye.curveTo(109, 200, 110, 202, 115, 202);
        leftPinkEye.curveTo(118, 201, 119, 200, 125, 200);
        leftPinkEye.curveTo(124, 202, 122, 204, 120, 207);
        leftPinkEye.curveTo(119, 209, 118, 211, 117, 213);
        leftPinkEye.curveTo(117, 215, 116, 217, 115, 221);
        leftPinkEye.curveTo(115, 221, 110, 223, 116, 224);
        leftPinkEye.curveTo(114, 227, 114, 230, 114, 232);
        leftPinkEye.curveTo(114, 237, 115, 239, 115, 242);
        leftPinkEye.curveTo(116, 244, 116, 245, 117, 247);
        leftPinkEye.curveTo(119, 249, 120, 252, 121, 254);
        leftPinkEye.curveTo(123, 255, 125, 256, 127, 258);
        leftPinkEye.curveTo(129, 259, 131, 260, 133, 261);
        leftPinkEye.curveTo(135, 261, 137, 261, 138, 261);
        leftPinkEye.curveTo(141, 261, 144, 260, 146, 259);
        leftPinkEye.curveTo(149, 258, 151, 257, 154, 255);
        leftPinkEye.curveTo(156, 253, 158, 251, 160, 248);
        leftPinkEye.curveTo(162, 246, 162, 245, 163, 244);
        leftPinkEye.curveTo(162, 256, 154, 263, 149, 269);
        g7d.setColor(pink_outline);
        g7d.fill(leftPinkEye);

        //outer eyes black right
        GeneralPath outerBlackR = new GeneralPath();
        outerBlackR.moveTo(231, 199);
        outerBlackR.lineTo(222, 199);
        outerBlackR.curveTo(221, 201, 218, 203, 216, 206);
        outerBlackR.curveTo(214, 208, 213, 211, 212, 213);
        outerBlackR.curveTo(211, 215, 210, 218, 209, 221);
        outerBlackR.curveTo(208, 224, 207, 228, 207, 230);
        outerBlackR.curveTo(207, 232, 206, 236, 206.5, 239);
        outerBlackR.curveTo(206, 243, 206, 249, 206.5, 253);
        outerBlackR.curveTo(208, 256, 208, 258, 209, 261);
        outerBlackR.curveTo(211, 265, 212, 267, 212, 268);
        outerBlackR.curveTo(213, 270, 213, 271, 215, 273);
        outerBlackR.curveTo(215, 274, 217, 276, 218, 277);
        outerBlackR.curveTo(219, 280, 221, 281, 223, 284);
        outerBlackR.curveTo(224, 285, 227, 287, 229, 290);
        outerBlackR.curveTo(231, 290, 233, 292, 235, 293);
        outerBlackR.curveTo(238, 295, 241, 297, 243, 298);
        outerBlackR.curveTo(245, 299, 248, 300, 250, 300);
        outerBlackR.curveTo(253, 301, 255, 302, 257, 302);
        outerBlackR.curveTo(261, 303, 264, 304, 268, 304);
        outerBlackR.curveTo(272, 304, 275, 304, 277, 304);
        outerBlackR.curveTo(281, 303, 285, 303, 289, 301);
        outerBlackR.curveTo(300, 295, 304, 291, 307, 289);
        g6d.setColor(Color.WHITE);
        g6d.fill(outerBlackR);

        //eyesRIghtOutline
        GeneralPath outerBlackROutline = new GeneralPath();
        outerBlackROutline.moveTo(231, 199);
        outerBlackROutline.lineTo(222, 199);
        outerBlackROutline.curveTo(221, 201, 218, 203, 216, 206);
        outerBlackROutline.curveTo(214, 208, 213, 211, 212, 213);
        outerBlackROutline.curveTo(211, 215, 210, 218, 209, 221);
        outerBlackROutline.curveTo(208, 224, 207, 228, 207, 230);
        outerBlackROutline.curveTo(207, 232, 206, 236, 206.5, 239);
        outerBlackROutline.curveTo(206, 243, 206, 249, 206.5, 253);
        outerBlackROutline.curveTo(208, 256, 208, 258, 209, 261);
        outerBlackROutline.curveTo(211, 265, 212, 267, 212, 268);
        outerBlackROutline.curveTo(213, 270, 213, 271, 215, 273);
        outerBlackROutline.curveTo(215, 274, 217, 276, 218, 277);
        outerBlackROutline.curveTo(219, 280, 221, 281, 223, 284);
        outerBlackROutline.curveTo(224, 285, 227, 287, 229, 290);
        outerBlackROutline.curveTo(231, 290, 233, 292, 235, 293);
        outerBlackROutline.curveTo(238, 295, 241, 297, 243, 298);
        outerBlackROutline.curveTo(245, 299, 248, 300, 250, 300);
        outerBlackROutline.curveTo(253, 301, 255, 302, 257, 302);
        outerBlackROutline.curveTo(261, 303, 264, 304, 268, 304);
        outerBlackROutline.curveTo(272, 304, 275, 304, 277, 304);
        outerBlackROutline.curveTo(281, 303, 285, 303, 289, 301);
        outerBlackROutline.curveTo(300, 295, 304, 291, 307, 289);
        g6d.setColor(Color.black);
        g6d.draw(outerBlackROutline);

        //pink eyes right
        Graphics2D g7d2 = (Graphics2D) g;
        BasicStroke bs50 = new BasicStroke(2.3f); //for drawing
        g7d2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g7d2.setStroke(bs50);
        Color pink_outline_Right = new Color(236, 107, 111);

        GeneralPath pinkRight = new GeneralPath();
        pinkRight.moveTo(250, 203);
        pinkRight.curveTo(244, 201, 239, 201, 232, 199); //Up

        pinkRight.curveTo(229, 203, 227, 206, 225, 209);
        pinkRight.curveTo(224, 211, 222, 214, 221, 217);
        pinkRight.curveTo(220, 219, 219, 224, 218, 228);
        pinkRight.curveTo(217, 231, 217, 234, 217, 238);
        pinkRight.curveTo(217, 240, 217, 244, 217, 246);
        pinkRight.curveTo(218, 249, 219, 252, 219, 255);
        pinkRight.curveTo(220, 257, 222, 261, 223, 263);
        pinkRight.curveTo(224, 266, 226, 268, 227, 270);
        pinkRight.curveTo(229, 273, 231, 276, 233, 278);
        pinkRight.curveTo(235, 280, 238, 282, 240, 284);
        pinkRight.curveTo(242, 286, 245, 286, 247, 287);

        pinkRight.curveTo(249, 289, 252, 290, 254, 291);
        pinkRight.curveTo(257, 292, 260, 293, 266, 294);
        pinkRight.curveTo(269, 294, 272, 294, 276, 294);
        pinkRight.curveTo(279, 293, 283, 293, 286, 292);
        pinkRight.curveTo(290, 291, 293, 290, 296, 289);
        pinkRight.curveTo(300, 287, 302, 285, 309, 282.5);
        pinkRight.curveTo(312, 280, 316, 270, 318, 260);
        g7d2.setColor(pink_outline_Right);
        g7d2.fill(pinkRight);

        GeneralPath pinkRightUp = new GeneralPath();
        pinkRightUp.moveTo(268, 179);
        pinkRightUp.curveTo(274, 185, 276, 190, 279, 195);
        pinkRightUp.curveTo(281, 193, 282, 193, 286, 193);
        pinkRightUp.curveTo(281, 187, 278, 184, 273, 179);
        g7d2.setBackground(pink_outline_Right);
        g7d2.fill(pinkRightUp);

        //inner black eyes
        Graphics2D g8d = (Graphics2D) g;
        BasicStroke bs6 = new BasicStroke(2f); //for drawing
        g8d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g8d.setStroke(bs6);

        GeneralPath innerBlackLeft = new GeneralPath();
        innerBlackLeft.moveTo(125, 200);
        innerBlackLeft.curveTo(124, 202, 122, 204, 120, 207);
        innerBlackLeft.curveTo(119, 209, 118, 211, 117, 213);
        innerBlackLeft.curveTo(117, 215, 116, 217, 114, 221);
        innerBlackLeft.curveTo(114, 221, 114, 223, 114, 224);
        innerBlackLeft.curveTo(114, 227, 114, 230, 114, 232);
        innerBlackLeft.curveTo(114, 237, 115, 239, 115, 242);
        innerBlackLeft.curveTo(116, 244, 116, 245, 117, 247);
        innerBlackLeft.curveTo(119, 249, 120, 252, 121, 254);
        innerBlackLeft.curveTo(123, 255, 125, 256, 127, 258);
        innerBlackLeft.curveTo(129, 259, 131, 260, 133, 261);
        innerBlackLeft.curveTo(135, 261, 137, 261, 138, 261);
        innerBlackLeft.curveTo(141, 261, 144, 260, 146, 259);
        innerBlackLeft.curveTo(149, 258, 151, 257, 154, 255);
        innerBlackLeft.curveTo(156, 253, 158, 251, 160, 248);
        innerBlackLeft.curveTo(162, 246, 162, 245, 163, 244);
        innerBlackLeft.curveTo(167, 234, 167, 226, 168, 220);
        innerBlackLeft.curveTo(167, 215, 167, 205, 160, 193);
        g8d.setPaint(Color.black);
        g8d.fill(innerBlackLeft);

        //inner black eyes right`
        GeneralPath innerBlackEyesRight = new GeneralPath();
        innerBlackEyesRight.moveTo(288, 192.5);
        innerBlackEyesRight.lineTo(278, 194);
        innerBlackEyesRight.lineTo(252, 203);
        innerBlackEyesRight.curveTo(250, 206, 248, 207, 246, 209);
        innerBlackEyesRight.curveTo(244, 211, 243, 213, 242, 215);
        innerBlackEyesRight.curveTo(241, 217, 240, 218, 239, 220);
        innerBlackEyesRight.curveTo(238, 222, 237, 224, 238, 225);
        innerBlackEyesRight.curveTo(237, 227, 236, 230, 236, 231);
        innerBlackEyesRight.curveTo(236, 233, 236, 235, 236, 236);
        innerBlackEyesRight.curveTo(236, 238, 236, 241, 236, 243);
        innerBlackEyesRight.curveTo(236, 245, 237, 247, 238, 249);
        innerBlackEyesRight.curveTo(238, 251, 239, 252, 240, 255);
        innerBlackEyesRight.curveTo(241, 257, 241, 259, 243, 260);
        innerBlackEyesRight.curveTo(245, 262, 246, 264, 247, 266);
        innerBlackEyesRight.curveTo(248, 267, 250, 269, 252, 271);
        innerBlackEyesRight.curveTo(255, 273, 257, 274, 259, 275);
        innerBlackEyesRight.curveTo(260, 276, 262, 277, 265, 278);
        innerBlackEyesRight.curveTo(267, 278, 270, 279, 273, 279);
        innerBlackEyesRight.curveTo(276, 279, 279, 279, 282, 279);
        innerBlackEyesRight.curveTo(285, 279, 287, 279, 290, 278);
        innerBlackEyesRight.curveTo(292, 278, 295, 276, 298, 275);
        innerBlackEyesRight.curveTo(301, 273, 303, 272, 306, 270);
        innerBlackEyesRight.curveTo(308, 268, 310, 266, 312, 265);
        innerBlackEyesRight.curveTo(313, 263, 315, 262, 319, 260);
        innerBlackEyesRight.curveTo(322, 248, 321, 234, 318, 222);
        innerBlackEyesRight.curveTo(309, 204, 306, 198, 304, 196);

        g8d.setPaint(Color.BLACK);
        g8d.fill(innerBlackEyesRight);

        //outer eyes black left
        GeneralPath eyesLeftOuter = new GeneralPath();
        eyesLeftOuter.moveTo(161, 195);
        eyesLeftOuter.curveTo(163, 197, 164, 201, 165, 205);//1
        eyesLeftOuter.curveTo(166, 209, 167, 214, 167, 218);//2
        eyesLeftOuter.curveTo(167, 222, 167, 227, 167, 233);//3
        eyesLeftOuter.curveTo(165, 239, 163, 246, 161, 253);//4
        eyesLeftOuter.curveTo(158, 258, 155, 262, 152, 267);//5
        eyesLeftOuter.curveTo(149, 271, 145, 274, 141, 277);//6
        eyesLeftOuter.curveTo(137, 279, 134, 281, 130, 282);//7
        eyesLeftOuter.curveTo(127, 282, 123, 282, 119, 282);//8
        eyesLeftOuter.curveTo(116, 280, 113, 279, 111, 277);//9
        eyesLeftOuter.curveTo(109, 275, 108, 273, 105, 270);//10
        g6d.setPaint(Color.black);
        g6d.draw(eyesLeftOuter);

        //cornea
        Graphics2D g9d = (Graphics2D) g;
        BasicStroke bs7 = new BasicStroke(0.1f); //for drawing
        g9d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g9d.setStroke(bs7);
        g9d.setPaint(Color.white);

        //cornea left
        Ellipse2D.Double corneaL = new Ellipse2D.Double(140, 195, 25, 30);
        g9d.setPaint(Color.white);
        g9d.fill(corneaL);
        g9d.setPaint(Color.black);
        g9d.draw(corneaL);

        //cornea right
        GeneralPath corneaRight = new GeneralPath();
        corneaRight.moveTo(280, 218);
        corneaRight.curveTo(278, 219, 276, 221, 275, 224);
        corneaRight.curveTo(274, 226, 274, 229, 275, 232);
        corneaRight.curveTo(275, 234, 276, 236, 277, 238);
        corneaRight.curveTo(279, 241, 282, 241, 283, 244);
        corneaRight.curveTo(285, 244, 287, 245, 289, 245);
        corneaRight.curveTo(291, 246, 294, 246, 296, 246);
        corneaRight.curveTo(299, 245, 301, 245, 303, 244);
        corneaRight.curveTo(304, 243, 307, 240, 308, 239);
        corneaRight.curveTo(309, 236, 311, 233, 310, 231);
        corneaRight.curveTo(310, 230, 309, 228, 309, 226);
        corneaRight.curveTo(308, 225, 307, 223, 306, 222);
        corneaRight.curveTo(305, 221, 303, 220, 301, 219);
        corneaRight.curveTo(300, 217, 296, 216, 293, 215);
        corneaRight.curveTo(290, 215, 287, 215, 284, 216);
        corneaRight.curveTo(281, 217, 279, 218, 277, 220);
        g9d.setPaint(Color.WHITE);
        g9d.fill(corneaRight);
    }

    public void faceFill(Graphics g) {
        Graphics2D g3d = (Graphics2D) g;

        Color bodyFillColor = new Color(252, 221, 201);
        g3d.setColor(bodyFillColor);

        Ellipse2D.Double elli = new Ellipse2D.Double(97, 148, 226, 189);
        g3d.fill(elli);
    }

    public void faceOutline(Graphics g) {
        Graphics2D g3d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(7f); //for drawing
        g3d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g3d.setStroke(bs);

        Ellipse2D.Double elli = new Ellipse2D.Double(97, 148, 226, 189);
        g3d.setColor(Color.black);
        g3d.draw(elli);
    }

    public void Mouth(Graphics g) {
        //mouth upper
        Graphics2D mouthOutline = (Graphics2D) g;
        BasicStroke bs8 = new BasicStroke(2.3f); //for drawing
        mouthOutline.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        mouthOutline.setStroke(bs8);
        mouthOutline.setPaint(Color.black);

        GeneralPath mouth = new GeneralPath();
        mouth.moveTo(163.5, 277);
        mouth.curveTo(165, 280, 168, 282, 170, 282);
        mouth.curveTo(172, 283, 174, 283, 177, 283);
        mouth.curveTo(179, 284, 182, 284, 184, 284);
        mouth.curveTo(188, 283, 190, 282, 193, 281);
        mouth.curveTo(195, 280, 196, 279, 198, 278);
        mouth.curveTo(199, 277, 200, 276, 202, 273);
        mouth.curveTo(202, 274, 203, 276, 204, 277);
        mouth.curveTo(205, 282, 206, 285, 206, 289);
        mouth.curveTo(207, 292, 206, 296, 205, 300);
        mouth.curveTo(201, 307, 200, 308, 198, 310);
        mouth.curveTo(193, 312, 189, 314, 187, 313);
        mouth.curveTo(181, 311, 178, 310, 175, 308);
        mouth.curveTo(173, 306, 170, 303, 169, 299);
        mouth.curveTo(165, 295, 164, 291, 162, 277);
        mouthOutline.setPaint(Color.BLACK);
        mouthOutline.fill(mouth);

        Graphics2D g10d = (Graphics2D) g;
        BasicStroke bs9 = new BasicStroke(1.5f); //for drawing
        g10d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g10d.setStroke(bs9);
        Color pink_outline_tongue = new Color(238, 115, 118);
        g10d.setColor(pink_outline_tongue);

        GeneralPath tongue = new GeneralPath();
        tongue.moveTo(187, 311);
        tongue.curveTo(187, 309, 187, 308, 187, 305);
        tongue.curveTo(188, 304, 189, 301, 190, 300);
        tongue.curveTo(191, 298, 193, 297, 194, 296);
        tongue.curveTo(196, 295, 197, 295, 199, 295);
        tongue.curveTo(200, 294, 202, 294, 204, 295);
        tongue.curveTo(204, 295, 204, 297, 203, 298);
        tongue.curveTo(203, 299, 202, 300, 202, 301);
        tongue.curveTo(201, 302, 200, 304, 199, 306);
        tongue.curveTo(197, 307, 196, 308, 194, 309);
        tongue.curveTo(192, 310, 191, 310, 188, 310);
        g10d.setColor(pink_outline_tongue);
        g10d.fill(tongue);
    }

    public void backHair(Graphics g) {
        //hair
        Graphics2D g4d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(3f); //for drawing
        g4d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g4d.setStroke(bs);
        Color backHairFillColor = new Color(241, 169, 49);

        GeneralPath backHairFill = new GeneralPath();
        backHairFill.moveTo(228, 388);
        backHairFill.curveTo(238, 401, 246, 412, 265, 428);
        backHairFill.curveTo(286, 432, 304, 428, 326, 416);
        backHairFill.curveTo(341, 401, 351, 383, 354, 370);
        backHairFill.curveTo(355, 351, 353, 341, 351, 330);
        backHairFill.curveTo(351, 330, 346, 335, 336, 344);
        backHairFill.curveTo(328, 348, 319, 350, 310, 348);
        backHairFill.curveTo(291, 336, 281, 325, 278, 322);
        backHairFill.curveTo(261, 329, 249, 334, 242, 335);
        g4d.setColor(backHairFillColor);
        g4d.fill(backHairFill);

        //outline
        Graphics2D gd = (Graphics2D) g;
        BasicStroke bs1 = new BasicStroke(6f); //for drawing
        gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gd.setStroke(bs1);
        GeneralPath backHairOutline = new GeneralPath();
        backHairOutline.moveTo(228, 388);
        backHairOutline.curveTo(238, 401, 246, 412, 265, 428);
        backHairOutline.curveTo(286, 432, 304, 428, 326, 415);
        backHairOutline.curveTo(341, 401, 351, 383, 353, 370);
        backHairOutline.curveTo(355, 351, 353, 341, 351, 330);
        backHairOutline.curveTo(351, 330, 346, 335, 336, 344);
        backHairOutline.curveTo(328, 348, 319, 350, 310, 346);
        backHairOutline.curveTo(291, 336, 281, 325, 278, 322);
        gd.setPaint(Color.BLACK);
        gd.draw(backHairOutline);

        Graphics2D g9d = (Graphics2D) g;
        BasicStroke bs7 = new BasicStroke(0.1f); //for drawing
        g9d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g9d.setStroke(bs7);
        g9d.setPaint(Color.black);

        //hair strands
        GeneralPath hairStrandLeft = new GeneralPath();
        hairStrandLeft.moveTo(284, 428);
        hairStrandLeft.quadTo(281, 422, 279, 414);
        hairStrandLeft.quadTo(283, 422, 287, 429);
        hairStrandLeft.lineTo(284, 428);
        g9d.setPaint(Color.BLACK);
        g9d.fill(hairStrandLeft);

        GeneralPath hairStrandCenter = new GeneralPath();
        hairStrandCenter.moveTo(327, 411);
        hairStrandCenter.quadTo(316, 403, 312, 398);
        hairStrandCenter.quadTo(318, 401, 329, 409);
        hairStrandCenter.lineTo(326, 412);
        g9d.setPaint(Color.BLACK);
        g9d.fill(hairStrandCenter);

        GeneralPath hairStrandRight = new GeneralPath();
        hairStrandRight.moveTo(352, 366);
        hairStrandRight.lineTo(333, 364);
        hairStrandRight.lineTo(353, 363);
        hairStrandRight.lineTo(352, 366);
        g9d.setPaint(Color.BLACK);
        g9d.fill(hairStrandRight);

    }

    public void feet(Graphics g) {
        //outer left ear
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs2 = new BasicStroke(3f); //for drawing
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setStroke(bs2);
        g2d.setPaint(Color.BLACK);

        //Feet
        Graphics2D shoesLine = (Graphics2D) g;
        BasicStroke shoes_line = new BasicStroke(5f); //for drawing
        shoesLine.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        shoesLine.setStroke(shoes_line);
        shoesLine.setPaint(Color.BLACK);

        GeneralPath leftFoot = new GeneralPath();
        leftFoot.moveTo(214, 406);
        leftFoot.curveTo(215, 409, 217, 413, 219, 418);
        leftFoot.curveTo(224, 424, 226, 428, 229, 432);
        leftFoot.curveTo(232, 435, 234, 438, 239, 441);
        leftFoot.curveTo(243, 444, 247, 446, 250, 447);
        leftFoot.curveTo(256, 448, 260, 447, 264, 446);
        leftFoot.curveTo(267, 443, 268, 441, 268, 436);
        leftFoot.curveTo(267, 430, 266, 427, 264, 422);
        leftFoot.curveTo(262, 418, 260, 414, 255, 409);
        leftFoot.curveTo(252, 406, 250, 403, 246, 399);
        leftFoot.curveTo(242, 395, 238, 393, 235, 390);
        shoesLine.setPaint(Color.white);
        shoesLine.fill(leftFoot);
        shoesLine.setPaint(Color.black);
        shoesLine.draw(leftFoot);

        //shoes
        Graphics2D shoes = (Graphics2D) g;
        BasicStroke bs12 = new BasicStroke(2f); //for drawing

        shoes.setStroke(bs12);

        GeneralPath socksLeft = new GeneralPath();
        socksLeft.moveTo(235, 440);
        socksLeft.quadTo(253, 432, 261, 420);
        socksLeft.curveTo(267, 427, 270, 439, 269, 440);
        socksLeft.curveTo(262, 449, 251, 447, 235, 440);
        shoes.setPaint(Color.BLACK);
        shoes.fill(socksLeft);


        BasicStroke bs1 = new BasicStroke(0.1f);
        shoes.setStroke(bs1);
        GeneralPath holeShoesLeft = new GeneralPath();
        holeShoesLeft.moveTo(245, 440);
        holeShoesLeft.curveTo(247, 439, 248, 438, 254, 433);
        holeShoesLeft.curveTo(255, 434, 255, 436, 256, 438);
        holeShoesLeft.curveTo(256, 439, 255, 440, 255, 441);
        holeShoesLeft.curveTo(254, 442, 252, 443, 250, 442);
        holeShoesLeft.curveTo(249, 442, 246, 441, 245, 440);
        shoes.setPaint(Color.white);
        shoes.fill(holeShoesLeft);

        //RIGHT FEET
        Graphics2D shoesLine2 = (Graphics2D) g;
        BasicStroke shoes_line2 = new BasicStroke(5f); //for drawing
        shoesLine2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        shoesLine2.setStroke(shoes_line2);
        shoesLine2.setPaint(Color.BLACK);

        GeneralPath RightFoot = new GeneralPath();
        RightFoot.moveTo(244, 378);
        RightFoot.curveTo(248, 381, 250, 383, 252, 386);
        RightFoot.curveTo(255, 387, 259, 390, 262, 390);
        RightFoot.curveTo(265, 391, 268, 391, 270, 391);
        RightFoot.curveTo(275, 390, 279, 389, 282, 388);
        RightFoot.curveTo(284, 386, 288, 384, 290, 382);
        RightFoot.curveTo(292, 380, 295, 378, 297, 374);
        RightFoot.curveTo(298, 371, 299, 369, 300, 365);
        RightFoot.curveTo(300, 362, 300, 359, 299, 356);
        RightFoot.curveTo(297, 355, 296, 352, 293, 351);
        RightFoot.curveTo(290, 349, 287, 349, 283, 349);
        RightFoot.curveTo(281, 351, 277, 352, 274, 355);
        RightFoot.quadTo(271, 357, 266, 365);
        shoesLine2.setPaint(Color.WHITE);
        shoesLine2.fill(RightFoot);
        shoesLine2.setPaint(Color.BLACK);
        shoesLine2.draw(RightFoot);

        Graphics2D socksLine = (Graphics2D) g;
        BasicStroke socks_line = new BasicStroke(2f); //for drawing
        socksLine.setStroke(socks_line);
        socksLine.setPaint(Color.BLACK);

        GeneralPath socksRight = new GeneralPath();
        socksRight.moveTo(273, 356);
        socksRight.curveTo(279, 358, 281, 359, 284, 361);
        socksRight.curveTo(288, 365, 292, 370, 295, 374);
        socksRight.curveTo(300, 368, 298, 360, 297, 354);
        socksRight.curveTo(292, 351, 287, 350, 280, 352);
        socksLine.setPaint(Color.BLACK);
        socksLine.fill(socksRight);

        //socks RIGHT
        Graphics2D socksInner = (Graphics2D) g;
        BasicStroke basicStroke = new BasicStroke(0.1f); //for drawing
        socksInner.setStroke(basicStroke);

        GeneralPath holeRight = new GeneralPath();
        holeRight.moveTo(291, 364);
        holeRight.curveTo(292, 362, 294, 361, 296, 361);
        holeRight.curveTo(297, 363, 296, 365, 295, 368.5);
        holeRight.quadTo(292, 367, 291, 364);
        socksInner.setPaint(Color.WHITE);
        socksInner.fill(holeRight);


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
        frame.setTitle("Blossom - Animation");
        frame.setBackground(Color.white);
        frame.setMinimumSize(new Dimension(512, 512));
        blossom_animation s = new blossom_animation();
        s.setBackground(Color.white);
        frame.add(s, BorderLayout.CENTER);
        frame.pack();
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