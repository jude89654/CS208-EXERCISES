package algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jude8 on 3/29/2017.
 */
public class LineGenerator extends JFrame {
    private JPanel mainPanel;
    private JPanel graphPanel;
    private JTextField x1TextField;
    private JTextField y1TextField;
    private JTextField x2TextField;
    private JTextField y2TextField;
    private JButton generateButton;
    private JComboBox algorithmComboBox;
    private JButton returnToMainMenuButton;
    private JTextArea pointsTextArea;

    String[] algorithms = new String[]{"Bresenham's","DDA"};

    static DDAAlgo ddaAlgo;
    static BresenhamPanel baAlgo;
    public LineGenerator(){
        super("CIRCLE GENERATING ALGORITHMS");
        setContentPane(mainPanel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        x1TextField.setText("1");
        y1TextField.setText("5");
        x2TextField.setText("40");
        y2TextField.setText("51");

        for(String algo: algorithms)algorithmComboBox.addItem(algo);

        graphPanel.setMinimumSize(new Dimension(650,650));

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointsTextArea.setText("");
                String algorithmSelected = algorithmComboBox.getSelectedItem().toString();
                if(algorithmSelected.equals("Bresenham's")){
                    baAlgo = new BresenhamPanel(Integer.parseInt(x1TextField.getText())
                            ,Integer.parseInt(y1TextField.getText())
                            ,Integer.parseInt(x2TextField.getText())
                            ,Integer.parseInt(y2TextField.getText()),pointsTextArea);

                    graphPanel.removeAll();
                    graphPanel.add(baAlgo);
                    graphPanel.revalidate();
                    graphPanel.repaint();
                }else{
                    ddaAlgo = new DDAAlgo(Integer.parseInt(x1TextField.getText())
                            ,Integer.parseInt(y1TextField.getText())
                            ,Integer.parseInt(x2TextField.getText())
                            ,Integer.parseInt(y2TextField.getText()),pointsTextArea);

                    graphPanel.removeAll();
                    graphPanel.add(ddaAlgo);
                    graphPanel.revalidate();
                    graphPanel.repaint();

                }
            }
        });
         returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HOME homeForm = new HOME();
                setVisible(false);
                dispose();
            }
        });

        pack();
    }
      public static void main(String[] args) {
       LineGenerator lineGenerator = new LineGenerator();
       lineGenerator.setVisible(true);
    }
}
