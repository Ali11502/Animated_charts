package Graph;

import Frames.JavaGraphs;
import Graph.Bars.BarFactory;
import Graph.Bars.VerticalBarText;

import javax.sound.sampled.Line;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class LineGraph extends Graph{
    /**
     * the maximum points height
     */
    private int maxPointHeight;
    /**
     * the gap between points
     */
    private int gapBetweenPoints = 10;
    /**
     * the gap width
     */
    private int gapWidth;

    /**
     * stores the points
     */
    private ArrayList<Point> points = new ArrayList<>();

    /**
     * stores the color for each point
     */
    private ArrayList<Color> colors = new ArrayList<>();

    public LineGraph(int x, int y, ArrayList<String[]> data) {
        super(x,y,data);
        this.setScale(new VerticalScale(x,y,this.getMaxDataValue()));
        calculateMaxPointHeight();
        calculateGapBetweenPoints();
        calculateScaleFactor();
        storePoints();

    }


    /**
     * function to store the location of the points to the array list
     */
    private void storePoints() {
        int tempX;
        tempX = this.getX() + gapWidth/2 + gapBetweenPoints;

        for(String[] record: this.getData()) {
            //make a random color
            Random random = new Random();
            Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));

            //calculate the points height
            int pointHeight = JavaGraphs.getFrameHeight() - (int) (Double.parseDouble(record[1])
                    * this.getScaleFactor()) - this.getY();

            //add the point to the points arraylist
            points.add(new Point(tempX, pointHeight));

            //add the random color to the color arraylist
            colors.add(color);

            tempX = tempX + gapBetweenPoints + gapWidth;
        }
    }


    /**
     * calculate the scale factor
     */
    @Override
    protected void calculateScaleFactor() {
        // calculated using ratio method

        this.setScaleFactor(maxPointHeight / this.getMaxDataValue());
    }

    /**
     * calculates the maximum point height
     */
    protected void calculateMaxPointHeight() {
        // Max point height is at 70% of the graph

        this.maxPointHeight = (7* JavaGraphs.getFrameHeight() - 2*this.getY()) / 10 - (11);
    }

    /**
     * calculates the gap between the points
     */
    protected void calculateGapBetweenPoints() {

        // calculates total gap between points
        // the remaining with is to plot the points
        // it works by ploting the points at the center of the vertical graph bars

        int dataSize = this.getData().size();
        int totalGapBetweenPoints = gapBetweenPoints * (dataSize + 1);
        int remainingWidth = JavaGraphs.getFrameWidth() - 2*this.getX()  - totalGapBetweenPoints;
        int gapWidth = remainingWidth /dataSize;
        this.gapWidth = gapWidth;
    }

    /**
     * draws the line graph
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    @Override
    public void drawGraph(Graphics2D g2d, double percentDraw) {
        this.getScale().draw(g2d);          // draws the vertical scale
        int size = points.size();           // the amount of data

        // For Animation
        // Draws graph step by step after each iteration to give animation effect
        percentDraw = (int) (percentDraw*100);


        for (int i = 0; i < percentDraw && percentDraw < size; i++) {

            // calculates point height in order to place the bartext correctly
            int pointHeight = (int) (Double.parseDouble(this.getData().get(i)[1]) * this.getScaleFactor());

            // text for the point
            // pointHeight + 5   to put bartext just above the point
            VerticalBarText lineText = new VerticalBarText(points.get(i).x - 12,this.getY(),27,
                    pointHeight + 5,this.getData().get(i)[0]);

            // draws the bar text
            lineText.draw(g2d);

            // sets the color of the line joining the points
            g2d.setColor(Color.BLACK);

            // draws line between the two points
            g2d.drawLine(points.get(i).x,points.get(i).y,points.get(i + 1).x,points.get(i + 1).y);

            // sets the color of the point (Oval)
            g2d.setColor(colors.get(i));

            //draws the point
            g2d.fillOval(points.get(i).x - 4,points.get(i).y - 4,8,8); // -4 to -8
        }

        // sets color for the last point
        g2d.setColor(colors.get(colors.size() - 1));

        // calculates pointHeight for the last point
        int pointHeight = (int) (Double.parseDouble(this.getData().get(this.getData().size() - 1)[1]) * this.getScaleFactor());

        // text for the last point
        VerticalBarText lineText = new VerticalBarText(points.get(this.getData().size() - 1).x
                - 12,this.getY(),30,pointHeight + 5,this.getData().get(this.getData().size() - 1)[0]);

        // draws text for the last point
        lineText.draw(g2d);

        // draws point for the last point
        g2d.fillOval(points.get(size - 1).x - 4,points.get(size - 1).y - 4 ,8,8);
    }
}
