package Graph.Bars;

import java.awt.*;

import java.util.Random;

public abstract class Bar {

    /**
     * offset due to top panel
     */
    protected final int offsetY = 35;

    /**
     * width of the bar
     */
    private int barWidth;
    /**
     * height of the bar
     */
    private int barHeight;
    /**
     * the x coordinate of the bar
     */
    private int x;
    /**
     * the y coordinate of the bar
     */
    private int y;

    /**
     * the text of the bar
     */
    private BarText barText;

    /**
     * a random which is used for making the random color
     */
    private Random random = new Random();


    /**
     * a random color for the bar
     */
    private Color color = new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256));

    /**
     *
     * @return the color
     */
    protected Color getColor() {
        return color;
    }

    /**
     *
     * @param barText the text to set for the bar
     */
    protected void setBarText(BarText barText) {
        this.barText = barText;
    }

    /**
     *
     * @return the text of the bar
     */
    protected BarText getBarText() {
        return barText;
    }

    /**
     *
     * @return the x coordinate of the bar
     */
    protected int getX() {
        return x;
    }

    /**
     *
     * @return the y coordinate of the bar
     */
    protected int getY() {
        return y;
    }

    /**
     *
     * @return the height of the bar
     */
    protected int getBarHeight() {
        return barHeight;
    }

    /**
     *
     * @return the width of the bar
     */
    protected int getBarWidth() {
        return barWidth;
    }

    /**
     * constructor for a bar
     * @param x x coordinate
     * @param y y coordinate
     * @param barWidth width of bar
     * @param barHeight height of bar
     */
    public Bar(int x, int y,int barWidth, int barHeight) {
        this.x = x;
        this.y = y;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
    }

    /**
     * function to draw the bar
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    public abstract void draw(Graphics2D g2d, double percentDraw);


}
