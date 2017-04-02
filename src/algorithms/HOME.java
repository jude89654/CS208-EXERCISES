package algorithms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jude8 on 3/29/2017.
 */
public class HOME extends JFrame {
    private JButton lineGenerationButton;
    private JButton circleGenerationButton;
    private JPanel panel1;

    CircleGenerator circleGenerator = new CircleGenerator();
    LineGenerator lineGenerator = new LineGenerator();


    HOME(){
        super("4CSA BISMONTE BOLO INFANTADO SANTOS J.");
        setContentPane(panel1);

        setVisible(true);
        lineGenerationButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            lineGenerator.setVisible(true);
        });
        circleGenerationButton.addActionListener(e -> {
            setVisible(false);
            dispose();
            circleGenerator.setVisible(true);

        });
        pack();
    }

    public static void main(String[] args) {
        HOME home = new HOME();
        home.setVisible(true);
    }
}
