package Frames;

import Graph.Graph;
import Graph.GraphArea;
import Graph.GraphTypeFactory;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class JavaGraphs extends JFrame implements ActionListener
{

	private static int width = 800;
	private static int height = 500;
    private int graphWidth = (int) (width * 0.85);          // 85% of the Jframe Width
    private int graphHeight = (int) (height * 0.85);        // 85% of the JFrame Height
	private Timer timer;
	private int delay = 15;
	private GraphArea area;
    private GraphTypeFactory graphTypeFactory = GraphTypeFactory.GetInstance();
    private Graph graph;
    private String graphType;
    private double delta = 0;                               // for animation
    private ArrayList<String[]> data;



    public JavaGraphs(String graphType) throws FileNotFoundException {
        super("Graphs Program");
        
        getContentPane().setBackground(Color.WHITE);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        //sets the type of graph
        this.graphType = graphType;

        //reads the data from the file
        this.data = readData();

        //defines the area
        this.area = new GraphArea(graphWidth,graphHeight);

        //get the graph from the graph factory
        graph = graphTypeFactory.getGraph(area.getX(),area.getY(),data,graphType);

        timer =  new Timer(delay, this);
        timer.start();
    }

    public void draw(Graphics g) 
    {
        // delta increases every 15 milli seconds
        this.delta = delta + 0.01;

        Graphics2D g2d = (Graphics2D) g;

        // draws the graph area
        area.draw(g2d);

        // When graph is partially drawn, keep drawing otherwise stop
        if (delta <= 1) {
            graph.drawGraph(g2d, delta);
        }
        if (delta > 1) {
            graph.drawGraph(g2d,1);
        }

    }
 
    public void paint(Graphics g) 
    {
        draw(g);
        g.dispose();
    }
 
    public static void main(String[] args) throws Exception
    {
        GraphSelectionGUI.display();
    }

    public static void makeGraph(String graphType)
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run()
            {
                try {
                    new JavaGraphs(graphType).setVisible(true);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        });
    }


    /**
     *
     * @return data of name and value in ArrayList
     * @throws FileNotFoundException
     */
    public ArrayList<String[]> readData() throws FileNotFoundException {

        Scanner reader = new Scanner(new File("src/data.txt"));

        ArrayList<String[]> data = new ArrayList<String[]>();

        //read data from the data.txt file by using scanner
        while (reader.hasNextLine()) {
            data.add(new String[] {reader.next(), reader.next()});


        }

        return data;
    }

    /**
     *
     * @return the frame height
     */
    public static int getFrameHeight() {
        return height;
    }

    /**
     *
     * @return the frame width
     */
    public static int getFrameWidth() {
        return width;
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}

}
