package Graph;

import Graph.Bars.BarFactory;

import java.awt.*;
import java.util.ArrayList;

public abstract class Graph {

    /**
     * the offset due to top
     */
    protected final int offset = 35;

    /**
     * the x coordinate
     */
    private int x;

    /**
     * the y coordinate
     */
    private int y;

    /**
     * the scale factor
     */
    private double scaleFactor;

    /**
     * the maximum data value
     */
    private double maxDataValue;

    /**
     * the data which has been read from file
     */
    private ArrayList<String[]> data;

    /**
     * the scale object which has been chosen, eg. vertical scale or horizontal scale
     */
    private Scale scale;

    /**
     * the count of letters in the highest letter word
     */
    public static int highestLetterCount;


    /**
     * function to find the highest letter word and store the amount of letters
     */
    private void findHighestLetterCount(){
        int tempcount=0;
        int lettercount=Integer.MIN_VALUE;
        for(String[] record: this.getData()) {
            char[] letterLength=record[0].toCharArray();
            tempcount=letterLength.length;
            if (tempcount>lettercount){
                lettercount=tempcount;
            }
        }
        highestLetterCount = lettercount;
    }

    /**
     *
     * @return the data which has been read from file and stored into an array list
     */
    protected ArrayList<String[]> getData() {
        return data;
    }

    /**
     *
     * @return an object of type scale based on the scale set
     */
    protected Scale getScale() {
        return scale;
    }

    /**
     * sets the scale
     * @param scale the scale to set
     */
    protected void setScale(Scale scale) {
        this.scale = scale;
    }

    /**
     *
     * @return the maximum data value
     */
    protected double getMaxDataValue() {
        return maxDataValue;
    }

    /**
     *
     * @return the x coordinate
     */
    protected int getX() {
        return x;
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
     * @return the scale factor
     */
    protected double getScaleFactor() {
        return scaleFactor;
    }

    /**
     * sets the scale factor
     * @param scaleFactor the scale factor to set
     */
    protected void setScaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
    }

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param data the data read from file
     */
    public Graph(int x, int y, ArrayList<String[]> data) {
        this.x = x;
        this.y = y;
        this.data = data;
        findMax();
        findHighestLetterCount();
    }

    /**
     * returns the max value in the data
     */
    private void findMax() {
        double max = Integer.MIN_VALUE;
        for(String[] record: data) {
            max = Math.max(max, Double.parseDouble(record[1]));
        }
        this.maxDataValue = max;
    }


    /**
     * function to calculate the scale factor
     */
    protected abstract void calculateScaleFactor();

    /**
     * function to draw the graph
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    public abstract void drawGraph(Graphics2D g2d , double percentDraw);

}
