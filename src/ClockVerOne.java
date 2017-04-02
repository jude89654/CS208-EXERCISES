import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.Calendar;

/**
 * Created by jude8 on 3/23/2017.
 */
public class ClockVerOne extends JPanel {


    double secondsRadius;
    double minutesRadius;
    double hoursRadius;
    static double clockDiameter;


    double width = 512;
    double height = 512;

    static int minute = 0, seconds = 0, hour = 0;
    // Date date = date.getTime();


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Calendar calendar = Calendar.getInstance();


        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        double radius = Math.min(width, height) / 2;

        double cx = width / 2;
        double cy = height / 2;

        secondsRadius = radius * 0.72;
        minutesRadius = radius * 0.60;
        hoursRadius = radius * 0.50;
        clockDiameter = radius * 1.8;

        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(Color.white);
        g2d.draw(new Ellipse2D.Double(cx - (clockDiameter / 2), cx - (clockDiameter / 2), clockDiameter, clockDiameter));
        g2d.setColor(Color.gray);
        g2d.fill(new Ellipse2D.Double(cx - (clockDiameter / 2), cx - (clockDiameter / 2), clockDiameter, clockDiameter));

        //draw second ticks
        g2d.setColor(Color.white);
        for (int a = 0; a < 360; a += 6) {
            Double angle = Math.toRadians(a);
            double x = cx + Math.cos(angle) * secondsRadius;
            double y = cy + Math.sin(angle) * secondsRadius;

            if (a % 30 == 0) {
                g2d.fill(new Ellipse2D.Double(x - (5 / 2), y - (5 / 2), 5, 5));
            } else
                g2d.fill(new Ellipse2D.Double(x - 1, y - 1, 2, 2));
        }


        g2d.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        //  g2d.d
        g2d.drawString("JUDE ARDYN BISMONTE", (int) cx - 60, 510);

        g2d.setFont(new Font("Calibri", Font.PLAIN, 30));
        g2d.drawString("12", (int) cx - 18, 55);
        g2d.drawString("6", (int) cx - 10, 475);
        g2d.drawString("9", (int) 42, (int) cy + 5);
        g2d.drawString("3", (int) 460, (int) cy + 5);

        g2d.setColor(Color.darkGray);
        g2d.drawString("Bismonte",(int)cx-50,(int)cy+100);

        //g2d.setFont


        g2d.setColor(Color.WHITE);
//draw hour hand

        g2d.setStroke(new BasicStroke(5f));
        g2d.draw(new Line2D.Double(cx,cy, cx+(Math.cos(Math.toRadians(30*hour)-(Math.PI/2)))*hoursRadius,
                cy+Math.sin(Math.toRadians((30*hour)+((minute/60)*30)-(Math.PI/2))*hoursRadius)));

        g2d.setStroke(new BasicStroke(3f));
        g2d.draw(new Line2D.Double(cx, cy, cx + (Math.cos(Math.toRadians(6 * minute) - (Math.PI / 2))) * minutesRadius,
                cy + Math.sin(Math.toRadians(6 * minute) - (Math.PI / 2)) * minutesRadius));


    }


    public static void main(String args[]) {

        JButton button = new JButton("TIME");

        JTextField hourTextField = new JTextField(1);
        JTextField minuteTextField = new JTextField(1);
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 3));
        buttonsPanel.add(hourTextField);
        buttonsPanel.add(new JLabel(":"));
        buttonsPanel.add(minuteTextField);

        buttonsPanel.add(button);


        Frame frame = new Frame();
        ClockVerOne clock = new ClockVerOne();
        clock.setMinimumSize(new Dimension((int) 550, (int) 550));
        clock.setBackground(new Color(0, 0, 0));
        frame.setMinimumSize(new Dimension((int) 550, (int) 580));
        frame.setLayout(new BorderLayout());
        frame.add(clock);
        frame.add(buttonsPanel, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            minute = Integer.parseInt(minuteTextField.getText());
            hour = Integer.parseInt(hourTextField.getText());
            clock.repaint();
        });

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
