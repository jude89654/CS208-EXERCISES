/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.*;
import java.awt.geom.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

/**
 * @author eleap
 */
public class DDA extends JPanel {
    public void actionPerformed(ActionEvent ae) {
    }

    static double x_1 = 0, y_1 = 0, x_2 = 0, y_2 = 0, tmpx = 0, tmpy = 0;
    private static JTextField x1TextField, y1TextField, x2TextField, y2TextField;
    private static JLabel lx1, lx2, ly1, ly2;
    private static JButton button;

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        BasicStroke bs = new BasicStroke(8.0f);


        double deltax = x_2 - x_1;
        double deltaY = y_2 - y_1;
        if (deltax >= deltaY) {         //x
            double slp = deltax / deltaY;
            while (tmpx != x_2) {
                if (deltax > 0) {
                    tmpx = x_1 + slp;
                    tmpy = y_1 + 1;
                    Line2D.Double dot = new Line2D.Double(x_1, y_1, tmpx, tmpy);
                    g2d.draw(dot);
                } else {
                    double tmpx = x_1 - slp;
                    double tmpy = y_1 + 1;
                }
            }
        } else {              //y
            double slp = deltax / deltaY;
            while (tmpy != y_2) {
                if (deltaY > 0) {
                    double tmpx = x_1 + 1;
                    double tmpy = y_1 + slp;
                } else {
                    double tmpx = x_1 - 1;
                    double tmpy = y_1 + slp;
                }


            }
        }
    }

    public static void main(java.lang.String args[]) {


        JFrame frame = new JFrame();
        DDA c = new DDA();
        c.setMinimumSize(new Dimension(900, 900));

        //Panel pane = new Panel();
        Panel inputPane = new Panel();
        inputPane.setBackground(Color.white);
        inputPane.setLayout(new GridLayout(1, 5));

        x1TextField = new JTextField(2);
        y1TextField = new JTextField(2);
        x2TextField = new JTextField(2);
        y2TextField = new JTextField(2);
        lx1 = new JLabel("x1TextField:");
        ly1 = new JLabel("y1TextField:");
        lx2 = new JLabel("x2TextField:");
        ly2 = new JLabel("y2TextField:");
        button = new JButton("Draw");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                x_1 = Integer.parseInt(x1TextField.getText());
                y_1 = Integer.parseInt(y1TextField.getText());
                x_2 = Integer.parseInt(x2TextField.getText());
                y_2 = Integer.parseInt(y2TextField.getText());
                c.repaint();
            }
        });

        inputPane.add(lx1);
        inputPane.add(x1TextField);
        inputPane.add(ly1);
        inputPane.add(y1TextField);
        inputPane.add(lx2);
        inputPane.add(x2TextField);
        inputPane.add(ly2);
        inputPane.add(y2TextField);
        inputPane.add(button);


        frame.setTitle("DDA");
        frame.setBackground(Color.white);
        frame.setMinimumSize(new Dimension(800, 800));
        frame.setForeground(Color.WHITE);
        frame.setLayout(new BorderLayout());
        frame.add(c);
        frame.add(inputPane, BorderLayout.NORTH);
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
