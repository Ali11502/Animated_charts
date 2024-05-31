package Graph;

import java.awt.*;

public abstract class Scale {

    /**
     * the x coordinate
     */
    private int x;

    /**
     * the y coordinate
     */
    private int y;

    /**
     * the maximum value
     */
    private double maxValue;

    /**
     * the number of steps/intervals to reach the maximum value
     */
    protected int numOfSteps = 10;

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param maxValue the maximum value
     */
    public Scale(int x, int y, double maxValue) {
        this.x = x;
        this.y = y;
        this.maxValue = maxValue;
    }

    /**
     *
     * @return the maximum value
     */
    protected double getMaxValue() {
        return maxValue;
    }

    /**
     *
     * @return the y coordinate
     */
    protected int getY() {
        return y;
    }

    /**
     *
     * @return the x coordinate
     */
    protected int getX() {
        return x;
    }

    /**
     * function for drawing the scale
     * @param g2d graphics to draw to
     */
    protected abstract void draw(Graphics2D g2d);
}
