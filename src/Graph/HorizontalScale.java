package Graph;

import Frames.JavaGraphs;

import java.awt.*;
import java.util.ArrayList;

public class HorizontalScale extends Scale{

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param maxValue the maximum value
     */
    public HorizontalScale(int x, int y, double maxValue) {
        super(x,y,maxValue);
    }

    /**
     * function to draw the horizontal scale
     * @param g2d graphics to draw to
     */
    public void draw(Graphics2D g2d) {


        // value between the intervals e.g 2,4,6,8 [the valueAtEachStep is 2]
        double valueAtEachStep = this.getMaxValue() / numOfSteps;

        // cumulative value at each step
        double interval = 0;

        // calculates the x value difference between each step to plot the labels
        int gapBetweenEachStep = 8*((JavaGraphs.getFrameWidth() - (2*this.getX())) / numOfSteps)/10;

        // x coordinate of where to plot the labels
        int tempX = this.getX() - 2;

        for (int i = 0; i < numOfSteps + 1 + 2; i++) {

            // draws the labels
            g2d.drawString("|",tempX,this.getY() + 35);
            g2d.drawString(Double.toString(Math.round(interval*100.0)/100.0),tempX - 5, this.getY() + 25);

            // updates tempX and interval
            tempX += gapBetweenEachStep;
            interval += valueAtEachStep;
        }

    }

}
