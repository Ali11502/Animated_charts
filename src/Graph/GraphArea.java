package Graph;

import Frames.JavaGraphs;

import java.awt.*;

public class GraphArea {
    /**
     * offset due to top panel
     */
    private final int offsetY = 35;

    /**
     * width of the graph
     */
    private static int graphWidth;

    /**
     * height of the graph
     */
    private static int graphHeight;

    /**
     * x coordinate
     */
    private int x;

    /**
     * y coordinate
     */
    private int y;

    /**
     *
     * @param graphWidth the width of the graph
     * @param graphHeight the height of the graph
     */
    public GraphArea(int graphWidth, int graphHeight) {
        // x = (JavaGraphs.getFrameWidth() - graphWidth) / 2     top left x coordinate of the graphArea
        // y = (JavaGraphs.getFrameHeight() - graphHeight) / 2;  top left y coordinate of the graphArea
        // Calculated so the graphArea is always in the center


        this.x = (JavaGraphs.getFrameWidth() - graphWidth) / 2;
        this.y = (JavaGraphs.getFrameHeight() - graphHeight) / 2;
        this.graphWidth = graphWidth;
        this.graphHeight = graphHeight;
    }

    /**
     *
     * @return x value
     */
    public int getX() {
        return x;
    }

    /**
     *
     * @return y value
     */
    public int getY() {
        return y;
    }

    /**
     * function to draw the grapharea
     * @param g2d graphics to draw to
     */
    public void draw(Graphics2D g2d) {
        g2d.drawRect(x,y + offsetY,graphWidth,graphHeight - offsetY);
    }
}
