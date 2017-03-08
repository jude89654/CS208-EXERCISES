import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * Created by judeBismonte on 2/23/2017.
 */
public class jude extends Frame {

    int picWidth = 750, picHeight = 605;
    double aspectRatio = picWidth / picHeight;
    double height = 605, width = 750;


    public void paint(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke bs = new BasicStroke(3.0f);
        g2d.setStroke(bs);
        createEar(g2d);
        createhead(g2d);
        createFace(g2d);
        createPoloAndNeckTie(g2d);
        createToga(g2d);
        createEyes(g2d);
        //AffineTransform move = new AffineTransform();
        //move.
        GeneralPath shadow = new GeneralPath();
        shadow.moveTo(302, 284);
        shadow.quadTo(311, 313, 324, 323);
        shadow.lineTo(329, 335);
        shadow.quadTo(365, 368, 440, 350);
        shadow.quadTo(444, 355, 452, 367);
        shadow.quadTo(478, 362, 486, 334);
        shadow.quadTo(488, 318, 497, 289);
        shadow.lineTo(498, 271);
        shadow.lineTo(492, 269);
        shadow.quadTo(516, 201, 481, 163);
        shadow.quadTo(480, 128, 468, 117);
        shadow.quadTo(477, 142, 469, 184);
        shadow.lineTo(483, 190);
        shadow.quadTo(492, 247, 463, 318);
        shadow.lineTo(458, 323);
        shadow.quadTo(396, 360, 331, 320);
        shadow.lineTo(302, 281);
        g2d.setPaint(new Color(206,148,128));
        g2d.fill(shadow);
    }

