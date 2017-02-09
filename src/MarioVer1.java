import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by jude8 on 2/3/2017.
 */
public class MarioVer1 extends Frame {
    static int height =720;
    static int width = height;
    static int framePixelHeight = 30;
    static int framePixelWidth = 30;
    static double scale = height / framePixelHeight;
    static Color black = Color.BLACK;
    static Color orange = Color.PINK;
    static Color red = Color.RED;


    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        // g2d.setPaint(Color.black);

        BasicStroke basicStroke = new BasicStroke(3.0f);
        g2d.setStroke(basicStroke);

        //strokes for orange
        ArrayList<Line2D.Double> linesForColorOrange = new ArrayList<>();
        //upper left ear
        linesForColorOrange.add(createLine(14, 7, 14, 2));
        linesForColorOrange.add(createLine(14, 3, 16, 3));
        linesForColorOrange.add(createLine(16, 3, 16, 4));
        linesForColorOrange.add(createLine(16, 4, 17, 4));
        linesForColorOrange.add(createLine(17, 4, 17, 6));
        linesForColorOrange.add(createLine(17, 6, 16, 6));
        linesForColorOrange.add(createLine(16, 6, 16, 7));
        linesForColorOrange.add(createLine(16, 7, 14, 7));
        linesForColorOrange.add(createLine(22, 2, 23, 2));
        linesForColorOrange.add(createLine(23, 2, 23, 5));
        linesForColorOrange.add(createLine(23, 5, 22, 5));
        linesForColorOrange.add(createLine(22, 5, 22, 2));

        //face
        linesForColorOrange.add(createLine(12, 13, 12, 11));
        linesForColorOrange.add(createLine(12, 11, 13, 11));
        linesForColorOrange.add(createLine(13, 11, 13, 10));
        linesForColorOrange.add(createLine(13, 10, 14, 10));
        linesForColorOrange.add(createLine(14, 10, 14, 12));
        linesForColorOrange.add(createLine(14, 12, 15, 12));
        linesForColorOrange.add(createLine(15, 12, 15, 13));
        linesForColorOrange.add(createLine(15, 13, 16, 13));
        linesForColorOrange.add(createLine(16, 13, 16, 12));
        linesForColorOrange.add(createLine(16, 12, 17, 12));
        linesForColorOrange.add(createLine(17, 12, 17, 11));
        linesForColorOrange.add(createLine(17, 11, 16, 11));
        linesForColorOrange.add(createLine(16, 11, 16, 9));
        linesForColorOrange.add(createLine(16, 9, 17, 9));
        linesForColorOrange.add(createLine(17, 9, 17, 8));
        linesForColorOrange.add(createLine(17, 8, 23, 8));
        linesForColorOrange.add(createLine(23, 8, 23, 11));
        linesForColorOrange.add(createLine(23, 11, 24, 11));
        linesForColorOrange.add(createLine(24, 11, 24, 13));
        linesForColorOrange.add(createLine(24, 13, 23, 13));
        linesForColorOrange.add(createLine(23, 13, 23, 14));
        linesForColorOrange.add(createLine(23, 14, 21, 14));
        linesForColorOrange.add(createLine(21, 14, 21, 13));
        linesForColorOrange.add(createLine(21, 13, 19, 13));
        linesForColorOrange.add(createLine(19, 13, 19, 12));
        linesForColorOrange.add(createLine(19, 12, 18, 12));
        linesForColorOrange.add(createLine(18, 12, 18, 13));
        linesForColorOrange.add(createLine(18, 13, 17, 13));
        linesForColorOrange.add(createLine(17, 13, 17, 14));
        linesForColorOrange.add(createLine(17, 14, 19, 14));
        linesForColorOrange.add(createLine(19, 14, 19, 15));
        linesForColorOrange.add(createLine(19, 15, 22, 15));
        linesForColorOrange.add(createLine(22, 15, 22, 16));
        linesForColorOrange.add(createLine(22, 16, 17, 16));
        linesForColorOrange.add(createLine(17, 16, 17, 15));
        linesForColorOrange.add(createLine(17, 16, 17, 15));
        linesForColorOrange.add(createLine(17, 15, 15, 15));
        linesForColorOrange.add(createLine(15, 15, 15, 14));
        linesForColorOrange.add(createLine(15, 14, 13, 14));
        linesForColorOrange.add(createLine(13, 14, 13, 13));
        linesForColorOrange.add(createLine(13, 14, 13, 13));
        linesForColorOrange.add(createLine(13, 13, 12, 13));

