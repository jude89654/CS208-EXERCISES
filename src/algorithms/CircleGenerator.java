package algorithms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by jude8 on 3/29/2017.
 */
public class CircleGenerator extends JFrame {
    private JPanel mainPanel;
    private JComboBox algorithmComboBox;
    private JTextField xTextField;
    private JTextField yTextField;
    private JTextField radiusTextField;
    private JButton generateButton;
    private JPanel graphPanel;
    private JButton returnToMainMenuButton;
    private JTextArea pointsTextArea;

    SymmetricPlottingAlgo symmetricPlottingAlgo;
    MidPointCircleAlgo midPointCircleAlgo= new MidPointCircleAlgo(30,30,5,pointsTextArea);

    String[] algorithms = new String[]{"Midpoint","Symmetric Plotting"};

    CircleGenerator(){
        super("CIRCLE GENERATING ALGORITHMS");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setContentPane(mainPanel);
        for (String algo:
             algorithms) {
            algorithmComboBox.addItem(algo);
        }
       // algorithmComboBox.;
        xTextField.setText("30");
        yTextField.setText("30");
        radiusTextField.setText("5");

        graphPanel.setMinimumSize(new Dimension(650,650));
        //graphPanel.add(new SymmetricPlottingAlgo(10,10,10));

        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pointsTextArea.setText("");
                String algorithmSelected =algorithmComboBox.getSelectedItem().toString();
                if(algorithmSelected.equals("Midpoint")){
                     midPointCircleAlgo= new MidPointCircleAlgo(Integer.parseInt(xTextField.getText())
                            ,Integer.parseInt(yTextField.getText())
                            ,Integer.parseInt(radiusTextField.getText()),pointsTextArea);


                    midPointCircleAlgo.repaint();
                    graphPanel.removeAll();
                    graphPanel.add(midPointCircleAlgo);


                    graphPanel.revalidate();
                    graphPanel.repaint();

               }else{
                    symmetricPlottingAlgo = new SymmetricPlottingAlgo(Integer.parseInt(xTextField.getText())
                            ,Integer.parseInt(yTextField.getText())
                            ,Integer.parseInt(radiusTextField.getText()),pointsTextArea);
                    graphPanel.removeAll();

                    graphPanel.add(symmetricPlottingAlgo);

                    graphPanel.revalidate();
                    graphPanel.repaint();
                }
            }
        });

        pack();
        returnToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                HOME homeForm = new HOME();
                setVisible(false);
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        CircleGenerator circleGenerator = new CircleGenerator();
        circleGenerator.setVisible(true);
    }


}
