package Graph;

import Frames.JavaGraphs;
import Graph.Bars.Bar;

import java.awt.*;
import java.util.ArrayList;

public class HorizontalBarGraph extends BarGraph{

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param data the data read from the file
     */
    public HorizontalBarGraph(int x, int y, ArrayList<String[]> data) {
        super(x,y,data);
        this.setScale(new HorizontalScale(x,y,this.getMaxDataValue()));
        setMaxBarHeight();
        setMaxBarWidth();
        setBarWidth();
        calculateScaleFactor();
        makeBars();

    }

    /**
     * function to make a bar by using bar factory to get a bar and add to arraylist of bars
     */
    protected void makeBars() {

        // Stores bars to avoid getting random color after each iteration

        int tempY;
        if (getGapBetweenBars() > getBarWidth()) {
            tempY = this.getY() + 1 + getGapBetweenBars() - getBarWidth() / 2;
        } else {
            tempY = this.getY() + 1 + getGapBetweenBars();
        }

        for (String[] record : this.getData()) {
            int barHeight = (int) (Double.parseDouble(record[1]) * this.getScaleFactor() );
            barList.add(barFactory.getBar(this.getX() + 1, tempY, getBarWidth(), barHeight, record[0], false));
            tempY = tempY + getGapBetweenBars() + getBarWidth();
        }

    }


    /**
     * sets the maximum bar height
     */
    protected void setMaxBarHeight() {

        // the max bar height is 70% of the bar width to give room for text

        setMaxBarHeight((7* JavaGraphs.getFrameWidth() - 2*this.getX()) / 10 -8);

    }

    /**
     * sets the maximum bar width
     */
    protected void setMaxBarWidth() {

        // max bar with is 1/6 of the total bar width
        // it is done to avoid the bar from taking the whole available width in case of few bars

        setMaxBarWidth(JavaGraphs.getFrameHeight() / 6);

    }

    /**
     * sets the width of the bar
     */
    protected void setBarWidth() {

        // Calculates total gap between the bars
        // The remaining space is for the bars
        // Calculates and sets the bar width in order to fit bars in the graph


        int dataSize = this.getData().size();
        int totalGapBetweenBars = getGapBetweenBars() * (dataSize + 1);
        int remainingHeight = JavaGraphs.getFrameHeight() - (2*this.getY() + offset)  - totalGapBetweenBars;
        int barWidth = remainingHeight /dataSize;
        setBarWidth(barWidth);

        if (barWidth > getMaxBarWidth()) {
            setBarWidth(getMaxBarWidth());

            //calculate the remaining height
            remainingHeight = JavaGraphs.getFrameHeight() - (2*this.getY() + offset) -(getBarWidth() * dataSize);

            //sets the gap between bars
            setGapBetweenBars((int) (remainingHeight / (dataSize + 1)));
        }

    }


    /**
     * calculates the scale factor
     */
    @Override
    protected void calculateScaleFactor() {

        // calculated using ratio method
        // Scales the graph to graph area no matter if the values are small or big

        this.setScaleFactor(getMaxBarHeight() / this.getMaxDataValue());
    }

    /**
     * function to draw the graph
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    public void drawGraph(Graphics2D g2d, double percentDraw) {

        //draws the scale
        this.getScale().draw(g2d);

        //draws every bar
        for (Bar bar: barList) {
            bar.draw(g2d,percentDraw);
        }
    }

}