        //left hand
        linesForColorOrange.add(createLine(9, 18, 13, 18));
        linesForColorOrange.add(createLine(13, 18, 13, 19));
        linesForColorOrange.add(createLine(13, 19, 14, 19));
        linesForColorOrange.add(createLine(14, 19, 14, 21));
        linesForColorOrange.add(createLine(14, 21, 12, 21));
        linesForColorOrange.add(createLine(12, 21, 12, 20));
        linesForColorOrange.add(createLine(12, 20, 9, 20));
        linesForColorOrange.add(createLine(9, 20, 9, 18));

        //right hand
        linesForColorOrange.add(createLine(23, 17, 26, 17));
        linesForColorOrange.add(createLine(26, 17, 26, 19));
        linesForColorOrange.add(createLine(26, 19, 24, 19));
        linesForColorOrange.add(createLine(24, 19, 24, 18));
        linesForColorOrange.add(createLine(24, 18, 23, 18));
        linesForColorOrange.add(createLine(23, 18, 23, 17));

        //tail bit
        linesForColorOrange.add(createLine(11, 22, 13, 22));
        linesForColorOrange.add(createLine(13, 22, 13, 23));
        linesForColorOrange.add(createLine(13, 23, 12, 23));
        linesForColorOrange.add(createLine(12, 23, 12, 24));
        linesForColorOrange.add(createLine(12, 24, 11, 24));
        linesForColorOrange.add(createLine(11, 24, 11, 22));

        for (Line2D.Double orangeLine : linesForColorOrange) {
            g2d.draw(orangeLine);
        }


        ArrayList<Line2D.Double> linesForRed = new ArrayList<>();
        //hat
        linesForRed.add(createLine(18, 4, 22, 4));
        linesForRed.add(createLine(22, 4, 22, 6));
        linesForRed.add(createLine(22, 6, 19, 6));
        linesForRed.add(createLine(19, 6, 19, 7));
        linesForRed.add(createLine(19, 7, 17, 7));
        linesForRed.add(createLine(17, 7, 17, 8));
        linesForRed.add(createLine(17, 8, 15, 8));
        linesForRed.add(createLine(15, 8, 15, 9));
        linesForRed.add(createLine(15, 9, 13, 9));
        linesForRed.add(createLine(13, 9, 13, 7));
        linesForRed.add(createLine(13, 7, 16, 7));
        linesForRed.add(createLine(16, 7, 16, 6));
        linesForRed.add(createLine(16, 6, 17, 6));
        linesForRed.add(createLine(17, 6, 17, 5));
        linesForRed.add(createLine(17, 5, 17, 4));
        linesForRed.add(createLine(17, 4, 18, 4));


        //left sleeve
        linesForRed.add(createLine(14, 16, 16, 16));
        linesForRed.add(createLine(16, 16, 16, 17));
        linesForRed.add(createLine(16, 17, 17, 17));
        linesForRed.add(createLine(17, 17, 17, 18));
        linesForRed.add(createLine(17, 18, 18, 18));
        linesForRed.add(createLine(18, 18, 18, 20));
        linesForRed.add(createLine(18, 20, 16, 20));
        linesForRed.add(createLine(16, 20, 16, 21));
        linesForRed.add(createLine(16, 21, 15, 21));
        linesForRed.add(createLine(15, 21, 15, 19));
        linesForRed.add(createLine(15, 19, 14, 19));
        linesForRed.add(createLine(14, 19, 14, 18));
        linesForRed.add(createLine(14, 18, 13, 18));
        linesForRed.add(createLine(13, 18, 13, 17));
        linesForRed.add(createLine(13, 17, 14, 17));
        linesForRed.add(createLine(14, 17, 14, 16));

