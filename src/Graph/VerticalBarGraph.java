package Graph;

import Frames.JavaGraphs;
import Graph.Bars.Bar;

import java.awt.*;
import java.util.ArrayList;

import static Frames.JavaGraphs.getFrameHeight;

public class VerticalBarGraph extends BarGraph{

    /**
     *
     * @param x the x coordinate
     * @param y the y coordinate
     * @param data the data read from the file
     */
    public VerticalBarGraph(int x, int y, ArrayList<String[]> data) {
        super(x,y,data);
        this.setScale(new VerticalScale(x,y,this.getMaxDataValue()));
        setMaxBarHeight();
        setMaxBarWidth();
        setBarWidth();
        calculateScaleFactor();
        makeBars();
        setTextScaling();
    }


    /**
     * function to make a bar by using bar factory to get a bar and add to arraylist of bars
     */
    protected void makeBars() {
        int tempX;
        if (getGapBetweenBars() > getBarWidth() ) {
            tempX = this.getX() + 1 + getGapBetweenBars() - getBarWidth() / 2;
        } else {
            tempX = this.getX() + 1 + getGapBetweenBars();
        }

        for(String[] record: this.getData()) {
            int barHeight = (int) (Double.parseDouble(record[1]) * this.getScaleFactor());
            barList.add(barFactory.getBar(tempX,this.getY(),getBarWidth(),barHeight,record[0],  true));
            tempX = tempX + getGapBetweenBars() + getBarWidth();
        }
    }


    /**
     * sets the max bar height
     */
    protected void setMaxBarHeight() {

        // max height is 70% of the graph height to give room for text

        setMaxBarHeight((7* (JavaGraphs.getFrameHeight()) - 2*this.getY()) / 10 - (10));

    }

    /**
     * sets the text scaling
     */
    public void setTextScaling(){
        VertTextScale=(getFrameHeight() -getMaxBarHeight())/100;
    }

    /**
     * sets the max bar width
     */
    protected void setMaxBarWidth() {

        // max bar with is 1/6 of the total bar width
        // it is done to avoid the bar from taking the whole available width in case of few bars

        setMaxBarWidth(JavaGraphs.getFrameHeight() / 6);

    }

    /**
     * set the width of the bar
     */
    protected void setBarWidth() {

        // Calculates total gap between the bars
        // The remaining space is for the bars
        // Calculates and sets the bar width in order to fit bars in the graph

        int dataSize = this.getData().size();
        int totalGapBetweenBars = getGapBetweenBars() * (dataSize + 1);
        int remainingWidth = JavaGraphs.getFrameWidth() - 2*this.getX()  - totalGapBetweenBars;
        int barWidth = remainingWidth /dataSize;
        setBarWidth(barWidth);

        if (barWidth > getMaxBarWidth()) {
            setBarWidth(getMaxBarWidth());
            remainingWidth = JavaGraphs.getFrameWidth() - 2*this.getX() -(getBarWidth() * dataSize);
            setGapBetweenBars((int) (remainingWidth / (dataSize + 1)));
        }

    }


    /**
     * calculate and set the scale factor
     */
    @Override
    protected void calculateScaleFactor() {

        // calculated using ratio method
        // Scales the graph to graph area no matter if the values are small or big

        this.setScaleFactor(getMaxBarHeight() / this.getMaxDataValue());
    }


    public void drawGraph(Graphics2D g2d, double percentDraw) {
        //gets and draws the scale
        this.getScale().draw(g2d);

        //get and draw each bar
        for (Bar bar: barList) {
            bar.draw(g2d,percentDraw);
        }

    }
}