    public void createFace(Graphics2D g2d) {
//        GeneralPath leftEye = new GeneralPath();
//        move(leftEye,327,208);
//        quad(leftEye,334,207,344,201);
//        quad(leftEye,356,198,368,206);

        Ellipse2D Mole = createEllipse(393, 208, 4, 4);


        GeneralPath leftEyeBrows = new GeneralPath();
        move(leftEyeBrows, 313, 185);
        quad(leftEyeBrows, 324, 176, 332, 176);
        quad(leftEyeBrows, 353, 174, 360, 175);
        quad(leftEyeBrows, 368, 175, 368, 179);
        quad(leftEyeBrows, 368, 184, 348, 183);
        quad(leftEyeBrows, 325, 184, 316, 191);
        quad(leftEyeBrows, 312, 190, 313, 185);
//        move(leftEyebrow,313,185);
//        quad(leftEyebrow,330,175,347,175);
//        quad(leftEyebrow,368,175,366,182);
//        quad(leftEyebrow,358,187,359,188);
//        quad(leftEyebrow,338,182,316,194);
//        quad(leftEyebrow,310,194,310,189);

        GeneralPath rightEyeBrows = new GeneralPath();
        move(rightEyeBrows, 483, 191);
        quad(rightEyeBrows, 460, 177, 431, 177);
        quad(rightEyeBrows, 421, 177, 421, 183);
        quad(rightEyeBrows, 421, 185, 431, 185);
        quad(rightEyeBrows, 449, 185, 475, 198);
        quad(rightEyeBrows, 483, 199, 483, 191);


        GeneralPath leftEyes = new GeneralPath();
        move(leftEyes, 327, 206);
        //top eye
        quad(leftEyes, 340, 200, 351, 200);
        quad(leftEyes, 361, 200, 366, 203);
        quad(leftEyes, 367, 205, 366, 205);
        quad(leftEyes, 360, 203, 361, 207);
        quad(leftEyes, 356, 211, 347, 208);
        quad(leftEyes, 342, 202, 337, 206);
        quad(leftEyes, 339, 209, 325, 209);
        quad(leftEyes, 330, 210, 327, 206);

        GeneralPath rightEyes = new GeneralPath();
        move(rightEyes, 429, 204);
        quad(rightEyes, 441, 200, 467, 210);
        quad(rightEyes, 466, 214, 459, 214);
        quad(rightEyes, 457, 214, 451, 212);
        quad(rightEyes, 452, 208, 448, 207);
        quad(rightEyes, 447, 212, 441, 212);
        quad(rightEyes, 433, 212, 433, 207);
        quad(rightEyes, 432, 205, 429, 204);
        rightEyes.closePath();


        //
        GeneralPath nose = new GeneralPath();
        move(nose, 370, 244);
        quad(nose, 368, 253, 378, 251);
        quad(nose, 383, 248, 388, 252);
        quad(nose, 401, 254, 406, 251);
        quad(nose, 413, 249, 417, 253);
        quad(nose, 423, 254, 420, 246);
        quad(nose, 416, 239, 415, 234);
        quad(nose, 413, 232, 412, 235);
        line(nose, 416, 243);
        quad(nose, 419, 248, 412, 247);
        quad(nose, 406, 245, 402, 249);
        quad(nose, 397, 250, 390, 249);
        quad(nose, 386, 245, 378, 247);
        quad(nose, 373, 248, 370, 244);

        GeneralPath mouth = new GeneralPath();
        move(mouth, 355, 284);
        //
        //
        // quad(mouth,)
        GeneralPath lip = new GeneralPath();
        move(lip, 354, 284);
        quad(lip, 390, 274, 434, 287);
        quad(lip, 391, 303, 356, 285);

        GeneralPath lipInverse = new GeneralPath();
        move(lipInverse, 383, 277);
        //quad(lipInverse, 387, 276, )

        GeneralPath lipLine = new GeneralPath();
        move(lipLine, 356, 284);
        quad(lipLine, 387, 289, 430, 287);


        g2d.setStroke(new BasicStroke(1.0f));
        g2d.setColor(Color.black);
        g2d.draw(lipLine);
        g2d.setStroke(new BasicStroke(3f));
        g2d.fill(Mole);


        g2d.setColor(new Color(176, 105, 99));
        g2d.fill(lip);

        g2d.setColor(Color.black);
        g2d.setStroke(new BasicStroke(0.5f));
        g2d.draw(lipLine);
        g2d.setStroke(new BasicStroke(3.0f));
        g2d.setColor(Color.black);
        g2d.fill(Mole);


        g2d.setColor(new Color(108, 84, 81));

        g2d.fill(leftEyeBrows);
        g2d.fill(rightEyeBrows);
        //g2d.fill(leftEyes);
        // g2d.fill(rightEyes);
        g2d.fill(nose);
        g2d.setStroke(new BasicStroke(0.5f));


    }

