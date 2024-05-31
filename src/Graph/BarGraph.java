package Graph;

import Graph.Bars.Bar;
import Graph.Bars.BarFactory;

import java.awt.*;
import java.util.ArrayList;

import static Frames.JavaGraphs.getFrameHeight;

public abstract class BarGraph extends Graph{

    /**
     * its the gap between the bars
     */
    private int gapBetweenBars = 10;

    /**
     * the vertical text scale
     */
    public static int VertTextScale;

    /**
     * the bars width
     */
    private int barWidth;

    /**
     * the maximum bar width
     */
    private int maxBarWidth;

    /**
     * the maximum bar height
     */
    private int maxBarHeight;

    /**
     * a array list to store the bars
     */
    protected ArrayList<Bar> barList = new ArrayList<>();

    /**
     * the barfactory which is used in drawing the bars
     */
    protected BarFactory barFactory = BarFactory.GetInstance();


    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param data the data which has been read from the file
     */
    public BarGraph(int x, int y, ArrayList<String[]> data) {
        super(x,y,data);
    }


    /**
     *
     * @param gapBetweenBars the gap to set between the bars
     */
    protected void setGapBetweenBars(int gapBetweenBars) {
        this.gapBetweenBars = gapBetweenBars;
    }

    /**
     * function to make the bars
     */
    protected abstract void makeBars();

    /**
     * sets the maximum bar height
     */
    protected void setMaxBarHeight(int maxBarHeight) {
        this.maxBarHeight = maxBarHeight;
    };

    /**
     *
     * @return the maximum bar height
     */
    protected int getMaxBarHeight() {
        return maxBarHeight;
    }

    /**
     *
     * @return the gap between the bars
     */
    protected int getGapBetweenBars() {
        return gapBetweenBars;
    }

    /**
     *
     * @return the max bar width
     */
    protected int getMaxBarWidth() {
        return maxBarWidth;
    }

    /**
     * sets the max bar width
     */
    protected void setMaxBarWidth(int maxBarWidth) {
        this.maxBarWidth = maxBarWidth;
    }


    /**
     *
     * @return the bar width
     */
    protected int getBarWidth() {
     return barWidth;
    }

    /**
     * sets the bar Width
     */

    protected void setBarWidth(int barWidth) {
        this.barWidth = barWidth;
    }

    /**
     * sets the max bar width
     */
    protected abstract void setMaxBarWidth();

    /**
     * sets the bars width
     */
    protected abstract void setBarWidth();


}
