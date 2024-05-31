package Graph;

import Frames.JavaGraphs;
import Graph.Bars.VerticalBar;

import java.awt.*;

public class VerticalScale extends Scale {

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param maxValue the maximum value
     */
    public VerticalScale(int x, int y, double maxValue) {
        super(x,y,maxValue);

    }

    /**
     * function for drawing the vertical scale for the vertical bar graph
     * @param g2d graphics to draw to
     */
    public void draw(Graphics2D g2d) {
        // value between the intervals e.g 2,4,6,8 [the valueAtEachStep is 2]
        double valueAtEachStep = this.getMaxValue() / numOfSteps;

        // cumulative value at each step
        double interval = 0;

        // calculates the Y value difference between each step to plot the labels
        int gapBetweenEachStep = (8*((JavaGraphs.getFrameHeight()  - (2*this.getY())) / numOfSteps)/10);

        // x coordinate of where to plot the labels
        int tempY = this.getY()*(numOfSteps + 2) + 19;

        for (int i = 0; i < numOfSteps + 2; i++) {

            // draws the labels
            g2d.drawString("—",this.getX() - 6,tempY);
            g2d.drawString(Double.toString(Math.round(interval*100.0)/100.0),this.getX() - 50, tempY);

            // updates tempY and interval
            tempY -= gapBetweenEachStep;
            interval += valueAtEachStep;
        }

    }
}