    public void createEyes(Graphics2D g2d) {
        GeneralPath leftEyeWhites = new GeneralPath();
        move(leftEyeWhites, 338, 207);
        quad(leftEyeWhites, 352, 192, 369, 207);
        quad(leftEyeWhites, 352, 210, 338, 207);

        GeneralPath rightEyeWhites = new GeneralPath();
        move(rightEyeWhites, 422, 209);
        quad(rightEyeWhites, 435, 196, 451, 209);
        quad(rightEyeWhites, 437, 214, 423, 210);

        GeneralPath leftEyeOutline = new GeneralPath();
        move(leftEyeOutline, 329, 207);
        quad(leftEyeOutline, 332, 206, 338, 203);
        quad(leftEyeOutline, 354, 190, 372, 208);
        // quad(leftEyeOutline,352,192,367,206);
        quad(leftEyeOutline, 349, 210, 329, 207);


        GeneralPath rightEyeOutline = new GeneralPath();
        move(rightEyeOutline, 419, 210);
        quad(rightEyeOutline, 432, 192, 453, 207);
        quad(rightEyeOutline, 455, 209, 461, 209);
        quad(rightEyeOutline, 437, 215, 418, 210);

        Ellipse2D leftIris = createEllipse(346, 198, 17, 17);
        Area leftIrisArea = new Area(leftIris);
        leftIrisArea.intersect(new Area(leftEyeWhites));

        Ellipse2D rightIris = createEllipse(429, 200, 17, 17);
        Area rightIrisArea = new Area(rightIris);
        rightIrisArea.intersect(new Area(rightEyeWhites));

//        Area leftEyeArea = new Area(leftEyeOutline);
//        leftEyeArea.subtract(new Area(leftEyeWhites));
//        leftEyeArea.add(leftIrisArea);

        GeneralPath leftEyelid = new GeneralPath();
        move(leftEyelid, 324, 205);
        quad(leftEyelid, 329, 205, 336, 201);
        quad(leftEyelid, 355, 194, 367, 203);


        g2d.setColor(new Color(88, 64, 61));
        //g2d.setColor(Color.black);
        g2d.fill(leftEyeOutline);
        g2d.fill(rightEyeOutline);
        g2d.setColor(Color.white);
        g2d.fill(leftEyeWhites);
        g2d.fill(rightEyeWhites);
        g2d.setColor(Color.black);
        g2d.fill(leftIrisArea);
        g2d.fill(rightIrisArea);
        g2d.setColor(Color.white);
        //g2d.fill(createEllipse(352,201,2,3));

//        g2d.setColor(new Color(119, 93, 93));
//        g2d.setStroke(new BasicStroke(0.5f));
        //g2d.draw(leftEyelid);
    }


    public Ellipse2D createEllipse(int x, int y, int w, int h) {
        return new Ellipse2D.Double(getX(x), getY(y), getY(w), getY(h));
    }

    public void createEar(Graphics2D g2d) {
        GeneralPath leftEar = new GeneralPath();
        move(leftEar, 306, 280);
        quad(leftEar, 289, 283, 289, 270);
        quad(leftEar, 290, 258, 286, 247);
        quad(leftEar, 286, 235, 282, 227);
        quad(leftEar, 280, 217, 283, 206);
        quad(leftEar, 283, 198, 291, 198);
        line(leftEar, 319, 239);
        leftEar.closePath();


        GeneralPath rightEar = new GeneralPath();
        move(rightEar, 506, 208);
        quad(rightEar, 529, 208, 529, 218);
        quad(rightEar, 533, 225, 530, 235);
        quad(rightEar, 527, 245, 524, 252);
        quad(rightEar, 523, 261, 518, 272);
        line(rightEar, 517, 280);
        quad(rightEar, 509, 287, 495, 287);
        line(rightEar, 474, 253);
        rightEar.closePath();
        g2d.setColor(new Color(217, 170, 155));
        g2d.fill(leftEar);
        g2d.fill(rightEar);
    }


    public void createhead(Graphics2D g2d) {


        GeneralPath hair = new GeneralPath();
        move(hair, 297, 241);
        quad(hair, 295, 220, 289, 202);
        quad(hair, 288, 166, 295, 130);
        quad(hair, 294, 143, 295, 130);
        quad(hair, 291, 113, 318, 82);
        quad(hair, 331, 58, 360, 46);
        quad(hair, 413, 30, 431, 48);
        quad(hair, 473, 48, 508, 91);
        quad(hair, 517, 101, 517, 128);
        quad(hair, 530, 164, 519, 208);
        quad(hair, 508, 215, 499, 271);

        g2d.setColor(Color.black);
        g2d.fill(hair);


        GeneralPath head = new GeneralPath();
        move(head, 332, 353);
        quad(head, 330, 331, 319, 316);
        quad(head, 300, 293, 298, 257);
        quad(head, 295, 234, 297, 203);
        quad(head, 297, 177, 314, 158);
        quad(head, 313, 138, 324, 130);
        quad(head, 330, 105, 350, 105);
        quad(head, 397, 98, 452, 107);
        quad(head, 481, 112, 481, 163);
        quad(head, 502, 178, 502, 227);
        quad(head, 503, 243, 494, 272);
        quad(head, 502, 244, 493, 268);
        line(head, 498, 290);
        quad(head, 487, 319, 488, 334);
        //
        line(head, 483, 533);
        line(head, 315, 499);
        head.closePath();
        g2d.setColor(new Color(217, 170, 155));
        g2d.fill(head);

        GeneralPath shadow = new GeneralPath();
        //move(shadow

    }

