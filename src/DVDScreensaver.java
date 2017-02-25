import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;


/**
 * Created by jude8 on 2/21/2017.
 *
 */
public class DVDScreensaver extends JPanel implements ActionListener {
    Timer T = new Timer(10,this);

    int ballWidth = 70;
    int ballHeight = 50;

    int x = 10;
    int y = 10;
    int xspeed=2;
    int yspeed=2;
    int colorIndex = 0;
    int letterIndex = 1;
    Color[] colors = new Color[]{Color.MAGENTA,Color.RED,Color.BLUE,Color.GRAY,Color.GREEN,Color.white,Color.yellow};

    DVDScreensaver(){
        setSize(640,480);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Ellipse2D ball = new Ellipse2D.Double(x,y,ballWidth,ballHeight);
        graphics2D.setColor(colors[colorIndex]);
        graphics2D.fill(ball);

        graphics2D.setFont(new Font("Arial",Font.BOLD,20));
       graphics2D.setColor(colors[letterIndex]);
        graphics2D.drawString("DVD",x+15,y+32);
        T.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(x>this.getWidth()-ballWidth|x==0){
            xspeed=-xspeed;
            colorIndex = (int)(Math.random()*colors.length);
            letterIndex = (int)(Math.random()*colors.length);
        }
        if(y>this.getHeight()-ballHeight|y==0){
            yspeed=-yspeed;
             colorIndex = (int)(Math.random()*colors.length);
             letterIndex = (int)(Math.random()*colors.length);
        }

        x+=xspeed;
        y+=yspeed;
        repaint();
    }

    public static void main(String args[]){
        JFrame jframe = new JFrame();

        DVDScreensaver dVDScreensaver = new DVDScreensaver();
        dVDScreensaver.setBackground(Color.BLACK);
        jframe.setMinimumSize(new Dimension(dVDScreensaver.getWidth(), dVDScreensaver.getHeight()));
        jframe.add(dVDScreensaver);
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