        //shirt
        linesForRed.add(createLine(19, 17, 21, 17));
        linesForRed.add(createLine(21, 17, 21, 18));
        linesForRed.add(createLine(21, 18, 22, 18));
        linesForRed.add(createLine(22, 18, 22, 19));
        linesForRed.add(createLine(22, 19, 23, 19));
        linesForRed.add(createLine(23, 19, 23, 20));
        linesForRed.add(createLine(23, 20, 20, 20));
        linesForRed.add(createLine(20, 20, 20, 18));
        linesForRed.add(createLine(20, 18, 19, 18));
        linesForRed.add(createLine(19, 18, 19, 17));

        //tail end
        linesForRed.add(createLine(5, 21, 6, 21));
        linesForRed.add(createLine(6, 21, 6, 25));
        linesForRed.add(createLine(6, 25, 5, 25));
        linesForRed.add(createLine(5, 25, 5, 24));
        linesForRed.add(createLine(5, 24, 4, 24));
        linesForRed.add(createLine(4, 24, 4, 22));
        linesForRed.add(createLine(4, 22, 5, 22));
        linesForRed.add(createLine(5, 22, 5, 21));

        //left foot
        linesForRed.add(createLine(13, 22, 15, 22));
        linesForRed.add(createLine(15, 22, 15, 23));
        linesForRed.add(createLine(15, 23, 14, 23));
        linesForRed.add(createLine(14, 23, 14, 28));
        linesForRed.add(createLine(14, 28, 12, 28));
        linesForRed.add(createLine(12, 28, 12, 25));
        linesForRed.add(createLine(12, 25, 13, 25));
        linesForRed.add(createLine(13, 25, 13, 22));
        //right foot
        linesForRed.add(createLine(24, 22, 26, 22));
        linesForRed.add(createLine(26, 22, 26, 26));
        linesForRed.add(createLine(26, 26, 25, 26));
        linesForRed.add(createLine(25, 26, 25, 27));
        linesForRed.add(createLine(25, 27, 23, 27));
        linesForRed.add(createLine(23, 27, 23, 23));
        linesForRed.add(createLine(23, 23, 24, 23));
        linesForRed.add(createLine(24, 23, 24, 22));


        for (Line2D.Double redLine : linesForRed) {
            g2d.draw(redLine);
        }


        //black
        ArrayList<Integer[]> blackRect = new ArrayList<>();
        //line 2
        blackRect.add(createIntegerArray(13, 2));
        blackRect.add(createIntegerArray(14, 2));
        blackRect.add(createIntegerArray(15, 2));
        blackRect.add(createIntegerArray(22, 2));
        blackRect.add(createIntegerArray(23, 2));
        blackRect.add(createIntegerArray(15, 2));
        blackRect.add(createIntegerArray(13, 3));
        blackRect.add(createIntegerArray(16, 3));
        //line 3
        blackRect.add(createIntegerArray(18, 3));
        blackRect.add(createIntegerArray(19, 3));
        blackRect.add(createIntegerArray(20, 3));
        blackRect.add(createIntegerArray(21, 3));
        blackRect.add(createIntegerArray(23, 3));
        //line 4
        blackRect.add(createIntegerArray(13, 4));
        blackRect.add(createIntegerArray(17, 4));
        blackRect.add(createIntegerArray(23, 4));
        //line 5
        blackRect.add(createIntegerArray(13, 5));
        blackRect.add(createIntegerArray(22, 5));
        //line 6
        blackRect.add(createIntegerArray(13, 6));

        for (int i = 19; i <= 24; i++) {
            blackRect.add(createIntegerArray(i, 6));
        }
        //line 7
        blackRect.add(createIntegerArray(13, 7));