    public void createPoloAndNeckTie(Graphics2D g2d) {
        GeneralPath poloPath = new GeneralPath();
        move(poloPath, 332, 353);
        quad(poloPath, 337, 371, 356, 397);
        quad(poloPath, 370, 416, 373, 418);
        line(poloPath, 461, 365);
        quad(poloPath, 480, 356, 487, 333);
        quad(poloPath, 488, 348, 500, 357);
        line(poloPath, 500, 500);
        line(poloPath, 417, 580);
        line(poloPath, 212, 582);
        line(poloPath, 209, 484);
        poloPath.closePath();

        GeneralPath neckTie = new GeneralPath();
        move(neckTie, 318, 522);
        line(neckTie, 346, 476);
        quad(neckTie, 346, 461, 354, 455);
        quad(neckTie, 355, 443, 347, 430);
        quad(neckTie, 362, 412, 373, 420);
        quad(neckTie, 378, 436, 386, 449);
        quad(neckTie, 370, 457, 372, 524);
        line(neckTie, 316, 575);
        neckTie.closePath();


        GeneralPath collarShadow = new GeneralPath();
        move(collarShadow, 347, 430);
        line(collarShadow, 322, 465);
        line(collarShadow, 331, 504);
        line(collarShadow, 331, 463);
        line(collarShadow, 352, 437);
        collarShadow.closePath();
        Area collar = new Area(collarShadow);
        collar.subtract(new Area(neckTie));

        GeneralPath black = new GeneralPath();
        move(black, 496, 376);
        quad(black, 500, 362, 494, 350);
        quad(black, 502, 356, 517, 373);
        black.closePath();


        g2d.setColor(Color.WHITE);
        g2d.fill(poloPath);


        g2d.setColor(new Color(55, 55, 55));
        g2d.fill(neckTie);
        g2d.fill(black);

        g2d.setColor(new Color(116, 108, 123));
        g2d.fill(collar);
        // g2d.fill(neckTieShadows);

    }


