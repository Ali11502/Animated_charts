package Graph.Bars;

import Frames.JavaGraphs;

import java.awt.*;

public class VerticalBar extends Bar{

    public VerticalBar(int x, int y, int barWidth, int barHeight, String barText) {
        // y = JavaGraphs.getFrameHeight() - barHeight - y
        // As java makes rectangle from top left, y is taken up so that it draws the rectangle correctly
        // from top to bottom

        super(x,JavaGraphs.getFrameHeight() - barHeight - y, barWidth,barHeight);
        this.setBarText(new VerticalBarText(x,y,barWidth,barHeight,barText));
    }

    /**
     * function to draw the vertical bar
     * @param g2d graphics to draw to
     * @param percentDraw
     */
    @Override
    public void draw(Graphics2D g2d, double percentDraw) {
        //sets the color based on the bars random assigned color
        g2d.setColor(this.getColor());

        //draws the bar to the graphic
        g2d.fillRect(this.getX() ,(int) (this.getY() + (this.getBarHeight()
                - this.getBarHeight() * (percentDraw))), this.getBarWidth(), (int) (this.getBarHeight() * (percentDraw)));

        //gets the bartext and draws it
        this.getBarText().draw(g2d);
    }
}