        for (int i = 17; i <= 25; i++) {
            blackRect.add(createIntegerArray(i, 7));
        }
        //line 8
        blackRect.add(createIntegerArray(13, 8));
        blackRect.add(createIntegerArray(15, 8));
        blackRect.add(createIntegerArray(16, 8));
        blackRect.add(createIntegerArray(23, 8));
        blackRect.add(createIntegerArray(24, 8));
        //line 9
        for (int i = 12; i <= 15; i++) {
            blackRect.add(createIntegerArray(i, 9));
        }
        blackRect.add(createIntegerArray(19, 9));
        blackRect.add(createIntegerArray(21, 9));
        blackRect.add(createIntegerArray(23, 9));

        //line 10;
        blackRect.add(createIntegerArray(12, 10));
        blackRect.add(createIntegerArray(14, 10));
        blackRect.add(createIntegerArray(15, 10));
        blackRect.add(createIntegerArray(19, 10));
        blackRect.add(createIntegerArray(21, 10));
        blackRect.add(createIntegerArray(23, 10));
        //line 11
        blackRect.add(createIntegerArray(11, 11));
        blackRect.add(createIntegerArray(14, 11));
        blackRect.add(createIntegerArray(15, 11));
        blackRect.add(createIntegerArray(16, 11));
        blackRect.add(createIntegerArray(24, 11));
        //line 12
        blackRect.add(createIntegerArray(11, 12));
        blackRect.add(createIntegerArray(15, 12));
        blackRect.add(createIntegerArray(18, 12));
        blackRect.add(createIntegerArray(24, 12));
        //line 13
        blackRect.add(createIntegerArray(12, 13));
        for (int i = 17; i <= 20; i++) {
            blackRect.add(createIntegerArray(i, 13));
        }
        for (int i = 23; i <= 25; i++) {
            blackRect.add(createIntegerArray(i, 13));
        }
        //line 14
        blackRect.add(createIntegerArray(13, 14));
        blackRect.add(createIntegerArray(14, 14));
        for (int i = 19; i <= 23; i++) {
            blackRect.add(createIntegerArray(i, 14));
        }
        //line 15
        for (int i = 14; i <= 16; i++) {
            blackRect.add(createIntegerArray(i, 15));
        }
        blackRect.add(createIntegerArray(22, 15));
        //line 16
        blackRect.add(createIntegerArray(12, 16));
        blackRect.add(createIntegerArray(13, 16));
        for (int i = 16; i <= 25; i++) {
            blackRect.add(createIntegerArray(i, 16));
        }
        //line 17
        for (int i = 9; i <= 12; i++) {
            blackRect.add(createIntegerArray(i, 17));
        }
        for (int i = 17; i <= 18; i++) {
            blackRect.add(createIntegerArray(i, 17));
        }
        for (int i = 21; i <= 22; i++) {
            blackRect.add(createIntegerArray(i, 17));
        }
        for (int i = 26; i <= 26; i++) {
            blackRect.add(createIntegerArray(i, 17));
        }
        //line 18
        for (int i = 18; i <= 19; i++) {
            blackRect.add(createIntegerArray(i, 18));
        }
        for (int i = 22; i <= 23; i++) {
            blackRect.add(createIntegerArray(i, 18));
        }
        blackRect.add(createIntegerArray(8, 18));
        blackRect.add(createIntegerArray(13, 18));
        blackRect.add(createIntegerArray(26, 18));
        //line 19
        for (int i = 18; i <= 19; i++) {
            blackRect.add(createIntegerArray(i, 19));
        }
        for (int i = 23; i <= 25; i++) {
            blackRect.add(createIntegerArray(i, 19));
        }
        blackRect.add(createIntegerArray(8, 19));
        blackRect.add(createIntegerArray(13, 19));
        //line 20
        for (int i = 4; i <= 11; i++) {
            blackRect.add(createIntegerArray(i, 20));
        }
        blackRect.add(createIntegerArray(14, 20));
        for (int i = 18; i <= 24; i++) {
            blackRect.add(createIntegerArray(i, 20));
        }
        //line 21
        for (int i = 3; i <= 3; i++) {
            blackRect.add(createIntegerArray(i, 21));
        }
        for (int i = 11; i <= 18; i++) {
            blackRect.add(createIntegerArray(i, 21));
        }
        for (int i = 21; i <= 22; i++) {
            blackRect.add(createIntegerArray(i, 21));
        }
        for (int i = 24; i <= 25; i++) {
            blackRect.add(createIntegerArray(i, 21));
        }
        //line 22
        for (int i = 3; i <= 3; i++) {
            blackRect.add(createIntegerArray(i, 22));
        }
        for (int i = 13; i <= 18; i++) {
            blackRect.add(createIntegerArray(i, 22));
        }
        for (int i = 21; i <= 23; i++) {
            blackRect.add(createIntegerArray(i, 22));
        }
        for (int i = 26; i <= 26; i++) {
            blackRect.add(createIntegerArray(i, 22));
        }
        //line 23
        for (int x : new int[]{3, 12, 15, 16, 17, 18, 19, 20, 21, 22, 26}) {
            blackRect.add(createIntegerArray(x, 23));
        }
        //line 24
        for (int x : new int[]{3, 4, 11, 12, 14, 15, 16, 17, 18, 19, 20, 21, 22, 26}) {
            blackRect.add(createIntegerArray(x, 24));
        }
        //line 25
        for (int i = 4; i <= 11; i++) {
            blackRect.add(createIntegerArray(i, 25));
        }