    public void createToga(Graphics2D g2d) {

        GeneralPath greyPath = new GeneralPath();
        move(greyPath, 276, 371);
        line(greyPath, 289, 363);
        line(greyPath, 301, 363);
        line(greyPath, 311, 353);
        line(greyPath, 330, 349);
        line(greyPath, 330, 359);
        quad(greyPath, 324, 369, 326, 384);
        line(greyPath, 323, 431);
        quad(greyPath, 320, 445, 324, 461);
        quad(greyPath, 332, 510, 332, 529);
        quad(greyPath, 359, 500, 424, 437);
        quad(greyPath, 496, 372, 516, 364);
        quad(greyPath, 520, 360, 538, 372);
        quad(greyPath, 581, 404, 603, 410);
        line(greyPath, 610, 420);
        line(greyPath, 322, 601);
        line(greyPath, 200, 489);
        greyPath.closePath();


        GeneralPath redPath = new GeneralPath();
        //left shoulder
        move(redPath, 199, 406);
        quad(redPath, 199, 399, 209, 398);
        line(redPath, 244, 384);
        quad(redPath, 260, 381, 277, 370);
        //pababa
        quad(redPath, 273, 374, 271, 407);
        line(redPath, 271, 434);
        quad(redPath, 271, 453, 288, 495);
        line(redPath, 312, 551);
        line(redPath, 322, 562);//red midpoint
        quad(redPath, 327, 563, 345, 551);
        quad(redPath, 397, 529, 461, 488);
        line(redPath, 517, 447);
        quad(redPath, 586, 397, 608, 420);
        quad(redPath, 623, 433, 644, 447);
        quad(redPath, 652, 452, 663, 461);
        quad(redPath, 688, 477, 689, 509);
        line(redPath, 317, 605);
        line(redPath, 149, 570);
        redPath.closePath();


        GeneralPath blackPath = new GeneralPath();
        move(blackPath, 65, 604);
        line(blackPath, 122, 507);
        quad(blackPath, 122, 460, 184, 414);
        line(blackPath, 190, 413);
        quad(blackPath, 194, 407, 198, 407);
        quad(blackPath, 220, 510, 317, 591);
        quad(blackPath, 338, 593, 371, 578);
        line(blackPath, 495, 528);
        quad(blackPath, 528, 510, 559, 500);
        quad(blackPath, 570, 497, 604, 476);
        quad(blackPath, 634, 459, 650, 464);
        quad(blackPath, 685, 476, 685, 509);
        quad(blackPath, 695, 519, 696, 528);
        quad(blackPath, 707, 544, 707, 555);
        quad(blackPath, 718, 573, 723, 604);

        ArrayList<Shape> togaLines = new ArrayList<>();
        //right side
        togaLines.add(createQuadCurve(652, 466, 594, 468, 563, 602));
        togaLines.add(createQuadCurve(559, 500, 536, 546, 524, 604));
        togaLines.add(createLine(525, 514, 496, 604));
        togaLines.add(createLine(496, 526, 467, 604));
        togaLines.add(createLine(440, 549, 419, 599));
        //left side
        togaLines.add(createLine(251, 506, 233, 564));
        togaLines.add(createLine(232, 464, 203, 562));
        togaLines.add(createQuadCurve(221, 435, 192, 498, 183, 565));
        togaLines.add(createQuadCurve(212, 413, 172, 497, 167, 565));
        togaLines.add(createQuadCurve(188, 413, 174, 437, 163, 472));
        // togaLines.add(createQuadCurve(173,448,174,457,163,472));
        togaLines.add(createQuadCurve(163, 472, 149, 491, 149, 571));

        GeneralPath togaThickLine = new GeneralPath();
        move(togaThickLine, 149, 572);
        quad(togaThickLine, 193, 554, 234, 569);
        quad(togaThickLine, 242, 573, 260, 571);
        quad(togaThickLine, 329, 568, 430, 604);


        g2d.setColor(new Color(26, 25, 30));
        g2d.draw(blackPath);
        g2d.fill(blackPath);


        for (Shape shape :
                togaLines) {
            g2d.setColor(Color.black);
            g2d.draw(shape);
        }

        g2d.setStroke(new BasicStroke(5.0f));
        g2d.draw(togaThickLine);
        g2d.setStroke(new BasicStroke(3.0f));

        g2d.setColor(new Color(204, 6, 5));
        Area redArea = new Area(redPath);
        redArea.subtract(new Area(blackPath));
        g2d.fill(redArea);

        g2d.setColor(new Color(212, 211, 225));
        Area greyArea = new Area(greyPath);
        redArea.add(new Area(blackPath));
        greyArea.subtract(redArea);
        g2d.fill(greyArea);


    }


    public void move(GeneralPath gp, double x, double y) {
        gp.moveTo(getX(x), getY(y));
    }

    public void line(GeneralPath gp, double x, double y) {
        gp.lineTo(getX(x), getY(y));
    }

    public void quad(GeneralPath gp, double x, double y, double x1, double y1) {
        gp.quadTo(getX(x), getY(y), getX(x1), getY(y1));
    }

    public double getY(double y) {
        return (height / picHeight) * y;
    }


    public double getX(double x) {
        return (width / picWidth) * x;
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


    public static void main(String args[]) {
        jude selfPortrait = new jude();
        selfPortrait.setSize(746, 570);
        selfPortrait.setLocation(25, 172);
        //selfPortrait.setUndecorated(true);
        selfPortrait.setBackground(new Color(137, 136, 142));
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

