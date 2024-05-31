package Frames;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphSelectionGUI implements ActionListener {

    private static JFrame frame;

    /**
     * function to display the gui
     */
    public static void display() {
        frame = new JFrame(" Graph Selection ");
        JPanel panel = new JPanel();
        frame.setSize(680, 150);
        frame.setLocation(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(panel);
        panel.setLayout(null);

        // Creates labels
        JLabel question_text = new JLabel(" Which graph should be displayed?");

        // Creates Selection Button
        JButton lineGraph = new JButton(" Line Graph ");
        JButton verticalBarGraph = new JButton(" Vertical Bar Graph ");
        JButton horizontalBarGraph = new JButton(" Horizontal Bar Graph ");

        // Defines the position and dimensions of the labels
        question_text.setBounds(20, 10, 500, 30);

        // Defiens the position and the dimensions of the buttons
        lineGraph.setBounds(20, 50, 200, 30);
        verticalBarGraph.setBounds(240, 50, 200, 30);
        horizontalBarGraph.setBounds(460, 50, 200, 30);

        // Adds the labels to the panel
        panel.add(question_text);

        // Adds the buttons to the panel
        panel.add(lineGraph);
        panel.add(verticalBarGraph);
        panel.add(horizontalBarGraph);

        // Displays the GUI
        frame.setVisible(true);

        // Adds Actions Listners to the button to perform the required action when they are clicked
        lineGraph.addActionListener(new GraphSelectionGUI());
        verticalBarGraph.addActionListener(new GraphSelectionGUI());
        horizontalBarGraph.addActionListener(new GraphSelectionGUI());
    }

    /**
     * action performed listener which checks which button is pressed
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Determines which button is Pressed
        String button_pressed = e.getActionCommand();
        String graphType;

        if (button_pressed.strip().equals("Line Graph")) {
            graphType = "LINE";
        } else if (button_pressed.strip().equals("Vertical Bar Graph")){
            graphType = "VBAR";
        } else {
            graphType = "HBAR";
        }

        //pass the button type to javagraphs
        JavaGraphs.makeGraph(graphType);
    }
}