        for (int i = 14; i <= 22; i++) {
            blackRect.add(createIntegerArray(i, 25));
        }
        for (int i = 26; i <= 26; i++) {
            blackRect.add(createIntegerArray(i, 25));
        }
        //line 26
        for (int x : new int[]{11, 14, 15, 16, 17, 22, 25, 26})
            blackRect.add(createIntegerArray(x, 26));
        //line 27
        for (int x : new int[]{11, 14, 23, 24, 25})
            blackRect.add(createIntegerArray(x, 27));
        //line 28
        for (int x : new int[]{11, 12, 13})
            blackRect.add(createIntegerArray(x, 28));

        //used for filling the black background
        for (Integer[] blackDoubleArray :
                blackRect) {
            // g2d.fill(createRect(blackDoubleArray[0], blackDoubleArray[1]));
            g2d.draw(createRect(blackDoubleArray[0], blackDoubleArray[1]));

        }

        //orange rect
        ArrayList<Rectangle2D.Double> orangeRect = new ArrayList<>();
        orangeRect.add(new Rectangle2D.Double(19 * scale, 21 * scale, 2 * scale, 2 * scale));
        orangeRect.add(new Rectangle2D.Double(6 * scale, 21 * scale, 2 * scale, 4 * scale));
        orangeRect.add(new Rectangle2D.Double(23 * scale, 21 * scale, scale, scale));
        for (Rectangle2D.Double rect : orangeRect) {
            g2d.draw(rect);
        }


        //red rect for the tail end.
        ArrayList<Rectangle2D.Double> redRect = new ArrayList<>();
        redRect.add(new Rectangle2D.Double(8 * scale, 21 * scale, 3 * scale, 4 * scale));


    }

    public static Line2D.Double createLine(int x1, int y1, int x2, int y2) {
        return new Line2D.Double(x1 * scale, y1 * scale, x2 * scale, y2 * scale);

    }

    public static Rectangle2D.Double createRect(int x, int y) {
        return new Rectangle2D.Double(x * scale, y * scale, scale, scale);
    }

    public Integer[] createIntegerArray(Integer... y) {
        //Double[] coordinates= new Double[y.length];

        return y;
    }


    public static void main(String args[]) {
        MarioVer1 marioVer1 = new MarioVer1();
        //marioVer1.setTitle("MARIO");
        marioVer1.setSize(width, height);
        marioVer1.setVisible(true);

        marioVer1.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

}
