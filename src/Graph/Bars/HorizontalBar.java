package Graph.Bars;

import java.awt.*;

public class HorizontalBar extends Bar{

    /**
     *
     * @param x x location
     * @param y y location
     * @param barWidth width of bar
     * @param barHeight height of bar
     * @param barText text for the bar
     */
    public HorizontalBar(int x, int y, int barWidth, int barHeight, String barText) {
        super(x,y,barHeight,barWidth);
        this.setBarText( new HorizontalBarText(x,y,barWidth,barHeight,barText));
    }

    /**
     * function to draw the horizontal bar
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    @Override
    public void draw(Graphics2D g2d, double percentDraw) {
        //sets the color based on the bars random assigned color
        g2d.setColor(this.getColor());

        //draws the bar to the graphic
        g2d.fillRect(this.getX(),this.getY() + offsetY, (int)(this.getBarWidth() * (percentDraw)), this.getBarHeight());

        //gets the bartext and draws it
        this.getBarText().draw(g2d);
    }
}
