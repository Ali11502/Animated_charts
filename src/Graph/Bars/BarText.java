package Graph.Bars;

import java.awt.*;

public abstract class BarText {

    /**
     * offset due to top panel
     */
    protected final int offsetY = 35;

    /**
     * the text of the bar
     */
    private String text;
    /**
     * the x coordinate of the text
     */
    private int x;
    /**
     * the y coordinate of the text
     */
    private int y;
    /**
     * the width of the bar
     */
    private int barWidth;
    /**
     * the height of the bar
     */
    private int barHeight;

    /**
     * the fontsize of the text
     */
    private int fontSize;

    /**
     * constructor for bartext
     * @param x the top left x coordinate of the text
     * @param y the top left y coordinate of the text
     * @param barWidth the width of the bar
     * @param barHeight the height of the bar
     * @param text the text of the bar
     */
    public BarText(int x, int y, int barWidth, int barHeight, String text) {
        this.x = x;
        this.y = y;
        this.barWidth = barWidth;
        this.barHeight = barHeight;
        this.text = text;
    }

    /**
     * sets the fontsize for this bartext
     * @param fontSize the fontsize to set
     */
    protected void setFontSize(int fontSize) {
        this.fontSize = fontSize;
    }

    /**
     *
     * @return the fontsize of the bar text
     */
    protected int getFontSize() {
        return fontSize;
    }

    /**
     *
     * @return the y coordinate of the bar text
     */
    protected int getY() {
        return y;
    }

    /**
     *
     * @return the x coordinate of the bar text
     */
    protected int getX() {
        return x;
    }

    /**
     *
     * @return the text of the bar text
     */
    protected String getText() {
        return text;
    }

    /**
     *
     * @return the width of the bar text's bar
     */
    protected int getBarWidth() {
        return barWidth;
    }

    /**
     * function to draw the bar text
     * @param g2d graphic to draw to
     */
    public abstract void draw(Graphics2D g2d);
}
